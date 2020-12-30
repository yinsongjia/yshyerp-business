package com.yshyerp.business.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yshyerp.business.mapper.CommodityMapper;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.response.dto.DropDownBoxDTO;
import com.yshyerp.business.service.CommodityService;
import com.yshyerp.business.utils.DropDownBoxUtils;
import com.yshyerp.business.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/20
 * @Description:
 */

@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class CommodityImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public Response qyery() {
        List<DropDownBoxDTO> commodityList = commodityMapper.qyery();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",DropDownBoxUtils.toDropDownBoxJSON(commodityMapper.qyery()));
//        JSONObject jsonObject=new JSONObject();
//          String strList=JSON.toJSONString(contracttankMapper.qyery()).replaceAll("\\s","");
//               jsonObject.put("lisType",JSON.parse(strList));
        return Response.success("查询成功", jsonObject);
    }
}
