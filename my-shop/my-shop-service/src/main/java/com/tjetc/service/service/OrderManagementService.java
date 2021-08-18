package com.tjetc.service.service;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.OrderManagement;
import com.tjetc.service.entity.VipManagement;

import java.util.List;
import java.util.Map;

public interface OrderManagementService {
    /**
     * 分页查询OrderManagement
     *
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return
     */
    AdminPageResult<OrderManagement> page(int pageNo, int pageSize);
    /* List<OrderManagement> PendingOrder(int pageNo, int pageSize);
     *//**
     * 待付款
     */
    AdminPageResult<OrderManagement> waitPaid(int pageNo, int pageSize);
    /*
     * 已发货
     */
    AdminPageResult<OrderManagement> ShippedOrder(int pageNo, int pageSize);
    /**
     * 取消/拒收订单
     */
    AdminPageResult<OrderManagement> RejectOrder(int pageNo, int pageSize);
    /**
     * 退款订单
     */
    AdminPageResult<OrderManagement> RefundOrder(int pageNo, int pageSize);
    /**
     * 已收货
     */
    AdminPageResult<OrderManagement> ReceivedOrder(int pageNo, int pageSize);

    Map<Integer,Long> findCount();
}
