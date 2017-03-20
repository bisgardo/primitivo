package primitivo.array;

import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class ShortArray {
	public static final short[] EMPTY = new short[0];
	
	public static short[] of() {
		return EMPTY;
	}
	
	public static short[] of(short... shorts) {
		if (shorts == null) {
			throw new NullPointerException("shorts");
		}
		if (shorts.length == 0) {
			return of();
		}
		return shorts;
	}
	
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
	
	public static short[] of(Iterator<Short> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	public static short[] of(Iterator<Short> iterator, int expectedLength) {
		Object shorts = IteratorToArray.of(iterator, short.class, expectedLength);
		if (shorts == null) {
			return EMPTY;
		}
		return (short[]) shorts;
	}
}
