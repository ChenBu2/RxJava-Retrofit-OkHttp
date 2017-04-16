package cn.com.san.utils;

import android.text.TextUtils;

import java.security.MessageDigest;

/**
 * 字符串生成MD5值工具类
 */
public class Md5Utils {
	public static String encode(String password) {
		if (TextUtils.isEmpty(password)) {
			return "";
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] result = digest.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (byte b : result) {
				int number = b & 0xff;
				String hex = Integer.toHexString(number);
				if (hex.length() == 1) {
					sb.append("0");
				}
				sb.append(hex);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
