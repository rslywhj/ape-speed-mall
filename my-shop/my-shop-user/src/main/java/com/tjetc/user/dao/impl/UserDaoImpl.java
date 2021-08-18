package com.tjetc.user.dao.impl;

import com.tjetc.user.common.util.DBDruidUtil;
import com.tjetc.user.dao.UserDao;
import com.tjetc.user.entity.User;

import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;

public class UserDaoImpl implements UserDao {
    /**
     * 用户登录
     * @param username  用户名
     * @param password  密码
     * @return
     */
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        Connection conn= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取链接
            String url="jdbc:mysql://localhost:3306/db3?useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            conn = DriverManager.getConnection(url, "root", "123456");
            //3、获取PrepareStatement
            String sql = "select vid,username,`password` from vipmanagement where username=? and password=?;";
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setObject(1,username);
            ps.setObject(2,password);
            //4、执行sql处理结果
            rs = ps.executeQuery();
            //rs.next() 移动游标，返回是否存在数据
            if (rs.next()){
                Long id = (Long)rs.getObject(1);
                String queryUsername = (String) rs.getObject(2);
                String queryPassword = (String) rs.getObject(3);
                User user = new User(id,queryUsername,queryPassword);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5、释放资源
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean insert(String username, String password) {
        Connection conn= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取链接
            String url="jdbc:mysql://localhost:3306/db3?useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            conn = DriverManager.getConnection(url, "root", "123456");
            //3、获取preparestatement
            String sql = "INSERT into vipmanagement(`username`,`password`,`registration_data`) VALUES(?,?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //获取日期
            LocalDate registration_data = LocalDate.now();
            //设置参数
            ps.setObject(1, username);
            ps.setObject(2, password);
            ps.setObject(3, registration_data);
            //4、执行sql语句，处理结果
            ps.executeUpdate();
            //获取自增id的rs
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                //获取自增主键id
                BigInteger id = (BigInteger) rs.getObject(1);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //5、释放资源
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean update(Long id, String vname, String vphone, String vemail) {
        String sql = "update vipmanagement vname=? ,vphone=? ,vemail=? where vid =?";
        Object[] params = new Object[]{vname,vphone,vemail,id} ;
        try {
            boolean b = DBDruidUtil.update(sql, params);
            return b;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean resPassword(Long id, String password) {
        String sql ="update vipmanagement password=? where vid = ?";
        Object[] params = new Object[]{id,password};
        try {
            boolean b = DBDruidUtil.update(sql, params);
            return b;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}
