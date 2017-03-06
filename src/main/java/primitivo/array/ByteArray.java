package primitivo.array;

public class ByteArray {
	public static final byte[] EMPTY = new byte[0];
	
	public static byte[] of(byte... bytes) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		return bytes;
	}
	
	public static byte[] of(Byte... bytes) {
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
}
