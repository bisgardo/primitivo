package primitivo.array;

import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class IntArray {
	public static final int[] EMPTY = new int[0];
	
	public static int[] of() {
		return EMPTY;
	}
	
	public static int[] of(int... ints) {
		if (ints == null) {
			throw new NullPointerException("ints");
		}
		if (ints.length == 0) {
			return of();
		}
		return ints;
	}
	
	// Cannot be varargs because that would conflict with the method above.
	public static int[] of(Integer[] integers) {
		if (integers == null) {
			throw new NullPointerException("integers");
		}
		int length = integers.length;
		if (length == 0) {
			return EMPTY;
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = integers[i];
		}
		return result;
	}
	
	public static int[] of(Iterator<Integer> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	public static int[] of(Iterator<Integer> iterator, int expectedLength) {
		Object ints = IteratorToArray.of(iterator, int.class, expectedLength);
		if (ints == null) {
			return EMPTY;
		}
		return (int[]) ints;
	}
	
	public static boolean contains(int[] ints, int element) {
		for (int i : ints) {
			if (i == element) {
				return true;
			}
		}
		return false;
	}
}
