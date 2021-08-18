package com.tjetc.service.service.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.dao.UserDao;
import com.tjetc.service.dao.impl.UserDaoImpl;
import com.tjetc.service.entity.User;
import com.tjetc.service.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public AdminPageResult<User> page(int start, int pageSize) {
        return userDao.selectPage(start, pageSize);
    }
}
