package com.tjetc.user.dao.impl;

import com.tjetc.user.common.util.DBDruidUtil;
import com.tjetc.user.dao.CartOderDao;
import com.tjetc.user.entity.CartAndPro;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartOrderDaoImpl implements CartOderDao {
    @Override
    public List<CartAndPro> SelectPrice(Long vid, Long gid) {
        String sql="select price,num from cart where user_id=? and id=?";
        Object[] params=new Object[]{vid,gid};
        List<CartAndPro> list=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                BigDecimal price = (BigDecimal)map.get("price");
                int num = (Integer)map.get("num");
                CartAndPro cartAndPro = new CartAndPro(price, num);
                list.add(cartAndPro);
                
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
