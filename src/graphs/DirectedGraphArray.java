package graph;

import java.util.*;

public class DirectedGraphArray {

    // instead of Map<Integer, List<Integer>> adjList
    // we just use int[][] graph
    // graph[i] = neighbors of node i

    public static void main(String[] args) {

        int[][] graph = {
                {4, 14, 3, 12, 5, 2, 8, 1, 10, 6, 13, 7, 11},
                {3, 5, 11, 13, 2, 4, 9, 10, 12, 6},
                {4, 5, 10, 6, 7, 13, 14, 12, 11, 3, 8},
                {7, 5, 6, 9, 13, 12, 11, 4, 14},
                {6, 8, 13, 12, 7, 10, 5, 9, 14, 11},
                {8, 9, 7, 13, 12, 11, 14, 10, 6},
                {8, 10, 14, 11, 13, 7},
                {11, 10, 12, 14, 9, 8},
                {11, 10, 13, 12, 9},
                {12, 13, 11, 10, 14},
                {14, 11, 13},
                {13, 14, 12},
                {14, 13},
                {14},
                {}
        };

        // with cycle: uncomment below to add 9 → 2
        // int[][] graph = {
        //     {1, 3}, {2, 4}, {5}, {4, 6}, {5, 7},
        //     {8}, {7}, {8, 9}, {9}, {2}   // 9 → 2 creates cycle
        // };

        DirectedGraphArray sol = new DirectedGraphArray();
//        System.out.println("Has cycle: " + sol.isCyclic(graph));

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));
        sol.findSmallestSetOfVertices(6, edges);
    }

    boolean isCyclicDFS(int current, int[][] graph, boolean[] visited, boolean[] recursivePath) {
        visited[current] = true;
        recursivePath[current] = true;

        for (int neighbour : graph[current]) {
            if (!visited[neighbour]) {
                if (isCyclicDFS(neighbour, graph, visited, recursivePath)) return true;
            } else if (recursivePath[neighbour]) {
                return true;
            }
        }

        recursivePath[current] = false;  // backtrack
        return false;
    }

    boolean isCyclic(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];        // instead of Set<Integer> visited
        boolean[] recursivePath = new boolean[n];  // instead of Set<Integer> recursivePath

        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                if (isCyclicDFS(vertex, graph, visited, recursivePath)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Question: 797
    public List<List<Integer>> DFS(final int current, final int[][] graph, final boolean[] visited, final List<List<Integer>> results, final List<Integer> path) {
        visited[current] = true;
        path.add(current);
        if (current == (graph.length - 1)) {
            results.add(new ArrayList<>(path));
        } else {
            for (int neighbour : graph[current]) {
                if (!visited[neighbour]) {
                    DFS(neighbour, graph, visited, results, path);
                }
            }
        }
        path.remove(path.size() - 1);
        visited[current] = false;
        return results;
    }

    // Question: 797
    public List<List<Integer>> DFS(int current, int[][] graph, List<List<Integer>> results, List<Integer> path) {
        path.add(current);
        if (current == graph.length - 1) {
            results.add(new ArrayList<>(path));
        } else {
            for (int neighbour : graph[current]) {
                DFS(neighbour, graph, results, path);
            }
        }
        path.remove(path.size() - 1);
        return results;
    }

    // Question: 797
    public void allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];        // instead of Set<Integer> visited
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        System.out.println(DFS(0, graph, result, path));
    }

    public int DFS(List<List<Integer>> graph, int current, List<Integer> depth) {
        depth.add(current);
        if (current == graph.size() - 1) {
            return depth.size();
        }
        for (int neighbour : graph.get(current)) {
            int result = DFS(graph, neighbour, depth);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> inDegree = new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inDegree.add(0);
        }
        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            inDegree.set(to, inDegree.get(to) + 1);
        }
        for (int i = 0; i < inDegree.size(); i++) {

            if (inDegree.get(i) == 0) {
                results.add(i);
            }
        }
        return results;
    }
}