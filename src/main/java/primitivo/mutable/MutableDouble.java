package primitivo.mutable;

public class MutableDouble implements Comparable<MutableDouble> {
	private double value;
	
	public MutableDouble(double value) {
		set(value);
	}
	
	public static MutableDouble of(double value) {
		return new MutableDouble(value);
	}
	
	public double get() {
		return value;
	}
	
	public void set(double value) {
		this.value = value;
	}
	
	public void add(double value) {
		this.value += value;
	}
	
	public void subtract(double value) {
		this.value -= value;
	}
	
	public void multiply(double value) {
		this.value *= value;
	}
	
	public void divide(double value) {
		this.value /= value;
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		
		MutableDouble other = (MutableDouble) object;
		return Double.compare(value, other.value) == 0;
	}
	
	@Override
	public int hashCode() {
		long temp = Double.doubleToLongBits(value);
		return (int) (temp ^ (temp >>> 32));
	}
	
	//@Override
	public int compareTo(MutableDouble other) {
		return Double.compare(value, other.value);
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
