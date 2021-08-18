
package com.tjetc.user.entity;

import java.math.BigDecimal;

public class CartAndPro {

    private Long id;
    private Long user_id;
    private Long product_id;
    private String product_name;
    private BigDecimal price;
    private int num;
    
    public CartAndPro(Long user_id, Long product_id, String product_name, BigDecimal price, int num) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.num = num;
    }

    public CartAndPro(BigDecimal price, int num) {
        this.price = price;
        this.num = num;
    }

    public CartAndPro(Long id, String product_name, BigDecimal price, int num) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
