package com.yshyerp.business.response.dto;


import lombok.Data;

/**
 * @Author: zhoyuhao
 * @Data: 2020-10-30
 * @Description: 下拉框模板
 */
@Data
public class DropDownBoxDTO {

    private String label;

    private String value;

    private String key;

    public final static String CHINSES_ALL = "全部";
    public final static String TEXT = "text";
    public final static String CHINSES_YES = "是";
    public final static String CHINSES_NO = "否";
    public final static String CHINSES_BOY = "男";
    public final static String CHINSES_GIRL = "女";


    public DropDownBoxDTO() {
    }

    ;

    public DropDownBoxDTO(String key, String value, String label) {
        this.value = value;
        this.label = label;
        this.key = key;
    }

    ;
}
