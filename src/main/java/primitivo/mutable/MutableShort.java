package primitivo.mutable;

/**
 * Mutable wrapper of a {@code short} value.
 * Provides a mutable alternative to {@link Short}.
 * <p>
 * By design, this class is not a subtype of
 * {@link MutableObject MutableObject&lt;Short&gt;},
 * but it may be converted into this type
 * using {@link MutableObject#of(MutableShort)}.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.mutable
 */

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
	
	public void negate() {
		value = (short) ~value;
	}
	
	public void and(short value) {
		this.value &= value;
	}
	
	public void or(short value) {
		this.value |= value;
	}
	
	public void xor(short value) {
		this.value ^= value;
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
		return value;
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
