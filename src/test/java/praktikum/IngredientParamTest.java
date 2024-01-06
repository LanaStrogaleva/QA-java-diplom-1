package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    @Parameterized.Parameter
    public String type;

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.valueOf(type), "IngridientName", 5);
        IngredientType actual = ingredient.getType();
        IngredientType expected = ingredient.type;
        assertEquals("Неверный тип ингридиента",expected,actual);
    }


}
