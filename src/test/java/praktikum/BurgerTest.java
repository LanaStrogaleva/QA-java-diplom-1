package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    public Bun bun;
    @Mock
    public Ingredient ingredient;
    @Mock
    public Ingredient ingredient2;

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
            burger.setBuns(bun);
        assertFalse(burger.bun ==null);
    }
    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        System.out.println(burger.ingredients.size());
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertTrue(burger.ingredients.indexOf(ingredient2) == 0);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float bunPrice = 5;
        float ingredientPrice = 3;
        float expected = 13;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        assertEquals("Неверная цена бургера", expected, burger.getPrice(), 0.0001);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(bun.getPrice()).thenReturn(5F);
        Mockito.when(ingredient.getName()).thenReturn("ingredientName");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(3F);

        Pattern pattern = Pattern.compile(".*bunName.*\\s*.*sauce\\s*ingredientName.*\\s*.*bunName.*\\s*Price:\\s*13,000000.*");

        assertTrue(pattern.matcher(burger.getReceipt()).find());

    }

}
