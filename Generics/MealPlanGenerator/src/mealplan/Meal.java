package mealplan;

public class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    public void showMeal() {
        System.out.println(mealType.getMealDetails());
    }
}
