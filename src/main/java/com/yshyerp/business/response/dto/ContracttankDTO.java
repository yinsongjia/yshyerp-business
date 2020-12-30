package com.yshyerp.business.response.dto;

import lombok.Data;

@Data
public class ContracttankDTO {
    private Integer billid;
    private String tank; //罐号
    private String commodity; //货品
    private Integer min_input; //最小量
    private String remarks;   //备注
}
