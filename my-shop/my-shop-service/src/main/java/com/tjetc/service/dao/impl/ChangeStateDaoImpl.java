package com.tjetc.service.dao.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.common.utils.DBDruidUtil;
import com.tjetc.service.dao.ChangeStateDao;

import java.sql.SQLException;

public class ChangeStateDaoImpl implements ChangeStateDao {
    @Override
    public AdminPageResult<Boolean> DeliverGoods(Long id) {
        String sql = "update ordermanagement set state='已发货' where oid=?";
        Object[] params = new Object[]{id};
        try {
            boolean update = DBDruidUtil.update(sql, params);
            AdminPageResult adminPageResult1 = new AdminPageResult(0, "", update);
            return adminPageResult1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public AdminPageResult<Boolean> Refund(Long id) {
        String sql = "update ordermanagement set refund_status='已退款' where oid=?";
        Object[] params = new Object[]{id};
        try {
            boolean update = DBDruidUtil.update(sql, params);
            AdminPageResult adminPageResult1 = new AdminPageResult(0, "", update);
            return adminPageResult1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}