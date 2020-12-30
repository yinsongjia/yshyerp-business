package com.yshyerp.business.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.business.controller.common.ControllerTemplate;
import com.yshyerp.business.entity.Contract;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.service.ContractService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/17
 * @Description:
 */
@RequestMapping("contract/")
@RestController
@Slf4j
public class ContractController implements ControllerTemplate<Contract> {
    @Autowired
    private ContractService contractService;

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<Contract> request) {
        log.info("addBerth Response报文:{}", JSON.toJSONString(request));
        Response response = contractService.addContract(request);
        log.info("addBerth Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    //@PathVariable  接收请求路径中占位符的值
    @GetMapping("getContractById/{id}")
    public Response getContractById(@PathVariable Integer id) {
        return contractService.getContractById(id);
    }


    @PutMapping("updateByIdshenhe")
   public  Response updateByIdshenhe(@RequestBody Request<List<Integer>> list){
       log.info("updateByIdshenhe报文:{}", JSON.toJSONString(list));
//       List<Integer> a = JSON.parseArray(JSON.toJSONString(list);
       Response response = contractService.updateByIdshenhe(list.getData());
       log.info("updateByIdshenhe报文:{}", JSON.toJSONString(response));
       return response;
   }

   @PutMapping("updateByIdzuofe")
   public  Response updateByIdzuofe(@RequestBody Request<List<Integer>> list){
        log.info("updateByIdzuofe Response报文:{}",JSON.toJSONString(list));
        Response response=contractService.updateByIdzuofe(list.getData());
        log.info("updateByIdzuofe Response报文:{}",JSON.toJSONString(response));
        return response;
   }
   @PutMapping("updateByIdyishenhe")
   public  Response updateByIdyishenhe(@RequestBody Request<List<Integer>> list){
        log.info("updateByIdyishenhe Response报文:{}",JSON.toJSONString(list));
        Response response=contractService.updateByIdyishenhe(list.getData());
        log.info("updateByIdyishenhe Response报文:{}",JSON.toJSONString(response));
        return  response;
   }
  @PutMapping("updateByIdyiwancheng")
  public Response updateByIdyiwancheng(@RequestBody Request<List<Integer>>list){
        log.info("updateByIdyiwancheng Response报文:{}",JSON.toJSONString(list));
        Response response=contractService.updateByIdyiwancheng(list.getData());
        log.info("updateByIdyiwancheng Response报文:{}",JSON.toJSONString(response));
        return  response;
  }
    @Override
    public Response delete(Request request) {
        log.info("deleteContract报文:{}", JSON.toJSONString(request));
        List<Integer> list = JSON.parseArray(JSON.toJSONString(request.getData()), Integer.class);
        Response response = contractService.deleteContract(list);
        log.info("deleteContract报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response updatePut(Request<Contract> request) {
        log.info("updateContract Response报文:{}", JSON.toJSONString(request));
        Response response = contractService.updateContract(request);
        log.info("updateContract Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getDropDownInit() {
        List<Map<String,Object>> stateList = new ArrayList<Map<String,Object>>();
        Map<String,Object> stateMap1 = new HashMap<String, Object>();
        Map<String,Object> stateMap2 = new HashMap<String, Object>();
        Map<String,Object> stateMap3 = new HashMap<String, Object>();
        Map<String,Object> stateMap4 = new HashMap<String, Object>();
        stateMap1.put("key", 0);
        stateMap1.put("label", "待审核");
        stateMap2.put("key", 1);
        stateMap2.put("label", "已作废");
        stateMap3.put("key",10);
        stateMap3.put("label","已审核");
        stateMap4.put("key", 100);
        stateMap4.put("label", "已完成");
        stateList.add(stateMap1);
        stateList.add(stateMap2);
        stateList.add(stateMap3);
        stateList.add(stateMap4);
        return Response.success("查询成功",stateList);
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @Override
    public Response postListInit(Request<Contract> request) {
        log.info("getContract Response报文:{}", JSON.toJSONString(request));
        Response response = contractService.getContract(request);
        log.info("getContract Response报文:{}", JSON.toJSONString(response));
        return response;
    }
}

