package com.yshyerp.business.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.business.entity.SerVice;
import com.yshyerp.business.response.dto.DropDownBoxDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SerViceMapper extends BaseMapper<SerVice> {

    /**
     * 服务内容下拉框初始化
     *
     * @return
     */
    List<DropDownBoxDTO> qyery();

    /**
     * 根据id查询收费项目
     *
     * @param serviceid 收费id
     * @param name      收费名称
     * @return
     */
    List<SerVice> getService(@Param("serviceid") String serviceid, @Param("name") String name);

    /**
     * 添加收费项目
     *
     * @param serVice
     * @return
     */
    Integer addService(@Param("serVice") SerVice serVice);

    /**
     * 修改id收费项目
     *
     * @param serVice
     */
    Integer updateservice(SerVice serVice);

    /**
     * 根据id删除收费项目
     *
     * @param serviceid
     */
    Integer deleteService(List<String> serviceid);
}