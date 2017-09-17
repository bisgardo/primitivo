package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator of unboxed {@code char} values.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.iterate
 */
public abstract class CharIterator implements Iterator<Character> {
	
	/**
	 * Returns the unboxed {@code char} of the value that
	 * {@link #next()} would have returned
	 * if it had been called instead.
	 *
	 * @return The next {@code char} value in the iteration.
	 */
	public abstract char nextChar();
	
	/**
	 * @return The next {@link Character} value in the iteration.
	 *         This value is never null.
	 */
	//@Override
	public Character next() {
		return nextChar();
	}
	
	//@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static final CharIterator EMPTY = new CharIterator() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public char nextChar() {
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	public static CharIterator of(Iterator<Character> iterator) {
		// Causes null value to result in a null pointer exception.
		return of(iterator, null);
	}
	
	public static CharIterator of(final Iterator<Character> iterator, final Character nullValue) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		if (iterator instanceof CharIterator) {
			return (CharIterator) iterator;
		}
		return new CharIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public char nextChar() {
				return next();
			}
			
			@Override
			public Character next() {
				Character current = iterator.next();
				if (current == null) {
					if (nullValue == null) {
						// Ensure that `next` and `nextChar` behave identically.
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
	
	public static CharIterator of(final char value) {
		return new CharIterator() {
			private boolean hasNext = true;
			
			//@Override
			public boolean hasNext() {
				return hasNext;
			}
			
			@Override
			public char nextChar() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				hasNext = false;
				return value;
			}
		};
	}
	
	public static CharIterator of(final char... values) {
		if (values == null) {
			throw new NullPointerException("values");
		}
		if (values.length == 0) {
			return EMPTY;
		}
		return new CharIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < values.length;
			}
			
			@Override
			public char nextChar() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return values[index++];
			}
		};
	}
	
	public static CharIterator range(final char from, final char to) {
		if (from >= to) {
			return EMPTY;
		}
		return new CharIterator() {
			private char current = from;
			
			//@Override
			public boolean hasNext() {
				return current < to;
			}
			
			@Override
			public char nextChar() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return current++;
			}
		};
	}
}
