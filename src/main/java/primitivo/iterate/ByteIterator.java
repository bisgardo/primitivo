package primitivo.iterate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Bisgaard Olesen
 */
public abstract class ByteIterator implements Iterator<Byte> {
	
	/**
	 * Returns the unboxed byte of the value that {{@link #next()}} would have returned if it had been called instead.
	 * @return the next byte value in the iteration.
	 */
	public abstract byte nextByte();
	
	/**
	 * @return the next Byte value in the iteration. This value is never null.
	 */
	//@Override
	public Byte next() {
		return nextByte();
	}
	
	//@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static final ByteIterator EMPTY = new ByteIterator() {
		//@Override
		public boolean hasNext() {
			return false;
		}
		
		@Override
		public byte nextByte() {
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	};
	
	public static ByteIterator of(Iterator<Byte> iterator) {
		// Causes null value to result in a null pointer exception.
		return of(iterator, null);
	}
	
	public static ByteIterator of(final Iterator<Byte> iterator, final Byte nullValue) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		return new ByteIterator() {
			//@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			
			@Override
			public byte nextByte() {
				return next();
			}
			
			@Override
			public Byte next() {
				Byte current = iterator.next();
				if (current == null) {
					if (nullValue == null) {
						// Ensure that `next` and `nextByte` behave identically.
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
	
	public static ByteIterator of(final byte... bytes) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		if (bytes.length == 0) {
			return EMPTY;
		}
		return new ByteIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < bytes.length;
			}
			
			@Override
			public byte nextByte() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return bytes[index++];
			}
		};
	}
	
	public static ByteIterator range(final byte fromByte, final byte toByte) {
		if (fromByte >= toByte) {
			return EMPTY;
		}
		return new ByteIterator() {
			private byte current = fromByte;
			
			//@Override
			public boolean hasNext() {
				return current < toByte;
			}
			
			@Override
			public byte nextByte() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return current++;
			}
		};
	}
}
