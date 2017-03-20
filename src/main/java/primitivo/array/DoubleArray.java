package primitivo.array;

import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class DoubleArray {
	public static final double[] EMPTY = new double[0];
	
	public static double[] of() {
		return EMPTY;
	}
	
	public static double[] of(double... doubles) {
		if (doubles == null) {
			throw new NullPointerException("doubles");
		}
		if (doubles.length == 0) {
			return of();
		}
		return doubles;
	}
	
	// Cannot be varargs because that would conflict with the method above.
	public static double[] of(Double[] doubles) {
		if (doubles == null) {
			throw new NullPointerException("doubles");
		}
		int length = doubles.length;
		if (length == 0) {
			return EMPTY;
		}
		double[] result = new double[length];
		for (int i = 0; i < length; i++) {
			result[i] = doubles[i];
		}
		return result;
	}
	
	public static double[] of(Iterator<Double> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	public static double[] of(Iterator<Double> iterator, int expectedLength) {
		Object doubles = IteratorToArray.of(iterator, double.class, expectedLength);
		if (doubles == null) {
			return EMPTY;
		}
		return (double[]) doubles;
	}
}
