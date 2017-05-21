package primitivo.mutable;

/**
 * Mutable wrapper of a {@code int} value.
 * Provides a mutable alternative to {@link Integer}.
 * <p>
 * By design, this class is not a subtype of
 * {@link MutableObject MutableObject&lt;Integer&gt;},
 * but it may be converted into this type
 * using {@link MutableObject#of(MutableInt)}.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.mutable
 */

public class MutableInt implements Comparable<MutableInt> {
	private int value;
	
	public MutableInt(int value) {
		set(value);
	}
	
	public static MutableInt of(int value) {
		return new MutableInt(value);
	}
	
	public int get() {
		return value;
	}
	
	public void set(int value) {
		this.value = value;
	}
	
	public void add(int value) {
		this.value += value;
	}
	
	public void subtract(int value) {
		this.value -= value;
	}
	
	public void multiply(int value) {
		this.value *= value;
	}
	
	public void divide(int value) {
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
		
		MutableInt other = (MutableInt) object;
		return value == other.value;
	}
	
	@Override
	public int hashCode() {
		return value;
	}
	
	//@Override
	public int compareTo(MutableInt other) {
		int otherValue = other.value;
		if (value < otherValue) {
			return -1;
		}
		return value == otherValue ? 0 : 1;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
