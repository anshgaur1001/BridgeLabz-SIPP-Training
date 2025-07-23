package mealplan;

public class Main {
    public static void main(String[] args) {
        VegetarianMeal veg = new VegetarianMeal("Paneer Curry with Rice");
        VeganMeal vegan = new VeganMeal("Tofu Stir-Fry");
        KetoMeal keto = new KetoMeal("Grilled Chicken with Avocado");
        HighProteinMeal protein = new HighProteinMeal("Egg White Omelette");

        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(veg);
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(vegan);
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(keto);
        Meal<HighProteinMeal> proteinMeal = MealPlanGenerator.generateMealPlan(protein);

        System.out.println("\n--- Personalized Meals ---");
        vegMeal.showMeal();
        veganMeal.showMeal();
        ketoMeal.showMeal();
        proteinMeal.showMeal();
    }
}
