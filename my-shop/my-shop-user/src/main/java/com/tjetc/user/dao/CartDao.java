
package com.tjetc.user.dao;

import com.tjetc.user.entity.CartAndPro;

import java.util.List;

public interface CartDao {
    List<CartAndPro> selectAllCart(Long user_id);

    boolean deleteById(Long id);

    boolean delById(long id);

    boolean delAllById(String[] split);

    boolean addById(Long id);

    boolean insertById(CartAndPro cartAndPro);
    
    int selectById(Long user_id, Long product_id);

    boolean addUpdate(CartAndPro cartAndPro);

    /**
     * 减少库存
     */
    Boolean delectGoods(Long id,int num);

    /**
     * 从购物车中删除
     */
    Boolean deleteCart(Long id);


}
