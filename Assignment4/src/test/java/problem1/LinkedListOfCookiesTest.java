package problem1;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListOfCookiesTest {
    private LinkedListOfCookies originalList;
    private Cookie cookie1, cookie2, cookie3, cookie4, cookieForTestFindGlutenFreeSugarLiteCookies, cookieForTestFindNutsAndDairyCookies, cookieCompare;
    private Object CookieNotFoundException;

    @BeforeEach
    void setUp() {
        cookie1 = new Cookie("Original",null,null, null,null,null,null,null,null,null,null);
        cookie2 = new Cookie("Milk",null,null, null,null,null,null,null,null,null,null);
        cookie3 = new Cookie("Raisin Mix",null,null, null,null,null,null,null,null,null,null);
        cookie4 = new Cookie("Chocolate",null,null, null,null,null,null,null,null,null,null);
        cookieForTestFindGlutenFreeSugarLiteCookies = new Cookie("Raisin Mix",null,null, null,10.0,null,null,null,null,null,true);
        cookieForTestFindNutsAndDairyCookies = new Cookie("Raisin Mix",null,null, null,null,null,null,null,true,true,null);
        cookieCompare = new Cookie("Original",null,null, null,90.0,null,null,null,false,false,false);

        originalList = new LinkedListOfCookies(null,0);
    }

    @Test
    void testIsEmpty() {

        assertTrue(originalList.isEmpty());
    }


    @Test
    void testCloneCookieList(){
        LinkedListOfCookies newList = (LinkedListOfCookies) originalList.addCookie(cookie1);

        LinkedListOfCookies clonedList = newList.cloneCookieList();

        assertEquals(newList, clonedList);
        assertNotSame(newList, clonedList, "Cloned list should be a different instance.");
        assertEquals(newList.size(), clonedList.size(), "Cloned list should have the same size as the original.");

    }

    @Test
    void testCountCookies() {
        int countCookiesNum = 0;
        assertEquals((int) originalList.countCookies(), countCookiesNum);

        CookieCatalogImmu modifiedList = originalList.addCookie(cookie1);
        int countCookiesNumAdd = 1;
        assertEquals((int) modifiedList.countCookies(), countCookiesNumAdd);
    }

    @Test
    void testCheckCookie() {
        LinkedListOfCookies newList = (LinkedListOfCookies) originalList.addCookie(cookie1);
        assertFalse(newList.isEmpty());
        assertTrue(newList.checkCookie(cookie1.getName()));
        assertFalse(newList.checkCookie(cookie2.getName()));
    }

    @Test
    void testAddCookie() {
        LinkedListOfCookies beforeList = new LinkedListOfCookies(null,0);
        CookieCatalogImmu modifiedList = beforeList.addCookie(cookie4);
        assertTrue(beforeList.isEmpty());
        assertNotSame(beforeList, modifiedList);
        assertTrue(modifiedList.checkCookie("Chocolate"));
        int countCookiesNumAdd = 1;
        assertEquals(countCookiesNumAdd, modifiedList.countCookies());
    }

    @Test
    void testRemoveCookie() throws CookieNotFoundException {
        originalList = (LinkedListOfCookies) originalList.addCookie(cookie1);
        originalList = (LinkedListOfCookies) originalList.addCookie(cookie2);
        originalList = (LinkedListOfCookies) originalList.addCookie(cookie3);
        assertTrue(originalList.checkCookie(cookie3.getName()));

        LinkedListOfCookies ListAfterRemove = (LinkedListOfCookies) originalList.removeCookie("Milk");
        assertFalse(ListAfterRemove.checkCookie("Milk"));
        assertThrowsExactly(CookieNotFoundException.class, () -> ListAfterRemove.removeCookie("Milk"));
    }

    @Test
    void testFindGlutenFreeSugarLiteCookies() {
        LinkedListOfCookies beforeList = new LinkedListOfCookies(null,0);
        beforeList = (LinkedListOfCookies) beforeList.addCookie(cookieForTestFindGlutenFreeSugarLiteCookies);
        beforeList = (LinkedListOfCookies) beforeList.addCookie(cookieCompare);
        LinkedListOfCookies GlutenFreeList = (LinkedListOfCookies) beforeList.findGlutenFreeSugarLiteCookies();

        assertTrue(beforeList.checkCookie("Original"));
        assertTrue(beforeList.checkCookie("Raisin Mix"));
        assertTrue(GlutenFreeList.checkCookie("Raisin Mix"));
        int size = 1;
        assertEquals(size, (int) GlutenFreeList.countCookies());
    }

    @Test
    void testFindNutsAndDairyCookies() {
        LinkedListOfCookies beforeList = new LinkedListOfCookies(null,0);
        beforeList = (LinkedListOfCookies) beforeList.addCookie(cookieForTestFindNutsAndDairyCookies);
        beforeList = (LinkedListOfCookies) beforeList.addCookie(cookieCompare);
        LinkedListOfCookies nutsAndDiaryList = (LinkedListOfCookies) beforeList.findNutsAndDairyCookies();

        assertTrue(beforeList.checkCookie("Raisin Mix"));
        int size = 1;
        assertEquals(size, (int) nutsAndDiaryList.countCookies());

    }

    @Test
    public void size() {
        LinkedListOfCookies beforeList = new LinkedListOfCookies(null,0);
        CookieCatalogImmu modifiedList1 = beforeList.addCookie(cookieForTestFindGlutenFreeSugarLiteCookies);
        int size = 1;
        assertEquals((int) modifiedList1.size(), size);
    }
}