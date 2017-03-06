package primitivo.array;

public class LongArray {
	public static final long[] EMPTY = new long[0];
	
	public static long[] of(long... longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		return longs;
	}
	
	public static long[] of(Long... longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		int length = longs.length;
		if (length == 0) {
			return EMPTY;
		}
		long[] result = new long[length];
		for (int i = 0; i < length; i++) {
			result[i] = longs[i];
		}
		return result;
	}
}
