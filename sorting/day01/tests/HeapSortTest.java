import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {
    private int[] emptyCase;
    private int[] oneCase;
    private int[] twoCase;
    private int[] fastCase;
    private int[] slowCase;

    private static final int RANGE = 100;

    @Before
    public void setup() {
        emptyCase = generateRandomArrayOfSize(0);
        oneCase = generateRandomArrayOfSize(1);
        twoCase = generateRandomArrayOfSize(2);
        fastCase = generateRandomArrayOfSize(1000);
        slowCase = generateRandomArrayOfSize(100000);
    }

    @Test
    public void testBuildHeapFrom() {
        HeapSort hs = new HeapSort();
        int[] in = new int[]{8, 2, 9, 1, 5, 6, 3, 1, 2};
        int[] heap = new int[]{9, 5, 8, 2, 2, 6, 3, 1, 1};
        hs.buildHeapFrom(in);
        assertArrayEquals(in, heap);
        in = new int[]{1, 3, 2, 5, 1, 2, 7, 9};
        heap = new int[]{9, 5, 7, 3, 1, 2, 2, 1};
        hs.buildHeapFrom(in);
        assertArrayEquals(in, heap);
    }

    @Test
    public void testHeapify() {
        HeapSort hs = new HeapSort();
        int[] in = new int[]{4, 2, 9, 1, 5, 6, 3, 1, 2};
        hs.heap = in;
        hs.size = in.length;
        hs.heapify(5);
        hs.heapify(7);
        hs.heapify(8);
        int[] out = new int[]{4, 2, 9, 1, 5, 6, 3, 1, 2};
        assertArrayEquals(in, out);
        hs.heapify(3);
        hs.heapify(0);
        out = new int[]{9, 2, 6, 2, 5, 4, 3, 1, 1};
        assertArrayEquals(in, out);
    }

    public static int[] generateRandomArrayOfSize(int n) {
        int[] random = new int[n];

        for (int i=0; i < n; i++) {
            random[i] = (int) (Math.random() * (2 * RANGE) - RANGE);
        }

        return random;
    }

    private void testSort(SortAlgorithm sorter) {
        assertArrayEquals(sorter.sort(emptyCase), emptyCase);
        assertArrayEquals(sorter.sort(oneCase), sort(oneCase));
        assertArrayEquals(sorter.sort(twoCase), sort(twoCase));
        assertArrayEquals(sorter.sort(fastCase), sort(fastCase));
        assertArrayEquals(sorter.sort(slowCase), sort(slowCase));
    }

    private int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    @Test
    public void testHeapSort() {
        testSort(new HeapSort());
    }

}
