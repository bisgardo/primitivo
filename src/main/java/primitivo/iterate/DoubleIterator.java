package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator of unboxed {@code double} values.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.iterate
 */
public abstract class DoubleIterator implements Iterator<Double> {
	
	/**
	 * Returns the unboxed {@code double} of the value that
	 * {@link #next()} would have returned
	 * if it had been called instead.
	 *
	 * @return The next {@code double} value in the iteration.
	 */
	public abstract double nextDouble();
	
	/**
	 * @return The next {@link Double} value in the iteration.
	 *         This value is never null.
	 */
	//@Override
	public Double next() {
		return nextDouble();
	}
	
	//@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static final DoubleIterator EMPTY = new DoubleIterator() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public double nextDouble() {
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	public static DoubleIterator of(final ByteIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new DoubleIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public double nextDouble() {
				return iterator.nextByte();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static DoubleIterator of(final ShortIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new DoubleIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public double nextDouble() {
				return iterator.nextShort();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static DoubleIterator of(final CharIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new DoubleIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public double nextDouble() {
				return iterator.nextChar();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static DoubleIterator of(final IntIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new DoubleIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public double nextDouble() {
				return iterator.nextInt();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static DoubleIterator of(final LongIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new DoubleIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public double nextDouble() {
				return iterator.nextLong();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static DoubleIterator of(final FloatIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new DoubleIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public double nextDouble() {
				return iterator.nextFloat();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static DoubleIterator of(Iterator<Double> iterator) {
		// Causes null value to result in a null pointer exception.
		return of(iterator, null);
	}
	
	public static DoubleIterator of(final Iterator<Double> iterator, final Double nullValue) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		if (iterator instanceof DoubleIterator) {
			return (DoubleIterator) iterator;
		}
		return new DoubleIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public double nextDouble() {
				return next();
			}
			
			@Override
			public Double next() {
				Double current = iterator.next();
				if (current == null) {
					if (nullValue == null) {
						// Ensure that `next` and `nextDouble` behave identically.
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
	
	public static DoubleIterator of(final double value) {
		return new DoubleIterator() {
			private boolean hasNext = true;
			
			//@Override
			public boolean hasNext() {
				return hasNext;
			}
			
			@Override
			public double nextDouble() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				hasNext = false;
				return value;
			}
		};
	}
	
	public static DoubleIterator of(final double... values) {
		if (values == null) {
			throw new NullPointerException("values");
		}
		if (values.length == 0) {
			return EMPTY;
		}
		return new DoubleIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < values.length;
			}
			
			@Override
			public double nextDouble() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return values[index++];
			}
		};
	}
	
	public static DoubleIterator range(final double from, final double to, final double step) {
		if (from >= to) {
			return EMPTY;
		}
		if (step == 0) {
			throw new IllegalArgumentException("Step cannot be zero");
		}
		return new DoubleIterator() {
			private double current = from;
			
			//@Override
			public boolean hasNext() {
				return current < to;
			}
			
			@Override
			public double nextDouble() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				double next = current;
				current += step;
				return next;
			}
		};
	}
}
