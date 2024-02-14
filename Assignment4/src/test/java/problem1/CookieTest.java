package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CookieTest {
    private Cookie cookie1;
    private String[] ingredients = {"flour","oil"};

    @BeforeEach
    void setUp() {
        cookie1 = new Cookie("Original",ingredients,0.01,2.0,2.0,2.0, 2.0,2.0,true,true,false);
    }

    @Test
    void getName() {
        assertEquals("Original", cookie1.getName());
    }

    @Test
    void getIngredients() {
        assertEquals(cookie1.getIngredients(), ingredients);

    }

    @Test
    void getQuantityPerServing() {
        assertEquals(cookie1.getQuantityPerServing(),0.01);
    }

    @Test
    void getCaloriesPerServing() {
        assertEquals(cookie1.getCaloriesPerServing(),2.0);
    }

    @Test
    void getSugarPerServing() {
        assertEquals(cookie1.getSugarPerServing(),2.0);
    }

    @Test
    void getFatPerServing() {
        assertEquals(cookie1.getFatPerServing(),2.0);
    }

    @Test
    void getProteinPerServing() {
        assertEquals(cookie1.getProteinPerServing(),2.0);
    }

    @Test
    void getFiberPerServing() {
        assertEquals(cookie1.getFiberPerServing(),2.0);
    }

    @Test
    void getContainsNuts() {
        assertTrue(cookie1.getContainsNuts());
    }

    @Test
    void getContainsDairy() {
        assertTrue(cookie1.getContainsDairy());
    }

    @Test
    void getGlutenFree() {
        assertEquals(cookie1.getGlutenFree(),false);
    }
}