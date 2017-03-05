package primitivo.array;

public class PrimitiveArray {
	public static final boolean[] EMPTY_BOOLEANS = new boolean[0];
	public static final byte[] EMPTY_BYTES = new byte[0];
	public static final short[] EMPTY_SHORTS = new short[0];
	public static final char[] EMPTY_CHARS = new char[0];
	public static final int[] EMPTY_INTS = new int[0];
	public static final long[] EMPTY_LONGS = new long[0];
	public static final float[] EMPTY_FLOATS = new float[0];
	public static final double[] EMPTY_DOUBLES = new double[0];
	
	public static boolean[] of(boolean... booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		return booleans;
	}
	
	public static byte[] of(byte... bytes) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		return bytes;
	}
	
	public static short[] of(short... shorts) {
		if (shorts == null) {
			throw new NullPointerException("shorts");
		}
		return shorts;
	}
	
	public static char[] of(char... chars) {
		if (chars == null) {
			throw new NullPointerException("chars");
		}
		return chars;
	}
	
	public static int[] of(int... ints) {
		if (ints == null) {
			throw new NullPointerException("ints");
		}
		return ints;
	}
	
	public static long[] of(long... longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		return longs;
	}
	
	public static float[] of(float... floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		return floats;
	}
	
	public static double[] of(double... doubles) {
		if (doubles == null) {
			throw new NullPointerException("doubles");
		}
		return doubles;
	}
	
	public static boolean[] of(Boolean... booleans) {
		if (booleans == null) {
			throw new NullPointerException("booleans");
		}
		int length = booleans.length;
		if (length == 0) {
			return EMPTY_BOOLEANS;
		}
		boolean[] result = new boolean[length];
		for (int i = 0; i < length; i++) {
			result[i] = booleans[i];
		}
		return result;
	}
	
	public static byte[] of(Byte... bytes) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		int length = bytes.length;
		if (length == 0) {
			return EMPTY_BYTES;
		}
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			result[i] = bytes[i];
		}
		return result;
	}
	
	public static short[] of(Short... shorts) {
		if (shorts == null) {
			throw new NullPointerException("shorts");
		}
		int length = shorts.length;
		if (length == 0) {
			return EMPTY_SHORTS;
		}
		short[] result = new short[length];
		for (int i = 0; i < length; i++) {
			result[i] = shorts[i];
		}
		return result;
	}
	
	public static char[] of(Character... characters) {
		if (characters == null) {
			throw new NullPointerException("characters");
		}
		int length = characters.length;
		if (length == 0) {
			return EMPTY_CHARS;
		}
		char[] result = new char[length];
		for (int i = 0; i < length; i++) {
			result[i] = characters[i];
		}
		return result;
	}
	
	public static int[] of(Integer... integers) {
		if (integers == null) {
			throw new NullPointerException("integers");
		}
		int length = integers.length;
		if (length == 0) {
			return EMPTY_INTS;
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = integers[i];
		}
		return result;
	}
	
	public static long[] of(Long... longs) {
		if (longs == null) {
			throw new NullPointerException("longs");
		}
		int length = longs.length;
		if (length == 0) {
			return EMPTY_LONGS;
		}
		long[] result = new long[length];
		for (int i = 0; i < length; i++) {
			result[i] = longs[i];
		}
		return result;
	}
	
	public static float[] of(Float... floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		int length = floats.length;
		if (length == 0) {
			return EMPTY_FLOATS;
		}
		float[] result = new float[length];
		for (int i = 0; i < length; i++) {
			result[i] = floats[i];
		}
		return result;
	}
	
	public static double[] of(Double... doubles) {
		if (doubles == null) {
			throw new NullPointerException("doubles");
		}
		int length = doubles.length;
		if (length == 0) {
			return EMPTY_DOUBLES;
		}
		double[] result = new double[length];
		for (int i = 0; i < length; i++) {
			result[i] = doubles[i];
		}
		return result;
	}
}
