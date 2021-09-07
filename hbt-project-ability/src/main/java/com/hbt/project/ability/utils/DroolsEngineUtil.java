package com.hbt.project.ability.utils;

public class DroolsEngineUtil {

    private DroolsEngineUtil(){
        throw new IllegalStateException("DroolsEngineUtil class");
    }

    public static boolean isEmpty(String param) {
        return param == null || "".equals(param);
    }
}
