package com.tjetc.user.entity;

import java.math.BigDecimal;

public class BuyShop {
    /**
     * 姓名
     */
    private String consignee;
    /**
     * 用户id
     */
    private Long vid;
    /**
     * 备注
     */
    private String guest_book;
    /**
     * 总价格
     */
    private BigDecimal total_amount;


    /**
     * 邮寄方式
     */
    private String distribution;


    /**
     * 地址id
     */
    private String address_id;

    public BuyShop() {
    }

    public BuyShop(String consignee, Long vid, String guest_book, BigDecimal total_amount, String distribution, String  address_id) {
        this.consignee = consignee;
        this.vid = vid;
        this.guest_book = guest_book;
        this.total_amount = total_amount;
        this.distribution = distribution;
        this.address_id = address_id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getGuest_book() {
        return guest_book;
    }

    public void setGuest_book(String guest_book) {
        this.guest_book = guest_book;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String  getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String  address_id) {
        this.address_id = address_id;
    }
}
