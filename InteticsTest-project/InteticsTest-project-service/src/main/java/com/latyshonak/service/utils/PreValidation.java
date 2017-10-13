package com.latyshonak.service.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PreValidation {

	public static boolean checkEmail(String Email) {
		Pattern p = Pattern.compile("^([a-zA-z0-9_-]+\\.)*[a-zA-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
		Matcher m = p.matcher(Email);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkUsername(String username) {
		Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z_\\\\.]{0,20}");
		Matcher m = p.matcher(username);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkPassword(String password) {
		Pattern p = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}$");
		Matcher m = p.matcher(password);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkRepeatPassword(String password, String retypePassword) {

		if (password.equals(retypePassword)) {
			return true;
		} else {
			return false;
		}

	}
}
