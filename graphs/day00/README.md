# Graph HW00: Graph Representation and Breadth First Traversal

## `UndirectedGraph`

Make a class `UndirectedGraph.java` that represents a graph. It should have the following API:

Constructor:
- `UndirectedGraph(int n)`, creates a graph with `n` vertices, labeled `0, 1, 2, ... , n-1`

Methods:
- `void addEdge(int v, int w)` Adds an edge between `v` and `w`
- `List<Integer> vertices()` Returns all vertices in the graph.
- `int numVertices()` Returns the number of vertices in the graph
- `int numEdges()` Returns the number of edges in the graph
- `Iterable<Integer> getNeighbors(int v)` Returns the vertices connected to `v`.
- `boolean hasEdgeBetween(int v, int w)` Returns `true` if `v` and `w` are connected.

Write a short comment at the beginning of each method detailing the runtime complexity in big-O notation. (runtime in graph problems is expressed in terms of `O(V)` and `O(E)`, where V and E are the number of vertices and edges).

## Shortest Path

In `ShortestPath.java`:

Methods:
- `List<Integer> shortestPath(Graph g, int v, int w)` Returns a list of vertices that form the shortest path from `v` to `w` (the first element in the `List` should be `v`, the last element should be `w`). Return `null` if there is no path.
- `int distanceBetween(Graph g, int v, int w)` Returns the distance between two nodes (answer should be `1` if they are directly connected). Return `-1` if the distance is infinite (the vertices are not connected).

## Level Order Traversal

The level-order traversal for a binary tree is the node in order from top to bottom, from left to right. For example, for the following tree:

![](https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Binary_tree.svg/192px-Binary_tree.svg.png)

The level order traversal is `[2, 7, 5, 2, 6, 9, 5, 11, 4]`. In `LevelOrderTraversal.java`, write a function that, given a `TreeNode` at the root of a binary tree, returns the level order traversal.