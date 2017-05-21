package primitivo.array;

import java.util.Iterator;

/**
 * Utility class of functions for constructing {@code boolean} arrays.
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
public class BooleanArray {
	/**
	 * Empty {@code boolean} array.
	 */
	public static final boolean[] EMPTY = new boolean[0];
	
	/**
	 * @return The empty {@code boolean} array {@link #EMPTY}.
	 */
	public static boolean[] of() {
		return EMPTY;
	}
	
	/**
	 * Construct a {@code boolean} array from a variable number of input values.
	 * If called with an array, the only effect of this function is to
	 * check for null and normalize the empty array to {@link #EMPTY}.
	 * The array is not copied - {@code array.clone()} should be used for that.
	 *
	 * @param booleans A variable number of primitive {@code boolean} values.
	 * @return Array containing the provided values.
	 */
	public static boolean[] of(boolean... booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		if (booleans.length == 0) {
			return of();
		}
		return booleans;
	}
	
	/**
	 * Unbox all elements of a {@link Boolean} array.
	 *
	 * @param booleans An array of {@link Boolean} values.
	 * @return Array containing the unwrapped values of the input array.
	 */
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
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * This function should be used instead of {@link #of(Iterator, int)},
	 * when no reasonable upper bound on the expected length of the iterator is known.
	 *
	 * @param iterator Iterator of {@code boolean} or non-null {@link Boolean} values.
	 * @return Array of all the iterator's values as primitive {@code boolean}s.
	 * @see #of(Iterator, int)
	 */
	public static boolean[] of(Iterator<Boolean> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * If no reasonable bound on the iterator's length is available,
	 * use {@link #of(Iterator)} instead.
	 *
	 * @param iterator Iterator of {@code boolean} or non-null {@link Boolean} values.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return Array of all the iterator's values as primitive {@code boolean}s.
	 * @see #of(Iterator)
	 */
	public static boolean[] of(Iterator<Boolean> iterator, int expectedLength) {
		Object booleans = IteratorToArray.of(iterator, boolean.class, expectedLength);
		if (booleans == null) {
			return EMPTY;
		}
		return (boolean[]) booleans;
	}
}
