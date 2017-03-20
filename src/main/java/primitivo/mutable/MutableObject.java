package primitivo.mutable;

/**
 * @author Michael Bisgaard Olesen
 */
public class MutableObject<T> {
	private T value;
	
	public MutableObject(T value) {
		set(value);
	}
	
	public static <T> MutableObject<T> of(T value) {
		return new MutableObject<T>(value);
	}
	
	public static MutableObject<Boolean> of(MutableBoolean mutableBoolean) {
		return of(mutableBoolean.get());
	}
	
	public static MutableObject<Byte> of(MutableByte mutableByte) {
		return of(mutableByte.get());
	}
	
	public static MutableObject<Short> of(MutableShort mutableShort) {
		return of(mutableShort.get());
	}
	
	public static MutableObject<Character> of(MutableChar mutableChar) {
		return of(mutableChar.get());
	}
	
	public static MutableObject<Integer> of(MutableInt mutableInt) {
		return of(mutableInt.get());
	}
	
	public static MutableObject<Long> of(MutableLong mutableLong) {
		return of(mutableLong.get());
	}
	
	public static MutableObject<Float> of(MutableFloat mutableFloat) {
		return of(mutableFloat.get());
	}
	
	public static MutableObject<Double> of(MutableDouble mutableDouble) {
		return of(mutableDouble.get());
	}
	
	public T get() {
		return value;
	}
	
	public void set(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
