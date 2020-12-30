package com.yshyerp.business.request.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Administrator
 * @Data: 2020/12/11
 * @Description:
 */
@Data
public class ContractserviceReqVO {
    private Integer id;

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


    private String name;

    private String unit;

    private Boolean istank;

    private Integer chargetype;

}

