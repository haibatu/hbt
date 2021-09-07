package com.hbt.common.web.utils;

import com.hbt.common.web.data.BaseRsp;
import org.springframework.util.CollectionUtils;
import java.util.Collections;
import java.util.List;

/**
 * 统一返回错误
 * @author Administrator
 */
public class BaseRspUtil {




    /**
     * 成功
     * @param <T>
     * @return
     */
    public static <T> BaseRsp success() {
        return new BaseRsp(Rsp.SUCCESS.getCode(),
                Rsp.SUCCESS.getMessage(),
                Collections.emptyList());
    }

    /**
     * 成功，自定义提示信息
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BaseRsp success(String message) {
        return new BaseRsp(Rsp.SUCCESS.getCode(),
                message,
                Collections.emptyList());
    }

    /**
     * 成功，带返回数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseRsp success(List<T> data) {
        return new BaseRsp(Rsp.SUCCESS.getCode(),
                Rsp.SUCCESS.getMessage(),
                !CollectionUtils.isEmpty(data)?data:Collections.emptyList());
    }

    /**
     * 成功，返回数据和扩展数据
     * @param data
     * @param extendData
     * @param <T>
     * @return
     */
    public static <T> BaseRsp success(List<T> data, T extendData) {
        return new BaseRsp(Rsp.SUCCESS.getCode(),
                Rsp.SUCCESS.getMessage(),
                !CollectionUtils.isEmpty(data)?data:Collections.emptyList(),
                extendData);
    }

    /**
     * 成功，返回数据和扩展数据
     * @param message
     * @param data
     * @param extendData
     * @param <T>
     * @return
     */
    public static <T> BaseRsp success(String message, List<T> data, T extendData) {
        return new BaseRsp(Rsp.SUCCESS.getCode(),
                message,
                !CollectionUtils.isEmpty(data)?data:Collections.emptyList(),
                extendData);
    }



    /**
     * 失败，统一错误
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BaseRsp error(String message) {
        return new BaseRsp(Rsp.ERROR.getCode(), message, Collections.emptyList());
    }

    /**
     * 失败，用户端错误
     * @param <T>
     * @return
     */
    public static <T> BaseRsp errorUser() {
        return new BaseRsp(Rsp.USER_ERROR.getCode(), Rsp.USER_ERROR.getMessage(), Collections.emptyList());
    }

    /**
     * 失败，系统端错误
     * @param <T>
     * @return
     */
    public static <T> BaseRsp errorSystem() {
        return new BaseRsp(Rsp.SYSTEM_ERROR.getCode(), Rsp.SYSTEM_ERROR.getMessage(), Collections.emptyList());
    }

    /**
     * 失败，第三方服务调用失败
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BaseRsp errorThirdServer(String message) {
        return new BaseRsp(Rsp.THIRD_SERVER_ERROR.getCode(), Rsp.THIRD_SERVER_ERROR.getMessage(), Collections.emptyList());
    }

    /**
     * 失败，自定义错误
     * @param <T>
     * @param iRsp
     * @return
     */
    public static <T> BaseRsp errorCustomize(Rsp iRsp) {
        return new BaseRsp(iRsp.getCode(), iRsp.getMessage(), Collections.emptyList());
    }



}
