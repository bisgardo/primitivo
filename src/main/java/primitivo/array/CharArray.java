package primitivo.array;

public class CharArray {
	public static final char[] EMPTY = new char[0];
	
	public static char[] of(char... chars) {
		if (chars == null) {
			throw new NullPointerException("chars");
		}
		return chars;
	}
	
	public static char[] of(Character... characters) {
		if (characters == null) {
			throw new NullPointerException("characters");
		}
		int length = characters.length;
		if (length == 0) {
			return EMPTY;
		}
		char[] result = new char[length];
		for (int i = 0; i < length; i++) {
			result[i] = characters[i];
		}
		return result;
	}
}
