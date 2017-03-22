
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShortestPathTest {

    private UndirectedGraph g1, g3, g4;


    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        g1 = new UndirectedGraph(9);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);
        g1.addEdge(4, 5);
        g1.addEdge(5, 6);
        g1.addEdge(3, 7);
        g1.addEdge(6, 7);

        g3 = new UndirectedGraph(5);
        g3.addEdge(0, 2);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(3, 4);

        g4 = new UndirectedGraph(4);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(0, 3);
    }


    /**
     * Test method for {@link ShortestPath#shortestPath(Graph, int, int)}.
     */
    @Test
    public void testShortestPath() {

        List<Integer> path1 = ShortestPath.shortestPath(g1, 0, 6);
        assertTrue(Arrays.equals(path1.toArray(), new Object[]{0, 2, 4, 5, 6}) ||
                Arrays.equals(path1.toArray(), new Object[]{0, 1, 3, 7, 6}));


        List<Integer> path2 = ShortestPath.shortestPath(g1, 0, 7);
        assertArrayEquals(path2.toArray(), new Object[]{0, 1, 3, 7});

        List<Integer> path3 = ShortestPath.shortestPath(g1, 3, 2);
        assertTrue(Arrays.equals(path3.toArray(), new Object[]{3, 1, 2}) ||
                Arrays.equals(path3.toArray(), new Object[]{3, 4, 2}));
    }

    /**
     * Test method for {@link ShortestPath#distanceBetween(Graph, int, int)}.
     */
    @Test
    public void testDistanceBetween() {
        assertThat(ShortestPath.distanceBetween(g1, 0, 6), is(4));
        assertThat(ShortestPath.distanceBetween(g1, 0, 4), is(2));
        assertThat(ShortestPath.distanceBetween(g1, 0, 3), is(2));
        assertThat(ShortestPath.distanceBetween(g1, 0, 8), is(-1));
    }

}
