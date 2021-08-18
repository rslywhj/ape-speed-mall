package com.tjetc.user.dao;

import com.tjetc.user.entity.Goods;

import java.util.List;

public interface GoodsDao {
    /**
     * 查看商品
     */
    Goods selectGoods(long id);

    /**
     * 根据一级的名去看二级的名
     */
    List<String> selectSecondName(String first_name);


}
