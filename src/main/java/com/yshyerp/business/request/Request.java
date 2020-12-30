package com.yshyerp.business.request;


import lombok.Data;

@Data
/**
 * @Author: yinsongjia
 * @Data: 2020/11/2
 * @Description: Request
 */
public class Request<T> {
    //请求主体
    private T data;

    //分页（当前页）
    private Integer pageNum;

    //分页（页大小）
    private Integer pageSize;
}
