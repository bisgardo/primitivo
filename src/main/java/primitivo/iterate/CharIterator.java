package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Bisgaard Olesen
 */
public abstract class CharIterator implements Iterator<Character> {
	
	/**
	 * Returns the unboxed char of the value that {@link #next()} would have returned if it had been called instead.
	 * @return the next char value in the iteration.
	 */
	public abstract char nextChar();
	
	/**
	 * @return the next Character value in the iteration. This value is never null.
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
	
	public static CharIterator of(final char... chars) {
		if (chars == null) {
			throw new NullPointerException("chars");
		}
		if (chars.length == 0) {
			return EMPTY;
		}
		return new CharIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < chars.length;
			}
			
			@Override
			public char nextChar() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return chars[index++];
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
