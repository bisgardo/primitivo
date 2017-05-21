package primitivo.array;

import java.util.Iterator;

/**
 * Utility class of functions for constructing {@code int} arrays.
 * <p>
 * All constructed arrays have the same length and ordering as the input
 * that they are based on.
 * <p>
 * None of the functions in this class accept nor return null values.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.array
 */
public class IntArray {
	/**
	 * Empty {@code int} array.
	 */
	public static final int[] EMPTY = new int[0];
	
	/**
	 * @return The empty {@code int} array {@link #EMPTY}.
	 */
	public static int[] of() {
		return EMPTY;
	}
	
	/**
	 * Construct a {@code int} array from a variable number of input values.
	 * If called with an array, the only effect of this function is to
	 * check for null and normalize the empty array to {@link #EMPTY}.
	 * The array is not copied - {@code array.clone()} should be used for that.
	 *
	 * @param ints A variable number of primitive {@code int} values.
	 * @return Array containing the provided values.
	 */
	public static int[] of(int... ints) {
		if (ints == null) {
			throw new NullPointerException("ints");
		}
		if (ints.length == 0) {
			return of();
		}
		return ints;
	}
	
	/**
	 * Unbox all elements of a {@link Integer} array.
	 *
	 * @param integers An array of {@link Integer} values.
	 * @return Array containing the unwrapped values of the input array.
	 */
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
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * This function should be used instead of {@link #of(Iterator, int)},
	 * when no reasonable upper bound on the expected length of the iterator is known.
	 *
	 * @param iterator Iterator of {@code int} or non-null {@link Integer} values.
	 * @return Array of all the iterator's values as primitive {@code int}s.
	 * @see #of(Iterator, int)
	 */
	public static int[] of(Iterator<Integer> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * If no reasonable bound on the iterator's length is available,
	 * use {@link #of(Iterator)} instead.
	 *
	 * @param iterator Iterator of {@code int} or non-null {@link Integer} values.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return Array of all the iterator's values as primitive {@code int}s.
	 * @see #of(Iterator)
	 */
	public static int[] of(Iterator<Integer> iterator, int expectedLength) {
		Object ints = IteratorToArray.of(iterator, int.class, expectedLength);
		if (ints == null) {
			return EMPTY;
		}
		return (int[]) ints;
	}
}
