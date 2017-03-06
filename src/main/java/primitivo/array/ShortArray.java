package primitivo.array;

public class ShortArray {
	public static final short[] EMPTY = new short[0];
	
	public static short[] of(short... shorts) {
		if (shorts == null) {
			throw new NullPointerException("shorts");
		}
		return shorts;
	}
	
	public static short[] of(Short... shorts) {
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
}
