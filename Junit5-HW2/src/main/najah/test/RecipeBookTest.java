package main.najah.test;

import org.junit.jupiter.api.*;
import main.najah.code.RecipeBook;
import main.najah.code.Recipe;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@DisplayName("RecipeBook Tests")
@TestMethodOrder(OrderAnnotation.class)
public class RecipeBookTest {

    RecipeBook recipeBook;
    Recipe recipe;

    @BeforeAll()
    static void beforeAllRec() {
        System.out.println("Initial RecipeBook Test. \n");
    }

    @AfterAll()
    static void afterAllRec() {
        System.out.println("All RecipeBook Test Completed. \n");
    }
 
    @BeforeEach
    void setupRec() throws Exception {
        recipeBook = new RecipeBook();
        recipe = new Recipe();
        recipe.setName("Coffee");
        System.out.println("Before RecipeBook Test Method.");
    }

    @AfterEach
    void tearDownRec() {
        System.out.println("After RecipeBook Test Method. \n");
    }

    @Test
    @Order(1)
    @DisplayName("Add Recipe: Successfully add a new recipe.")
    void testAddRecipe() {
    	System.out.println("The recipe has been added successfully.");
        assertTrue(recipeBook.addRecipe(recipe));
    }

    @Test
    @Order(2)
    @DisplayName("Delete Recipe: Successfully delete a recipe.")
    void testDeleteRecipe() {
        recipeBook.addRecipe(recipe); // Add
        System.out.println("The recipe has been deleted successfully.");
        assertEquals("Coffee", recipeBook.deleteRecipe(0)); //0 -> index
    }

    @Test
    @Order(3)
    @DisplayName("Delete Recipe: Delete non-existing recipe returns null.")
    void testDeleteNonExistingRecipe() {
    	System.out.println("Attempt to delete recipe does not exist.");
        assertNull(recipeBook.deleteRecipe(1));
    }

    @Test
    @Order(4)
    @DisplayName("Edit Recipe: Successfully edit a recipe")
    void testEditRecipe() {
    	System.out.println("Edit recipe successfully.");
        recipeBook.addRecipe(recipe); // Add again
        Recipe newRecipe = new Recipe(); // new recipe 
        newRecipe.setName("Tea");
        assertEquals("Coffee", recipeBook.editRecipe(0, newRecipe));
    }

    @Test
    @Order(5)
    @DisplayName("Edit Recipe: Edit non-existing recipe returns null.")
    void testEditNonExistingRecipe() {
    	System.out.println("Attempt to edit recipe does not exist.");
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Latte"); // new recipe
        assertNull(recipeBook.editRecipe(0, newRecipe));
    }

    @Test
    @Order(6) 
    @DisplayName("Get Recipes: Ensure array is initialized with null")
    void testGetRecipesInitial() {
    	System.out.println("Check that the array is initially empty.");
        Recipe[] recipes = recipeBook.getRecipes(); // call a function 
        assertEquals(4, recipes.length); // 4 in java page
        for (Recipe index : recipes) {
            assertNull(index);
        }
    }

    @Test
    @Order(7)
    @DisplayName("Timeout Test: Add Recipe within time")
    @Timeout(1)
    void testAddRecipeTimeout() {
    	System.out.println("Use time out.");
        assertTrue(recipeBook.addRecipe(recipe));
    }
}
