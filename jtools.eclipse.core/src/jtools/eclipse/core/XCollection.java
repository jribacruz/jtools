package jtools.eclipse.core;

import java.util.ArrayList;
import java.util.Collection;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 * @param <E>
 */
public class XCollection<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XCollection() {
		super();

	}

	public XCollection(Collection<? extends E> c) {
		super(c);

	}

	/**
	 * 
	 * @param predicate
	 * @return
	 */
	public XCollection<E> filter(Predicate<E> predicate) {
		XCollection<E> cache = new XCollection<>();
		for (E model : this) {
			if (predicate.apply(model)) {
				cache.add(model);
			}
		}
		return cache;
	}

	/**
	 * Encontra a primeira ocorrencia do elemento E da lista.
	 * 
	 * @param predicate
	 * @return
	 */
	public E find(Predicate<E> predicate) {
		for (E model : this) {
			if (predicate.apply(model)) {
				return model;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param function
	 * @return
	 */
	public <X> XCollection<X> transform(Function<E, X> function) {
		XCollection<X> transformedList = new XCollection<>();
		for (E e : this) {
			if (e != null) {
				transformedList.add(function.apply(e));
			}
		}
		return transformedList;
	}

	public <X> XCollection<X> filterAndTransform(Predicate<E> predicate, Function<E, X> function) {
		return filter(predicate).transform(function);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (E e : this) {
			sb.append(e.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
