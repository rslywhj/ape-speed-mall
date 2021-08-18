package com.tjetc.service.service.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.dao.OrderManagementDao;
import com.tjetc.service.dao.impl.OrderManagementDaoImpl;
import com.tjetc.service.entity.OrderManagement;
import com.tjetc.service.service.OrderManagementService;

import java.util.List;
import java.util.Map;

public class OrderManagementServiceImpl implements OrderManagementService {
    OrderManagementDao orderManagementDao = new OrderManagementDaoImpl();

    @Override
    public AdminPageResult<OrderManagement> page(int start, int pageSize) {
        return orderManagementDao.selectPage(start, pageSize);
    }

    @Override
    public AdminPageResult<OrderManagement> waitPaid(int start, int pageSize) {
        return orderManagementDao.waitPaid(start,pageSize);
    }

    @Override
    public AdminPageResult<OrderManagement> ShippedOrder(int start, int pageSize) {
        return orderManagementDao.ShippedOrder(start,pageSize);
    }

    @Override
    public AdminPageResult<OrderManagement> RejectOrder(int start, int pageSize) {
        return orderManagementDao.RejectOrder(start,pageSize);
    }

    @Override
    public AdminPageResult<OrderManagement> RefundOrder(int start, int pageSize) {
        return orderManagementDao.RefundOrder(start,pageSize);
    }

    @Override
    public AdminPageResult<OrderManagement> ReceivedOrder(int start, int pageSize) {
        return orderManagementDao.ReceivedOrder(start,pageSize);
    }

    @Override
    public Map<Integer, Long> findCount() {
        Map<Integer, Long> map = orderManagementDao.findCount();
        if (map!=null){
            return map;
        }else {
            map.put(1,0L);
            map.put(2,0L);
        }
        return map;
    }
}