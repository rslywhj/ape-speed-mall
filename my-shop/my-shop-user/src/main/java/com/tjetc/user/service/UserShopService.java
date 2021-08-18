package com.tjetc.user.service;

import com.tjetc.user.entity.Address;
import com.tjetc.user.entity.BuyShop;
import com.tjetc.user.entity.Order;

import java.util.List;

public interface UserShopService {
    Long UserBuyShop(BuyShop buyShop);
    Boolean toPay(Long id);
    List<Address> selectAddress(Long vid);
    List<Order> waitPaid(Long vid);
    /**
     * 查看自己的待发货订单
     */
    List<Order> waitDeliver(Long vid);

    /**
     * 查看自己的已发货订单
     */
    List<Order> Deliver(Long vid);
    /**
     * 查看自己的取消/拒收订单
     */
    List<Order> Remove(Long vid);
    /**
     * 查看自己的已收货订单
     */
    List<Order> TakeDelivery(Long vid);
    /**
     * 查看自己的退款订单
     */
    List<Order> Refund(Long vid);
    /**
     * 取消/拒收
     */
    Boolean toRemove(Long vid);
    /**
     * 确认收货
     */
    Boolean toTakeDelivery(Long vid);
    /**
     * 申请退款
     */
    Boolean toApplyRefund(Long vid);

}
