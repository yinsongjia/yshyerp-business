package com.yshyerp.business.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.business.controller.common.ControllerTemplate;
import com.yshyerp.business.entity.SerVice;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.service.ServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("service/")
@RestController
@Slf4j
public class ServiceController implements ControllerTemplate<SerVice> {

    @Autowired
    private ServiceService serviceService;
//  @PostMapping("getservice")
//    public Response getService(@RequestBody Request<SerVice> serVice){
//     return serviceService.getService(serVice);
//  }

//@PostMapping("addService")
//    public Response addService(@RequestBody  Request<SerVice>  serVice){
//      return serviceService.addService(serVice.getData());
//}

//@GetMapping("deleteService/{serviceid}")
//    public  Response deleteService(@PathVariable    String serviceid){
//
//      return serviceService.deleteService(serviceid);
//}

//  @PostMapping("updateservice")
//    public Response updateservice(@RequestBody  Request<SerVice> serVice){
//
//      return serviceService.updateservice(serVice.getData());
//  }


    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response postListInit(Request<SerVice> request) {
        log.info("getService Response报文:{}", JSON.toJSONString(request));
        Response response = serviceService.getService(request);
        log.info("getService Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response addPost(Request<SerVice> request) {
        log.info("addService Response报文:{}", JSON.toJSONString(request));
        Response response = serviceService.addService(request.getData());
        log.info("addService Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("deleteShupcode Response报文参：{} ", JSON.toJSONString(request));
        List<String> list = (List<String>) JSON.parse(JSON.toJSONString(request.getData()));
        Response response = serviceService.deleteService(list);
        log.info("deleteByCustomer Response报文参：{}", JSON.toJSONString(response));
        return response;
    }


    @Override
    public Response updatePut(Request<SerVice> request) {
        log.info("deleteService Response报文:{}", JSON.toJSONString(request));
        Response response = serviceService.updateservice(request.getData());
        log.info("deleteService Response报文:{}", JSON.toJSONString(response));
        return response;
    }


    @Override
    public Response getDropDownInit() {
        return serviceService.qyery();
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }


}
