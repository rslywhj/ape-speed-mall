package com.tjetc.service.common.utils;

import java.sql.*;

public class DBSimpleUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、获取连接
        String url = "jdbc:mysql://localhost:3306、db3?useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        return DriverManager.getConnection(url, "root", "123456");
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
