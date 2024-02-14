package problem1;

import java.util.Objects;

public class LinkedListOfCookies implements CookieCatalogImmu{

    private CookieNode head;
    private int numNodes;

    public LinkedListOfCookies(CookieNode head, int numNodes) {
        this.head = head;
        this.numNodes = numNodes;
    }

    public LinkedListOfCookies cloneCookieList(){
        LinkedListOfCookies newList = new LinkedListOfCookies(null,0);
        CookieNode ptr = this.head;
        while(ptr != null){
            newList =(LinkedListOfCookies) newList.addCookie(ptr.getCookie());
            // NEED CASTING newList1.addCookie(ptr.getCookie());
            ptr = ptr.getNextNode();
        }
        newList.numNodes = this.numNodes;
        return newList;
    }

    @Override
    public Boolean isEmpty() {
        return(this.head == null && this.numNodes == 0);
    }

    @Override
    public Integer countCookies() {
        return (this.numNodes);
    }

    @Override
    public Boolean checkCookie(String cookieName) {
        CookieNode current = this.head;
        while(current != null){
            if(current.getCookie().getName().equals(cookieName)){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    @Override
    public CookieCatalogImmu addCookie(Cookie cookie) {
        LinkedListOfCookies cookieList = this.cloneCookieList();
        if(!cookieList.checkCookie(cookie.getName())) {
            cookieList.head = new CookieNode(cookie, head);
            cookieList.numNodes++;
        }
        return cookieList;
    }


    @Override
    public CookieCatalogImmu removeCookie(String cookieName) throws CookieNotFoundException {
        LinkedListOfCookies cookieList = this.cloneCookieList();

        if(cookieList.checkCookie(cookieName)){
            if(cookieList.head.getCookie().getName().equals(cookieName)){
                cookieList.head = cookieList.head.getNextNode();
            }
            else{
                CookieNode current = cookieList.head.getNextNode();;
                CookieNode prev = cookieList.head;
                while(current != null){
                    if(current.getCookie().getName().equals(cookieName)){
                        prev.setNextNode(current.getNextNode());
                        break;
                    }
                    current = current.getNextNode();
                    prev = prev.getNextNode();
                }
            }
            cookieList.numNodes--;
        }
        else {
            throw new CookieNotFoundException(cookieName);
        }
        return cookieList;
    }

    @Override
    public CookieCatalogImmu findGlutenFreeSugarLiteCookies() {
        LinkedListOfCookies cookieList = new LinkedListOfCookies(null,0);
        CookieNode check = this.head;
        while(check != null){
            if(check.getCookie().getGlutenFree() && check.getCookie().getSugarPerServing() < 30.0){
                cookieList = (LinkedListOfCookies) cookieList.addCookie(check.getCookie());
            }
            check = check.getNextNode();
        }
        return cookieList;
    }

    @Override
    public CookieCatalogImmu findNutsAndDairyCookies() {
        LinkedListOfCookies cookList = new LinkedListOfCookies(null,0);
        CookieNode check = this.head;
        while(check != null){
            if(check.getCookie().getContainsNuts() && check.getCookie().getContainsDairy()){
                //Down casting
                cookList = (LinkedListOfCookies) cookList.addCookie((check.getCookie()));
            }
            check = check.getNextNode();
        }
        return cookList;
    }

    @Override
    public Integer size() {
        return this.numNodes;
    }

    @Override
    public String toString() {
        return "LinkedListOfCookies{" +
            "head=" + head +
            ", numNodes=" + numNodes +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkedListOfCookies cookies)) {
            return false;
        }
        return numNodes == cookies.numNodes && Objects.equals(head, cookies.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, numNodes);
    }

}
