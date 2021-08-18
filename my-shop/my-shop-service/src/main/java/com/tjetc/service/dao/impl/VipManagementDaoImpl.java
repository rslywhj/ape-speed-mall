package com.tjetc.service.dao.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.common.utils.DBDruidUtil;
import com.tjetc.service.dao.VipManagementDao;
import com.tjetc.service.entity.VipManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VipManagementDaoImpl implements VipManagementDao {
    @Override
    public AdminPageResult<VipManagement> selectPage(int start, int pageSize) {
        //查询数据总条数
        Long count = 0L;
        String sql = "select count(vid) count  from vipManagement";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //分页查询User的数据集合
        sql = "select vid,avatar,username,vname,vphone,vemail,password,registration_data from vipManagement limit ?,?";
        /**
         *
         select * from user LIMIT 0,2;  # 第1页 （1-1）*2 =0
         select * from user LIMIT 2,2;  # 第2页	（2-1）*2 =2
         select * from user LIMIT 4,2;  # 第3页  （3-1）*2 = 4
         */
        Object[] params = new Object[]{start, pageSize};
        List<VipManagement> vipManagements = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                long vid = (long) map.get("vid");
                String username = (String) map.get("username");
                String vname = (String) map.get("vname");
                String vphone = (String) map.get("vphone");
                String vemail = (String) map.get("vemail");
                String password = (String) map.get("password");
                String avatar = (String) map.get("avatar");
                String registration_data= (String) map.get("registration_data");
                VipManagement vipManagement = new VipManagement(vid,avatar,username,vname,vphone,vemail,password,registration_data);
                vipManagements.add(vipManagement);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        AdminPageResult pageResult = new AdminPageResult(0, "", count, vipManagements);
        return pageResult;
    }
}
