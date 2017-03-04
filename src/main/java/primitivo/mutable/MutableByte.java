package primitivo.mutable;

public class MutableByte implements Comparable<MutableByte> {
	private byte value;
	
	public MutableByte(byte value) {
		set(value);
	}
	
	public static MutableByte of(byte value) {
		return new MutableByte(value);
	}
	
	public byte get() {
		return value;
	}
	
	public void set(byte value) {
		this.value = value;
	}
	
	public void add(byte value) {
		this.value += value;
	}
	
	public void subtract(byte value) {
		this.value -= value;
	}
	
	public void multiply(byte value) {
		this.value *= value;
	}
	
	public void divide(byte value) {
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
		
		MutableByte other = (MutableByte) object;
		return value == other.value;
	}
	
	@Override
	public int hashCode() {
		return (int) value;
	}
	
	//@Override
	public int compareTo(MutableByte other) {
		return value - other.value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
