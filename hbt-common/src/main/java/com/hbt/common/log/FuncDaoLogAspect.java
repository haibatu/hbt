package com.hbt.common.log;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
@ConditionalOnProperty(
        prefix = "base.log.microservice",
        name = {"enable"},
        matchIfMissing = false
)
public class FuncDaoLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(FuncDaoLogAspect.class);
    @Value("${base.log.microservice.printResult:false}")
    private boolean printResult;

    public FuncDaoLogAspect() {
    }

    @Pointcut("@within(org.springframework.stereotype.Repository)")
    public void logPointCutAllDao(){

    }

    @Pointcut("within(com.hbt.common.dao.IBaseDao+)")
    public void logPointCutMsDao(){

    }


    @Around("logPointCutAllDao()|| logPointCutMsDao()")
    public Object daoAroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        if (logger.isDebugEnabled()) {
            Object[] objects = joinPoint.getArgs();
            logger.debug("\n执行方法:" + joinPoint.getSignature().toShortString() + "\n方法入参:" + (objects == null ? "[]" : Arrays.toString(objects)) + "\n执行时长:" + (System.currentTimeMillis() - startTime) + "ms" + (this.printResult ? "\n执行结果:" + (result == null ? "[]" : result.toString()) : ""));
        }

        return result;
    }
}
