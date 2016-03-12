package jtools.commons.types;

import java.util.ArrayList;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 * @param <E>
 */
public class TCollection<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param predicate
	 * @return
	 */
	public TCollection<E> filter(Predicate<E> predicate) {
		TCollection<E> cache = new TCollection<>();
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

}
