package problem2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;


public class CatalogTest {
    private Catalog catalog;
    private ArtItem book, musicSingle, musicBand;
    private Author author;
    private RecordingArtist artistSingle, artistBand;
    private Band band;
    @BeforeEach
    public void setUp() {
        catalog = new Catalog();
        author = new Author("John", "Doe");
        artistSingle = new RecordingArtist("Jane", "Smith");
        artistBand = new RecordingArtist("Judy","Smith");
        band = new Band("The Band");
        band.bandMember = new ArrayList<RecordingArtist>();
        band.addBandMember("The Band",artistBand);

        book = new ArtItem("Test Title", 2000, author);
        musicSingle = new ArtItem("Single Title", 2010, artistSingle);
        musicBand = new ArtItem("Band Title", 2020, band);

        catalog.addItem(book);
        catalog.addItem(musicSingle);
        catalog.addItem(musicBand);
    }

    @Test
    public void testAddItem() {
        assertEquals(3, catalog.getCatalogArtItems().size());
    }

    @Test
    public void testSearchByKeyword() {
        ArrayList<ArtItem> matchedList = catalog.search("Test");
        assertTrue(matchedList.contains(book));
        assertEquals(1, matchedList.size());
        assertFalse(matchedList.contains(musicSingle));
        assertFalse(catalog.search("Test").contains(musicBand));
        assertEquals(1, catalog.search("single").size());
        assertEquals(0, catalog.search("Nonexistent").size());
    }

    @Test
    public void testSearchByAuthor() {
        ArrayList<ArtItem> result = catalog.search(author);
        assertEquals(1, result.size());
        assertTrue(result.contains(book));
    }

    @Test
    public void testSearchByRecordingArtist() {
        ArrayList<ArtItem> resultSingle = catalog.search(artistSingle);
        assertEquals(1, resultSingle.size());
        assertTrue(resultSingle.contains(musicSingle));

        ArrayList<ArtItem> resultBand = catalog.search(artistBand);
        assertEquals(1, resultBand.size());
        assertTrue(resultBand.contains(musicBand));
    }

    @Test
    public void testEquals() {
        Catalog anotherCatalog = new Catalog();
        anotherCatalog.addItem(book);
        anotherCatalog.addItem(musicSingle);
        anotherCatalog.addItem(musicBand);

        assertEquals(catalog, anotherCatalog);
        assertEquals(anotherCatalog, catalog);
        assertNotEquals(null, catalog);
        assertNotEquals(catalog, new Object());
    }

    @Test
    public void testHashCode() {
        Catalog anotherCatalog = new Catalog();
        anotherCatalog.addItem(book);
        anotherCatalog.addItem(musicSingle);
        anotherCatalog.addItem(musicBand);

        assertEquals(catalog.hashCode(), anotherCatalog.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Catalog{catalogArtItems=" + catalog.getCatalogArtItems() + "}";
        assertEquals(expected, catalog.toString());
    }
}
