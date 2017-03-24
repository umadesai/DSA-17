
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReviewProblemTest {
    private int[] A1, A2, A3;


    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        A1 = new int[]{2,3,1,2,4,3};
        A2 = new int[]{4, 5, 4, 9, 8, 2, 0, 1, 2, 4, 5, 4, 8, 1, 0, 8, 3, 1, 5, 1, 3, 6, 2, 3, 0, 4, 0, 7, 3, 9};
    }

    /**
     * Test method for {@link ReviewProblem#minimumLengthSubArray(int[], int)}.
     */
    @Test
    public void testMinimumLengthSubArray() {
        assertThat(ReviewProblem.minimumLengthSubArray(A1, 4), is(1));
        assertThat(ReviewProblem.minimumLengthSubArray(A1, 7), is(2));
        assertThat(ReviewProblem.minimumLengthSubArray(A1, 8), is(3));
        assertThat(ReviewProblem.minimumLengthSubArray(A2, 1), is(1));
        assertThat(ReviewProblem.minimumLengthSubArray(A2, 2), is(1));
        assertThat(ReviewProblem.minimumLengthSubArray(A2, 9), is(1));
        assertThat(ReviewProblem.minimumLengthSubArray(A2, 12), is(2));
        assertThat(ReviewProblem.minimumLengthSubArray(A2, 17), is(2));
        assertThat(ReviewProblem.minimumLengthSubArray(A2, 28), is(5));
        assertThat(ReviewProblem.minimumLengthSubArray(A2, 49), is(12));
        assertThat(ReviewProblem.minimumLengthSubArray(A2, 87), is(24));
    }
}
