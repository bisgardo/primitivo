package primitivo.mutable;

/**
 * @author Michael Bisgaard Olesen
 */
public class MutableLong implements Comparable<MutableLong> {
	private long value;
	
	public MutableLong(long value) {
		set(value);
	}
	
	public static MutableLong of(long value) {
		return new MutableLong(value);
	}
	
	public long get() {
		return value;
	}
	
	public void set(long value) {
		this.value = value;
	}
	
	public void add(long value) {
		this.value += value;
	}
	
	public void subtract(long value) {
		this.value -= value;
	}
	
	public void multiply(long value) {
		this.value *= value;
	}
	
	public void divide(long value) {
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
		
		MutableLong other = (MutableLong) object;
		return value == other.value;
	}
	
	@Override
	public int hashCode() {
		return (int) (value ^ (value >>> 32));
	}
	
	//@Override
	public int compareTo(MutableLong other) {
		long otherValue = other.value;
		if (value < otherValue) {
			return -1;
		} else if (value == otherValue) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
