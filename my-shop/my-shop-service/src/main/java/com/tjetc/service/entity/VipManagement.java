package com.tjetc.service.entity;

public class VipManagement {
    private long vid;
    /**
     *账号
     */
    private String username;
    /**
     *头像
     */
    private String avatar;
    /**
     *用户名
     */
    private String vname;
    /**
     *手机号码
     */
    private String vphone;
    /**
     *电子邮箱
     */
    private  String vemail;
    /**
     *密码
     */
    private String password;
    /**
     *注册时间
     */
    private String registration_data;

    public VipManagement() {
    }

    public VipManagement(long vid, String avatar, String username, String vname, String vphone, String vemail, String password, String registration_data) {
        this.vid = vid;
        this.avatar = avatar;
        this.username = username;
        this.vname = vname;
        this.vphone = vphone;
        this.vemail = vemail;
        this.password = password;
        this.registration_data = registration_data;
    }

    public long getVid() {
        return vid;
    }

    public void setId(long vid) {
        this.vid = vid;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }

    public String getVemail() {
        return vemail;
    }

    public void setVemail(String vemail) {
        this.vemail = vemail;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getavatar() {
        return avatar;
    }

    public void setavatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRegistration_data() {
        return registration_data;
    }

    public void setRegistration_data(String registration_data) {
        this.registration_data = registration_data;
    }
}
