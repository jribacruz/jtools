package jtools.eclipse.core.util;

public class Reflections {
	
	public static <T> T getInstance(Class<T> tClass) {
		try {
			return tClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
