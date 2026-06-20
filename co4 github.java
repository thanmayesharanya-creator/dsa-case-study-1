import java.util.*;

class Edge {
    int destination;
    int distance;

    public Edge(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}

public class BMTCShortestPath {

    static int[] dijkstra(List<List<Edge>> graph, int source, int[] surgePenalty) {

        int n = graph.size();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[source] = 0;
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();
            int u = current.vertex;

            for (Edge edge : graph.get(u)) {

                int v = edge.destination;

                int newCost = distance[u]
                        + edge.distance
                        + surgePenalty[v];

                if (newCost < distance[v]) {
                    distance[v] = newCost;
                    pq.add(new Node(v, newCost));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {

        int vertices = 6;

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // BMTC Route Connections
        graph.get(0).add(new Edge(1, 5));
        graph.get(0).add(new Edge(2, 8));

        graph.get(1).add(new Edge(3, 7));
        graph.get(1).add(new Edge(4, 6));

        graph.get(2).add(new Edge(4, 4));

        graph.get(3).add(new Edge(5, 3));

        graph.get(4).add(new Edge(5, 5));

        // Surge Zone Penalties
        int[] surgePenalty = {
            0,  // Stop A
            2,  // Stop B
            5,  // Stop C (high congestion)
            1,  // Stop D
            4,  // Stop E
            0   // Stop F
        };

        int source = 0;

        int[] shortestDistances =
                dijkstra(graph, source, surgePenalty);

        System.out.println("BMTC Route Cost with Surge Penalties:");

        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println(
                "Stop " + i +
                " -> Cost = " +
                shortestDistances[i]
            );
        }
    }
}