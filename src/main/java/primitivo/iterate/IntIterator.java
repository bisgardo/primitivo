package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator of unboxed {@code int} values.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.iterate
 */
public abstract class IntIterator implements Iterator<Integer> {
	
	/**
	 * Returns the unboxed {@code int} of the value that
	 * {@link #next()} would have returned
	 * if it had been called instead.
	 *
	 * @return The next {@code int} value in the iteration.
	 */
	public abstract int nextInt();
	
	/**
	 * @return The next {@link Integer} value in the iteration.
	 *         This value is never null.
	 */
	//@Override
	public Integer next() {
		return nextInt();
	}
	
	//@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static final IntIterator EMPTY = new IntIterator() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public int nextInt() {
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	public static IntIterator of(final ByteIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new IntIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public int nextInt() {
				return iterator.nextByte();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	
	public static IntIterator of(final ShortIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new IntIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public int nextInt() {
				return iterator.nextShort();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static IntIterator of(final CharIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new IntIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public int nextInt() {
				return iterator.nextChar();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static IntIterator of(Iterator<Integer> iterator) {
		// Causes null value to result in a null pointer exception.
		return of(iterator, null);
	}
	
	public static IntIterator of(final Iterator<Integer> iterator, final Integer nullValue) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		if (iterator instanceof IntIterator) {
			return (IntIterator) iterator;
		}
		return new IntIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public int nextInt() {
				return next();
			}
			
			@Override
			public Integer next() {
				Integer current = iterator.next();
				if (current != null) {
					return current;
				}
				if (nullValue == null) {
					// Ensure that `next` and `nextInt` behave identically.
					throw new NullPointerException("current");
				}
				return nullValue;
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static IntIterator of(final int value) {
		return new IntIterator() {
			private boolean hasNext = true;
			
			//@Override
			public boolean hasNext() {
				return hasNext;
			}
			
			@Override
			public int nextInt() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				hasNext = false;
				return value;
			}
		};
	}
	
	public static IntIterator of(final int... values) {
		if (values == null) {
			throw new NullPointerException("values");
		}
		if (values.length == 0) {
			return EMPTY;
		}
		return new IntIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < values.length;
			}
			
			@Override
			public int nextInt() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return values[index++];
			}
		};
	}
	
	public static IntIterator range(final int from, final int to) {
		if (from >= to) {
			return EMPTY;
		}
		return new IntIterator() {
			private int current = from;
			
			//@Override
			public boolean hasNext() {
				return current < to;
			}
			
			@Override
			public int nextInt() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return current++;
			}
		};
	}
}
