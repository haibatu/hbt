package com.hbt.common.web.exception;

import com.hbt.common.web.utils.IRsp;

/**
 * @author Administrator
 */
public class GlobalException extends RuntimeException {
    public IRsp rsp;

    public GlobalException(IRsp rsp) {
        super(rsp.getMessage());
        this.rsp = rsp;
    }

    public GlobalException(String message){
        super(message);
    }

    public GlobalException(String message, Throwable cause){
        super(message, cause);
    }

    public GlobalException(Throwable cause){
        super(cause);
    }

    public IRsp getRsp() {
        return rsp;
    }
}