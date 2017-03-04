package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Bisgaard Olesen
 */
public abstract class BooleanIterator implements Iterator<Boolean> {
	
	/**
	 * Returns the unboxed boolean of the value that {{@link #next()}} would have returned if it had been called instead.
	 * @return the next boolean value in the iteration.
	 */
	public abstract boolean nextBoolean();
	
	/**
	 * @return the next Boolean value in the iteration. This value is never null.
	 */
	//@Override
	public Boolean next() {
		return nextBoolean();
	}
	
	//@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static final BooleanIterator EMPTY = new BooleanIterator() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public boolean nextBoolean() {
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	public static BooleanIterator of(Iterator<Boolean> iterator) {
		// Causes null value to result in a null pointer exception.
		return of(iterator, null);
	}
	
	public static BooleanIterator of(final Iterator<Boolean> iterator, final Boolean nullValue) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		return new BooleanIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public boolean nextBoolean() {
				return next();
			}
			
			@Override
			public Boolean next() {
				Boolean current = iterator.next();
				if (current == null) {
					if (nullValue == null) {
						// Ensure that `next` and `nextBoolean` behave identically.
						throw new NullPointerException("current");
					}
					return nullValue;
				}
				return current;
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static BooleanIterator of(final boolean... booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		if (booleans.length == 0) {
			return EMPTY;
		}
		return new BooleanIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < booleans.length;
			}
			
			@Override
			public boolean nextBoolean() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return booleans[index++];
			}
		};
	}
}
