package com.yshyerp.business.service;

import com.yshyerp.business.entity.Contractlist;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.request.dto.ContractserviceReqVO;
import com.yshyerp.business.response.Response;
import java.util.List;

public interface ContractlistService {

    /**
     * 查询合同费率相关
     *
     * @param req
     * @return
     */
    Response getContractlist(Request<Contractlist> req);

    /**
     * 查询服务内容下拉框
     * @return
     */
   Response  query();

    /**
     * 2表连查vo信息
     * @param contractserviceReqVO
     * @return
     */
    Response getServiceContractList(Integer billid);

    /**
     * 添加合同费率相关
     *
     * @param contractlist
     * @return
     */
    Response addContractlist(Request<Contractlist> contractlist);

    /**
     * 修改合同费率相关
     *
     * @param contractlist
     * @return
     */
    Response updateContractlist(Request<Contractlist> contractlist);

    /**
     * 多删除 修改状态
     *
     * @param list
     * @return
     */
    Response deleteContractlist(List<Integer> list);
}