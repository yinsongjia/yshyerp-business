package com.yshyerp.business.controller;

import com.yshyerp.business.controller.common.ControllerTemplate;
import com.yshyerp.business.entity.Commodity;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/20
 * @Description:
 */
@RequestMapping("commodity/")
@RestController
@Slf4j
public class CommodityController implements ControllerTemplate<Commodity> {
    @Autowired //默认按类型匹配的方式，在容器查找匹配的Bean，当有且仅有一个匹配的Bean时，Spring将其注入@Autowired标注的变量中。
    private CommodityService commodityService;

    @Override //表示当前方法覆盖了父类的方法
    public Response getDetail(String request) {
        return null;
    }

    @Override //表示当前方法覆盖了父类的方法
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override //表示当前方法覆盖了父类的方法
    public Response addPost(Request<Commodity> request) {
        return null;
    }

    @Override //表示当前方法覆盖了父类的方法
    public Response delete(Request request) {
        return null;
    }

    @Override //表示当前方法覆盖了父类的方法
    public Response updatePut(Request<Commodity> request) {
        return null;
    }

    @Override //表示当前方法覆盖了父类的方法
    public Response getDropDownInit() {
        return commodityService.qyery();
    }

    @Override //表示当前方法覆盖了父类的方法
    public Response getAddDropDownInit() {
        return null;
    }

    @Override //表示当前方法覆盖了父类的方法
    public Response postListInit(Request<Commodity> request) {
        return null;
    }
}
