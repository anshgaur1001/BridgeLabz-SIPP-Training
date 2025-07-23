package mealplan;

public class VeganMeal implements MealPlan {
    private String name;

    public VeganMeal(String name) {
        this.name = name;
    }

    @Override
    public String getMealDetails() {
        return "Vegan Meal: " + name;
    }
}
