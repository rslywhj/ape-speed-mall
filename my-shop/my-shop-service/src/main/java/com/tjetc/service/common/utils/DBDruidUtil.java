package com.tjetc.service.common.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DBDruidUtil {
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;
    //定义Druid的数据源变量
    private static DruidDataSource pool;
    /**
     * 初始连接数
     **/
    private static int initialSize = 5;
    /**
     * 最大活动连接数
     **/
    private static int maxActive = 6;
    /**
     * 最小闲置连接数
     **/
    private static int minIdle = 5;
    /**
     * 连接耗尽时最大等待获取连接时间
     **/
    private static long maxWait = 1000;

    //保存线程对应的连接，底层使用Map<线程id，Connection>保存的
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        InputStream inputStream = null;
        try {
            //创建db.properties的流
            inputStream = DBDruidUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //创建Properties对象
            Properties p = new Properties();
            //把数据流读入Properties对象中
            p.load(inputStream);
            //从Properties对象中获取配置数据
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            driverName = p.getProperty("driverName");
            //实例化并初始化数据源
            init();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实例化数据源并初始化
     */
    private static void init() {
        //实例化DruidDataSource
        pool = new DruidDataSource();
        //设置驱动的driverName
        pool.setDriverClassName(driverName);
        //设置url
        pool.setUrl(url);
        //设置数据库的用户名
        pool.setUsername(username);
        //设置数据库的密码
        pool.setPassword(password);

        // 设置连接池中初始连接数
        pool.setInitialSize(initialSize);
        // 设置最大连接数
        pool.setMaxActive(maxActive);
        // 设置最小的闲置链接数
        pool.setMinIdle(minIdle);
        // 设置最大的等待时间(等待获取链接的时间)
        pool.setMaxWait(maxWait);
    }

    /**
     * insert语句使用，返回新增数据的自增主键。
     *
     * @param sql
     * @return
     */
    private static Object insert(Connection connection, String sql, Object[] params) throws SQLException {
        PreparedStatement ps = null;
        Object id = null;
        try {
            //创建PreparedStatement
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //设置参数
            setPreparedStatementParam(ps, params);
            //执行sql
            ps.executeUpdate();
            // 执行此 Statement 对象而创建的所有自动生成的键
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                // 指定返回生成的主键
                id = rs.getObject(1);
            }
        } finally {
            close(ps);
        }
        return id;
    }

    /**
     * insert语句使用，返回新增数据的自增主键。
     *
     * @param sql
     * @return
     */
    public static Object insert(String sql, Object[] params) throws SQLException {
        Connection conn = null;
        Object id;
        try {
            //创建连接
            conn = getConnection();
            id = insert(conn, sql, params);
        } finally {
            //判断connnection 对象是自动还是非自动提交，如果是自动提交，直接关闭，如果是非自动提交，
            // 说明有事务要执行，把关闭Connection工作交给上层处理，这不负责关闭
            if(conn.getAutoCommit()) {
                closeConnection();
            }
        }
        return id;
    }

    /**
     * 更新、删除
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    private static boolean update(Connection connection, String sql, Object[] params) throws SQLException {
        PreparedStatement ps = null;
        try {
            //步骤2：设置SQL语句以及对应的参数
            ps = connection.prepareStatement(sql);
            setPreparedStatementParam(ps, params);
            //步骤3：执行update
            int result = ps.executeUpdate();
            //返回执行的结果
            return result > 0 ? true : false;
        } finally {
            //步骤4：关闭资源
            close(ps);
        }
    }

    /**
     * 更新、删除
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static boolean update(String sql, Object[] params) throws SQLException {
        Connection connection = null;
        try {
            //步骤1：获取链接
            connection = getConnection();
            return update(connection, sql, params);
        } finally {
            //步骤2：关闭连接资源
            //判断connnection 对象是自动还是非自动提交，如果是自动提交，直接关闭，如果是非自动提交，
            // 说明有事务要执行，把关闭Connection工作交给上层处理，这不负责关闭
            if(connection.getAutoCommit()) {
                closeConnection();
            }
        }
    }

    /**
     * 查询一个
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    private static Map<String, Object> selectOne(Connection connection, String sql, Object[] params) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //步骤2：设置SQL语句以及对应的参数
            ps = connection.prepareStatement(sql);
            setPreparedStatementParam(ps, params);

            //步骤3：执行查询，把查询结果的列作为key，列对应的值作为value，保存到Map中
            rs = ps.executeQuery();

            if (rs.next()) {
                return getResultMap(rs);
            }
        } finally {
            //步骤4：关闭资源
            close(rs, ps);
        }
        return null;
    }

    /**
     * 获取ResultMap
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private static Map<String, Object> getResultMap(ResultSet rs) throws SQLException {
        //获取到result的元数据，包含了列的信息
        ResultSetMetaData metaData = rs.getMetaData();

        //获取到当前表的所有的列的列数
        int columnCount = metaData.getColumnCount();

        //存储数据库列与值的map
        Map<String, Object> map = new HashMap<>();

        //根据列的数量，获取到每一个列的列名以及对应的值
        for (int i = 0; i < columnCount; i++) {
            //能够获取到每一个列的名称，参数是每个列的序号值
            String columnName = metaData.getColumnLabel(i + 1);
            Object columnValue = rs.getObject(columnName);
            map.put(columnName, columnValue);

        }
        return map;
    }

    /**
     * 查询一个
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static Map<String, Object> selectOne(String sql, Object[] params) throws SQLException {
        Connection connection = null;
        try {
            //步骤1：获取链接
            connection = getConnection();
            return selectOne(connection, sql, params);
        } finally {
            //步骤4：关闭资源
            //判断connnection 对象是自动还是非自动提交，如果是自动提交，直接关闭，如果是非自动提交，
            // 说明有事务要执行，把关闭Connection工作交给上层处理，这不负责关闭
            if(connection.getAutoCommit()) {
                closeConnection();
            }
        }
    }

    /**
     * 查询集合
     *
     * @param sql
     * @param params
     * @return
     */
    private static List<Map<String, Object>> selectList(Connection connection, String sql, Object[] params) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<String, Object>> list;
        try {
            //步骤2：设置SQL语句以及对应的参数
            ps = connection.prepareStatement(sql);
            setPreparedStatementParam(ps, params);

            //步骤3：执行查询，把查询结果的列作为key，列对应的值作为value，保存到Map中
            rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()) {
                list.add(getResultMap(rs));
            }
        } finally {
            //步骤4：关闭资源
            close(rs, ps);
        }
        return list;
    }

    /**
     * 查询集合
     *
     * @param sql
     * @param params
     * @return
     */
    public static List<Map<String, Object>> selectList(String sql, Object[] params) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            return selectList(connection, sql, params);
        } finally {
            //判断connnection 对象是自动还是非自动提交，如果是自动提交，直接关闭，如果是非自动提交，
            // 说明有事务要执行，把关闭Connection工作交给上层处理，这不负责关闭
            if(connection.getAutoCommit()) {
                closeConnection();
            }
        }
    }

    /**
     * 设置参数
     *
     * @param ps
     * @param params
     * @throws SQLException
     */
    private static void setPreparedStatementParam(PreparedStatement ps, Object[] params) throws SQLException {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        //ThreadLocal 用来存储线程和对象关系 底层Map<线程，对象>

        //通过数据源获取连接
        //threadLocal.get() 调用内部 先要查找当前线程id，再根据线程id从Map获取Connection连接对象
        Connection conn = threadLocal.get();
        //判断conn存不存，不存在从连接池获取连接，存在的话直接返回
        if (conn == null) {
            conn = pool.getConnection();
            //把conn对象存储到threadLocal变量中
            //threadLocal.set() 先Map存储conn对象，key为当前线程的id，value就是conn连接对象
            threadLocal.set(conn);
        }
        return conn;
    }


    //开启事务
    public static void beginTransaction() throws SQLException {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
    }

    //提交事务
    public static void commit() throws SQLException {
        Connection conn = getConnection();
        conn.commit();
    }

    //回滚事务
    public static void rollback() throws SQLException {
        Connection conn = getConnection();
        conn.rollback();
    }

    public static void closeConnection() {
        Connection connection;
        try {
            connection = getConnection();
            if (connection != null) {
                try {
                    //修改自动提交
                    connection.setAutoCommit(true);
                    connection.close();
                    //ThreadLocal 删除存储对应的Connection对象
                    threadLocal.remove();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void close(ResultSet rs,PreparedStatement ps) {
        close(rs);
        close(ps);
    }

    private static void close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
