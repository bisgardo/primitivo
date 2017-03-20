package primitivo.array;

import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class BooleanArray {
	public static final boolean[] EMPTY = new boolean[0];
	
	public static boolean[] of() {
		return EMPTY;
	}
	
	public static boolean[] of(boolean... booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		if (booleans.length == 0) {
			return of();
		}
		return booleans;
	}
	
	// Cannot be varargs because that would conflict with the method above.
	public static boolean[] of(Boolean[] booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		int length = booleans.length;
		if (length == 0) {
			return EMPTY;
		}
		boolean[] result = new boolean[length];
		for (int i = 0; i < length; i++) {
			result[i] = booleans[i];
		}
		return result;
	}
	
	public static boolean[] of(Iterator<Boolean> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	public static boolean[] of(Iterator<Boolean> iterator, int expectedLength) {
		Object booleans = IteratorToArray.of(iterator, boolean.class, expectedLength);
		if (booleans == null) {
			return EMPTY;
		}
		return (boolean[]) booleans;
	}
}
