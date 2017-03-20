package primitivo.array;

import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class FloatArray {
	public static final float[] EMPTY = new float[0];
	
	public static float[] of() {
		return EMPTY;
	}
	
	public static float[] of(float... floats) {
		if (floats == null) {
			throw new NullPointerException("floats");
		}
		if (floats.length == 0) {
			return of();
		}
		return floats;
	}
	
	// Cannot be varargs because that would conflict with the method above.
	public static float[] of(Float[] floats) {
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
	
	public static float[] of(Iterator<Float> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	public static float[] of(Iterator<Float> iterator, int expectedLength) {
		Object floats = IteratorToArray.of(iterator, float.class, expectedLength);
		if (floats == null) {
			return EMPTY;
		}
		return (float[]) floats;
	}
}
