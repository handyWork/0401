package com.springBoot.entity;

import java.io.Serializable;

public class JepaasEndUser implements Serializable {

    // 主键
    private  String userId;
    private String userName;
    private  String  photo;
    private  String email;
    private  String phone;
    private  String gsmc;
    //所属行业
    private  String sshyCode;
    private  String sshyName;
    //企业性质
    private  String qyxzCode;
    private  String qyxzName;
    private  String password;
    private String shengName;
    private String shiName;
    private String shengCode;
    private String shiCode;

    public String getShengName() {
        return shengName;
    }

    public void setShengName(String shengName) {
        this.shengName = shengName;
    }

    public String getShiName() {
        return shiName;
    }

    public void setShiName(String shiName) {
        this.shiName = shiName;
    }

    public String getShengCode() {
        return shengCode;
    }

    public void setShengCode(String shengCode) {
        this.shengCode = shengCode;
    }

    public String getShiCode() {
        return shiCode;
    }

    public void setShiCode(String shiCode) {
        this.shiCode = shiCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getSshyCode() {
        return sshyCode;
    }

    public void setSshyCode(String sshyCode) {
        this.sshyCode = sshyCode;
    }

    public String getSshyName() {
        return sshyName;
    }

    public void setSshyName(String sshyName) {
        this.sshyName = sshyName;
    }

    public String getQyxzCode() {
        return qyxzCode;
    }

    public void setQyxzCode(String qyxzCode) {
        this.qyxzCode = qyxzCode;
    }

    public String getQyxzName() {
        return qyxzName;
    }

    public void setQyxzName(String qyxzName) {
        this.qyxzName = qyxzName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
