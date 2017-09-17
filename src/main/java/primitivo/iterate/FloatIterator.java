package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator of unboxed {@code float} values.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.iterate
 */
public abstract class FloatIterator implements Iterator<Float> {
	
	/**
	 * Returns the unboxed {@code float} of the value that
	 * {@link #next()} would have returned
	 * if it had been called instead.
	 *
	 * @return The next {@code float} value in the iteration.
	 */
	public abstract float nextFloat();
	
	/**
	 * @return The next {@link Float} value in the iteration.
	 *         This value is never null.
	 */
	//@Override
	public Float next() {
		return nextFloat();
	}
	
	//@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static final FloatIterator EMPTY = new FloatIterator() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public float nextFloat() {
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	public static FloatIterator of(final ByteIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new FloatIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public float nextFloat() {
				return iterator.nextByte();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static FloatIterator of(final ShortIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new FloatIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public float nextFloat() {
				return iterator.nextShort();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static FloatIterator of(final CharIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new FloatIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public float nextFloat() {
				return iterator.nextChar();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static FloatIterator of(final IntIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new FloatIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public float nextFloat() {
				return iterator.nextInt();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static FloatIterator of(Iterator<Float> iterator) {
		// Causes null value to result in a null pointer exception.
		return of(iterator, null);
	}
	
	public static FloatIterator of(final Iterator<Float> iterator, final Float nullValue) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		if (iterator instanceof FloatIterator) {
			return (FloatIterator) iterator;
		}
		return new FloatIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public float nextFloat() {
				return next();
			}
			
			@Override
			public Float next() {
				Float current = iterator.next();
				if (current == null) {
					if (nullValue == null) {
						// Ensure that `next` and `nextFloat` behave identically.
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
	
	public static FloatIterator of(final float value) {
		return new FloatIterator() {
			private boolean hasNext = true;
			
			//@Override
			public boolean hasNext() {
				return hasNext;
			}
			
			@Override
			public float nextFloat() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				hasNext = false;
				return value;
			}
		};
	}
	
	public static FloatIterator of(final float... floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		if (floats.length == 0) {
			return EMPTY;
		}
		return new FloatIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < floats.length;
			}
			
			@Override
			public float nextFloat() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return floats[index++];
			}
		};
	}
	
	public static FloatIterator range(final float from, final float to, final float step) {
		if (from >= to) {
			return EMPTY;
		}
		if (step == 0) {
			throw new IllegalArgumentException("Step cannot be zero");
		}
		return new FloatIterator() {
			private float current = from;
			
			//@Override
			public boolean hasNext() {
				return current < to;
			}
			
			@Override
			public float nextFloat() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				float next = current;
				current += step;
				return next;
			}
		};
	}
}
