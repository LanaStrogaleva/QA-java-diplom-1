package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter
    public String ingredientType;

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void checkIngredientTypeTest() {
        String actual = IngredientType.valueOf(ingredientType).toString();
        assertEquals("Такого типа ингридиента не существует",actual, ingredientType);
    }

}


