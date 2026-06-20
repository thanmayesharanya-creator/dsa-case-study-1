import java.util.*;

public class WikipediaHyperlinkGraph {

    private Map<String, List<String>> graph;

    public WikipediaHyperlinkGraph() {
        graph = new HashMap<>();
    }

    // Add a Wikipedia page
    public void addPage(String page) {
        graph.putIfAbsent(page, new ArrayList<>());
    }

    // Add a hyperlink between pages
    public void addLink(String from, String to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.putIfAbsent(to, new ArrayList<>());
        graph.get(from).add(to);
    }

    // Display graph
    public void displayGraph() {
        System.out.println("\n===== Wikipedia Hyperlink Graph =====");
        for (String page : graph.keySet()) {
            System.out.println(page + " --> " + graph.get(page));
        }
    }

    // Find shortest path using BFS
    public void shortestPath(String start, String end) {

        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end))
                break;

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!visited.contains(end)) {
            System.out.println("\nNo path found!");
            return;
        }

        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        System.out.println("\nShortest Path:");
        System.out.println(String.join(" -> ", path));
    }

    public static void main(String[] args) {

        WikipediaHyperlinkGraph wiki = new WikipediaHyperlinkGraph();

        // Add pages
        wiki.addPage("Artificial Intelligence");
        wiki.addPage("Machine Learning");
        wiki.addPage("Deep Learning");
        wiki.addPage("Data Science");
        wiki.addPage("Neural Networks");
        wiki.addPage("Big Data");

        // Add hyperlinks
        wiki.addLink("Artificial Intelligence", "Machine Learning");
        wiki.addLink("Machine Learning", "Deep Learning");
        wiki.addLink("Machine Learning", "Data Science");
        wiki.addLink("Deep Learning", "Neural Networks");
        wiki.addLink("Data Science", "Big Data");
        wiki.addLink("Big Data", "Neural Networks");

        wiki.displayGraph();

        wiki.shortestPath(
                "Artificial Intelligence",
                "Neural Networks"
        );
    }
}