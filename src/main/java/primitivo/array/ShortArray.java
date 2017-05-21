package primitivo.array;

import java.util.Iterator;

/**
 * Utility class of functions for constructing {@code short} arrays.
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
public class ShortArray {
	/**
	 * Empty {@code short} array.
	 */
	public static final short[] EMPTY = new short[0];
	
	/**
	 * @return The empty {@code short} array {@link #EMPTY}.
	 */
	public static short[] of() {
		return EMPTY;
	}
	
	/**
	 * Construct a {@code short} array from a variable number of input values.
	 * If called with an array, the only effect of this function is to
	 * check for null and normalize the empty array to {@link #EMPTY}.
	 * The array is not copied - {@code array.clone()} should be used for that.
	 *
	 * @param shorts A variable number of primitive {@code short} values.
	 * @return Array containing the provided values.
	 */
	public static short[] of(short... shorts) {
		if (shorts == null) {
			throw new NullPointerException("shorts");
		}
		if (shorts.length == 0) {
			return of();
		}
		return shorts;
	}
	
	/**
	 * Unbox all elements of a {@link Short} array.
	 *
	 * @param shorts An array of {@link Short} values.
	 * @return Array containing the unwrapped values of the input array.
	 */
	// Cannot be varargs because that would conflict with the method above.
	public static short[] of(Short[] shorts) {
		if (shorts == null) {
			throw new NullPointerException("shorts");
		}
		int length = shorts.length;
		if (length == 0) {
			return EMPTY;
		}
		short[] result = new short[length];
		for (int i = 0; i < length; i++) {
			result[i] = shorts[i];
		}
		return result;
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * This function should be used instead of {@link #of(Iterator, int)},
	 * when no reasonable upper bound on the expected length of the iterator is known.
	 *
	 * @param iterator Iterator of {@code short} or non-null {@link Short} values.
	 * @return Array of all the iterator's values as primitive {@code short}s.
	 * @see #of(Iterator, int)
	 */
	public static short[] of(Iterator<Short> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * If no reasonable bound on the iterator's length is available,
	 * use {@link #of(Iterator)} instead.
	 *
	 * @param iterator Iterator of {@code short} or non-null {@link Short} values.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return Array of all the iterator's values as primitive {@code short}s.
	 * @see #of(Iterator)
	 */
	public static short[] of(Iterator<Short> iterator, int expectedLength) {
		Object shorts = IteratorToArray.of(iterator, short.class, expectedLength);
		if (shorts == null) {
			return EMPTY;
		}
		return (short[]) shorts;
	}
}
