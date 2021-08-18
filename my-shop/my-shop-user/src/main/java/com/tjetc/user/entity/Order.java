package com.tjetc.user.entity;

import java.math.BigDecimal;

public class Order {
      private Long oid;
      private String consignee;
      private String guest_book;
      private BigDecimal total_amount;
      private String distribution;
      private String order_data;
      private String refund_status;
      private String refund_notes;
      private String apply_data;

    public Order(Long oid, String consignee,  BigDecimal total_amount,  String refund_status, String refund_notes,String apply_data,String distribution) {
        this.oid = oid;
        this.consignee = consignee;
        this.total_amount = total_amount;
        this.refund_status = refund_status;
        this.refund_notes = refund_notes;
        this.apply_data=apply_data;
        this.distribution = distribution;

    }

    public Order(Long oid, String consignee, String guest_book, BigDecimal total_amount, String distribution, String order_data) {
        this.oid = oid;
        this.consignee = consignee;
        this.guest_book = guest_book;
        this.total_amount = total_amount;
        this.distribution = distribution;
        this.order_data = order_data;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
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

    public String getOrder_data() {
        return order_data;
    }

    public void setOrder_data(String order_data) {
        this.order_data = order_data;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public String getRefund_notes() {
        return refund_notes;
    }

    public void setRefund_notes(String refund_notes) {
        this.refund_notes = refund_notes;
    }
}
