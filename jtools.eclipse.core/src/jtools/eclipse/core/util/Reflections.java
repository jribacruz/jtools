package jtools.eclipse.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
	
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericTypeArgument(final Class<?> clazz, final int idx) {
		final Type type = clazz.getGenericSuperclass();

		ParameterizedType paramType;
		try {
			paramType = (ParameterizedType) type;
		} catch (ClassCastException cause) {
			return getGenericTypeArgument((Class<T>) type, idx);
		}

		return (Class<T>) paramType.getActualTypeArguments()[idx];
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericTypeArgument(final Field field, final int idx) {
		final Type type = field.getGenericType();
		final ParameterizedType paramType = (ParameterizedType) type;
		
		return (Class<T>) paramType.getActualTypeArguments()[idx];
	}
	
	public static <T> Class<T> getGenericTypeArgument(final Member member, final int idx) {
		Class<T> result = null;

		if (member instanceof Field) {
			result = getGenericTypeArgument((Field) member, idx);
		} else if (member instanceof Method) {
			result = getGenericTypeArgument((Method) member, idx);
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericTypeArgument(final Method method, final int pos) {
		return (Class<T>) method.getGenericParameterTypes()[pos];
	}
	
}
