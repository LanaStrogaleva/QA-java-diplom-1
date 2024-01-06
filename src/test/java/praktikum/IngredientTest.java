package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameter
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {IngredientType.SAUCE, "Сырный соус", 5F},
                {IngredientType.FILLING, "Курица", 10.5F}
        };
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        String expected = ingredient.name;
        assertEquals("Неверное имя ингридиента",expected,actual);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        float expected = ingredient.price;
        assertEquals("Неверная цена ингридиента",expected,actual, 0.0001);
    }
}
