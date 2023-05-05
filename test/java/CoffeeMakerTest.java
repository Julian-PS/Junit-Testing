import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CoffeeMakerTest {

    CoffeeMaker test;

    @Before
    public void createNewCoffeeMaker() throws Exception {
        test = new CoffeeMaker();
    }

    @Test
    public void addRecipeMochaShouldReturnTrue() {
        Recipe mocha = new Recipe();
        assertTrue(test.addRecipe(mocha));
    }

    @Test
    public void deleteRecipeMochaShouldReturnStringMocha() {
        Recipe mocha = new Recipe();
        mocha.setName("mocha");         // edit recipe's name
        test.addRecipe(mocha);          // add recipe we want to delete to index 0
        assertEquals("mocha", test.deleteRecipe(0));    // return name of deleted recipe located at [0]
    }

    @Test
    public void editRecipeMochaForCappuccinoShouldReturnMocha() {
        Recipe mocha = new Recipe();
        mocha.setName("mocha");
        test.addRecipe(mocha);
        Recipe cappuccino = new Recipe();
        assertEquals("mocha", test.editRecipe(0, cappuccino));
    }

    @Test
    public void addInventoryValue100ToAllShouldBe115() throws InventoryException {
        test.addInventory("100", "100", "100", "100");
        assertEquals("Coffee: 115\nMilk: 115\nSugar: 115\nChocolate: 115\n", test.checkInventory());
    }

    @Test
    public void checkInventoryForDefaultShouldBe15() {
        assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", test.checkInventory());
    }

    @Test
    public void makeCoffeeSuccessfullyAndReturn10() throws RecipeException {
        // create and add mocha recipe with price 10
        Recipe mocha = new Recipe();
        mocha.setPrice("10");
        test.addRecipe(mocha);
        // test the purchase with amtPaid 20
        assertEquals(10, test.makeCoffee(0, 20));
    }

    @Test
    public void makeCoffeeNullRecipeReturnsAmtPaid() {

        assertEquals(20, test.makeCoffee(0, 20));
    }

    @Test
    public void makeCoffeeNotEnoughIngredientsReturnsAmtPaid() throws RecipeException {

        Recipe mocha = new Recipe();
        mocha.setPrice("20");
        mocha.setAmtCoffee("20");     // default inventory only has 15
        test.addRecipe(mocha);

        assertEquals(100, test.makeCoffee(0, 100));
    }

    @Test
    public void makeCoffeePaidLessThanCostReturnsAmtPaid() throws RecipeException {

        Recipe mocha = new Recipe();
        mocha.setPrice("20");
        mocha.setAmtCoffee("20");     // default inventory only has 15
        test.addRecipe(mocha);

        assertEquals(17, test.makeCoffee(0, 17));
    }

    @Test
    public void getRecipesReturnsDefaultArrayWith4NullRecipes() {

        // default RecipeBook should have 4 null recipes
        assertEquals(4, test.getRecipes().length);
        assertNull(test.getRecipes()[0]);
        assertNull(test.getRecipes()[1]);
        assertNull(test.getRecipes()[2]);
        assertNull(test.getRecipes()[3]);

    }

    @Test
    public void getRecipesWithMockitoCustomizedResponse() {

        // Mocked CoffeeMaker to simulate a response
        // Response will be an array with 5 Recipe objects (a to e)
        CoffeeMaker mockedCoffeeMaker = mock(CoffeeMaker.class);

        //create recipes that will form the array
        Recipe a = new Recipe();
        Recipe b = new Recipe();
        Recipe c = new Recipe();
        Recipe d = new Recipe();
        Recipe e = new Recipe();

        // set name for the arrays, so we can assert they are placed in the corresponding index
        a.setName("a");
        b.setName("b");
        c.setName("c");
        d.setName("d");
        e.setName("e");

        Recipe[] recipeArray = new Recipe[5];
        recipeArray[0] = a;
        recipeArray[1] = b;
        recipeArray[2] = c;
        recipeArray[3] = d;
        recipeArray[4] = e;

        when(mockedCoffeeMaker.getRecipes()).thenReturn(recipeArray);

        assertEquals(5, mockedCoffeeMaker.getRecipes().length);  // confirm array's length is 5
        assertEquals(a, mockedCoffeeMaker.getRecipes()[0]);              // confirm the recipes are in the returned array
        assertEquals(b, mockedCoffeeMaker.getRecipes()[1]);
        assertEquals(c, mockedCoffeeMaker.getRecipes()[2]);
        assertEquals(d, mockedCoffeeMaker.getRecipes()[3]);
        assertEquals(e, mockedCoffeeMaker.getRecipes()[4]);

    }
}