package com.yshyerp.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;

public class Contractlist {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    //通过注解表名该字段不是数据库的字段
    @TableField(exist = false)
    private Integer key;
    private Integer billid;

    private Integer showid;

    private String serviceid;

    private BigDecimal price;

    private BigDecimal miniquan;

    private BigDecimal freequan;

    private Boolean istax;

    private BigDecimal taxrate;

    private Boolean isnum;

    private String tank;

    private String remarks;

    private String d;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public Integer getShowid() {
        return showid;
    }

    public void setShowid(Integer showid) {
        this.showid = showid;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid == null ? null : serviceid.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMiniquan() {
        return miniquan;
    }

    public void setMiniquan(BigDecimal miniquan) {
        this.miniquan = miniquan;
    }

    public BigDecimal getFreequan() {
        return freequan;
    }

    public void setFreequan(BigDecimal freequan) {
        this.freequan = freequan;
    }

    public Boolean getIstax() {
        return istax;
    }

    public void setIstax(Boolean istax) {
        this.istax = istax;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public Boolean getIsnum() {
        return isnum;
    }

    public void setIsnum(Boolean isnum) {
        this.isnum = isnum;
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank == null ? null : tank.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }
}