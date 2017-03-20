package primitivo.array;

import org.junit.Test;
import primitivo.iterate.IntIterator;
import primitivo.iterate.ObjectIterator;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertArrayEquals;

public class IteratorToArrayTest {
	
	@Test
	public void ints() {
		for (int i = 0; i < 100; i++) {
			int[] ints = new int[i];
			for (int j = 0; j < i; j++) {
				ints[j] = j;
			}
			
			for (int expectedLength = 0; expectedLength < 100; expectedLength++) {
				IntIterator it = IntIterator.of(ints);
				int[] array = IntArray.of(it, expectedLength);
				assertArrayEquals(
						String.format("array(it(%s)) = %s", Arrays.toString(ints), Arrays.toString(array)),
						ints,
						array
				);
			}
		}
	}
	
	@Test
	public void strings() {
		for (int i = 0; i < 100; i++) {
			String[] strings = new String[i];
			char letter = 'a';
			for (int j = 0; j < i; j++) {
				strings[j] = String.valueOf(letter++);
			}
			
			for (int expectedLength = 0; expectedLength < 100; expectedLength++) {
				Iterator<String> it = ObjectIterator.of(strings);
				String[] array = ObjectArray.of(it, String.class, expectedLength);
				assertArrayEquals(
						String.format("array(it(%s)) = %s", Arrays.toString(strings), Arrays.toString(array)),
						strings,
						array
				);
			}
		}
	}
}
