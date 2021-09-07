package com.hbt.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {
    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);
    public StringUtil() {
    }

    public static boolean isEmptyCheckNullStr(String str) {
        return str == null || "".equals(str) || "null".equals(str.trim().toLowerCase());
    }

}
