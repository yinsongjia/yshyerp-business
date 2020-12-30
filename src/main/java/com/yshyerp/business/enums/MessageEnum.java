package com.yshyerp.business.enums;

/**
 * @Author: zhouyuhao
 * @Data: 2020-11-04
 */
public enum MessageEnum {

    INSERT_ERROR("添加失败！"),
    UPDATE_ERROR("修改失败！"),
    SELECT_ERROR("查询失败！"),
    DELETE_ERROR("删除失败！"),
    INSERT_SUCCESS("添加成功"),
    UPDATE_SUCCESS("修改成功"),
    SELECT_SUCCESS("查询成功"),
    DELETE_SUCCESS("删除成功");

    private String val;

    MessageEnum(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }


}
