package com.hbt.common.web.utils;

/**
 * @author hbt
 * 统一响应信息错误码接口， 参照阿里巴巴开发手册。
 */
public enum Rsp implements IRsp {

    /** 成功 **/
    SUCCESS("00000", "一切 ok"),

    /** 错误 **/
    ERROR("11111", "错误"),

    /** 错误 - 用户端错误 **/
    USER_ERROR("A0001", "用户端错误"),
    USER_REGISTER_ERROR("A0100", "用户注册错误"),
    USER_EXISTS("A0111", "用户名已存在"),
    USER_PASSWORD_VALID_FAILED("A0120", "密码校验失败"),
    USER_LOGIN_EXCEPTION("A0200", "用户登陆异常"),
    USER_CLIENT_AUTHORITY_FAILED("A0212", "客户端认证失败"),
    USER_LOGIN_OVERDUE("A0230", "用户登陆已过期"),
    USER_ACCESS_AUTHORITY_EXCEPTION("A0300", "访问权限异常"),
    USER_ACCESS_UNAUTHORIZED("A0301", "访问未授权"),
    USER_REQUEST_PARAM_ERROR("A0400", "用户请求参数错误"),
    USER_REQUEST_SERVER_EXCEPTION("A0500", "用户请求服务异常"),
    USER_RESOURCES_EXCEPTION("A0600", "用户资源异常"),
    USER_UPLOAD_FILE_EXCEPTION("A0700", "用户上传文件异常"),
    USER_CURRENT_VERSION_EXCEPTION("A0800", "用户当前版本异常"),
    USER_SECRET_UNAUTHORIZED("A0900", "用户隐私未授权"),
    USER_EQUIPMENT_EXCEPTION("A1000", "用户设备异常"),

    /** 错误 - 系统执行出错 **/
    SYSTEM_ERROR("B0001", "系统执行出错"),
    SYSTEM_EXECUTE_OVERDUE("B0100", "系统执行超时"),
    SYSTEM_DISASTER_RECOVERY("B0200", "系统容灾功能被触发"),
    SYSTEM_RESOURCES_EXCEPTION("B0300", "系统资源异常"),

    /** 错误 - 调用第三方服务出错 **/
    THIRD_SERVER_ERROR("C0001", "调用第三方服务出错"),
    THIRD_SERVER_MIDDLEWARE_ERROR("C0100", "中间件服务出错"),
    THIRD_SERVER_OVERDUE("C0200", "第三方系统执行超时"),
    THIRD_SERVER_DATABASE_SERVER_ERROR("C0300", "数据库服务出错"),
    THIRD_SERVER_DISASTER_SYSTEM_RECOVERY("C0400", "第三方容灾系统被触发"),
    THIRD_SERVER_NOTICE_SERVER_ERROR("C0500", "通知服务出错");

    private String code;
    private String message;


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    Rsp(String code, String message) {
        this.code = code;
        this.message = message;
    }
}