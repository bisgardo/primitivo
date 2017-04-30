package primitivo.array;

import java.util.Iterator;

/**
 * @author Michael Bisgaard Olesen
 */
public class CharArray {
	public static final char[] EMPTY = new char[0];
	
	public static char[] of() {
		return EMPTY;
	}
	
	public static char[] of(char... chars) {
		if (chars == null) {
			throw new NullPointerException("chars");
		}
		if (chars.length == 0) {
			return of();
		}
		return chars;
	}
	
	// Cannot be varargs because that would conflict with the method above.
	public static char[] of(Character[] characters) {
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
	
	public static char[] of(Iterator<Character> iterator) {
		return of(iterator, IteratorToArray.DEFAULT_EXPECTED_LENGTH);
	}
	
	public static char[] of(Iterator<Character> iterator, int expectedLength) {
		Object chars = IteratorToArray.of(iterator, char.class, expectedLength);
		if (chars == null) {
			return EMPTY;
		}
		return (char[]) chars;
	}
}
