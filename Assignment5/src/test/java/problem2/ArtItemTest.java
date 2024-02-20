package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtItemTest {

    private ArtItem artItem;
    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author("Wyllie", "F");
        artItem = new ArtItem("Mocking Jay", 2030, author);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Mocking Jay", artItem.getTitle());
        assertEquals(Integer.valueOf(2030), artItem.getYear());
        assertEquals(author, artItem.getCreator());
    }

    @Test
    void testSearchKeyword() {
        assertTrue(artItem.searchKeyword("jay"));
        assertFalse(artItem.searchKeyword("starry"));
    }

    @Test
    void testEquals() {
        ArtItem anotherArtItem = new ArtItem("Mocking Jay", 2030, author);
        assertEquals(artItem, anotherArtItem);

        ArtItem differentArtItem = new ArtItem("Starry Night", 1889, author);
        assertNotEquals(artItem, differentArtItem);
    }

}
