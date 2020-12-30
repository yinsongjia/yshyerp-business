package com.yshyerp.business.service;

import com.yshyerp.business.entity.Contract;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.response.dto.DropDownBoxDTO;

import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/17
 * @Description:
 */
public interface ContractService {
    /**
     * 查询合同登记
     *
     * @param req
     * @return
     */
    Response getContract(Request<Contract> req);
    /**
     * 根据id修改state状态(审核)
     * @return
     */
    Response updateByIdshenhe(List<Integer> list);

    /**
     * 根据id修改state状态(作废)
     * @param id
     * @return
     */
    Response updateByIdzuofe(List<Integer> id);

    /**
     * 根据id修改state状态(已审核)
     * @param yishenhe
     * @return
     */
    Response updateByIdyishenhe(List<Integer>yishenhe);

    /**
     * 根据id修改state状态(100已审核)
     * @param yiwancheng
     * @return
     */
    Response updateByIdyiwancheng(List<Integer>yiwancheng);

    /**
     * 查询state状态下拉框
     * @return
     */
      Response query();

    /**
     * 根据id查询合同
     *
     * @param id
     */
    Response getContractById(Integer id);

    /**
     * 添加合同登记
     *
     * @param contract 对象
     * @return
     */
    Response addContract(Request<Contract> contract);

    /**
     * 修改合同登记
     *
     * @param contract
     * @return
     */
    Response updateContract(Request<Contract> contract);

    /**
     * 多删除 修改状态
     *
     * @param list
     * @return
     */
    Response deleteContract(List<Integer> list);
}
