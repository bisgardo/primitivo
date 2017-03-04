package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Bisgaard Olesen
 */
public abstract class ShortIterator implements Iterator<Short> {
	
	/**
	 * Returns the unboxed short of the value that {{@link #next()}} would have returned if it had been called instead.
	 * @return the next short value in the iteration.
	 */
	public abstract short nextShort();
	
	/**
	 * @return the next Short value in the iteration. This value is never null.
	 */
	//@Override
	public Short next() {
		return nextShort();
	}
	
	//@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static final ShortIterator EMPTY = new ShortIterator() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public short nextShort() {
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	public static ShortIterator of(final ByteIterator iterator) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		return new ShortIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public short nextShort() {
				return iterator.nextByte();
			}
			
			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}
	
	public static ShortIterator of(Iterator<Short> iterator) {
		// Causes null value to result in a null pointer exception.
		return of(iterator, null);
	}
	
	public static ShortIterator of(final Iterator<Short> iterator, final Short nullValue) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		return new ShortIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public short nextShort() {
				return next();
			}
			
			@Override
			public Short next() {
				Short current = iterator.next();
				if (current == null) {
					if (nullValue == null) {
						// Ensure that `next` and `nextShort` behave identically.
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
	
	public static ShortIterator of(final short... shorts) {
		if (shorts == null) {
			throw new NullPointerException("shorts");
		}
		if (shorts.length == 0) {
			return EMPTY;
		}
		return new ShortIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < shorts.length;
			}
			
			@Override
			public short nextShort() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return shorts[index++];
			}
		};
	}
	
	public static ShortIterator range(final short from, final short to) {
		if (from >= to) {
			return EMPTY;
		}
		return new ShortIterator() {
			private short current = from;
			
			//@Override
			public boolean hasNext() {
				return current < to;
			}
			
			@Override
			public short nextShort() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return current++;
			}
		};
	}
}
