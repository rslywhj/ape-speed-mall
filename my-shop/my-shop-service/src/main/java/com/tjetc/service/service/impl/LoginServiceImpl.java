package com.tjetc.service.service.impl;

import com.tjetc.service.dao.LoginDao;
import com.tjetc.service.dao.impl.LoginDaoImpl;
import com.tjetc.service.service.LoginService;

import java.util.Map;

public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    @Override
    public boolean adminRegister(String username, String password) {
        Map<String, Object> map = loginDao.adminRegister(username, password);
        if (map!=null){
            return true;
        }
        return false;
    }
}
