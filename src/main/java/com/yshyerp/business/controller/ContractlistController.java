package com.yshyerp.business.controller;


import com.alibaba.fastjson.JSON;
import com.yshyerp.business.controller.common.ControllerTemplate;
import com.yshyerp.business.entity.Contractlist;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.request.dto.ContractserviceReqVO;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.service.ContractlistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Administrator
 * @Data: 2020/11/27
 * @Description:
 */
@RequestMapping("contractlist/")
@RestController
@Slf4j
public class ContractlistController implements ControllerTemplate<Contractlist> {
    @Autowired
    private ContractlistService contractlistService;

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<Contractlist> request) {
        log.info("addContractlist Response报文:{}", JSON.toJSONString(request));
        Response response = contractlistService.addContractlist(request);
        log.info("addContractlist Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("deleteContractlist  Response报文:{}", JSON.toJSONString(request));
        List<Integer> list = JSON.parseArray(JSON.toJSONString(request.getData()), Integer.class);
        Response response = contractlistService.deleteContractlist(list);
        log.info("deleteContractlist Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response updatePut(Request<Contractlist> request) {
        log.info("updatePut Response报文:{}", JSON.toJSONString(request));
        Response response = contractlistService.updateContractlist(request);
        log.info("updatePut Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getDropDownInit() {
        return contractlistService.query();
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }


    //@PathVariable  接收请求路径中占位符的值
    @GetMapping("getServiceContractList/{billid}")
    public Response getServiceContractList(@PathVariable Integer billid) {
        return contractlistService.getServiceContractList(billid) ;
    }
    @Override
    public Response postListInit(Request<Contractlist> request) {
        log.info("getContract Response报文:{}", JSON.toJSONString(request));
        Response response = contractlistService.getContractlist(request);
        log.info("getContract Response报文:{}", JSON.toJSONString(response));
        return response;
    }
}
