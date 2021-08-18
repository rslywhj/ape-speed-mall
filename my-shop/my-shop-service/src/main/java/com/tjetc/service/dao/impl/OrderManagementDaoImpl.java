package com.tjetc.service.dao.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.common.utils.DBDruidUtil;
import com.tjetc.service.dao.OrderManagementDao;
import com.tjetc.service.entity.OrderManagement;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManagementDaoImpl implements OrderManagementDao {

    @Override
    public AdminPageResult<OrderManagement> selectPage(int start, int pageSize) {
        //查询数据总条数
        Long count = 0L;
        String sql = "select count(oid) count  from orderManagement where state='待发货'";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        sql = "select oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes from orderManagement where state='待发货' limit ?,?";
        Object[] params = new Object[]{start, pageSize};
        List<OrderManagement> orderManagements1 = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                long oid = (long) map.get("oid");
                String consignee = (String) map.get("consignee");
                String guest_book = (String) map.get("guest_book");
                BigDecimal total_amount = (BigDecimal) map.get("total_amount");
                BigDecimal received_amount = (BigDecimal) map.get("received_amount");
                String distribution = (String) map.get("distribution");
                String order_data = (String) map.get("order_data");
                String state = (String) map.get("state");
                String applicant = (String) map.get("applicant");
                BigDecimal refund_amount = (BigDecimal) map.get("refund_amount");
                String apply_data = (String) map.get("oapply_data");
                String refund_status = (String) map.get("refund_status");
                String refund_notes = (String) map.get("refund_notes");
                        OrderManagement orderManagement1 = new OrderManagement(oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes);
                        orderManagements1.add(orderManagement1);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        AdminPageResult pageResult1 = new AdminPageResult(0, "", count, orderManagements1);
        return pageResult1;
    }

    @Override
    public AdminPageResult<OrderManagement> waitPaid(int start, int pageSize) {
        //查询数据总条数
        Long count = 0L;
        String sql = "select count(oid) count  from orderManagement where state='待付款'";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        sql = "select oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes from orderManagement where state='待付款' limit ?,?";
        Object[] params = new Object[]{start, pageSize};
        List<OrderManagement> orderManagements2 = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                long oid = (long) map.get("oid");
                String consignee = (String) map.get("consignee");
                String guest_book = (String) map.get("guest_book");
                BigDecimal total_amount = (BigDecimal) map.get("total_amount");
                BigDecimal received_amount = (BigDecimal) map.get("received_amount");
                String distribution = (String) map.get("distribution");
                String order_data = (String) map.get("order_data");
                String state = (String) map.get("state");
                String applicant = (String) map.get("applicant");
                BigDecimal refund_amount = (BigDecimal) map.get("refund_amount");
                String apply_data = (String) map.get("oapply_data");
                String refund_status = (String) map.get("refund_status");
                String refund_notes = (String) map.get("refund_notes");
                        OrderManagement orderManagement2 = new OrderManagement(oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes);
                        orderManagements2.add(orderManagement2);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        AdminPageResult pageResult1 = new AdminPageResult(0, "", count, orderManagements2);
        return pageResult1;
    }

    @Override
    public AdminPageResult<OrderManagement> ShippedOrder(int start, int pageSize) {

        Long count = 0L;
        String sql = "select count(oid) count  from orderManagement where state='已发货'";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        sql = "select oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes from orderManagement where state='已发货' limit ?,?";
        Object[] params = new Object[]{start, pageSize};
        List<OrderManagement> orderManagements3 = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                long oid = (long) map.get("oid");
                String consignee = (String) map.get("consignee");
                String guest_book = (String) map.get("guest_book");
                BigDecimal total_amount = (BigDecimal) map.get("total_amount");
                BigDecimal received_amount = (BigDecimal) map.get("received_amount");
                String distribution = (String) map.get("distribution");
                String order_data = (String) map.get("order_data");
                String state = (String) map.get("state");
                String applicant = (String) map.get("applicant");
                BigDecimal refund_amount = (BigDecimal) map.get("refund_amount");
                String apply_data = (String) map.get("oapply_data");
                String refund_status = (String) map.get("refund_status");
                String refund_notes = (String) map.get("refund_notes");
                        OrderManagement orderManagement3 = new OrderManagement(oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes);
                        orderManagements3.add(orderManagement3);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        AdminPageResult pageResult1 = new AdminPageResult(0, "", count, orderManagements3);
        return pageResult1;
    }

    @Override
    public AdminPageResult<OrderManagement> RejectOrder(int start, int pageSize) {
        //查询数据总条数
        Long count = 0L;
        String sql = "select count(oid) count  from orderManagement where state='取消/拒收'";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        sql = "select oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes from orderManagement where state='取消/拒收' limit ?,?";
        Object[] params = new Object[]{start, pageSize};
        List<OrderManagement> orderManagements4 = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                long oid = (long) map.get("oid");
                String consignee = (String) map.get("consignee");
                String guest_book = (String) map.get("guest_book");
                BigDecimal total_amount = (BigDecimal) map.get("total_amount");
                BigDecimal received_amount = (BigDecimal) map.get("received_amount");
                String distribution = (String) map.get("distribution");
                String order_data = (String) map.get("order_data");
                String state = (String) map.get("state");
                String applicant = (String) map.get("applicant");
                BigDecimal refund_amount = (BigDecimal) map.get("refund_amount");
                String apply_data = (String) map.get("oapply_data");
                String refund_status = (String) map.get("refund_status");
                String refund_notes = (String) map.get("refund_notes");
                OrderManagement orderManagement4 = new OrderManagement(oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes);
                orderManagements4.add(orderManagement4);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        AdminPageResult pageResult1 = new AdminPageResult(0, "", count, orderManagements4);
        return pageResult1;
    }

    @Override
    public AdminPageResult<OrderManagement> RefundOrder(int start, int pageSize) {
        //查询数据总条数
        Long count = 0L;
        String sql = "select count(oid) count  from orderManagement where state='退款'";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        sql = "select oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes from orderManagement where state='退款' limit ?,?";
        Object[] params = new Object[]{start, pageSize};
        List<OrderManagement> orderManagements5 = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                long oid = (long) map.get("oid");
                String consignee = (String) map.get("consignee");
                String guest_book = (String) map.get("guest_book");
                BigDecimal total_amount = (BigDecimal) map.get("total_amount");
                BigDecimal received_amount = (BigDecimal) map.get("received_amount");
                String distribution = (String) map.get("distribution");
                String order_data = (String) map.get("order_data");
                String state = (String) map.get("state");
                String applicant = (String) map.get("applicant");
                BigDecimal refund_amount = (BigDecimal) map.get("refund_amount");
                String apply_data = (String) map.get("oapply_data");
                String refund_status = (String) map.get("refund_status");
                String refund_notes = (String) map.get("refund_notes");
                        OrderManagement orderManagement5 = new OrderManagement(oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes);
                        orderManagements5.add(orderManagement5);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        AdminPageResult pageResult1 = new AdminPageResult(0, "", count, orderManagements5);
        return pageResult1;
    }

    @Override
    public AdminPageResult<OrderManagement> ReceivedOrder(int start, int pageSize) {
        //查询数据总条数
        Long count = 0L;
        String sql = "select count(oid) count  from orderManagement where state='已收货'";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        sql = "select oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes from orderManagement where state='已收货' limit ?,?";
        Object[] params = new Object[]{start, pageSize};
        List<OrderManagement> orderManagements6 = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                long oid = (long) map.get("oid");
                String consignee = (String) map.get("consignee");
                String guest_book = (String) map.get("guest_book");
                BigDecimal total_amount = (BigDecimal) map.get("total_amount");
                BigDecimal received_amount = (BigDecimal) map.get("received_amount");
                String distribution = (String) map.get("distribution");
                String order_data = (String) map.get("order_data");
                String state = (String) map.get("state");
                String applicant = (String) map.get("applicant");
                BigDecimal refund_amount = (BigDecimal) map.get("refund_amount");
                String apply_data = (String) map.get("oapply_data");
                String refund_status = (String) map.get("refund_status");
                String refund_notes = (String) map.get("refund_notes");
                OrderManagement orderManagement6 = new OrderManagement(oid,consignee,guest_book,total_amount,received_amount,distribution,order_data,state,applicant,refund_amount,apply_data,refund_status,refund_notes);
                orderManagements6.add(orderManagement6);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        AdminPageResult pageResult1 = new AdminPageResult(0, "", count, orderManagements6);
        return pageResult1;
    }

    @Override
    public Map<Integer, Long> findCount() {
        //查询已发货数量
        String sql1 = "select count(oid) count from orderManagement where state = '已发货'";
        Map<Integer,Long> map = new HashMap<>();
        try {
            Map<String, Object> objectMap = DBDruidUtil.selectOne(sql1, null);
            Long count1 = (Long)objectMap.get("count");
            map.put(1,count1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //查询待发货数量
        String sql2 = "select count(oid) count from orderManagement where state = '待发货' ";
        try {
            Map<String, Object> objectMap = DBDruidUtil.selectOne(sql2, null);
            Long count2 = (Long)objectMap.get("count");
            map.put(2,count2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return map;
    }
}
