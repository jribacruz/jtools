package jtools.generator.eclipse.ui.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jtools.eclipse.core.facade.Jt;
import jtools.eclipse.core.model.JtAttribute;
import jtools.eclipse.core.model.JtMethod;
import jtools.eclipse.core.model.JtModel;
import jtools.generator.eclipse.ui.impl.JtModelImpl;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.Annotation;

public class JtModelHelper {

	public static JtModel[] asArray(List<JtModel> models) {
		return models.toArray(new JtModel[] {});
	}

	/**
	 * 
	 * @param models
	 * @param predicate
	 * @return
	 */
	public static List<JtModel> filterModels(List<JtModel> models, Predicate<JtModel> predicate) {
		List<JtModel> filteredModels = new ArrayList<>();
		for (JtModel model : models) {
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
	public static List<JtAttribute> filterAttributes(List<JtAttribute> models, Predicate<JtAttribute> predicate) {
		List<JtAttribute> filteredAttributes = new ArrayList<>();
		for (JtAttribute attribute : models) {
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
	public static List<JtMethod> filterMethods(List<JtMethod> models, Predicate<JtMethod> predicate) {
		List<JtMethod> filteredMethods = new ArrayList<>();
		for (JtMethod method : models) {
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
	public static boolean hasAnnotationTypeName(JtModel model, String typeName) {

		for (Annotation annotation : model.getJavaClass().getAnnotations()) {
			if (annotation.getType().getJavaClass().getName().endsWith(typeName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param attribute
	 * @param typeName
	 * @return
	 */
	public static boolean hasAnnotationTypeName(JtAttribute attribute, String typeName) {
		for (Annotation annotation : attribute.getAnnotations()) {
			if (annotation.getType().getJavaClass().getName().endsWith(typeName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param method
	 * @param typeName
	 * @return
	 */
	public static boolean hasAnnotationTypeName(JtMethod method, String typeName) {
		for (Annotation annotation : method.getAnnotations()) {
			if (annotation.getType().getJavaClass().getName().endsWith(typeName)) {
				return true;
			}
		}
		return false;
	}

	public static String getMethodNameWithParams(JtMethod method) {
		StringBuilder sb = new StringBuilder();
		sb.append(method.getName());
		sb.append("(");
		sb.append(StringUtils.join(method.getParamentersTypeName(), ","));
		sb.append(")");
		return sb.toString();
	}

	public static List<JtModel> getModels(IProject project) {
		List<JtModel> models = new ArrayList<>();
		for (ICompilationUnit compilationUnit : Jt.PROJECT.getCompilationUnits(project)) {
			try {
				models.add(new JtModelImpl(compilationUnit));
			} catch (FileNotFoundException e) {
				Jt.MESSAGE.error(e.getMessage());
			} catch (IOException e) {
				Jt.MESSAGE.error(e.getMessage());
			}
		}
		return models;
	}

}
