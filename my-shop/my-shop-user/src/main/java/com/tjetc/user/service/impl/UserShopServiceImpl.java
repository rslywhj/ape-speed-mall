package com.tjetc.user.service.impl;

import com.tjetc.user.dao.UserShopDao;
import com.tjetc.user.dao.impl.UserShopDaoImpl;
import com.tjetc.user.entity.Address;
import com.tjetc.user.entity.BuyShop;
import com.tjetc.user.entity.Order;
import com.tjetc.user.service.UserShopService;

import java.util.List;

public class UserShopServiceImpl implements UserShopService {
    UserShopDao userShopDao=new UserShopDaoImpl();
    @Override
    public Long UserBuyShop(BuyShop buyShop) {
        Long aLong = userShopDao.BuyGoods(buyShop);
        return aLong;
    }

    @Override
    public Boolean toPay(Long id) {
        Boolean aBoolean = userShopDao.toPay(id);
        return aBoolean;
    }

    @Override
    public List<Address> selectAddress(Long vid) {
        List<Address> select = userShopDao.select(vid);
        return select;
    }

    @Override
    public List<Order> waitPaid(Long vid) {
        List<Order> list = userShopDao.waitPaid(vid);
        return list;
    }

    @Override
    public List<Order> waitDeliver(Long vid) {
        List<Order> list = userShopDao.waitDeliver(vid);
        return list;
    }

    @Override
    public List<Order> Deliver(Long vid) {
        List<Order> deliver = userShopDao.Deliver(vid);
        return deliver;
    }

    @Override
    public List<Order> Remove(Long vid) {
        List<Order> remove = userShopDao.Remove(vid);
        return remove;
    }

    @Override
    public List<Order> TakeDelivery(Long vid) {
        List<Order> list = userShopDao.TakeDelivery(vid);
        return list;
    }

    @Override
    public List<Order> Refund(Long vid) {
        List<Order> refund = userShopDao.Refund(vid);
        return refund;
    }

    @Override
    public Boolean toRemove(Long vid) {
        Boolean aBoolean = userShopDao.toRemove(vid);
        return aBoolean;
    }

    @Override
    public Boolean toTakeDelivery(Long vid) {
        Boolean aBoolean = userShopDao.toTakeDelivery(vid);
        return aBoolean;
    }

    @Override
    public Boolean toApplyRefund(Long vid) {
        Boolean aBoolean = userShopDao.toApplyRefund(vid);
        return aBoolean;
    }
}
