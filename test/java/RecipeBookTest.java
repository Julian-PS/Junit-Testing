import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RecipeBookTest {

    RecipeBook test;

    @Before
    public void createNewDefaultRecipeBook() throws Exception {
        test = new RecipeBook();
    }

    @Test
    public void testGetRecipesForDefaultConstructor() {

        // a new RecipeBook should create an array with 4 null recipes
        assertEquals(4, test.getRecipes().length);   // length of array should be 4
        assertNull(test.getRecipes()[0]);                    // all recipes should be null
        assertNull(test.getRecipes()[1]);
        assertNull(test.getRecipes()[2]);
        assertNull(test.getRecipes()[3]);
    }

    @Test
    public void testAddRecipeAndThenTryToAddAgain() {

        Recipe toAdd = new Recipe();
        assertTrue(test.addRecipe(toAdd));          // recipe successfully added
        assertEquals(toAdd, test.getRecipes()[0]);  // recipe added at first available, test[0]
        assertFalse(test.addRecipe(toAdd));         // since recipe already exists, it cannot be added again
    }

    @Test
    public void testAddRecipeFullArray() {

        // we create 5 new recipes and add them to the RecipeBook. Only the first 4 should be added
        // and return true. The last one should return false because RecipeBook is full
        Recipe toAdd1 = new Recipe();
        toAdd1.setName("1");                       // change the name of each recipe to differentiate them
        Recipe toAdd2 = new Recipe();
        toAdd2.setName("2");
        Recipe toAdd3 = new Recipe();
        toAdd3.setName("3");
        Recipe toAdd4 = new Recipe();
        toAdd4.setName("4");
        Recipe toAdd5 = new Recipe();
        toAdd5.setName("5");
        assertTrue(test.addRecipe(toAdd1));
        assertTrue(test.addRecipe(toAdd2));
        assertTrue(test.addRecipe(toAdd3));
        assertTrue(test.addRecipe(toAdd4));          // recipes successfully added
        assertEquals(toAdd1, test.getRecipes()[0]);  // recipe added at first available, [0]
        assertEquals(toAdd2, test.getRecipes()[1]);  // recipe added at first available, [1]
        assertEquals(toAdd3, test.getRecipes()[2]);  // recipe added at first available, [2]
        assertEquals(toAdd4, test.getRecipes()[3]);  // recipe added at first available, [3]
        assertFalse(test.addRecipe(toAdd5));         // recipe not added because we don't have spaces available
    }

    @Test
    public void deleteRecipeMocha() {

        Recipe mocha = new Recipe();
        mocha.setName("mocha");          // name the recipe
        test.addRecipe(mocha);           //add recipe to first available place, [0]
        assertEquals("mocha", test.deleteRecipe(0));  //recipe deleted and name returned
    }

    @Test
    public void deleteRecipeNonExistent() {

        assertNull(test.deleteRecipe(3));     // return null if deleting a non existent recipe
    }

    @Test
    public void editRecipeChangeMochaToAmericano() {

        Recipe mocha = new Recipe();
        mocha.setName("mocha");
        test.addRecipe(mocha);                      // recipe added to index 0
        Recipe americano = new Recipe();
        assertEquals("mocha", test.editRecipe(0, americano));  // replace recipe and return name
        assertEquals(americano, test.getRecipes()[0]);    // to confirm recipe has been successfully replaced
    }

    @Test
    public void editRecipeNullReturnsNull() {

        Recipe mocha = new Recipe();
        assertNull(test.editRecipe(2, mocha));    // index 2 is null so it returns null
    }
}