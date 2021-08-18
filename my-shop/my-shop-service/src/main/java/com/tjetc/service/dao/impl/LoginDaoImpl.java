package com.tjetc.service.dao.impl;

import com.tjetc.service.common.utils.DBDruidUtil;
import com.tjetc.service.dao.LoginDao;

import java.sql.SQLException;
import java.util.Map;

public class LoginDaoImpl implements LoginDao {

    @Override
    public Map<String,Object> adminRegister(String username,String password) {
        try {
            String sql = "select * from admin where admin_name = ? and password = ?";
            Object[] params = {username,password};
            Map<String, Object> map = DBDruidUtil.selectOne(sql, params);
            if (map!=null){
                return map;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
