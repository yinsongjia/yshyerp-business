package com.yshyerp.business.controller.common;

import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-05
 * @Description: controller公共模板
 */
public interface ControllerTemplate<T> {


    /**
     * 获取指定的数据
     * 比如：显示详细信息
     *
     * @return
     */
    @GetMapping("getDetail/{request}")
    Response getDetail(@PathVariable String request);


    /**
     * 用于修改页面 数据初始化
     * 比如：显示修改的信息、下拉框数据
     *
     * @return
     */
    @GetMapping("getUpdateInit/{request}")
    Response getUpdateInit(@PathVariable String request);

    /**
     * 添加数据
     * 比如：点击确认按钮进行添加操作
     *
     * @return
     */
    @PostMapping("addPost")
    Response addPost(@RequestBody Request<T> request);


    /**
     * 删除数据
     * 比如：点击删除按钮进行删除操作
     *
     * @param request
     * @return
     */
    @DeleteMapping("delete")
    Response delete(@RequestBody Request request);

    /**
     * 修改数据
     * 比如：点击修改确认按钮进行的操作
     *
     * @return
     */
    @PutMapping("updatePut")
    Response updatePut(@RequestBody Request<T> request);

    /**
     * 页面数据上面下拉框初始化数据
     * 比如：用来条件查询数据的下拉框数据
     *
     * @return
     */
    @GetMapping("getDropDownInit")
    Response getDropDownInit();

    /**
     * 添加页面所需要的下拉框初始化数据
     * 比如：添加数据的时候对下拉框数据初始化
     *
     * @return
     */
    @GetMapping("getAddDropDownInit")
    Response getAddDropDownInit();

    /**
     * 页面数据List初始化 支持分页
     * 比如：页面数据的显示
     *
     * @return
     */
    @PostMapping("postListInit")
    Response postListInit(@RequestBody Request<T> request);
}
