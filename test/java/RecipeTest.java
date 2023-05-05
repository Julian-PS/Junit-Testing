import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {

    Recipe test;

    @Before
    public void createNewDefaultRecipe() throws Exception {
        test = new Recipe();
    }

    @Test
    public void testConstructorRecipe() {
        assertEquals("", test.getName());
        assertEquals(0, test.getPrice());
        assertEquals(0, test.getAmtCoffee());
        assertEquals(0, test.getAmtMilk());
        assertEquals(0, test.getAmtSugar());
        assertEquals(0, test.getAmtChocolate());
    }

    @Test
    public void getAmtChocolateAfterDefaultConstructorShouldBe0() {
        assertEquals(0, test.getAmtChocolate());
    }

    @Test
    public void setAmtChocolateTo100() throws RecipeException {
        test.setAmtChocolate("100");
        assertEquals(100, test.getAmtChocolate());
    }

    @Test
    public void setAmtChocolateWithLettersThrowsError() throws RecipeException {     // using asserThrows
        assertThrows(RecipeException.class, () -> {test.setAmtChocolate("hello");});
    }

    @Test (expected = RecipeException.class)
    public void setAmtChocolateWithNegativeThrowsError() throws RecipeException {     // using (expected = )
        test.setAmtChocolate("-20");
    }

    @Test
    public void getAmtCoffeeAfterDefaultConstructorShouldBe0() {
        assertEquals(0, test.getAmtCoffee());
    }

    @Test
    public void setAmtCoffeeTo100() throws RecipeException {
        test.setAmtCoffee("100");
        assertEquals(100, test.getAmtCoffee());
    }

    @Test
    public void setAmtCoffeeWithLettersThrowsError() throws RecipeException {     // using asserThrows
        assertThrows(RecipeException.class, () -> {test.setAmtCoffee("hello");});
    }

    @Test (expected = RecipeException.class)
    public void setAmtCoffeeWithNegativeThrowsError() throws RecipeException {     // using (expected = )
        test.setAmtCoffee("-20");
    }

    @Test
    public void getAmtMilkAfterDefaultConstructorShouldBe0() {
        assertEquals(0, test.getAmtMilk());
    }

    @Test
    public void setAmtMilkTo100() throws RecipeException {
        test.setAmtMilk("100");
        assertEquals(100, test.getAmtMilk());
    }

    @Test
    public void setAmtMilkWithLettersThrowsError() throws RecipeException {     // using asserThrows
        assertThrows(RecipeException.class, () -> {test.setAmtMilk("hello");});
    }

    @Test (expected = RecipeException.class)
    public void setAmtMilkWithNegativeThrowsError() throws RecipeException {     // using (expected = )
        test.setAmtMilk("-20");
    }

    @Test
    public void getAmtSugarAfterDefaultConstructorShouldBe0() {
        assertEquals(0, test.getAmtSugar());
    }

    @Test
    public void setAmtSugarTo100() throws RecipeException {
        test.setAmtSugar("100");
        assertEquals(100, test.getAmtSugar());
    }

    @Test
    public void setAmtSugarWithLettersThrowsError() throws RecipeException {     // using asserThrows
        assertThrows(RecipeException.class, () -> {test.setAmtSugar("hello");});
    }

    @Test (expected = RecipeException.class)
    public void setAmtSugarWithNegativeThrowsError() throws RecipeException {     // using (expected = )
        test.setAmtSugar("-20");
    }

    @Test
    public void getNameAfterDefaultConstructor() {
        assertEquals("", test.getName());
    }

    @Test
    public void setNameToBen() {
        test.setName("Ben");
        assertEquals("Ben", test.getName());
    }

    @Test
    public void nameShouldNotChangeWithNullParam() {
        test.setName("Ben");
        test.setName(null);
        assertEquals("Ben", test.getName());
    }

    @Test
    public void getPriceAfterDefaultConstructorShouldBe0() {
        assertEquals(0, test.getPrice());
    }

    @Test
    public void setPriceTo100() throws RecipeException {
        test.setPrice("100");
        assertEquals(100, test.getPrice());
    }

    @Test
    public void setPriceWithLettersThrowsError() throws RecipeException {     // using asserThrows
        assertThrows(RecipeException.class, () -> {test.setPrice("hello");});
    }

    @Test (expected = RecipeException.class)
    public void setPriceWithNegativeThrowsError() throws RecipeException {     // using (expected = )
        test.setPrice("-20");
    }

    @Test
    public void testToStringWithDefaultRecipe() {
        assertEquals("", test.toString());
    }

    @Test
    public void testToStringWithNameBen() {
        test.setName("Ben");
        assertEquals("Ben", test.toString());
    }

    @Test
    public void testHashCodeDefaultConstructorEquals31() {
        assertEquals(31, test.hashCode());
    }

    @Test
    public void testHashCodeNameHiEquals3360() {
        test.setName("hi");
        assertEquals(3360, test.hashCode());  // hashCode for String "hi" is 3329, add 31 to get answer
    }

    @Test
    public void testEqualsTrueFor2EqualNameRecipes() {
        Recipe toCompare = new Recipe();
        assertTrue(test.equals(toCompare));
    }

    @Test
    public void testEqualsFalseFor2NonEqualNameRecipes() {
        Recipe toCompare = new Recipe();
        toCompare.setName("Ben");
        assertFalse(test.equals(toCompare));
    }

    @Test
    public void testEqualsTrueForSameObject() {
        assertTrue(test.equals(test));
    }

    @Test
    public void testEqualsFalseForNullObjectParam() {
        Recipe toCompare = new Recipe();
        toCompare = null;
        assertFalse(test.equals(toCompare));
    }

    @Test
    public void testEqualsFalseForDifferentObjectClass() {
        Inventory toCompare = new Inventory();
        assertFalse(test.equals(toCompare));
    }

}