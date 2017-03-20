package primitivo.mutable;

/**
 * @author Michael Bisgaard Olesen
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
		if (value == other.value) {
			return 0;
		} else if (value) {
			return 1;
		} else {
			return -1;
		} 
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
