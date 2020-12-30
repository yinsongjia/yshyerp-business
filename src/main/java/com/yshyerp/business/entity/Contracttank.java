package com.yshyerp.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class Contracttank {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //通过注解表名该字段不是数据库的字段
    @TableField(exist = false)
    private Integer key;
    private Integer billid;

    private Integer showid;

    private String tank;

    private String commodity;

    private Integer minInput;

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