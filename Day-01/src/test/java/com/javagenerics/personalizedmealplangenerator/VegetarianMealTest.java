package com.javagenerics.personalizedmealplangenerator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class VegetarianMealTest {

    private Meal<VegetarianMeal> vegetarianMeal;
    private Meal<VeganMeal> veganMeal;
    private Meal<KetoMeal> ketoMeal;
    private Meal<HighProteinMeal> highProteinMeal;

    @BeforeEach
    void setUp() {
        vegetarianMeal = new Meal<>();
        veganMeal = new Meal<>();
        ketoMeal = new Meal<>();
        highProteinMeal = new Meal<>();

        vegetarianMeal.addMeal(new VegetarianMeal("Vegetable Stir Fry"));
        veganMeal.addMeal(new VeganMeal("Tofu Salad"));
        ketoMeal.addMeal(new KetoMeal("Grilled Salmon"));
        highProteinMeal.addMeal(new HighProteinMeal("Chicken Breast with Quinoa"));
    }


    @Test
    void testMealAddition() {
        assertEquals(1, vegetarianMeal.getMeals().size());
        assertEquals(1, veganMeal.getMeals().size());
        assertEquals(1, ketoMeal.getMeals().size());
        assertEquals(1, highProteinMeal.getMeals().size());
    }


    @Test
    void testRetrieveMeals() {
        List<VegetarianMeal> vegMeals = vegetarianMeal.getMeals();
        assertEquals("Vegetable Stir Fry", vegMeals.get(0).getMealName());

        List<VeganMeal> veganMeals = veganMeal.getMeals();
        assertEquals("Tofu Salad", veganMeals.get(0).getMealName());
    }


    @Test
    void testMealPlanGenerator() {
        assertDoesNotThrow(() -> MealPlanGenerator.generateMealPlan(vegetarianMeal));
        assertDoesNotThrow(() -> MealPlanGenerator.generateMealPlan(veganMeal));
    }


    @Test
    void testToStringFormat() {
        assertEquals("Vegetarian Meal: Vegetable Stir Fry", vegetarianMeal.getMeals().get(0).toString());
        assertEquals("Vegan Meal: Tofu Salad", veganMeal.getMeals().get(0).toString());
    }


    @Test
    void testTypeSafety() {
        // Should fail at compile-time if uncommented
        // Meal<String> stringMeal = new Meal<>(); // Not allowed

        assertTrue(true); // Placeholder to indicate compile-time safety
    }
}