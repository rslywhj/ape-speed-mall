package com.tjetc.user.service.impl;

import com.tjetc.user.dao.GoodsDao;
import com.tjetc.user.dao.impl.GoodsDaoImpl;
import com.tjetc.user.entity.Goods;
import com.tjetc.user.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public Goods selectGoods(long id) {

        Goods goods = goodsDao.selectGoods(id);
        return goods;
    }

    @Override
    public List<String> selectSecondName(String first_name) {
        List<String> list = goodsDao.selectSecondName(first_name);
        return list;
    }
}
