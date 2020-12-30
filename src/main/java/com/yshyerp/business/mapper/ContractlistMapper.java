package com.yshyerp.business.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.business.entity.Contractlist;
import com.yshyerp.business.request.dto.ContractserviceReqVO;
import com.yshyerp.business.response.dto.DropDownBoxDTO;
import com.yshyerp.business.response.dto.ServiceContractListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContractlistMapper extends BaseMapper<Contractlist> {

    /**
     * 查询合同费率相关
     *
     * @param contractlist
     * @return
     */
    List<Contractlist> getContractlist(Contractlist contractlist);

    /**
     * 2表连查vo信息
     * @param contractserviceReqVO
     * @return
     */
    List<ContractserviceReqVO> getServiceContractList(Integer billid);
    /**
     * 查询服务内容下拉框
     * @return
     */
    List<DropDownBoxDTO>  query();

    /**
     * 添加合同费率相关
     *
     * @param contractlist
     * @return
     */
    Integer addContractlist(Contractlist contractlist);

    /**
     * 修改合同费率相关
     *
     * @param contractlist
     * @return
     */
    Integer updateContractlist(Contractlist contractlist);

    /**
     * 多删除 修改状态
     *
     * @param list
     * @return
     */
    Integer deleteContractlist(List<Integer> list);

}