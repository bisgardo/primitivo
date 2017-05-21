package primitivo.array;

import java.util.Iterator;

/**
 * Utility class of functions for constructing {@code double} arrays.
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
public class DoubleArray {
	/**
	 * Empty {@code double} array.
	 */
	public static final double[] EMPTY = new double[0];
	
	/**
	 * @return The empty {@code double} array {@link #EMPTY}.
	 */
	public static double[] of() {
		return EMPTY;
	}
	
	/**
	 * Construct a {@code double} array from a variable number of input values.
	 * If called with an array, the only effect of this function is to
	 * check for null and normalize the empty array to {@link #EMPTY}.
	 * The array is not copied - {@code array.clone()} should be used for that.
	 *
	 * @param doubles A variable number of primitive {@code double} values.
	 * @return Array containing the provided values.
	 */
	public static double[] of(double... doubles) {
		if (doubles == null) {
			throw new NullPointerException("doubles");
		}
		if (doubles.length == 0) {
			return of();
		}
		return doubles;
	}
	
	/**
	 * Unbox all elements of a {@link Double} array.
	 *
	 * @param doubles An array of {@link Double} values.
	 * @return Array containing the unwrapped values of the input array.
	 */
	// Cannot be varargs because that would conflict with the method above.
	public static double[] of(Double[] doubles) {
		if (doubles == null) {
			throw new NullPointerException("doubles");
		}
		int length = doubles.length;
		if (length == 0) {
			return EMPTY;
		}
		double[] result = new double[length];
		for (int i = 0; i < length; i++) {
			result[i] = doubles[i];
		}
		return result;
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * This function should be used instead of {@link #of(Iterator, int)},
	 * when no reasonable upper bound on the expected length of the iterator is known.
	 *
	 * @param iterator Iterator of {@code double} or non-null {@link Double} values.
	 * @return Array of all the iterator's values as primitive {@code double}s.
	 * @see #of(Iterator, int)
	 */
	public static double[] of(Iterator<Double> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * If no reasonable bound on the iterator's length is available,
	 * use {@link #of(Iterator)} instead.
	 *
	 * @param iterator Iterator of {@code double} or non-null {@link Double} values.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return Array of all the iterator's values as primitive {@code double}s.
	 * @see #of(Iterator)
	 */
	public static double[] of(Iterator<Double> iterator, int expectedLength) {
		Object doubles = IteratorToArray.of(iterator, double.class, expectedLength);
		if (doubles == null) {
			return EMPTY;
		}
		return (double[]) doubles;
	}
}
