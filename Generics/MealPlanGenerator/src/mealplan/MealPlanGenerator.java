package mealplan;

public class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        // You can add validation here (e.g., nutrition rules, time constraints, etc.)
        System.out.println("Generating personalized meal plan...");
        return new Meal<>(mealType);
    }
}
