package com.hbt.common.exception;

/**
 * 统一异常处理
 */
public class  BaseException extends RuntimeException {

    private String errorRspCode;
    private String errorRspDesc;
    private String errorSubCode;
    private String errorSubDesc;

    public BaseException(String errorRspDesc) {
        super(errorRspDesc);
        this.errorRspCode = "8888";
        this.errorRspDesc = errorRspDesc;
    }

    public BaseException(String errorRspCode, String errorRspDesc) {
        super(errorRspDesc);
        this.errorRspCode = errorRspCode;
        this.errorRspDesc = errorRspDesc;
    }

    public BaseException(String errorRspCode, String errorRspDesc, String errorSubCode) {
        super(errorRspCode);
        this.errorRspCode = errorRspCode;
        this.errorRspDesc = errorRspDesc;
        this.errorSubCode = errorSubCode;
    }

    public BaseException(String errorRspCode, String errorRspDesc, String errorSubCode, String errorSubDesc) {
        super(errorRspCode);
        this.errorRspCode = errorRspCode;
        this.errorRspDesc = errorRspDesc;
        this.errorSubCode = errorSubCode;
        this.errorSubDesc = errorSubDesc;
    }

    public String getErrorRspCode() {
        return errorRspCode;
    }

    public void setErrorRspCode(String errorRspCode) {
        this.errorRspCode = errorRspCode;
    }

    public String getErrorRspDesc() {
        return errorRspDesc;
    }

    public void setErrorRspDesc(String errorRspDesc) {
        this.errorRspDesc = errorRspDesc;
    }

    public String getErrorSubCode() {
        return errorSubCode;
    }

    public void setErrorSubCode(String errorSubCode) {
        this.errorSubCode = errorSubCode;
    }

    public String getErrorSubDesc() {
        return errorSubDesc;
    }

    public void setErrorSubDesc(String errorSubDesc) {
        this.errorSubDesc = errorSubDesc;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "errorRspCode='" + errorRspCode + '\'' +
                ", errorRspDesc='" + errorRspDesc + '\'' +
                ", errorSubCode='" + errorSubCode + '\'' +
                ", errorSubDesc='" + errorSubDesc + '\'' +
                '}';
    }
}
