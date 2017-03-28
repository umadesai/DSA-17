
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;


public class PermutationsTest {
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link Permutations#permutations(List)}.
     */
    @Test
    public void testPermutations3() {
        List<List<Integer>> perm3 = Permutations.permutations(Arrays.asList(1, 2, 3));
        Integer[][] expectedOutput = new Integer[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
        assertThat(perm3, containsInAnyOrder(TestUtil.arrayToLists(expectedOutput)));
    }

    /**
     * Test method for {@link Permutations#permutations(List)}.
     */
    @Test
    public void testPermutations4() {
        List<List<Integer>> perm4 = Permutations.permutations(Arrays.asList(1, 2, 3, 4));
        Integer[][] expectedOutput = new Integer[][]{{1, 2, 3, 4}, {1, 2, 4, 3}, {1, 3, 2, 4}, {1, 3, 4, 2}, {1, 4, 2,
                3}, {1, 4, 3, 2}, {2, 1, 3, 4}, {2, 1, 4, 3}, {2, 3, 1, 4}, {2, 3, 4, 1}, {2, 4, 1, 3}, {2, 4, 3, 1},
                {3, 1, 2, 4}, {3, 1, 4, 2}, {3, 2, 1, 4}, {3, 2, 4, 1}, {3, 4, 1, 2}, {3, 4, 2, 1}, {4, 1, 2, 3}, {4,
                1, 3, 2}, {4, 2, 1, 3}, {4, 2, 3, 1}, {4, 3, 1, 2}, {4, 3, 2, 1}};
        assertThat(perm4, containsInAnyOrder(TestUtil.arrayToLists(expectedOutput)));
    }


}