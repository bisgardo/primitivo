package primitivo.array;

import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class LongArray {
	public static final long[] EMPTY = new long[0];
	
	public static long[] of() {
		return EMPTY;
	}
	
	public static long[] of(long... longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		if (longs.length == 0) {
			return of();
		}
		return longs;
	}
	
	// Cannot be varargs because that would conflict with the method above.
	public static long[] of(Long[] longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		int length = longs.length;
		if (length == 0) {
			return EMPTY;
		}
		long[] result = new long[length];
		for (int i = 0; i < length; i++) {
			result[i] = longs[i];
		}
		return result;
	}
	
	public static long[] of(Iterator<Long> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	public static long[] of(Iterator<Long> iterator, int expectedLength) {
		Object longs = IteratorToArray.of(iterator, long.class, expectedLength);
		if (longs == null) {
			return EMPTY;
		}
		return (long[]) longs;
	}
}
