package primitivo.array;

public class DoubleArray {
	public static final double[] EMPTY = new double[0];
	
	public static double[] of(double... doubles) {
		if (doubles == null) {
			throw new NullPointerException("doubles");
		}
		return doubles;
	}
	
	public static double[] of(Double... doubles) {
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
}
