package com.hbt.common.exception;

import com.hbt.common.utils.StringUtil;

public class BaseBusiException extends BaseException{


    public BaseBusiException(String errorRspCode, String errorRspDesc) {
        super("8888", errorRspCode, errorRspDesc);
    }

    public BaseBusiException(String errorRspCode, String errorRspDesc, String errorSubCode) {
        super(errorRspCode, errorRspDesc, errorSubCode);
    }

    public BaseBusiException(String errorRspCode, String errorRspDesc, String errorSubCode, String errorSubDesc) {
        super(errorRspCode, errorRspDesc, errorSubCode, errorSubDesc);
    }

    @Override
    public String toString() {
        return "BaseBusiException{errorRspCode='" + super.getErrorRspCode() + '\'' + ", errorRspDesc='" + super.getErrorRspDesc() + '\'' + (StringUtil.isEmptyCheckNullStr(super.getErrorSubCode()) ? "" : ", errorSubCode='" + super.getErrorSubCode() + '\'') + (StringUtil.isEmptyCheckNullStr(super.getErrorSubDesc()) ? "" : ", errorSubDesc='" + super.getErrorSubDesc() + '\'') + '}';
    }
}
