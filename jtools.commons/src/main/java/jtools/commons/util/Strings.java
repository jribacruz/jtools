package jtools.commons.util;

public class Strings {

	public static String removeStartEndQuotes(String str) {
		return str.substring(1, str.length() - 1);
	}

}
