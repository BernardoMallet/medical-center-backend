package com.medicalcenter.util;

import java.util.Base64;

public class StringUtil {

	public static String encodeBase64(String s) {
		return Base64.getEncoder().encodeToString(s.getBytes());
	}

	public static String decodeBase64(String encodedString) {
		byte[] decode = Base64.getDecoder().decode(encodedString);
		return new String(decode);
	}
	
	public static boolean checkIfIsBlankOrEmptyOrNull(String s) {
		return s == null || s.isBlank() || s.isEmpty();
	}
}
