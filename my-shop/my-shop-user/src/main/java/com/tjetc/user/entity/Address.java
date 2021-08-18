package com.tjetc.user.entity;

/**
 * 地址
 */
public class Address {
    /**
     * 地址id
     */
    Long address_id;
    /**
     * 用户id
     */
    Long username_id;
    /**
     * 用户地址
     */
    String address;

    public Address(Long address_id, Long username_id, String address) {
        this.address_id = address_id;
        this.username_id = username_id;
        this.address = address;
    }

    public Address(Long address_id, String address) {
        this.address_id = address_id;
        this.address = address;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public Long getUsername_id() {
        return username_id;
    }

    public void setUsername_id(Long username_id) {
        this.username_id = username_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
