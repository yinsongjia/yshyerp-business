package com.yshyerp.business.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.business.entity.Contract;
import com.yshyerp.business.entity.Contracttank;
import com.yshyerp.business.enums.MessageEnum;
import com.yshyerp.business.mapper.ContractMapper;
import com.yshyerp.business.mapper.ContracttankMapper;
import com.yshyerp.business.mapper.SerViceMapper;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.request.dto.ContractReqDTO;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.response.dto.ServiceContractListDTO;
import com.yshyerp.business.service.ContractService;
import com.yshyerp.business.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/17
 * @Description:
 */
@Service   //用于标注业务层组件（注入dao）
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class ContractImpl implements ContractService {
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ContracttankMapper contracttankMapper;
    @Autowired
    private SerViceMapper serViceMapper;


    @Override
    public Response getContract(Request<Contract> req) {
        Response response = null;
        //判断是否分页 否则查看所有
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        try {
//            QueryWrapper<Contract> qw = Wrappers.query();
//            qw.apply("ISNULL(d,'')=''");
//            qw.orderByAsc("id");
//            if (!StringUtils.isEmpty(req.getData().getContractI())) qw.eq("contract_i", req.getData().getContractI());
//            if (!StringUtils.isEmpty(req.getData().getCustomer())) qw.eq("customer", req.getData().getCustomer());
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo<>(contractMapper.getContract(req.getData())));
        } catch (Exception e) {
            log.info(e.getMessage());
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response updateByIdshenhe(List<Integer> list) {
        Response response=null;
        try {
            response =Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), contractMapper.updateByIdshenhe(list));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response updateByIdzuofe(List<Integer> id) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.UPDATE_SUCCESS.getVal(),contractMapper.updateByIdzuofe(id));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response updateByIdyishenhe(List<Integer> yishenhe) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), contractMapper.updateByIdyishenhe(yishenhe));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response updateByIdyiwancheng(List<Integer> yiwancheng) {
        Response response=null;
        try {
            response=Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), contractMapper.updateByIdyiwancheng(yiwancheng));
        }catch (Exception e){
            log.info(e.getMessage());
            response=Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }


    @Override
    public Response query() {
        JSONObject jsonObject=new JSONObject();
        String strContract= JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (contractMapper.query())).replaceAll("\\s","");
         jsonObject.put("listContract",JSON.parse(strContract));
        return Response.success("查询成功",jsonObject);
    }

    @Override
    public Response getContractById(Integer id) {
        Response response = null;
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper qw = Wrappers.query();
            qw.eq("billid", id);

            Contract contract = contractMapper.selectById(id);
            List<Contracttank> contracttankList = contracttankMapper.selectList(qw);

            map.put("contract", contract);
            map.put("contracttankList", contracttankList);

            List<ServiceContractListDTO> serviceContractList = contractMapper.getServiceContractListByBillId(id);

            map.put("serviceContractList", serviceContractList);
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), map);
        } catch (Exception e) {
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("getContractById：{}", e.getMessage());
        }
        return response;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response addContract(Request<Contract> contract) {
        Response response = null;
        try {
            //执行sql操作
            response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(), contractMapper.insert(contract.getData()));
        } catch (Exception e) {
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
            log.info(e.getMessage());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateContract(Request<Contract> contract) {
        Response response = null;
        try {
            //执行sql操作
            response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), contractMapper.updateById(contract.getData()));
        } catch (Exception e) {
            log.info(e.getMessage());
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    public Response deleteContract(List<Integer> list) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), contractMapper.deleteContract(list));
        } catch (Exception e) {
            log.info("deleteContract接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
        }
        return response;
    }
}
