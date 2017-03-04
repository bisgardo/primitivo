package primitivo.mutable;

public class MutableFloat implements Comparable<MutableFloat> {
	private float value;
	
	public MutableFloat(float value) {
		set(value);
	}
	
	public static MutableFloat of(float value) {
		return new MutableFloat(value);
	}
	
	public float get() {
		return value;
	}
	
	public void set(float value) {
		this.value = value;
	}
	
	public void add(float value) {
		this.value += value;
	}
	
	public void subtract(float value) {
		this.value -= value;
	}
	
	public void multiply(float value) {
		this.value *= value;
	}
	
	public void divide(float value) {
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
		
		MutableFloat mutableFloat = (MutableFloat) object;
		return Float.compare(value, mutableFloat.value) == 0;
	}
	
	@Override
	public int hashCode() {
		return value == +0.0f ? 0 : Float.floatToIntBits(value);
	}
	
	//@Override
	public int compareTo(MutableFloat mutableFloat) {
		return Float.compare(value, mutableFloat.value);
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
