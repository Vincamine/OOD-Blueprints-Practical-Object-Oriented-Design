package problem1;

public class CookieNotFoundException extends Exception {

    public CookieNotFoundException(String cookieName) {
        super(String.format("Cookie %s Not Found\n", cookieName) );
    }
}
