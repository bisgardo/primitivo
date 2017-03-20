package primitivo.array;

import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class ByteArray {
	public static final byte[] EMPTY = new byte[0];
	
	public static byte[] of() {
		return EMPTY;
	}
	
	public static byte[] of(byte... bytes) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		if (bytes.length == 0) {
			return of();
		}
		return bytes;
	}
	
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
	
	public static byte[] of(Iterator<Byte> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	public static byte[] of(Iterator<Byte> iterator, int expectedLength) {
		Object bytes = IteratorToArray.of(iterator, byte.class, expectedLength);
		if (bytes == null) {
			return EMPTY;
		}
		return (byte[]) bytes;
	}
}
