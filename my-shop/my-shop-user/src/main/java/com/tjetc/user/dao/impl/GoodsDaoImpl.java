package com.tjetc.user.dao.impl;

import com.tjetc.user.common.util.DBDruidUtil;
import com.tjetc.user.dao.GoodsDao;
import com.tjetc.user.entity.Goods;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsDaoImpl implements GoodsDao {
    /**
     * 查看商品
     */
    @Override
    public Goods selectGoods(long id) {
        String sql="select product_name,gpicture,des,price,stock from `product` where product_id=?";
        Object[] params=new Object[]{id};
        try {
            Map<String, Object> result = DBDruidUtil.selectOne(sql, params);
            Goods goods = getGoods(result);
            return goods;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> selectSecondName(String first_name) {
        String sql="select category_id from category where category_fid=(select first_id from first_level where first_name='?')";
        Object[] params=new Object[]{first_name};
        List<String> lists=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                 sql="select second_name from second_level where second_id=?";
                 Object[] param=new Object[]{map};
                Map<String, Object> map1 = DBDruidUtil.selectOne(sql, param);
                Object second_name = map1.get("second_name");
                String s = String.valueOf(second_name);
                lists.add(s);
            }
            return lists;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return lists;
    }


    private Goods getGoods(Map<String, Object> result) {

        String product_name = (String) result.get("product_name");
        String gpicture =(String)result.get("gpicture");
        String des = (String) result.get("des");
        BigDecimal gprice = (BigDecimal) result.get("price");
        int stock= (int) result.get("stock");
        Goods goods = new Goods();
        goods.setDes(des);
        goods.setStock(stock);
        goods.setProduct_name(product_name);
        goods.setImage(gpicture);
        goods.setPrice(gprice);
        return goods;
    }

}
