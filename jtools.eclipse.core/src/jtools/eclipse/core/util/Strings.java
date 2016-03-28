package jtools.eclipse.core.util;

public class Strings {

	public static String removeStartEndQuotes(String str) {
		return str.substring(1, str.length() - 1);
	}

}
