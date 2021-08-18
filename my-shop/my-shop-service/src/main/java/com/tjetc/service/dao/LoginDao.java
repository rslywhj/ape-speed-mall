package com.tjetc.service.dao;

import java.util.Map;

public interface LoginDao {
    /**
     * 管理员登录，用于登录后台
     * @param username
     * @param password
     * @return
     */
    Map<String,Object> adminRegister(String username, String password);
}
