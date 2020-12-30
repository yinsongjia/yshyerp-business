package com.yshyerp.business.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.business.entity.Contractlist;
import com.yshyerp.business.entity.Contracttank;
import com.yshyerp.business.enums.MessageEnum;
import com.yshyerp.business.mapper.CommodityMapper;
import com.yshyerp.business.mapper.ContractlistMapper;
import com.yshyerp.business.mapper.ContracttankMapper;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.response.dto.DropDownBoxDTO;
import com.yshyerp.business.service.ContracttankService;
import com.yshyerp.business.utils.DropDownBoxUtils;
import com.yshyerp.business.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/18
 * @Description:
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class ContracttankImpl implements ContracttankService {

    @Autowired
    private ContracttankMapper contracttankMapper; //储罐相关
    @Autowired
    private ContractlistMapper contractlistMapper; //

    @Autowired
    private CommodityMapper commodityMapper; //货品

    @Override
    public Response getContracttankById(Integer billid) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), contracttankMapper.getContracttankById(billid));
        } catch (Exception e) {
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("getContracttankById：{}", e.getMessage());
        }
        return response;
    }

    @Override
    public Response getContracttank(Request<Contracttank> req) {
        Response response = null;
        //判断是否分页 否则查询所有
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        try {
            QueryWrapper<Contracttank> qw = Wrappers.query();
            if (!StringUtils.isEmpty(req.getData().getCommodity())) qw.eq("commodity", req.getData().getCommodity());
            if (!StringUtils.isEmpty(req.getData().getTank())) qw.eq("tank", req.getData().getTank());
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo<>(contracttankMapper.getContracttank(req.getData())));
        } catch (Exception e) {
            log.info("getContracttank接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
        }

        return response;
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public Response addContracttank(Request<Contracttank> contracttank) {
        Response response = null;
        try {


            response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(), contracttankMapper.insert(contracttank.getData()));
        } catch (Exception e) {
            log.info("addContracttank接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
        }
        return response;
    }

    //    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public Response updateContracttank(Request<Contracttank> contracttank) {
        Response response = null;
        try {

            response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), contracttankMapper.updateById(contracttank.getData()));
        } catch (Exception e) {
            log.info("updateContracttank接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response qyery() {
        JSONObject jsonObject=new JSONObject();
        String strContract= JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (contracttankMapper.qyery())).replaceAll("\\s","");
        jsonObject.put("listContract",JSON.parse(strContract));
        return Response.success("查询成功",jsonObject);
    }

    @Override
    public Response delete(List<Integer> id) {
   Response response=null;
        try {
            response=Response.success(MessageEnum.DELETE_SUCCESS.getVal(), contracttankMapper.delete(id));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.DELETE_ERROR.getVal());
        }
        return response;
    }
}
