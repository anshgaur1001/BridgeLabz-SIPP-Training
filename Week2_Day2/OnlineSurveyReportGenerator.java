import java.util.*;
import java.util.stream.Collectors;

class SurveyResponse {
    private String restaurantName;
    private int rating; // 1–5

    public SurveyResponse(String restaurantName, int rating) {
        this.restaurantName = restaurantName;
        this.rating = rating;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getRating() {
        return rating;
    }
}

public class OnlineSurveyReportGenerator {
    public static void main(String[] args) {
        // Step 1: Sample Data
        List<SurveyResponse> responses = Arrays.asList(
                new SurveyResponse("PizzaHut", 4),
                new SurveyResponse("PizzaHut", 5),
                new SurveyResponse("KFC", 3),
                new SurveyResponse("KFC", 4),
                new SurveyResponse("Subway", 5),
                new SurveyResponse("Subway", 4),
                new SurveyResponse("Subway", 5)
        );

        // Step 2: Group by restaurant and calculate average rating
        Map<String, Double> avgRatings = responses.stream()
                .collect(Collectors.groupingBy(
                        SurveyResponse::getRestaurantName,
                        Collectors.averagingInt(SurveyResponse::getRating)
                ));

        // Step 3: Print report
        System.out.println("---- Average Ratings per Restaurant ----");
        avgRatings.forEach((restaurant, avg) ->
                System.out.printf("%s → %.2f%n", restaurant, avg));

        // Step 4: Find best & worst restaurant
        Map.Entry<String, Double> best = avgRatings.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        Map.Entry<String, Double> worst = avgRatings.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println("\n✅ Best Restaurant: " + best.getKey() + " → " + best.getValue());
        System.out.println("⚠️ Needs Improvement: " + worst.getKey() + " → " + worst.getValue());
    }
}
