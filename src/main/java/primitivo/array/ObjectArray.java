package primitivo.array;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class ObjectArray {
	public static final Boolean[] EMPTY_BOOLEANS = new Boolean[0];
	public static final Byte[] EMPTY_BYTES = new Byte[0];
	public static final Short[] EMPTY_SHORTS = new Short[0];
	public static final Character[] EMPTY_CHARACTERS = new Character[0];
	public static final Integer[] EMPTY_INTEGERS = new Integer[0];
	public static final Long[] EMPTY_LONGS = new Long[0];
	public static final Float[] EMPTY_FLOATS = new Float[0];
	public static final Double[] EMPTY_DOUBLES = new Double[0];
	
	public static final String[] EMPTY_STRINGS = new String[0];
	public static final Object[] EMPTY_OBJECTS = new Object[0];
	
	// Disambiguation function.
	public static Object[] of() {
		return EMPTY_OBJECTS;
	}
	
	public static Boolean[] of(boolean... booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		int length = booleans.length;
		if (length == 0) {
			return EMPTY_BOOLEANS;
		}
		Boolean[] result = new Boolean[length];
		for (int i = 0; i < length; i++) {
			result[i] = booleans[i];
		}
		return result;
	}
	
	public static Byte[] of(byte... bytes) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		int length = bytes.length;
		if (length == 0) {
			return EMPTY_BYTES;
		}
		Byte[] result = new Byte[length];
		for (int i = 0; i < length; i++) {
			result[i] = bytes[i];
		}
		return result;
	}
	
	public static Short[] of(short... shorts) {
		if (shorts == null) {
			throw new NullPointerException("shorts");
		}
		int length = shorts.length;
		if (length == 0) {
			return EMPTY_SHORTS;
		}
		Short[] result = new Short[length];
		for (int i = 0; i < length; i++) {
			result[i] = shorts[i];
		}
		return result;
	}
	
	public static Character[] of(char... characters) {
		if (characters == null) {
			throw new NullPointerException("characters");
		}
		int length = characters.length;
		if (length == 0) {
			return EMPTY_CHARACTERS;
		}
		Character[] result = new Character[length];
		for (int i = 0; i < length; i++) {
			result[i] = characters[i];
		}
		return result;
	}
	
	public static Integer[] of(int... integers) {
		if (integers == null) {
			throw new NullPointerException("integers");
		}
		int length = integers.length;
		if (length == 0) {
			return EMPTY_INTEGERS;
		}
		Integer[] result = new Integer[length];
		for (int i = 0; i < length; i++) {
			result[i] = integers[i];
		}
		return result;
	}
	
	public static Long[] of(long... longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		int length = longs.length;
		if (length == 0) {
			return EMPTY_LONGS;
		}
		Long[] result = new Long[length];
		for (int i = 0; i < length; i++) {
			result[i] = longs[i];
		}
		return result;
	}
	
	public static Float[] of(float... floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		int length = floats.length;
		if (length == 0) {
			return EMPTY_FLOATS;
		}
		Float[] result = new Float[length];
		for (int i = 0; i < length; i++) {
			result[i] = floats[i];
		}
		return result;
	}
	
	public static Double[] of(double... doubles) {
		if (doubles == null) {
			throw new NullPointerException("doubles");
		}
		int length = doubles.length;
		if (length == 0) {
			return EMPTY_DOUBLES;
		}
		Double[] result = new Double[length];
		for (int i = 0; i < length; i++) {
			result[i] = doubles[i];
		}
		return result;
	}
	
	//@SafeVarargs
	public static <T> T[] of(T... objects) {
		if (objects == null) {
			throw new NullPointerException("objects");
		}
		return objects;
	}
	
	public static <T> T[] of(Iterator<? extends T> iterator, Class<T> type) {
		return of(iterator, type, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] of(Iterator<? extends T> iterator, Class<T> type, int expectedLength) {
		Object objects = IteratorToArray.of(iterator, type, expectedLength);
		if (objects == null) {
			objects = Array.newInstance(type, 0);
		}
		return (T[]) objects;
	}
}
