package mealplan;

public class KetoMeal implements MealPlan {
    private String name;

    public KetoMeal(String name) {
        this.name = name;
    }

    @Override
    public String getMealDetails() {
        return "Keto Meal: " + name;
    }
}
