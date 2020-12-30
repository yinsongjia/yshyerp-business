package com.yshyerp.business.service;

import com.yshyerp.business.entity.SerVice;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.response.dto.DropDownBoxDTO;

import java.util.List;

public interface ServiceService {

    /**
     * 服务内容下拉框初始化
     *
     * @return
     */
    Response qyery();

    /**
     * 根据id查询收费项目
     *
     * @param req
     * @param
     * @return
     */
    Response getService(Request<SerVice> req);

    /**
     * 添加收费项目
     *
     * @param serVice
     * @return
     */
    Response addService(SerVice serVice);

    /**
     * 修改id收费项目
     *
     * @param serVice
     */
    Response updateservice(SerVice serVice);

    /**
     * 根据id删除收费项目
     *
     * @param serviceid
     */
    Response deleteService(List<String> serviceid);
}
