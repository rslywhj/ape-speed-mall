package com.tjetc.service.dao.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.common.utils.DBDruidUtil;
import com.tjetc.service.dao.UserDao;
import com.tjetc.service.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public AdminPageResult<User> selectPage(int start, int pageSize) {
        //查询数据总条数
        Long count = 0L;
        String sql = "select count(id) count  from user";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //分页查询User的数据集合
        sql = "select id,username,password from user limit ?,?";
        /**
         *
         select * from user LIMIT 0,2;  # 第1页 （1-1）*2 =0
         select * from user LIMIT 2,2;  # 第2页	（2-1）*2 =2
         select * from user LIMIT 4,2;  # 第3页  （3-1）*2 = 4
         */
        Object[] params = new Object[]{start, pageSize};
        List<User> users = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long id = (Long) map.get("id");
                String username = (String) map.get("username");
                String password = (String) map.get("password");
                User user = new User(id, username, password);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        AdminPageResult pageResult = new AdminPageResult(0, "", count, users);
        return pageResult;
    }
}
