package com.hbt.common.web.exception;

import com.hbt.common.web.data.BaseRsp;
import com.hbt.common.web.utils.BaseRspUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Administrator
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseRsp handleIllegalArgumentException(IllegalArgumentException e) {
        return BaseRspUtil.error(e.getMessage());
    }


    @ExceptionHandler(GlobalException.class)
    public BaseRsp handleBizException(GlobalException e) {
        if (e.getRsp() != null) {
            return BaseRspUtil.error(e.getMessage());
        }
        return BaseRspUtil.error(e.getMessage());
    }

}