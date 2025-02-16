package com.javagenerics.personalizedmealplangenerator;

import java.util.ArrayList;
import java.util.List;

    interface MealPlan {
        String getMealName();
    }


    class VegetarianMeal implements MealPlan {
        private String mealName;

        public VegetarianMeal(String mealName) {
            this.mealName = mealName;
        }

        @Override
        public String getMealName() {
            return mealName;
        }

        @Override
        public String toString() {
            return "Vegetarian Meal: " + mealName;
        }
    }

    class VeganMeal implements MealPlan {
        private String mealName;

        public VeganMeal(String mealName) {
            this.mealName = mealName;
        }

        @Override
        public String getMealName() {
            return mealName;
        }

        @Override
        public String toString() {
            return "Vegan Meal: " + mealName;
        }
    }

    class KetoMeal implements MealPlan {
        private String mealName;

        public KetoMeal(String mealName) {
            this.mealName = mealName;
        }

        @Override
        public String getMealName() {
            return mealName;
        }

        @Override
        public String toString() {
            return "Keto Meal: " + mealName;
        }
    }

    class HighProteinMeal implements MealPlan {
        private String mealName;

        public HighProteinMeal(String mealName) {
            this.mealName = mealName;
        }

        @Override
        public String getMealName() {
            return mealName;
        }

        @Override
        public String toString() {
            return "High-Protein Meal: " + mealName;
        }
    }

    // Step 3: Generic Meal Management Class
    class Meal<T extends MealPlan> {
        private List<T> meals;

        public Meal() {
            this.meals = new ArrayList<>();
        }

        public void addMeal(T meal) {
            meals.add(meal);
        }

        public List<T> getMeals() {
            return meals;
        }

        public void displayMeals() {
            for (T meal : meals) {
                System.out.println(meal);
            }
        }
    }


    class MealPlanGenerator {
        public static <T extends MealPlan> void generateMealPlan(Meal<T> mealCategory) {
            System.out.println("\nGenerated Meal Plan:");
            mealCategory.displayMeals();
        }
    }

    // Step 5: Testing the Meal Plan System
    public class PersonalizedMealPlanGenerator{
        public static void main(String[] args) {
            // Create meal categories
            Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
            Meal<VeganMeal> veganMeals = new Meal<>();
            Meal<KetoMeal> ketoMeals = new Meal<>();
            Meal<HighProteinMeal> highProteinMeals = new Meal<>();

            // Add meals to each category
            vegetarianMeals.addMeal(new VegetarianMeal("Vegetable Stir Fry"));
            vegetarianMeals.addMeal(new VegetarianMeal("Paneer Butter Masala"));

            veganMeals.addMeal(new VeganMeal("Tofu Salad"));
            veganMeals.addMeal(new VeganMeal("Vegan Smoothie"));

            ketoMeals.addMeal(new KetoMeal("Grilled Salmon"));
            ketoMeals.addMeal(new KetoMeal("Avocado and Eggs"));

            highProteinMeals.addMeal(new HighProteinMeal("Chicken Breast with Quinoa"));
            highProteinMeals.addMeal(new HighProteinMeal("Protein Shake"));

            // Generate meal plans
            MealPlanGenerator.generateMealPlan(vegetarianMeals);
            MealPlanGenerator.generateMealPlan(veganMeals);
            MealPlanGenerator.generateMealPlan(ketoMeals);
            MealPlanGenerator.generateMealPlan(highProteinMeals);
        }
    }




