package com.yshyerp.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.business.entity.Contract;
import com.yshyerp.business.response.dto.DropDownBoxDTO;
import com.yshyerp.business.response.dto.ServiceContractListDTO;

import java.util.List;

public interface ContractMapper extends BaseMapper<Contract> {

    /**
     * 查询合同登记
     *
     * @return
     */
    List<Contract> getContract(Contract contract);

    /**
     * 根据id查询合同
     *
     * @param id
     * @return
     */
    List<ServiceContractListDTO> getServiceContractListByBillId(Integer id);

    /**
     * 添加合同登记
     *
     * @param contract 对象
     * @return
     */
    Integer addContract(Contract contract);

    /**
     * 修改合同登记
     *
     * @param contract
     * @return
     */
    Integer updateContract(Contract contract);

    /**
     * 多删除 修改状态
     *
     * @param list
     * @return
     */
    Integer deleteContract(List<Integer> list);

    /**
     * 根据id修改state状态(0审核)
     * @return
     */
    Integer updateByIdshenhe(List<Integer> list);

    /**
     * 根据id修改state状态(1作废)
     * @param id
     * @return
     */
    Integer updateByIdzuofe(List<Integer> id);

    /**
     * 根据id修改state状态(10已审核)
     * @param yishenhe
     * @return
     */
    Integer updateByIdyishenhe(List<Integer>yishenhe);
    /**
     * 根据id修改state状态(100已审核)
     * @param yiwancheng
     * @return
     */
    Integer updateByIdyiwancheng(List<Integer>yiwancheng);
    /**
     * 查询state状态下拉框
     * @return
     */
    List<DropDownBoxDTO> query();
}