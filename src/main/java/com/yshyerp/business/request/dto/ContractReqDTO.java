package com.yshyerp.business.request.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.util.List;

/**
 * @Author: Administrator
 * @Data: 2020/12/10
 * @Description:
 */
public class ContractReqDTO {

    private String contractI;


    private String customer;
    private List<Integer> stateList;


    public String getContractI() {
        return contractI;
    }

    public void setContractI(String contractI) {
        this.contractI = contractI == null ? null : contractI.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public List<Integer> getStateList() {
        return stateList;
    }

    public void setStateList(List<Integer> stateList) {
        this.stateList = stateList;
    }
}
