package problem1;

//
public interface CookieCatalogImmu {
    /***
     * Checks if the CookieCatalog is empty.
     */
    Boolean isEmpty();

    /***
     * counts the number of Cookiess in the CookieCatalog
     */
    Integer countCookies();

    /***
     * checks if a Cookie with the requested name exists in the CookieCatalog.
     * @param cookieName
     */
    Boolean checkCookie(String cookieName);


    /***
     * adds a Cookie to the CookieCatalog.
     * note: CookieCatalog does not allow duplicate Cookies
     * @param cookie
     */
    CookieCatalogImmu addCookie(Cookie cookie);

    /***
     * removes a specified Cookie from the CookieCatalog.
     * If the Cookie does not exist in the CookieCatalog, the system should
     *   throw CookieNotFoundException, which you will have to implement yourself.
     * @param cookieName
     * */
    CookieCatalogImmu removeCookie(String cookieName) throws CookieNotFoundException;

    /***
     * finds and return all Cookies from the CookieCatalog
     *     that are gluten-free, and whose amount of sugar per serving is less than 30 grams.
     */
    CookieCatalogImmu findGlutenFreeSugarLiteCookies();

    /***
     * finds and return all Cookies from the CookieCatalog that contain both nuts and dairy.
     */
    CookieCatalogImmu findNutsAndDairyCookies();

    Integer size();


}
