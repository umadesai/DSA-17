public class UndirectedGraph extends Digraph {

    private int numEdges;

    // O(V)
    public UndirectedGraph(int n) {
        super(n);
    }

    // O(1)
    @Override
    public void addEdge(int v, int w) {
        super.addEdge(v, w);
        super.addEdge(w, v);
        numEdges++;
    }

    // O(1)
    @Override
    public int numEdges() {
        return numEdges;
    }

}