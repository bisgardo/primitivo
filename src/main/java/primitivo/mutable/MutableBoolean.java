package primitivo.mutable;

/**
 * Mutable wrapper of a {@code boolean} value.
 * Provides a mutable alternative to {@link Boolean}.
 * <p>
 * By design, this class is not a subtype of
 * {@link MutableObject MutableObject&lt;Boolean&gt;},
 * but it may be converted into this type
 * using {@link MutableObject#of(MutableBoolean)}.
 *
 * @author Michael Bisgaard Olesen
 *
 * @see primitivo.mutable
 */
public class MutableBoolean implements Comparable<MutableBoolean> {
	private boolean value;
	
	public MutableBoolean(boolean value) {
		set(value);
	}
	
	public static MutableBoolean of(boolean value) {
		return new MutableBoolean(value);
	}
	
	public boolean get() {
		return value;
	}
	
	public void set(boolean value) {
		this.value = value;
	}
	
	public void negate() {
		value = !value;
	}
	
	public void and(boolean value) {
		this.value &= value;
	}
	
	public void or(boolean value) {
		this.value |= value;
	}
	
	public void xor(boolean value) {
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
		
		MutableBoolean other = (MutableBoolean) object;
		return value == other.value;
	}
	
	@Override
	public int hashCode() {
		return value ? 1 : 0;
	}
	
	//@Override
	public int compareTo(MutableBoolean other) {
		if (value) {
			return other.value ? 0 : 1;
		} else {
			return other.value ? -1 : 0;
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
