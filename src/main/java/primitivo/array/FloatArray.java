package primitivo.array;

import java.util.Iterator;

/**
 * Utility class of functions for constructing {@code float} arrays.
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
public class FloatArray {
	/**
	 * Empty {@code float} array.
	 */
	public static final float[] EMPTY = new float[0];
	
	/**
	 * @return The empty {@code float} array {@link #EMPTY}.
	 */
	public static float[] of() {
		return EMPTY;
	}
	
	/**
	 * Construct a {@code float} array from a variable number of input values.
	 * If called with an array, the only effect of this function is to
	 * check for null and normalize the empty array to {@link #EMPTY}.
	 * The array is not copied - {@code array.clone()} should be used for that.
	 *
	 * @param floats A variable number of primitive {@code float} values.
	 * @return Array containing the provided values.
	 */
	public static float[] of(float... floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		if (floats.length == 0) {
			return of();
		}
		return floats;
	}
	
	/**
	 * Unbox all elements of a {@link Float} array.
	 *
	 * @param floats An array of {@link Float} values.
	 * @return Array containing the unwrapped values of the input array.
	 */
	// Cannot be varargs because that would conflict with the method above.
	public static float[] of(Float[] floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		int length = floats.length;
		if (length == 0) {
			return EMPTY;
		}
		float[] result = new float[length];
		for (int i = 0; i < length; i++) {
			result[i] = floats[i];
		}
		return result;
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * This function should be used instead of {@link #of(Iterator, int)},
	 * when no reasonable upper bound on the expected length of the iterator is known.
	 *
	 * @param iterator Iterator of {@code float} or non-null {@link Float} values.
	 * @return Array of all the iterator's values as primitive {@code float}s.
	 * @see #of(Iterator, int)
	 */
	public static float[] of(Iterator<Float> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * If no reasonable bound on the iterator's length is available,
	 * use {@link #of(Iterator)} instead.
	 *
	 * @param iterator Iterator of {@code float} or non-null {@link Float} values.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return Array of all the iterator's values as primitive {@code float}s.
	 * @see #of(Iterator)
	 */
	public static float[] of(Iterator<Float> iterator, int expectedLength) {
		Object floats = IteratorToArray.of(iterator, float.class, expectedLength);
		if (floats == null) {
			return EMPTY;
		}
		return (float[]) floats;
	}
}
