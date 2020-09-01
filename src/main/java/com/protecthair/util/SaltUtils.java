package com.protecthair.util;

import java.util.Random;

/**
 * @author by liuquan
 * @Classname SaltUtils
 * @Description TODO
 * @Date 2020/8/19 20:46
 */
public class SaltUtils {
    public static String getSalt(int n){
        char[] chars = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "1234567890!@#$%^&*()_+").toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            //Random().nextInt()返回值为[0,n)
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
