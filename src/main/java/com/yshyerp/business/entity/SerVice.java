package com.yshyerp.business.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

@TableName("service")
public class SerVice {
    @TableId(value = "serviceid")
    private String serviceid;

    private String name;

    private String unit;

    private BigDecimal price;

    private String priceunit;

    private Boolean isdefault;

    private Boolean istank;

    private Boolean isship;

    private Integer chargetype;

    private Integer orderface;

    private Integer chargeclass;

    private Integer state;

    private String remark;

    private String d;

    private String sapservicecode;

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid == null ? null : serviceid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPriceunit() {
        return priceunit;
    }

    public void setPriceunit(String priceunit) {
        this.priceunit = priceunit == null ? null : priceunit.trim();
    }

    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    public Boolean getIstank() {
        return istank;
    }

    public void setIstank(Boolean istank) {
        this.istank = istank;
    }

    public Boolean getIsship() {
        return isship;
    }

    public void setIsship(Boolean isship) {
        this.isship = isship;
    }

    public Integer getChargetype() {
        return chargetype;
    }

    public void setChargetype(Integer chargetype) {
        this.chargetype = chargetype;
    }

    public Integer getOrderface() {
        return orderface;
    }

    public void setOrderface(Integer orderface) {
        this.orderface = orderface;
    }

    public Integer getChargeclass() {
        return chargeclass;
    }

    public void setChargeclass(Integer chargeclass) {
        this.chargeclass = chargeclass;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }

    public String getSapservicecode() {
        return sapservicecode;
    }

    public void setSapservicecode(String sapservicecode) {
        this.sapservicecode = sapservicecode == null ? null : sapservicecode.trim();
    }
}