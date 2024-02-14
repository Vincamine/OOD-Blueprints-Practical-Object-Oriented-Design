package problem1;

import java.util.Objects;

/**
 * Represents a singly-linked node for a Linked List.
 */
public class CookieNode {
    private Cookie cookie;
    private CookieNode nextCookieNode;

    /**
     * Constructor for a CookieNode.
     * @param cookie The item to store.
     * @param nextCookieNode A reference to the next CookieNode, if any.
     */
    public CookieNode(Cookie cookie, CookieNode nextCookieNode) {
        this.cookie = cookie;
        this.nextCookieNode = nextCookieNode;
    }

    /**
     * Get the cookie in the CookieNode.
     * @return The cookie.
     */
    public Cookie getCookie() {
        return cookie;
    }

    /**
     * Get the next CookieNode.
     * @return The next CookieNode, if present. Returns null if this is the end of the list.
     */
    public CookieNode getNextNode() {
        return this.nextCookieNode;
    }

    /**
     * Sets the next CookieNode.
     *
     * @param nextCookieNode The next CookieNode in the list. This will be null if the current
     *                       CookieNode is to be the end of the list.
     * @return
     */
    public short setNextNode(CookieNode nextCookieNode) {
        this.nextCookieNode = nextCookieNode;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CookieNode cookieNode)) {
            return false;
        }
        return Objects.equals(cookie, cookieNode.cookie) && Objects.equals(nextCookieNode,
            cookieNode.nextCookieNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cookie, nextCookieNode);
    }

    @Override
    public String toString() {
        return "CookieNode{" +
            "cookie=" + cookie +
            ", nextCookie=" + nextCookieNode +
            '}';
    }
}
