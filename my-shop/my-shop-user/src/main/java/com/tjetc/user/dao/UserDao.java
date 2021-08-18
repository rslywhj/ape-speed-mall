package com.tjetc.user.dao;

import com.tjetc.user.entity.User;

public interface UserDao {
    /**
     * 根据用户名和密码查找user
     *
     * @param username  用户名
     * @param password  密码
     * @return
     */
    User selectByUsernameAndPassword(String username, String password);
    
    /**
     * 注册
     *
     * @param
     * @return 自增id
     */
    boolean insert(String username, String password);

    /**
     * 更新用户资料
     * @param id
     * @param vname
     * @param vphone
     * @param vemail
     * @return
     */
    boolean update(Long id,String vname,String vphone,String vemail);
    
    boolean resPassword(Long id , String password);



}
