package com.yshyerp.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.business.entity.Contracttank;
import com.yshyerp.business.response.dto.DropDownBoxDTO;


import java.util.List;

public interface ContracttankMapper extends BaseMapper<Contracttank> {

    /**
     * 根据billid查询指定的罐号
     *
     * @param billid
     * @return
     */
    List<Contracttank> getContracttankById(Integer billid);

    /**
     * 查询储罐相关
     *
     * @return
     */
    List<Contracttank> getContracttank(Contracttank contracttank);

    /**
     * 添加Contracttank储罐相关
     *
     * @return
     */
    Integer addContracttank(Contracttank contracttank);

    /**
     * 修改Contracttank储罐相关
     *
     * @return
     */
    Integer updateContracttank(Contracttank contracttank);

    /**
     * 罐号下拉框初始化
     *
     * @return
     */
    List<DropDownBoxDTO> qyery();

    /**
     * 删除储罐相关(修改状态)
     * @param id
     * @return
     */
    Integer delete(List<Integer> id);


}