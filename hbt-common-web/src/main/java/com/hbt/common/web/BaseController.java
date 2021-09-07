package com.hbt.common.web;

import com.hbt.common.web.data.BaseRsp;
import com.hbt.common.web.exception.GlobalException;
import com.hbt.common.web.utils.BaseRspUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
public class BaseController{

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public BaseController() {
    }

    @ExceptionHandler({GlobalException.class})
    public BaseRsp exp(HttpServletRequest request, GlobalException e) {
        logger.info(e.getRsp().getCode() + ":" + e.getRsp().getMessage());
        return BaseRspUtil.error("请求参数错误");
    }


    @ExceptionHandler({Exception.class})
    public BaseRsp exp(HttpServletRequest request, Exception e) {
        logger.error(e.getMessage(), e);
        return BaseRspUtil.error("出错啦！网络连接错误或者连接超时！");
    }
}
