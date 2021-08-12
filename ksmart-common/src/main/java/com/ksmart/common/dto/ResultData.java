package com.ksmart.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:28
 * @description:
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ResultData<T> {

    /**
     * 结果状态 ,正常响应200，其他状态码都为失败
     */
    private int status;
    private String msg;
    private T data;
    private boolean success;
    private long timestamp;
    /**
     * 返回到网关层用于记录详细日志的信息也可作为前端请求调试辅助信息
     */
    private String detail;

    public static <T> ResultData<T> ok(T data) {
        return ok(data, null);
    }

    public static <T> ResultData<T> error(String msg) {
        return error(msg, null);
    }


    public static <T> ResultData<T> success(T data, String msg) {
        return success(data, msg, null);
    }

    public static <T> ResultData<T> success(String msg) {
        return success(msg, null);
    }

    public static <T> ResultData<T> ok(T data, String detail) {
        return new ResultData<T>().setStatus(200).setData(data).setMsg("")
                .setSuccess(true).setTimestamp(
                        LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"))).setDetail(detail);
    }

    public static <T> ResultData<T> error(String msg, String detail) {
        return new ResultData<T>().setStatus(500).setMsg(msg)
                .setSuccess(false).setTimestamp(
                        LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"))).setDetail(detail);
    }


    public static <T> ResultData<T> success(T data, String msg, String detail) {
        return new ResultData<T>().setStatus(200).setData(data).setMsg(msg)
                .setSuccess(true).setTimestamp(
                        LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"))).setDetail(detail);
    }

    public static <T> ResultData<T> success(String msg, String detail) {
        return success(null, msg, detail);
    }
}
