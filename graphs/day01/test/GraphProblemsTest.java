
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GraphProblemsTest {

    private UndirectedGraph g1, g2, g3;
    private Digraph g4, g5;


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

        g2 = new UndirectedGraph(5);
        g2.addEdge(0, 2);
        g2.addEdge(1, 3);
        g2.addEdge(1, 4);
        g2.addEdge(3, 4);

        g3 = new UndirectedGraph(4);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(0, 3);

        g4 = new Digraph(5);
        g4.addEdge(4, 0);
        g4.addEdge(0, 2);
        g4.addEdge(0, 3);
        g4.addEdge(1, 2);
        g4.addEdge(3, 1);

        g5 = new Digraph(6);
        g5.addEdge(5, 3);
        g5.addEdge(5, 2);
        g5.addEdge(1, 3);
        g5.addEdge(1, 2);
        g5.addEdge(1, 4);
        g5.addEdge(2, 4);
        g5.addEdge(4, 0);
        g5.addEdge(5, 3);
    }

    /**
     * Test method for {@link GraphProblems#connected(Graph, int, int)}.
     */
    @Test
    public void testConnected() {
        assertThat(GraphProblems.connected(g1, 0, 5), is(true));
        assertThat(GraphProblems.connected(g1, 0, 8), is(false));
        assertThat(GraphProblems.connected(g4, 4, 3), is(true));
        assertThat(GraphProblems.connected(g4, 3, 4), is(false));
        assertThat(GraphProblems.connected(g5, 5, 4), is(true));
        assertThat(GraphProblems.connected(g5, 5, 1), is(false));
        assertThat(GraphProblems.connected(g4, 4, 5), is(false));
    }

    /**
     * Test method for {@link GraphProblems#topologicalOrder(Digraph)}.
     */
    @Test
    public void testTopologicalOrder() {
        List<Integer> order = GraphProblems.topologicalOrder(g4);
        assertThat(order.toArray(), is(new Integer[]{4, 0, 3, 1, 2}));
        // This graph has multiple valid topological orders
        order = GraphProblems.topologicalOrder(g5);
        assertThat(order.toArray(), anyOf(
                is(new Integer[]{1, 5, 2, 4, 3, 0}),
                is(new Integer[]{1, 5, 2, 4, 0, 3}),
                is(new Integer[]{5, 1, 2, 4, 0, 3}),
                is(new Integer[]{1, 5, 3, 2, 4, 0}),
                is(new Integer[]{5, 1, 3, 2, 4, 0}),
                is(new Integer[]{1, 5, 2, 3, 4, 0}),
                is(new Integer[]{5, 1, 2, 4, 3, 0}),
                is(new Integer[]{5, 1, 2, 3, 4, 0})));

    }


    /**
     * Test method for {@link GraphProblems#hasCycle(UndirectedGraph)}.
     */
    @Test
    public void testHasCycle() {
        assertThat(GraphProblems.hasCycle(g1), is(true));
        assertThat(GraphProblems.hasCycle(g2), is(true));
        assertThat(GraphProblems.hasCycle(g3), is(false));
    }

}
