package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;


class CookieNodeTest {
    private CookieNode node1, node2, node3;
    private Cookie cookie1, cookie2, cookie3;
    private String[] ingredients = {"flour","oil"};


    @BeforeEach
    void setUp() {
        cookie1 = new Cookie("Chocolate",ingredients,2.2,0.9, 0.9, 0.9, 0.9, 0.9, false,false,false);
        cookie2 = new Cookie("Peanut",ingredients,2.2,0.9, 0.9, 0.9, 0.9, 0.9, true,false,false);
        cookie3 = new Cookie("Milk",ingredients,2.2,0.9, 0.9, 0.9, 0.9, 0.9, true,true,false);
        node1 = new CookieNode(cookie1, null);
        node2 = new CookieNode(cookie2, null);
        node3 = new CookieNode(cookie3,null);
    }

    @Test
    void testGetCookie() {
        assertEquals(node1.getCookie(), cookie1);
    }

    @Test
    void getNextNode() {
        node1.setNextNode(node2);
        assertEquals(node1.getNextNode(), node2);
    }

    @Test
    void setNextNode() {
        node2.setNextNode(node3);
        assertTrue(node2.getNextNode().equals(node3));
    }
}