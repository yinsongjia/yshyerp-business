package com.yshyerp.business.service;

import com.yshyerp.business.entity.Contracttank;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;

import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/18
 * @Description:
 */
public interface ContracttankService {


    /**
     * 根据billid查询指定的罐号
     *
     * @param billid
     * @return
     */
    Response getContracttankById(Integer billid);

    /**
     * 查询储罐相关
     *
     * @return
     */
    Response getContracttank(Request<Contracttank> req);

    /**
     * 添加Contracttank储罐相关
     *
     * @return
     */
    Response addContracttank(Request<Contracttank> contracttank);

    /**
     * 修改Contracttank储罐相关
     *
     * @return
     */
    Response updateContracttank(Request<Contracttank> contracttank);

    /**
     * 货品下拉框初始化
     *
     * @return
     */
    Response qyery();

    /**
     * 删除储罐相关(修改状态)
     * @param id
     * @return
     */
    Response delete(List<Integer> id);
}
