package com.yshyerp.business.response;

import lombok.Data;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/2
 * @Description: Response
 */
@Data
public class Response<T> {
    //返回信息
    private String message = "操作成功";

    //返回主体
    private T data;

    //返回状态
    private String status = "200";

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    public static <T> Response<T> success(String message, T data) {
        Response response = new Response();
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> error(String message) {
        Response response = new Response();
        response.setMessage(message);
        response.setStatus("500");
        return response;
    }
}
