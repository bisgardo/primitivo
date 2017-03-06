package primitivo.array;

public class IntArray {
	public static final int[] EMPTY = new int[0];
	
	public static int[] of(int... ints) {
		if (ints == null) {
			throw new NullPointerException("ints");
		}
		return ints;
	}
	
	public static int[] of(Integer... integers) {
		if (integers == null) {
			throw new NullPointerException("integers");
		}
		int length = integers.length;
		if (length == 0) {
			return EMPTY;
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = integers[i];
		}
		return result;
	}
	
}
