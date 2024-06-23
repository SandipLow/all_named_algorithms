package com.sandip;
import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


public class Graphs {
    /**
     * Breadth First Search
     * @param node
     * @param adj adjacency list
     */
    public static void bfs(int node, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[adj.size() + 1];
        
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.print(n + " ");
            for (int i : adj.get(n)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }   
    }

    /**
     * Depth First Search
     * @param node
     * @param adj adjacency list
     * @param visited boolean array to keep track of visited nodes
     */
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        System.out.print(node + " ");
        for (int i : adj.get(node)) {
            if (!visited[i]) dfs(i, adj, visited);
        }
    }

    /**
     * Kahn's algorithm for Topological Sort
     * @param n number of nodes
     * @param adj adjacency list
     * @return topological order
     * @throws Exception if graph has cycle
     */
    public static ArrayList<Integer> topologicalSort(int n, ArrayList<ArrayList<Integer>> adj) throws Exception {
        // Calculate in-degree of each node
        int[] inDegree = new int[n];
        for (int i=0; i<n; i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }

        // Add nodes with in-degree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        
        // Perform topological sort
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int i : adj.get(node)) {
                inDegree[i]--;
                if (inDegree[i] == 0) q.add(i);
            }
        }

        if (ans.size() != n) throw new Exception("Graph has cycle");
        return ans;
    }

    /**
     * Dijkstra's algorithm for undirected weighted graph
     * @param src source node
     * @param n number of nodes
     * @param adj adjacency list
     * @return shortest distance from source node to all other nodes
     */
    public static List<Integer> dijkstara(int src, int n, List<List<Pair>> adj) {
        List<Integer> dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        dist.set(src, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.first;
            int w = p.second;

            if (w > dist.get(u)) continue;

            for (Pair edge : adj.get(u)) {
                int v = edge.first;
                int weight = edge.second;

                if (dist.get(u) + weight < dist.get(v)) {
                    dist.set(v, dist.get(u) + weight);
                    pq.add(new Pair(v, dist.get(v)));
                }
            }
        }

        return dist;   
    }
}