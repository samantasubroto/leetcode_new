package graphs;

import java.util.*;

public class CenterStarGraph {
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) {
        CenterStarGraph g = new CenterStarGraph();

        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 2);
    }

    void addVertex(int v) {
        adjList.put(v, new ArrayList<>());
    }

    void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

}
