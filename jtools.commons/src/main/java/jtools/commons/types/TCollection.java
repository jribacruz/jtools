package jtools.commons.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
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

	public TCollection() {
		super();

	}

	public TCollection(Collection<? extends E> c) {
		super(c);

	}

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

	/**
	 * 
	 * @param function
	 * @return
	 */
	public <X> TCollection<X> transform(Function<E, X> function) {
		TCollection<X> transformedList = new TCollection<>();
		for (E e : this) {
			transformedList.add(function.apply(e));
		}
		return transformedList;
	}
	
	public <X> TCollection<X> filterAndTransform(Predicate<E> predicate, Function<E, X> function) {
		return filter(predicate).transform(function);
	}

}
