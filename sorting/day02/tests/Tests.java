import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    @Before
    public void setup() {
    }

    private int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    private String[] sort(String[] array) {
        String[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    /**
     * Test method for {@link CountingSort#countingSort(int[])} .
     */
    @Test
    public void testCountingSort() {
        int[] max_values = new int[]{10, 100, 1000};
        for (int m : max_values) {
            int[] A = generateRandomArrayOfSize(100000, 0, m);
            int[] sorted = sort(A);
            CountingSort.countingSort(A);
            assertArrayEquals(A, sorted);
        }
    }

    /**
     * Test method for {@link RadixSort#radixSort(int[], int)}.
     */
    @Test
    public void testRadixSort() {
        int[] max_values = new int[]{10, 100, 1000, 10000};
        int[] bases = new int[]{2, 3, 5, 10, 13, 17, 26};
        for (int m : max_values) {
            for (int b : bases) {
                int[] A = generateRandomArrayOfSize(10000, 0, m);
                int[] sorted = sort(A);
                RadixSort.radixSort(A, b);
                assertArrayEquals(A, sorted);
            }
        }
    }

    /**
     * Test method for {@link Problems#sortNumsBetween100s(int[])}.
     */
    @Test
    public void testSortNumsUnder100() {
        int[] array_lengths = new int[]{10, 100, 1000, 100000};
        for (int l : array_lengths) {
            int[] A = generateRandomArrayOfSize(l, -100, 101);
            int[] sorted = sort(A);
            Problems.sortNumsBetween100s(A);
            assertArrayEquals(A, sorted);
        }
    }

    /**
     * Test method for {@link RadixSort#countingSortByDigit(int[], int, int)}.
     */
    @Test
    public void testCountingSortByDigit() {
        int[] in = new int[]{43, 4, 32, 107, 1920, 10010, 1, 484, 295};
        int[] out = new int[]{1920, 10010, 1, 32, 43, 4, 484, 295, 107};
        RadixSort.countingSortByDigit(in, 10, 0);
        assertArrayEquals(in,out);
        in = new int[]{43, 4, 32, 107, 1920, 10010, 1, 484, 295};
        out = new int[]{4, 107, 1, 10010, 1920, 32, 43, 484, 295};
        RadixSort.countingSortByDigit(in, 10, 1);
        assertArrayEquals(in,out);
        in = new int[]{43, 4, 32, 107, 1920, 10010, 1, 484, 295};
        out = new int[]{4, 1, 295, 107, 1920, 10010, 32, 43, 484};
        RadixSort.countingSortByDigit(in, 7, 1);
        assertArrayEquals(in,out);
        in = new int[]{43, 4, 32, 107, 1920, 10010, 1, 484, 295};
        out = new int[]{4, 107, 1, 43, 32, 10010, 295, 1920, 484};
        RadixSort.countingSortByDigit(in, 3, 3);
        assertArrayEquals(in,out);
    }

    /**
     * Test method for {@link Problems#countingSortByCharacter(String[], int)} (int[], int, int)}.
     */
    @Test
    public void testCountingSortByCharacter() {
        String[] in = new String[]{"then", "sidd", "hieu", "love", "hate", "they", "desk", "pork", "poll", "aapl", "goog", "msft"};
        String[] out = new String[]{"sidd", "love", "hate", "goog", "desk", "pork", "poll", "aapl", "then", "msft", "hieu", "they"};
        Problems.countingSortByCharacter(in, 0);
        assertArrayEquals(in,out);
        in = new String[]{"then", "sidd", "hieu", "love", "hate", "they", "desk", "pork", "poll", "aapl", "goog", "msft"};
        out = new String[]{"hate", "aapl", "desk", "then", "they", "sidd", "hieu", "love", "pork", "poll", "goog", "msft"};
        Problems.countingSortByCharacter(in, 2);
        assertArrayEquals(in,out);
    }

    /**
     * Test method for {@link Problems#sortStrings(String[], int)}.
     */
    @Test
    public void testSortString() {
        int[] lengths = new int[]{5, 10, 20};
        for (int l : lengths) {
            String[] S = generateRandomStringArrayOfSize(10000, l);
            String[] sorted = sort(S);
            Problems.sortStrings(S, l);
            assertArrayEquals(S, sorted);

        }
    }


    private static int[] generateRandomArrayOfSize(int n, int min, int max) {
        int[] random = new int[n];
        for (int i = 0; i < n; i++)
            random[i] = ThreadLocalRandom.current().nextInt(max-min) + min;
        return random;
    }


    private static String[] generateRandomStringArrayOfSize(int n, int stringLength) {
        String[] random = new String[n];
        for (int i = 0; i < n; i++)
            random[i] = randomString(stringLength);
        return random;
    }


    private static String randomString(int length) {
        int i = ThreadLocalRandom.current().nextInt((int) Math.pow(26, length));
        char[] chars = new char[length];
        int j = 0;
        while (j < chars.length) {
            chars[j++] = (char) (i % 26 + 'a');
            i /= 26;
        }
        return new String(chars);
    }

}
