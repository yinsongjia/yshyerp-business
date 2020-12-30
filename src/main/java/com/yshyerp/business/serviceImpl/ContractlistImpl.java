package com.yshyerp.business.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.business.entity.Contractlist;
import com.yshyerp.business.enums.MessageEnum;
import com.yshyerp.business.mapper.ContractlistMapper;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.request.dto.ContractserviceReqVO;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.service.ContractlistService;
import com.yshyerp.business.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: Administrator
 * @Data: 2020/11/27
 * @Description:
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class ContractlistImpl implements ContractlistService {
    @Autowired
    private ContractlistMapper contractlistMapper;

    @Override
    public Response getContractlist(Request<Contractlist> req) {

        Response response = null;
        //判断是否分页 否则查询所有
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        try {
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo<>(contractlistMapper.getContractlist(req.getData())));
        } catch (Exception e) {
            log.info("getContractlist接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response query() {
        JSONObject jsonObject=new JSONObject();
        String strname= JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (contractlistMapper.query())).replaceAll("\\s","");
        jsonObject.put("listname",JSON.parse(strname));
        return Response.success("查询成功",jsonObject);
    }

    @Override
    public Response getServiceContractList(Integer billid) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.SELECT_SUCCESS.getVal(), contractlistMapper.getServiceContractList(billid));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response addContractlist(Request<Contractlist> contractlist) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(), contractlistMapper.insert(contractlist.getData()));
        } catch (Exception e) {
            log.info("addContractlist接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateContractlist(Request<Contractlist> contractlist) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), contractlistMapper.updateById(contractlist.getData()));
        } catch (Exception e) {
            log.info("updateContractlist接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response deleteContractlist(List<Integer> list) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), contractlistMapper.deleteContractlist(list));
        } catch (Exception e) {
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.info("deleteContractlist接口操作失败", e.getMessage());
        }
        return response;
    }
}
