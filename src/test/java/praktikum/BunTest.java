package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun =new Bun("bunWithCream", 3);

    @Test
    public void getNameTest(){
        String expected = "bunWithCream";
        assertEquals("Имя не соответствует", expected,bun.getName());
    }

    @Test
    public void getPriceTest(){
        float expected = 3;
        assertEquals("Цена не соответствует", expected,bun.getPrice(), 0.0001);
    }


}
