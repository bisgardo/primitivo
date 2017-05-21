package primitivo.array;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * Container class of an efficient function for converting generic iterators into arrays.
 * <p>
 * In the implementation of the methods of this class,
 * arrays are thought of as lists with a dynamic size
 * (tracked in separate variables) which is limited by the array's length.
 *
 * @author Michael Bisgaard Olesen.
 */
class IteratorToArray {
	/**
	 * Default expected (maximum) length of arrays produced by {@link #of(Iterator, Class, int)}.
	 * Is used by delegating functions when no reasonable guess is available.
	 * This constant is defined centrally here such that delegators don't need to
	 * define their own defaults or magic constants.
	 */
	static final int DEFAULT_EXPECTED_LENGTH = 16;
	
	private static class Prefix {
		private final Prefix prefix;
		private final Object array;
		
		private Prefix(Prefix prefix, Object array) {
			this.prefix = prefix;
			this.array = array;
		}
	}
	
	/**
	 * Efficient function for converting generic iterators into arrays.
	 * The array may be of primitive type, which makes it impossible to generify the function
	 * (in its current form - see below);
	 * {@link Object} is the only type that can represent all arrays.
	 * This is also the reason why the class and function is not public.
	 * Instead, type-safe delegator functions are contained in the classes
	 * in the {@link primitivo.array} package.
	 * <p>
	 * The function works by copying the consumed elements one at a time
	 * into a chain of arrays of increasing length.
	 * These arrays are merged once in the end; thus minimizing
	 * the number of times that elements are copied.
	 * <p>
	 * If the {@code expectedLength} parameter matches the number of element exactly,
	 * only a single array is allocated.
	 * <p>
	 * If {@code iterator} is empty, null is returned.
	 * Delegator functions are expected to replace this value
	 * with an empty array of the correct type.
	 * <p>
	 * In the future, the interface might be changed such that
	 * an object that can create and modify arrays is passed.
	 * Other than eliminating reflection (which could actually turn out to be very efficient),
	 * this would allow the method to be properly generified
	 * and prevent autoboxing of primitive types
	 * (though they currently do happen in such a way that the JIT should be able to
	 * optimize them away if the method is inlined).
	 *
	 * @param iterator Iterator producing values that are assignable to {@code type}.
	 * @param type The type of the produced array.
	 * @param expectedLength The expected number of elements to be consumed from the iterator.
	 *                       The function is most efficient if this value is
	 *                       as small an overestimate as possible.
	 * @return An array of type {@code type} containing, in order,
	 *         the exact values obtained by consuming {@code iterator}.
	 *         If the iterator is empty, null is returned.
	 * @throws ClassCastException If a value produced by {@code iterator}
	 *                            is not assignable to {@code type}.
	 * @throws IllegalArgumentException If {@code expectedLength} is negative
	 *                                  or if {@code type} is {@link Void#TYPE}.
	 */
	static Object of(Iterator<?> iterator, Class<?> type, int expectedLength) {
		if (iterator == null) {
			throw new NullPointerException("iterator");
		}
		if (expectedLength < 0) {
			throw new IllegalArgumentException("Negative expected length");
		}
		if (!iterator.hasNext()) {
			return null;
		}
		
		// Iterator is not empty.
		if (expectedLength == 0) {
			expectedLength = DEFAULT_EXPECTED_LENGTH;
		}
		
		Object array = Array.newInstance(type, expectedLength);
		int arrayLength = expectedLength;
		int arraySize = 0;
		
		Prefix prefixArrays = null;
		int resultLength = 0;
		
		do {
			// Allocate new array if necessary.
			if (arraySize == arrayLength) {
				// Store the current array as the next prefix.
				prefixArrays = new Prefix(prefixArrays, array);
				
				// Allocate new array of the same size as the current number of elements
				// and (lazy-)update length and size.
				resultLength += arraySize;
				array = Array.newInstance(type, resultLength);
				arrayLength = resultLength;
				arraySize = 0;
			}
			
			// Write current value.
			// Primitive values are boxed and then immediately unboxed.
			Array.set(array, arraySize++, iterator.next());
		} while (iterator.hasNext());
		
		resultLength += arraySize;
		
		// Simple case where there is a single, full array.
		if (prefixArrays == null && arrayLength == resultLength) {
			return array;
		}
		
		// Allocate result array and merge values into it from back to front.
		Object result = Array.newInstance(type, resultLength);
		joinInto(prefixArrays, array, arraySize, result);
		return result;
	}
	
	/**
	 * Helper method for iteratively joining a number of arrays into a single array.
	 * <p>
	 * Due to reliance on a number of unchecked preconditions being met,
	 * this method should stay private.
	 *
	 * @param prefixArrays A singly-linked list of prefix arrays.
	 * @param suffixArray A suffix array.
	 * @param suffixArraySize The size of the suffix array. This may be smaller than its length.
	 * @param result The array that all prefix- and suffix-arrays are written into.
	 *               The length of this array must be equal to the sum of all prefix array lengths
	 *               plus {@code suffixArraySize}.
	 */
	@SuppressWarnings("SuspiciousSystemArraycopy")
	private static void joinInto(Prefix prefixArrays, Object suffixArray, int suffixArraySize, Object result) {
		// Write suffix array to the back of the result array.
		int offset = Array.getLength(result) - suffixArraySize;
		System.arraycopy(suffixArray, 0, result, offset, suffixArraySize);
		
		// Iterate prefix arrays; popping the rightmost one to be the next suffix array.
		// Note that prefix arrays are always full; i.e., their size equals their length.
		while (prefixArrays != null) {
			suffixArray = prefixArrays.array;
			suffixArraySize = Array.getLength(suffixArray);
			offset -= suffixArraySize;
			System.arraycopy(suffixArray, 0, result, offset, suffixArraySize);
			prefixArrays = prefixArrays.prefix;
		}
	}
}
