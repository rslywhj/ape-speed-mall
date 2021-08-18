package com.tjetc.user.service;

import com.tjetc.user.entity.Goods;

import java.util.List;

public interface GoodsService {
    Goods selectGoods(long id);

    List<String> selectSecondName(String first_name);
}
