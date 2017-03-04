package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Bisgaard Olesen
 */
public abstract class LongIterator implements Iterator<Long> {
	
	/**
	 * Returns the unboxed long of the value that {{@link #next()}} would have returned if it had been called instead.
	 * @return the next long value in the iteration.
	 */
	public abstract long nextLong();
	
	/**
	 * @return the next Long value in the iteration. This value is never null.
	 */
	//@Override
	public Long next() {
		return nextLong();
	}
	
	//@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static final LongIterator EMPTY = new LongIterator() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public long nextLong() {
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	public static LongIterator of(final ByteIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new LongIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public long nextLong() {
				return iterator.nextByte();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static LongIterator of(final ShortIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new LongIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public long nextLong() {
				return iterator.nextShort();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static LongIterator of(final CharIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new LongIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public long nextLong() {
				return iterator.nextChar();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static LongIterator of(final IntIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new LongIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public long nextLong() {
				return iterator.nextInt();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static LongIterator of(Iterator<Long> iterator) {
		// Causes null value to result in a null pointer exception.
		return of(iterator, null);
	}
	
	public static LongIterator of(final Iterator<Long> iterator, final Long nullValue) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		return new LongIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public long nextLong() {
				return next();
			}
			
			@Override
			public Long next() {
				Long current = iterator.next();
				if (current == null) {
					if (nullValue == null) {
						// Ensure that `next` and `nextLong` behave identically.
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
	
	public static LongIterator of(final long... longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		if (longs.length == 0) {
			return EMPTY;
		}
		return new LongIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < longs.length;
			}
			
			@Override
			public long nextLong() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return longs[index++];
			}
		};
	}
	
	public static LongIterator range(final int from, final int to) {
		if (from >= to) {
			return EMPTY;
		}
		return new LongIterator() {
			private int current = from;
			
			//@Override
			public boolean hasNext() {
				return current < to;
			}
			
			@Override
			public long nextLong() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return current++;
			}
		};
	}
}
