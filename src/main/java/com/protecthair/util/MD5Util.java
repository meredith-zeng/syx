package com.protecthair.util;

import org.springframework.util.DigestUtils;

/**
 * MD5
 * @author 17996
 */
public class MD5Util {
	public static String md5(String src) {
		return DigestUtils.md5DigestAsHex(src.getBytes());
	}

	public static void main(String[] args) {
		System.out.println(md5("123456"+"gPv4"));
	}
}
