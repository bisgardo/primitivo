package primitivo.array;

import java.util.Iterator;

/**
 * Utility class of functions for constructing {@code long} arrays.
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
public class LongArray {
	/**
	 * Empty {@code long} array.
	 */
	public static final long[] EMPTY = new long[0];
	
	/**
	 * @return The empty {@code long} array {@link #EMPTY}.
	 */
	public static long[] of() {
		return EMPTY;
	}
	
	/**
	 * Construct a {@code long} array from a variable number of input values.
	 * If called with an array, the only effect of this function is to
	 * check for null and normalize the empty array to {@link #EMPTY}.
	 * The array is not copied - {@code array.clone()} should be used for that.
	 *
	 * @param longs A variable number of primitive {@code long} values.
	 * @return Array containing the provided values.
	 */
	public static long[] of(long... longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		if (longs.length == 0) {
			return of();
		}
		return longs;
	}
	
	/**
	 * Unbox all elements of a {@link Long} array.
	 *
	 * @param longs An array of {@link Long} values.
	 * @return Array containing the unwrapped values of the input array.
	 */
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
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * This function should be used instead of {@link #of(Iterator, int)},
	 * when no reasonable upper bound on the expected length of the iterator is known.
	 *
	 * @param iterator Iterator of {@code long} or non-null {@link Long} values.
	 * @return Array of all the iterator's values as primitive {@code long}s.
	 * @see #of(Iterator, int)
	 */
	public static long[] of(Iterator<Long> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * If no reasonable bound on the iterator's length is available,
	 * use {@link #of(Iterator)} instead.
	 *
	 * @param iterator Iterator of {@code long} or non-null {@link Long} values.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return Array of all the iterator's values as primitive {@code long}s.
	 * @see #of(Iterator)
	 */
	public static long[] of(Iterator<Long> iterator, int expectedLength) {
		Object longs = IteratorToArray.of(iterator, long.class, expectedLength);
		if (longs == null) {
			return EMPTY;
		}
		return (long[]) longs;
	}
}
