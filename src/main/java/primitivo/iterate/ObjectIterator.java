package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Utility class for constructing generic iterators.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.iterate
 */
public class ObjectIterator {
	
	public static final Iterator<?> EMPTY = new Iterator<Object>() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		//@Override
		public Object next() {
			throw new NoSuchElementException();
		}
		
		//@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	@SuppressWarnings("unchecked")
	public static <T> Iterator<T> of() {
		return (Iterator<T>) EMPTY;
	}
	
	public static <T> Iterator<T> of(final T value) {
		return new Iterator<T>() {
			private boolean hasNext = true;
			
			//@Override
			public boolean hasNext() {
				return hasNext;
			}
			
			//@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				hasNext = false;
				return value;
			}
			
			//@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	//@SafeVarargs
	public static <T> Iterator<T> of(final T... objects) {
		if (objects == null) {
			throw new NullPointerException("objects");
		}
		if (objects.length == 0) {
			return of();
		}
		return new Iterator<T>() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < objects.length;
			}
			
			//@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return objects[index++];
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
