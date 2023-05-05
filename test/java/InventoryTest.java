import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    Inventory test;

    @Before
    public void crateNewDefaultInventory() throws Exception {
        test = new Inventory();
    }

    @Test
    public void testConstructorInventory() {
        assertEquals(15,test.getCoffee());
        assertEquals(15,test.getMilk());
        assertEquals(15,test.getSugar());
        assertEquals(15,test.getChocolate());
    }

    @Test
    public void getChocolateAfterDefaultConstructorShouldBe15() {
        assertEquals(15, test.getChocolate());
    }

    @Test
    public void setChocolateTo27() {
        test.setChocolate(27);
        assertEquals(27, test.getChocolate());
    }

    @Test
    public void trySetChocolateWithNegativeAmount() {
        test.setChocolate(-3);
        assertEquals(15, test.getChocolate());  // If input < 0 amount does not change
    }

    @Test
    public void addChocolateToDefaultShouldBe15PlusAmtAdded() throws InventoryException {
        test.addChocolate("100");
        assertEquals(115, test.getChocolate());
    }

    @Test
    public void addChocolateWithLettersThrowsError() throws InventoryException {
        assertThrows(InventoryException.class, () -> {test.addChocolate("hello");});
    }

    @Test (expected = InventoryException.class)
    public void addChocolateWithNegativeThrowsError() throws InventoryException {
        test.addChocolate("-100");
    }

    @Test
    public void getCoffeeAfterDefaultConstructorShouldBe15() {
        assertEquals(15, test.getCoffee());
    }

    @Test
    public void setCoffeeTo97() {
        test.setCoffee(97);
        assertEquals(97, test.getCoffee());
    }

    @Test
    public void trySetCoffeeWithNegativeAmount() {
        test.setCoffee(-97);
        assertEquals(15, test.getCoffee());  // If input < 0 amount does not change
    }

    @Test
    public void addCoffeeToDefaultShouldBe15PlusAmtAdded() throws InventoryException {
        test.addCoffee("100");
        assertEquals(115, test.getCoffee());
    }

    @Test
    public void addCoffeeWithLettersThrowsError() throws InventoryException {
        assertThrows(InventoryException.class, () -> {test.addCoffee("hello");});
    }

    @Test (expected = InventoryException.class)
    public void addCoffeeWithNegativeThrowsError() throws InventoryException {
        test.addCoffee("-100");
    }

    @Test
    public void getMilkAfterDefaultConstructorShouldBe15() {
        assertEquals(15, test.getMilk());
    }

    @Test
    public void setMilkTo37() {
        test.setMilk(37);
        assertEquals(37, test.getMilk());
    }

    @Test
    public void trySetMilkWithNegativeAmount() {
        test.setMilk(-7);
        assertEquals(15, test.getMilk());   // If input < 0 amount does not change
    }

    @Test
    public void addMilkToDefaultShouldBe15PlusAmtAdded() throws InventoryException {
        test.addMilk("100");
        assertEquals(115, test.getMilk());
    }

    @Test
    public void addMilkWithLettersThrowsError() throws InventoryException {
        assertThrows(InventoryException.class, () -> {test.addMilk("hello");});
    }

    @Test (expected = InventoryException.class)
    public void addMilkWithNegativeThrowsError() throws InventoryException {
        test.addMilk("-100");
    }

    @Test
    public void getSugarAfterDefaultConstructorShouldBe15() {
        assertEquals(15, test.getSugar());
    }

    @Test
    public void setSugarTo18() {
        test.setSugar(18);
        assertEquals(18, test.getSugar());
    }

    @Test
    public void trySetSugarWithNegativeAmount() {
        test.setSugar(-18);
        assertEquals(15, test.getSugar());   // If input < 0 amount does not change
    }

    @Test
    public void addSugarToDefaultShouldBe15PlusAmtAdded() throws InventoryException {
        test.addSugar("100");
        assertEquals(115, test.getSugar());
    }

    @Test
    public void addSugarWithLettersThrowsError() throws InventoryException {
        assertThrows(InventoryException.class, () -> {test.addSugar("hello");});
    }

    @Test (expected = InventoryException.class)
    public void addSugarWithNegativeThrowsError() throws InventoryException {
        test.addSugar("-100");
    }

    @Test
    public void enoughIngredientsWithDefaultInventoryAndDefaultRecipeShouldBeTrue() {
        Recipe toCompare = new Recipe();  // Create default recipe, where all values are 0
        // we know we have 15 of each in inventory and 0 is required, so it should return true
        assertEquals(true, test.enoughIngredients(toCompare));
    }

    @Test
    public void enoughIngredientsWithDefaultInventoryAndCustomRecipeShouldBeFalse() throws RecipeException {
        Recipe toCompare = new Recipe();  // Create default recipe, where all values are 0
        // set required amounts to 20
        toCompare.setAmtCoffee("20");
        toCompare.setAmtMilk("20");
        toCompare.setAmtSugar("20");
        toCompare.setAmtChocolate("20");
        // since the required amount is 20, and we only have 15, it should return false
        assertEquals(false, test.enoughIngredients(toCompare));
    }

    @Test
    public void useIngredientsSuccessfully() throws RecipeException {
        Recipe recipe = new Recipe();   // create default recipe
        // set amount needed of all ingredients for recipe to 5
        recipe.setAmtCoffee("5");
        recipe.setAmtMilk("5");
        recipe.setAmtSugar("5");
        recipe.setAmtChocolate("5");
        // return true since ingredients should have been successfully used
        assertEquals(true, test.useIngredients(recipe));
        // make sure amount of inventory is reduced by amount used (we had 15 and used 5, so it should be 10)
        assertEquals(10, test.getCoffee());
        assertEquals(10, test.getMilk());
        assertEquals(10, test.getSugar());
        assertEquals(10, test.getChocolate());
    }

    @Test
    public void useIngredientsUnsuccessfully() throws RecipeException {
        Recipe recipe = new Recipe();   // create default recipe
        // set amount needed of all ingredients for recipe to 20
        recipe.setAmtCoffee("20");
        recipe.setAmtMilk("20");
        recipe.setAmtSugar("20");
        recipe.setAmtChocolate("20");
        // return false since we don't have enough ingredients. We need 20 and we have 15
        assertEquals(false, test.useIngredients(recipe));
        // since no ingredients were used, we should still have the same original amount of 15
        assertEquals(15, test.getCoffee());
        assertEquals(15, test.getMilk());
        assertEquals(15, test.getSugar());
        assertEquals(15, test.getChocolate());
    }

    @Test
    public void testToStringWithDefaultConstructor() {
        assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", test.toString());
    }
}