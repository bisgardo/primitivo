package primitivo.array;

import java.util.Iterator;

/**
 * Utility class of functions for constructing {@code char} arrays.
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
public class CharArray {
	/**
	 * Empty {@code char} array.
	 */
	public static final char[] EMPTY = new char[0];
	
	/**
	 * @return The empty {@code char} array {@link #EMPTY}.
	 */
	public static char[] of() {
		return EMPTY;
	}
	
	/**
	 * Construct a {@code char} array from a variable number of input values.
	 * If called with an array, the only effect of this function is to
	 * check for null and normalize the empty array to {@link #EMPTY}.
	 * The array is not copied - {@code array.clone()} should be used for that.
	 *
	 * @param chars A variable number of primitive {@code char} values.
	 * @return Array containing the provided values.
	 */
	public static char[] of(char... chars) {
		if (chars == null) {
			throw new NullPointerException("chars");
		}
		if (chars.length == 0) {
			return of();
		}
		return chars;
	}
	
	/**
	 * Unbox all elements of a {@link Character} array.
	 *
	 * @param characters An array of {@link Character} values.
	 * @return Array containing the unwrapped values of the input array.
	 */
	// Cannot be varargs because that would conflict with the method above.
	public static char[] of(Character[] characters) {
		if (characters == null) {
			throw new NullPointerException("characters");
		}
		int length = characters.length;
		if (length == 0) {
			return EMPTY;
		}
		char[] result = new char[length];
		for (int i = 0; i < length; i++) {
			result[i] = characters[i];
		}
		return result;
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * This function should be used instead of {@link #of(Iterator, int)},
	 * when no reasonable upper bound on the expected length of the iterator is known.
	 *
	 * @param iterator Iterator of {@code char} or non-null {@link Character} values.
	 * @return Array of all the iterator's values as primitive {@code char}s.
	 * @see #of(Iterator, int)
	 */
	public static char[] of(Iterator<Character> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	/**
	 * Consume all the values of an iterator and return them as an array.
	 * If no reasonable bound on the iterator's length is available,
	 * use {@link #of(Iterator)} instead.
	 *
	 * @param iterator Iterator of {@code char} or non-null {@link Character} values.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return Array of all the iterator's values as primitive {@code char}s.
	 * @see #of(Iterator)
	 */
	public static char[] of(Iterator<Character> iterator, int expectedLength) {
		Object chars = IteratorToArray.of(iterator, char.class, expectedLength);
		if (chars == null) {
			return EMPTY;
		}
		return (char[]) chars;
	}
}
