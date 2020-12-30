package com.yshyerp.business.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.business.entity.Commodity;
import com.yshyerp.business.response.dto.DropDownBoxDTO;

import java.util.List;

public interface CommodityMapper extends BaseMapper<Commodity> {

    /**
     * 货品下拉框初始化
     *
     * @return
     */
    List<DropDownBoxDTO> qyery();

}