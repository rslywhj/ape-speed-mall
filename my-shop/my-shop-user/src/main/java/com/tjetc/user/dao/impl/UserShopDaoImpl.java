package com.tjetc.user.dao.impl;



import com.tjetc.service.common.utils.DBDruidUtil;
import com.tjetc.user.dao.UserShopDao;
import com.tjetc.user.entity.Address;
import com.tjetc.user.entity.BuyShop;
import com.tjetc.user.entity.Order;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserShopDaoImpl implements UserShopDao {
    @Override
    public Long BuyGoods(BuyShop buyShop) {

        String sql="insert into ordermanagement(consignee,vid,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,address_id,refund_notes) values(?,?,?,?,?,?,?,'待付款','无',0,'无','无',?,'无')";
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String orderTime = dateTime.format(dtf);
        Object[] params=new Object[]{buyShop.getConsignee(),buyShop.getVid(),buyShop.getGuest_book(),buyShop.getTotal_amount(),buyShop.getTotal_amount(),buyShop.getDistribution(),orderTime,buyShop.getAddress_id()};
        try {
            Object insert = DBDruidUtil.insert(sql, params);
            String s = String.valueOf(insert);
            long l = Long.parseLong(s);
            return  l;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean toPay(Long id) {
        String sql="update ordermanagement set state='待发货' where oid=?";
        Object[] params=new Object[]{id};
        try {
            boolean update = DBDruidUtil.update(sql, params);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Address> select(Long username_id) {
        String sql="select address_id,address from address where vid=?";
        Object[]params=new Object[]{username_id};
        List<Address> list=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long address_id = (Long)map.get("address_id");
                String address = (String)map.get("address");
                Address address1 = new Address(address_id, address);
                list.add(address1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      return list;
    }

    /***
     *查看自己的待付款订单
     */
    @Override
    public List<Order> waitPaid(Long vid) {
        String sql="select oid,consignee,guest_book,total_amount,distribution,order_data from ordermanagement where vid=? and state='待付款'";
        Object[] params=new Object[]{vid};
        List<Order> lists=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long oid = (Long)map.get("oid");
                String consignee = (String)map.get("consignee");
                String guest_book = (String)map.get("guest_book");
                BigDecimal total_amount = (BigDecimal)map.get("total_amount");
                String distribution = (String)map.get("distribution");
                String order_data = (String)map.get("order_data");
                Order order = new Order(oid, consignee, guest_book, total_amount, distribution, order_data);
                lists.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lists;
    }


    /**
     * 查看自己的代发货订单
     */
    @Override
    public List<Order> waitDeliver(Long vid) {
        String sql="select oid,consignee,guest_book,total_amount,distribution,order_data from ordermanagement where vid=? and state='待发货'";
        Object[] params=new Object[]{vid};
        List<Order> lists=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long oid = (Long)map.get("oid");
                String consignee = (String)map.get("consignee");
                String guest_book = (String)map.get("guest_book");
                BigDecimal total_amount = (BigDecimal)map.get("total_amount");
                String distribution = (String)map.get("distribution");
                String order_data = (String)map.get("order_data");
                Order order = new Order(oid, consignee, guest_book, total_amount, distribution, order_data);
                lists.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lists;
    }


    /**
     * 查看自己的已发货订单
     */
    @Override
    public List<Order> Deliver(Long vid) {
        String sql="select oid,consignee,guest_book,total_amount,distribution,order_data from ordermanagement where vid=? and state='已发货'";
        Object[] params=new Object[]{vid};
        List<Order> lists=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long oid = (Long)map.get("oid");
                String consignee = (String)map.get("consignee");
                String guest_book = (String)map.get("guest_book");
                BigDecimal total_amount = (BigDecimal)map.get("total_amount");
                String distribution = (String)map.get("distribution");
                String order_data = (String)map.get("order_data");
                Order order = new Order(oid, consignee, guest_book, total_amount, distribution, order_data);
                lists.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lists;
    }

    @Override
    public List<Order> Remove(Long vid) {
        String sql="select oid,consignee,guest_book,total_amount,distribution,order_data from ordermanagement where vid=? and state='取消/拒收'";
        Object[] params=new Object[]{vid};
        List<Order> lists=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long oid = (Long)map.get("oid");
                String consignee = (String)map.get("consignee");
                String guest_book = (String)map.get("guest_book");
                BigDecimal total_amount = (BigDecimal)map.get("total_amount");
                String distribution = (String)map.get("distribution");
                String order_data = (String)map.get("order_data");
                Order order = new Order(oid, consignee, guest_book, total_amount, distribution, order_data);
                lists.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lists;
    }

    @Override
    public List<Order> TakeDelivery(Long vid) {
        String sql="select oid,consignee,guest_book,total_amount,distribution,order_data from ordermanagement where vid=? and state='已收货'";
        Object[] params=new Object[]{vid};
        List<Order> lists=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long oid = (Long)map.get("oid");
                String consignee = (String)map.get("consignee");
                String guest_book = (String)map.get("guest_book");
                BigDecimal total_amount = (BigDecimal)map.get("total_amount");
                String distribution = (String)map.get("distribution");
                String order_data = (String)map.get("order_data");
                Order order = new Order(oid, consignee, guest_book, total_amount, distribution, order_data);
                lists.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lists;
    }

    @Override
    public List<Order> Refund(Long vid) {
        String sql="select oid,consignee,total_amount,apply_data,refund_status,refund_notes,distribution from ordermanagement where vid=? and state='退款'";
        Object[] params=new Object[]{vid};
        List<Order> lists=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Long oid = (Long)map.get("oid");
                String consignee = (String)map.get("consignee");
                BigDecimal total_amount = (BigDecimal)map.get("total_amount");
                String apply_data = (String)map.get("apply_data");
                String refund_status = (String)map.get("refund_status");
                String refund_notes = (String)map.get("refund_notes");
                String distribution = (String)map.get("distribution");
                Order order = new Order(oid, consignee, total_amount, refund_status, refund_notes, apply_data,distribution);
                lists.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lists;
    }

    @Override
    public Boolean toRemove(Long vid) {
        String sql="update ordermanagement set state='取消/拒收' where oid=?";
        Object[] params=new Object[]{vid};
        try {
            boolean update = DBDruidUtil.update(sql, params);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean toTakeDelivery(Long vid) {
        String sql="update ordermanagement set state='已收货' where oid=?";
        Object[] params=new Object[]{vid};
        try {
            boolean update = DBDruidUtil.update(sql, params);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean toApplyRefund(Long vid) {
        String sql="select consignee,total_amount from ordermanagement where oid=?";
        Object[] params=new Object[]{vid};
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, params);
            Object total_amount1 = map.get("total_amount");
            String s = String.valueOf(total_amount1);
            Double aDouble = Double.valueOf(s);
            BigDecimal total_amount = BigDecimal.valueOf(aDouble);
            Object consignee1 = map.get("consignee");
            String consignee = String.valueOf(consignee1);
            sql="update  ordermanagement set state='退款',applicant=?,refund_amount=?,apply_data=?,refund_status='未退款' where oid=?";
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String orderTime = dateTime.format(dtf);
            Object[] param=new Object[]{consignee,total_amount,orderTime,vid};
            boolean update = DBDruidUtil.update(sql, param);
            return update;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}
