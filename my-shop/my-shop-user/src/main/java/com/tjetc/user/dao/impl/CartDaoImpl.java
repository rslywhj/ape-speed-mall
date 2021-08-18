package com.tjetc.user.dao.impl;

import com.tjetc.user.common.util.DBDruidUtil;
import com.tjetc.user.dao.CartDao;
import com.tjetc.user.entity.CartAndPro;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDaoImpl implements CartDao {
    @Override
    public List<CartAndPro> selectAllCart(Long user_id) {
        String sql = "select c.id,p.product_id,p.product_name,p.price,c.num from product p,cart c where p.product_id=c.product_id and c.user_id = ?;";
        List<CartAndPro> cartAndPros = new ArrayList<>();
        try {
            Object[] params = new Object[]{user_id};
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long id = (Long) map.get("id");
                String product_name = (String) map.get("product_name");
                BigDecimal price = (BigDecimal) map.get("price");
                int num = (int) map.get("num");
                CartAndPro cartAndPro = new CartAndPro(id,product_name, price, num);
                cartAndPros.add(cartAndPro);
            }
            return cartAndPros;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql="update cart set num=num-1 where id = ? ";
        try {
            Object[] params = new Object[]{id};
            boolean bl = DBDruidUtil.update(sql, params);
            return bl;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addById(Long id) {
        String sql="update cart set num=num+1 where id = ? ";
        try {
            Object[] params = new Object[]{id};
            boolean bl = DBDruidUtil.update(sql, params);
            return bl;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insertById(CartAndPro cartAndPro) {
        String sql="insert into cart(user_id,product_id,product_name,num,price) values(?,?,?,?,?)";
        Object[] params=new Object[]{cartAndPro.getUser_id(),cartAndPro.getProduct_id(),cartAndPro.getProduct_name(),cartAndPro.getNum(),cartAndPro.getPrice()};
        try {
            Object insert = DBDruidUtil.insert(sql, params);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delById(long id) {
        String sql = "delete from cart where id = ?";
        try {
            Object[] params = new Object[]{id};
            boolean bl = DBDruidUtil.update(sql, params);
            return bl;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delAllById(String[] split) {
        String sql = "delete from cart where id in (";
        for (String s : split) {
            sql = sql.concat("?,");
        }
        sql=sql.substring(0,sql.length()-1);
        sql = sql.concat(")");
        try {
            boolean update = DBDruidUtil.update(sql, split);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public int selectById(Long user_id, Long product_id) {
        String sql="select user_id,product_id,product_name,num,price from cart where user_id=? and product_id=?";
        Object[] params=new Object[]{user_id,product_id};
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, params);
            if(map!=null){
                int num =(Integer)map.get("num");
                return num;
            }else {
                return 0;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean addUpdate(CartAndPro cartAndPro) {
        String sql="update cart set num=? where user_id = ? and product_id = ? ";
        Object[] params =new Object[]{cartAndPro.getNum(),cartAndPro.getUser_id(),cartAndPro.getProduct_id()} ;
        try {
            boolean update = DBDruidUtil.update(sql, params);
            return update;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    @Override
    public Boolean delectGoods(Long product_id,int num) {
        String sql="update product set stock=stock-? where product_id=?";
        Object[] params=new Object[]{num,product_id};
        try {
            boolean update = DBDruidUtil.update(sql, params);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteCart(Long id) {
        String sql="delete from cart where id=?";
        Object[] params=new Object[]{id};
        try {
            boolean update = DBDruidUtil.update(sql, params);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}

