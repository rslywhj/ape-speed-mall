package com.tjetc.user.service.impl;

import com.tjetc.user.dao.CartOderDao;
import com.tjetc.user.dao.impl.CartOrderDaoImpl;
import com.tjetc.user.entity.CartAndPro;
import com.tjetc.user.service.CartOrderService;

import java.util.List;

public class CartOrderServiceImpl implements CartOrderService {
    CartOderDao cartOderDao=new CartOrderDaoImpl();
    @Override
    public List<CartAndPro> selectPrice(Long vid, Long product_id) {
        List<CartAndPro> list = cartOderDao.SelectPrice(vid, product_id);
        return list;

    }
}
