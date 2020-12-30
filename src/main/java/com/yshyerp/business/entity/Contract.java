package com.yshyerp.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Date;
import java.util.List;

public class Contract {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //通过注解表名该字段不是数据库的字段
    @TableField(exist = false)
    private Integer key;

    @TableField(value = "contract_i")
    private String contractI;

    private String d;

    private String customer;

    private Date stDate;

    private Date enDate;

    private Date chkDate;

    private String conLong;

    private String tank;

    private String commodity;

    private Integer minInput;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    private  Integer state;
    //使用注解后端不显示
    @JsonIgnore
    //通过注解表名该字段不是数据库的字段
    @TableField(exist = false)
    private List<Integer> stateList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractI() {
        return contractI;
    }

    public void setContractI(String contractI) {
        this.contractI = contractI == null ? null : contractI.trim();
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public Date getStDate() {
        return stDate;
    }

    public void setStDate(Date stDate) {
        this.stDate = stDate;
    }

    public Date getEnDate() {
        return enDate;
    }

    public void setEnDate(Date enDate) {
        this.enDate = enDate;
    }

    public Date getChkDate() {
        return chkDate;
    }

    public void setChkDate(Date chkDate) {
        this.chkDate = chkDate;
    }

    public String getConLong() {
        return conLong;
    }

    public void setConLong(String conLong) {
        this.conLong = conLong == null ? null : conLong.trim();
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank == null ? null : tank.trim();
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity == null ? null : commodity.trim();
    }

    public Integer getMinInput() {
        return minInput;
    }

    public void setMinInput(Integer minInput) {
        this.minInput = minInput;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public List<Integer> getStateList() {
        return stateList;
    }

    public void setStateList(List<Integer> stateList) {
        this.stateList = stateList;
    }
}