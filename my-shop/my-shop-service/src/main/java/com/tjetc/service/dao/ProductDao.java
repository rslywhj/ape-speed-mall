package com.tjetc.service.dao;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.Category;
import com.tjetc.service.entity.First;
import com.tjetc.service.entity.Product;
import com.tjetc.service.entity.Second;

import java.util.Map;

/**
 * 关于商品表
 */
public interface ProductDao {

    /**
     * 库存预警
     *
     * @param start
     * @param pageSize
     * @param stock
     * @return
     */
    AdminPageResult<Product> selectWarning(int start, int pageSize, int stock);

    //查一级类别和二级类别确定的类别id
    AdminPageResult<Category> selectCategory(int start, int pageSize);

    //插入一级类别
    int insertFist_level(String first_name);

    //插入二级类别
    int insertSecond_level(String second_name);

    /**
     *  添加类别
     * @param first_id
     * @param second_id
     * @return
     */
    boolean insertCategory(int first_id, int second_id);

    // 查第一个类别的id
    AdminPageResult<First> selectFirst();

    // 查第2个类别的id
    AdminPageResult<Second> selectSecond(int first_id);


    /**
     * 分页查询数据 -- 查询在售商品
     *
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return
     */
    AdminPageResult<Product> selectPage(int pageNo, int pageSize);

    /**
     * 下架商品
     *
     * @param product_id
     * @return
     */
    boolean soldOut(Integer product_id);

    /**
     * 分页查询数据 -- 查询仓库
     *
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return
     */
    AdminPageResult<Product> selectSoldOutPage(int pageNo, int pageSize);

    /**
     * 上架商品
     *
     * @param product_id
     * @return
     */
    boolean putaway(Integer product_id);

    /**
     * 获取在售商品数量和仓库商品数量
     *
     * @return
     */
    Map<Integer, Long> findCount();

    /**
     * 添加商品
     */
    Boolean addProduct(Product product);

    /**
     * 增加图片
     *
     * @return
     */
    boolean addPicture(String picturePath,Integer product_id);

    /**
     * 查同一个名字商品的数量
     *
     * @param product_name
     * @return
     */
    Long productCount(String product_name);


    /**
     * 全部上架
     *
     * @return
     */
    boolean allStores();

}
