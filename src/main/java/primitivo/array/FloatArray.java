package primitivo.array;

public class FloatArray {
	public static final float[] EMPTY = new float[0];
	
	public static float[] of(float... floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		return floats;
	}
	
	public static float[] of(Float... floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		int length = floats.length;
		if (length == 0) {
			return EMPTY;
		}
		float[] result = new float[length];
		for (int i = 0; i < length; i++) {
			result[i] = floats[i];
		}
		return result;
	}
}
