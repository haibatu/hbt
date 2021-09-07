package com.hbt.common.web.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ApiModel(
    description = "服务返回结果"
)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRsp<T, A> implements Serializable {

    @ApiModelProperty(
        name = "code",
        value = "服务返回编码",
        required = true,
        example = "00000"
    )
    private String code;

    @ApiModelProperty(
        name = "message",
        value = "服务返回描述",
        required = true,
        example = "服务调用成功！"
    )
    private String message;

    @ApiModelProperty(
            name = "data",
            value = "服务返回数据",
            required = true
    )
    private List<T> data = Collections.emptyList();

    @ApiModelProperty(
            name = "extendData",
            value = "服务返回扩展数据",
            required = true
    )
    private A extendData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public A getExtendData() {
        return extendData;
    }

    public void setExtendData(A extendData) {
        this.extendData = extendData;
    }

    public BaseRsp(String code, String message, List<T> data, A extendData) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.extendData = extendData;
    }

    public BaseRsp(String code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseRsp(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseRsp{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", extendData=" + extendData +
                '}';
    }
}
