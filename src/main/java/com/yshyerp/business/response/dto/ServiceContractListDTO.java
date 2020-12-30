package com.yshyerp.business.response.dto;

import lombok.Data;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/25
 * @Description:
 */
@Data
public class ServiceContractListDTO {
    private String serviceid;
    private String name;
    private String unit;
    private Boolean istank;


    private String billid;
    private String showid;
    private String price;
    private String miniquan;
    private String freequan;
    private String istax;
    private String chargetype;
    private String taxrate;
    private String isnum;
    private String tank;
    private String remarks;
}
