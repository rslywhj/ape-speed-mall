package com.tjetc.user.service.impl;

import com.tjetc.user.dao.UserDao;
import com.tjetc.user.dao.impl.UserDaoImpl;
import com.tjetc.user.entity.User;
import com.tjetc.user.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        //调用Dao
        return userDao.selectByUsernameAndPassword(username,password);
    }
    
    @Override
    public boolean add(String username, String password) {
        return userDao.insert(username,password);
    }

    @Override
    public boolean update(Long id, String vname, String vphone, String vemail) {
        return userDao.update(id,vname,vphone,vemail);
    }

    @Override
    public boolean resPassword(Long id, String password) {
        return userDao.resPassword(id,password);
    }

}
