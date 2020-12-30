package com.yshyerp.business.utils;


import com.alibaba.fastjson.JSONObject;
import com.yshyerp.business.response.dto.DropDownBoxDTO;

import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-11
 * @Description: 下拉框utils
 */
public class DropDownBoxUtils {

    /**
     * 将对象数组转换成指定json格式 案例  {"全部":{text:"全部"},"是":{text:"是"} }
     *
     * @param list
     * @return
     */
    public static JSONObject toDropDownBoxJSON(List<DropDownBoxDTO> list) {
        JSONObject jsonObj2 = new JSONObject();
        Integer index = null;
        for (DropDownBoxDTO dr : list) {
            JSONObject jsonObj3 = new JSONObject();
            if (index == null) {
                jsonObj3.put(DropDownBoxDTO.TEXT, "全部");
                jsonObj2.put(DropDownBoxDTO.CHINSES_ALL, jsonObj3);
                jsonObj3 = new JSONObject();
                index = 1;
            }
            jsonObj3.put(DropDownBoxDTO.TEXT, dr.getValue());
            jsonObj2.put(dr.getValue(), jsonObj3);
        }
        return jsonObj2;
    }
}
