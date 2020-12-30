package com.yshyerp.business.request.dto;


import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: zhoyuhao
 * @Data: 2020-10-30
 * @Description: 货品RequestDTO
 */
@Data
public class CommodityReqDTO {

    private String code;

    private String commodity;

    private String fullname;

    private String cname;

    private BigDecimal density;

    private String commCode;

    private String d;

    private Boolean wx;

    private Integer id;

    private Integer order1;

    private BigDecimal flash;

    private String nature;

    private String type;

}
