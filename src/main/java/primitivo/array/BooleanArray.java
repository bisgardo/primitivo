package primitivo.array;

public class BooleanArray {
	public static final boolean[] EMPTY = new boolean[0];
	
	public static boolean[] of(boolean... booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		return booleans;
	}
	
	public static boolean[] of(Boolean... booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		int length = booleans.length;
		if (length == 0) {
			return EMPTY;
		}
		boolean[] result = new boolean[length];
		for (int i = 0; i < length; i++) {
			result[i] = booleans[i];
		}
		return result;
	}
}
