package com.protecthair.util;

import java.util.UUID;

/**
 * @author by liuquan
 * @Classname UUIDUtil
 * @Description TODO
 * @Date 2020/8/10 14:13
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");//去掉原生的"-"
    }
}
