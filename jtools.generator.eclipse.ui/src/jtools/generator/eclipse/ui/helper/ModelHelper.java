package jtools.generator.eclipse.ui.helper;

import java.util.ArrayList;
import java.util.List;

import jtools.generator.eclipse.ui.model.Attribute;
import jtools.generator.eclipse.ui.model.Method;
import jtools.generator.eclipse.ui.model.Model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.Annotation;

public class ModelHelper {

	/**
	 * 
	 * @param models
	 * @param predicate
	 * @return
	 */
	public static List<Model> filterModels(List<Model> models, Predicate<Model> predicate) {
		List<Model> filteredModels = new ArrayList<>();
		for (Model model : filteredModels) {
			if (predicate.apply(model)) {
				filteredModels.add(model);
			}
		}
		return filteredModels;
	}

	/**
	 * 
	 * @param models
	 * @param predicate
	 * @return
	 */
	public static List<Attribute> filterAttributes(List<Attribute> models, Predicate<Attribute> predicate) {
		List<Attribute> filteredAttributes = new ArrayList<>();
		for (Attribute attribute : filteredAttributes) {
			if (predicate.apply(attribute)) {
				filteredAttributes.add(attribute);
			}
		}
		return filteredAttributes;
	}

	/**
	 * 
	 * @param models
	 * @param predicate
	 * @return
	 */
	public static List<Method> filterMethods(List<Method> models, Predicate<Method> predicate) {
		List<Method> filteredMethods = new ArrayList<>();
		for (Method method : filteredMethods) {
			if (predicate.apply(method)) {
				filteredMethods.add(method);
			}
		}
		return filteredMethods;
	}

	/**
	 * 
	 * @param model
	 * @param typeName
	 * @return
	 */
	public static boolean hasAnnotationTypeName(Model model, String typeName) {
		for (Annotation annotation : model.getJavaClass().getAnnotations()) {
			return annotation.getType().getJavaClass().getName().equals(typeName);
		}
		return false;
	}

	/**
	 * 
	 * @param attribute
	 * @param typeName
	 * @return
	 */
	public static boolean hasAnnotationTypeName(Attribute attribute, String typeName) {
		for (Annotation annotation : attribute.getAnnotations()) {
			return annotation.getType().getJavaClass().getName().equals(typeName);
		}
		return false;
	}

	/**
	 * 
	 * @param method
	 * @param typeName
	 * @return
	 */
	public static boolean hasAnnotationTypeName(Method method, String typeName) {
		for (Annotation annotation : method.getAnnotations()) {
			return annotation.getType().getJavaClass().getName().equals(typeName);
		}
		return false;
	}

}
