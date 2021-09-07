package com.hbt.project.ability.utils;

import com.hbt.project.ability.service.impl.DroolsEngineServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 一键体检工具类
 */
public class PhysicalUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhysicalUtil.class);


    private static boolean isContinue = true;

    /**
     * 获取执行规则的顺序，如果停机，则后面的规则不匹配
     *
     * @param flag
     * @return
     */
    public static void isContinue(boolean flag) {
        isContinue = flag;
    }

    /**
     * 获取是否可以继续执行规则的标示
     *
     * @return
     */
    public static boolean getContinue() {
        return isContinue;
    }
}
