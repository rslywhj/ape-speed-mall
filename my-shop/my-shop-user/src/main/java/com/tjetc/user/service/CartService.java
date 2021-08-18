
package com.tjetc.user.service;

import com.tjetc.user.entity.CartAndPro;

import java.util.List;

public interface CartService {
    List<CartAndPro> findAllCart(Long user_id);

    boolean deleteById(Long id);

    boolean removeById(long id);

    boolean delAll(String[] split);
    
    boolean addById(CartAndPro cartAndPro);

    int selectByid(Long user_id, Long product_id);
    
    boolean addUpdate(Long id);

    /**
     * 减少商品库存
     */
    boolean updateGoods(Long product_id,int num);

    /**
     * 从购物车中删除
     */
    boolean deleteCart(Long id);


}
