import java.util.List;

public interface Graph {

    void addEdge(int v, int w);
    List<Integer> vertices();
    int numVertices();
    int numEdges();
    Iterable<Integer> getNeighbors(int v);
    boolean hasEdgeBetween(int v, int w);

}