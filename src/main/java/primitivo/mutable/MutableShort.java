package primitivo.mutable;

public class MutableShort implements Comparable<MutableShort> {
	private short value;
	
	public MutableShort(short value) {
		set(value);
	}
	
	public static MutableShort of(short value) {
		return new MutableShort(value);
	}
	
	public short get() {
		return value;
	}
	
	public void set(short value) {
		this.value = value;
	}
	
	public void add(short value) {
		this.value += value;
	}
	
	public void subtract(short value) {
		this.value -= value;
	}
	
	public void multiply(short value) {
		this.value *= value;
	}
	
	public void divide(short value) {
		this.value /= value;
	}
	
	public void increment() {
		value++;
	}
	
	public void decrement() {
		value--;
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		
		MutableShort other = (MutableShort) object;
		return value == other.value;
	}
	
	@Override
	public int hashCode() {
		return (int) value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	//@Override
	public int compareTo(MutableShort other) {
		return value - other.value;
	}
}