package com.tjetc.user.service;

import com.tjetc.user.entity.CartAndPro;

import java.util.List;

public interface CartOrderService {
    List<CartAndPro> selectPrice(Long vid,Long product_id);

}
