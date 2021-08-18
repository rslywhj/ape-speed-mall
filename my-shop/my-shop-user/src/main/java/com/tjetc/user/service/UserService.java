package com.tjetc.user.service;

import com.tjetc.user.entity.User;

public interface UserService {
    /**
     * 根据用户名和密码查找user
     *
     * @param username  用户名
     * @param password  密码
     * @return
     */
    User findByUsernameAndPassword(String username,String password);

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    boolean add(String username, String password);

    /**
     * 更新个人资料
     * @param id
     * @param vname
     * @param vphone
     * @param vemail
     * @return
     */
    boolean update(Long id ,String vname ,String vphone ,String vemail);

    boolean resPassword(Long id ,String password);

}
