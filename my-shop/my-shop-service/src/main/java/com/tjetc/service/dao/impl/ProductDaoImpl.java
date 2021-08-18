package com.tjetc.service.dao.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.common.utils.DBDruidUtil;
import com.tjetc.service.dao.ProductDao;
import com.tjetc.service.entity.Category;
import com.tjetc.service.entity.First;
import com.tjetc.service.entity.Product;
import com.tjetc.service.entity.Second;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    /**
     * 查找库存小的
     * @param start
     * @param pageSize
     * @param num
     * @return
     */
    @Override
    public AdminPageResult<Product> selectWarning(int start, int pageSize, int num) {

        Long count=0L;
        String sql="select count(product_id) count from product where stock<?";
        Object[]params=new Object[]{num};
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, params);
            count= (Long)map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sql="select  product_id,product_name,stock,price,gpicture,des from product where stock<? limit ?,?";
        params = new Object[]{num,start, pageSize};
        List<Product> products=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Integer product_id = (Integer) map.get("product_id");
                String product_name = (String) map.get("product_name");
                String picturePath = (String) map.get("gpicture");
                String des = (String) map.get("des");
                BigDecimal price = (BigDecimal) map.get("price");
                Integer stock = (Integer) map.get("stock");
                Product product = new Product(product_id,product_name, price, stock,picturePath,des,0,0);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        AdminPageResult pageResult = new AdminPageResult(0, "", count, products);
        return pageResult;
    }

    /**
     * 查看商品的一二级分类
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public AdminPageResult<Category> selectCategory(int start, int pageSize) {
        Long count=0L;
        String sql="select COUNT(first_id) count from first_level";

        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count= (Long)map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sql="SELECT f.first_name,GROUP_CONCAT(s.second_name) second_name from category c,first_level f,second_level s WHERE \n" +
                "c.category_fid=f.first_id and c.category_sid=s.second_id\n" +
                "GROUP BY first_id limit ?,?";
        Object[]params = new Object[]{start, pageSize};
        List<Category> categories=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {

                String first_name = (String) map.get("first_name");
                String second_name = (String) map.get("second_name");
                Category category = new Category(first_name, second_name);
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        AdminPageResult pageResult = new AdminPageResult(0, "", count, categories);
        return pageResult;
    }

    @Override
    public int insertFist_level(String first_name)  {
        String sql="insert into first_level(first_name) VALUES (?)";
        Object[]params=new Object[]{first_name};
        try {
            BigInteger first_id = (BigInteger) DBDruidUtil.insert(sql, params);
            return first_id.intValue();
        }  catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public int insertSecond_level(String second_name) {
        String sql="insert into second_level(second_name) VALUES (?)";
        Object[]params=new Object[]{second_name};
        try {

            BigInteger second_id = (BigInteger) DBDruidUtil.insert(sql, params);

            return second_id.intValue();
        }  catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean insertCategory(int first_id, int second_id) {
        String sql="insert into category(category_fid,category_sid) VALUES(?,?)";
        Object[]params=new Object[]{first_id,second_id};
        try {
            BigInteger categroy_id = (BigInteger) DBDruidUtil.insert(sql, params);

            return  true;
        }  catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public AdminPageResult<First> selectFirst() {
        String sql="SELECT * from first_level";
        List<First> lists=new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, null);
            for (Map<String, Object> map : maps) {
                Integer first_id = (Integer) map.get("first_id");
                String first_name = (String) map.get("first_name");
                First first = new First(first_id, first_name);
                lists.add(first);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        AdminPageResult pageResult = new AdminPageResult(0, "", 0,lists);
        return pageResult;
    }

    @Override
    public AdminPageResult<Second> selectSecond(int first_id) {
        String sql="select s.second_id,s.second_name from second_level s,category c WHERE c.category_fid=? and c.category_sid=s.second_id";
        List<Second> lists=new ArrayList<>();
        Object[]params=new Object[]{first_id};
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Integer second_id = (Integer) map.get("second_id");
                String second_name = (String) map.get("second_name");
                Second second = new Second(second_id,second_name);
                lists.add(second);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        AdminPageResult pageResult = new AdminPageResult(0, "", 0,lists);
        return pageResult;
    }













    //查询在售商品
    @Override
    public AdminPageResult<Product> selectPage(int pageNo, int pageSize) {
        //查询数据总条数
        Long count = 0L;
        String sql = "select count(product_id) count from product where status_id = 1";
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //分页查询User的数据集合
        sql = "select product_id,product_name,gpicture,price,stock,des from product where status_id = 1 limit ?,?";
        Object[] params = {pageNo, pageSize};
        List<Product> products = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Integer product_id = (Integer) map.get("product_id");
                String product_name = (String) map.get("product_name");
                String picturePath = (String) map.get("gpicture");
                String des = (String) map.get("des");
                BigDecimal price = (BigDecimal) map.get("price");
                Integer stock = (Integer) map.get("stock");
                Product product = new Product(product_id,product_name, price, stock,picturePath,des,0,0);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        AdminPageResult pageResult = new AdminPageResult(0, "", count, products);
        return pageResult;
    }

    //下架商品
    @Override
    public boolean soldOut(Integer product_id) {
        boolean flag = false;
        try {
            String sql = "update product set status_id = 0 where product_id = ?";
            Object[] params = {product_id};
            flag = DBDruidUtil.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }

    //查询仓库
    @Override
    public AdminPageResult<Product> selectSoldOutPage(int pageNo, int pageSize) {
        Long count = 0L;
        try {
            //查询总条数
            String sql = "select count(product_id) count from product where status_id = 0";
            Map<String, Object> map = DBDruidUtil.selectOne(sql, null);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Product> products = new ArrayList<>();
        try {
            //分页查询
            String sql = "select product_id,product_name,gpicture,price,stock,des from product where status_id = 0 limit ?,?";
            Object[] params = {pageNo, pageSize};
            List<Map<String, Object>> maps = DBDruidUtil.selectList(sql, params);
            for (Map<String, Object> map : maps) {
                Integer product_id = (Integer) map.get("product_id");
                String product_name = (String) map.get("product_name");
                String picturePath = (String) map.get("gpicture");
                String des = (String) map.get("des");
                BigDecimal price = (BigDecimal) map.get("price");
                Integer stock = (Integer) map.get("stock");
                Product product = new Product(product_id,product_name, price, stock,picturePath,des,0,0);
                products.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        AdminPageResult result = new AdminPageResult(0, "", count, products);

        return result;
    }

    //上架商品
    @Override
    public boolean putaway(Integer product_id) {
        boolean flag = false;
        String sql = "update product set status_id = 1 where product_id = ?";
        Object[] params = {product_id};
        try {
            flag = DBDruidUtil.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }

    //欢迎页查询商品数量
    @Override
    public Map<Integer,Long> findCount() {
        //查询在线商品的数量
        String sql1 = "select count(product_id) count from product where status_id = 1";
        Map<Integer,Long> map = new HashMap<>();
        try {
            Map<String, Object> objectMap = DBDruidUtil.selectOne(sql1, null);
            Long count1 = (Long)objectMap.get("count");
            map.put(1,count1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //查询仓库商品数量
        String sql2 = "select count(product_id) count from product where status_id = 0";
        try {
            Map<String, Object> objectMap = DBDruidUtil.selectOne(sql2, null);
            Long count2 = (Long)objectMap.get("count");
            map.put(2,count2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return map;
    }
    

    //新增图片
    @Override
    public boolean addPicture(String picturePath, Integer product_id) {
//        boolean bl = false;
//        String sql2 = "insert into picture(picturePath,product_id) values(?,?)";
//        Object[] params2 = {picturePath, product_id};
//        try {
//            BigInteger id = (BigInteger) DBDruidUtil.insert(sql2, params2);
//            if (id != null) {
//                bl = true;
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return bl;
        return false;
    }

    //查商品是否重复
    @Override
    public Long productCount(String product_name) {
        Long count = null;
        //查询product_name是否存在
        String sql = "select count(product_id) count from product where product_name = ?";
        Object[] params = {product_name};
        try {
            Map<String, Object> map = DBDruidUtil.selectOne(sql, params);
            count = (Long) map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    //新增商品
    @Override
    public Boolean addProduct(Product product) {
        String sql="INSERT INTO product(product_name,`DES`,price,stock,gpicture,category_id,status_id) VALUES (?,?,?,?,?, (select category_id from category where category_fid=? and category_sid=?), 1)";
        Object[] params=new Object[]{product.getProduct_name(),product.getDes(),product.getPrice(),product.getstock(),product.getgpicture(),product.getOne(),product.getTwo()};
        try {
            Object insert = DBDruidUtil.insert(sql, params);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean allStores() {
        String sql = "update product set status_id = 1 where status_id = 0";
        boolean flag = false;
        try {
            flag = DBDruidUtil.update(sql, null);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }
}
