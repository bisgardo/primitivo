package primitivo.array;

import java.util.Iterator;

/**
 * Utility class of functions for constructing {@code byte} arrays.
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
public class ByteArray {
	/**
	 * Empty {@code byte} array.
	 */
	public static final byte[] EMPTY = new byte[0];
	
	/**
	 * @return The empty {@code byte} array {@link #EMPTY}.
	 */
	public static byte[] of() {
		return EMPTY;
	}
	
	/**
	 * Construct a {@code byte} array from a variable number of input values.
	 * If called with an array, the only effect of this function is to
	 * check for null and normalize the empty array to {@link #EMPTY}.
	 * The array is not copied - {@code array.clone()} should be used for that.
	 *
	 * @param bytes A variable number of primitive {@code byte} values.
	 * @return Array containing the provided values.
	 */
	public static byte[] of(byte... bytes) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		if (bytes.length == 0) {
			return of();
		}
		return bytes;
	}
	
	/**
	 * Unbox all elements of a {@link Byte} array.
	 *
	 * @param bytes An array of {@link Byte} values.
	 * @return Array containing the unwrapped values of the input array.
	 */
	// Cannot be varargs because that would conflict with the method above.
	public static byte[] of(Byte[] bytes) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		int length = bytes.length;
		if (length == 0) {
			return EMPTY;
		}
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			result[i] = bytes[i];
		}
		return result;
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * This function should be used instead of {@link #of(Iterator, int)},
	 * when no reasonable upper bound on the expected length of the iterator is known.
	 *
	 * @param iterator Iterator of {@code byte} or non-null {@link Byte} values.
	 * @return Array of all the iterator's values as primitive {@code byte}s.
	 * @see #of(Iterator, int)
	 */
	public static byte[] of(Iterator<Byte> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * If no reasonable bound on the iterator's length is available,
	 * use {@link #of(Iterator)} instead.
	 *
	 * @param iterator Iterator of {@code byte} or non-null {@link Byte} values.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return Array of all the iterator's values as primitive {@code byte}s.
	 * @see #of(Iterator)
	 */
	public static byte[] of(Iterator<Byte> iterator, int expectedLength) {
		Object bytes = IteratorToArray.of(iterator, byte.class, expectedLength);
		if (bytes == null) {
			return EMPTY;
		}
		return (byte[]) bytes;
	}
}
