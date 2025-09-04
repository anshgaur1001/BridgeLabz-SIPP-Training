import java.util.*;

public class SocialMediaFriendRecommendation {

    // BFS function to find 2nd-degree connections
    public static List<String> recommendFriends(Map<String, List<String>> graph, String user) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();
        Set<String> visited = new HashSet<>();

        // Start BFS from the user
        queue.add(user);
        distance.put(user, 0);
        visited.add(user);

        List<String> recommendations = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int dist = distance.get(current);

            // Stop BFS after reaching level 2
            if (dist == 2) continue;

            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    distance.put(neighbor, dist + 1);
                    queue.add(neighbor);

                    // Collect only 2nd-degree connections
                    if (dist + 1 == 2) {
                        // Exclude direct friends and self
                        if (!graph.get(user).contains(neighbor) && !neighbor.equals(user)) {
                            recommendations.add(neighbor);
                        }
                    }
                }
            }
        }
        return recommendations;
    }

    public static void main(String[] args) {
        // Graph representation (Adjacency List)
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Alice", Arrays.asList("Bob", "Charlie"));
        graph.put("Bob", Arrays.asList("Alice", "David", "Emma"));
        graph.put("Charlie", Arrays.asList("Alice", "Frank"));
        graph.put("David", Arrays.asList("Bob"));
        graph.put("Emma", Arrays.asList("Bob"));
        graph.put("Frank", Arrays.asList("Charlie"));

        String user = "Alice";

        System.out.println("Current User: " + user);
        System.out.println("Direct Friends: " + graph.get(user));

        List<String> suggestions = recommendFriends(graph, user);
        System.out.println("Friend Suggestions: " + suggestions);
    }
}
