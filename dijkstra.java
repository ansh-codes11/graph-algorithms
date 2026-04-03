import java.util.*;

class Pair {
    int node, dist;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class Dijkstra {
    public static void dijkstra(int V, List<List<Pair>> adj, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            for (Pair neighbor : adj.get(curr.node)) {
                if (curr.dist + neighbor.dist < dist[neighbor.node]) {
                    dist[neighbor.node] = curr.dist + neighbor.dist;
                    pq.add(new Pair(neighbor.node, dist[neighbor.node]));
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }
}
