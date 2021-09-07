package com.hbt.common.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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


@Aspect // 定义切面容器
@Component  // 标记为一个spring容器
@Order(1)   // 定义容器的加载顺序， 数字越小优先级越高，可以为负数
@ConditionalOnProperty(
        prefix = "base.log.microservice", // 属性前缀
        name = {"printWeb"}, // 从application.properties中读取属性值
        matchIfMissing = true // 如果读取的属性值不存在，则设置默值为true；如果为false，则@Component不生效
)
public class FuncControllerLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(FuncControllerLogAspect.class);

    @Value("${base.log.microservice.printResult:false}")
    private boolean printResult;

    public FuncControllerLogAspect() {
    }

    /**
     * @within  匹配标注了指定注解的类及其子孙类 @RestController
     */
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void logPointCutAllWeb(){

    }

    /**
     * within  匹配标注的类及其子孙类
     */
    @Pointcut("within(com.hbt.common.controller.IBaseController+)")
    public void logPointCutMsWeb(){

    }

    /**
     * @annotation 匹配指定注解 @RequestMapping
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logPointCutRequestMapping() {

    }
    /**
     * @annotation 匹配指定注解 @GetMapping
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void logPointCutGetMapping() {

    }
    /**
     * @annotation 匹配指定注解 @PostMapping
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void logPointCutPostMapping() {

    }

    /**
     * 环绕增强
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("(logPointCutMsWeb()||logPointCutAllWeb())&&(logPointCutRequestMapping()||logPointCutGetMapping()||logPointCutPostMapping())")
    public Object webAroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        if (logger.isInfoEnabled()) {
            Object[] objects = joinPoint.getArgs();
            logger.info("\n----请求调用结束----\n请求参数信息:" + (objects == null ? "[]" : Arrays.toString(objects)) + "\n执行时长:" + (System.currentTimeMillis() - startTime) + "ms" + (this.printResult ? "\n响应信息:" + (result == null ? "[]" : result.toString()) : ""));
        }
        return result;
    }

    /**
     * 异常抛出增强
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(
            value = "(logPointCutMsWeb()||logPointCutAllWeb())&&(logPointCutRequestMapping()||logPointCutGetMapping()||logPointCutPostMapping())",
            throwing = "ex"
    )
    public void webAfterThrowingLogger(JoinPoint joinPoint, Exception ex) {
        Object[] objects = joinPoint.getArgs();
        logger.error("\n异常请求信息:" + (objects == null ? "[]" : Arrays.toString(objects)) + "\n异常响应信息:" + ex.toString());
    }

}
