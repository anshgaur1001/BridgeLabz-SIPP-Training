package mealplan;

public class VegetarianMeal implements MealPlan {
    private String name;

    public VegetarianMeal(String name) {
        this.name = name;
    }

    @Override
    public String getMealDetails() {
        return "Vegetarian Meal: " + name;
    }
}
