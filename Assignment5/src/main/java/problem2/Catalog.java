package problem2;

import java.util.ArrayList;
import java.util.Objects;

public class Catalog {
    protected ArrayList<ArtItem> catalogArtItems;

    public Catalog() {
        this.catalogArtItems = new ArrayList<ArtItem>();
    }

    //unnecessary to return this.
    public void addItem(ArtItem artItem){
        this.catalogArtItems.add(artItem);
    }

    /**
     * This should retrieve all items in the catalog, regardless of type, that have a title
     * containing the keyword. For example, if search is passed the keyword “a”, all items with a
     * title that contains “a” should be in the returned collection. The search should be case
     * insensitive. This means that, following on from the previous example, searching for “a” would
     * @return items that have either “a” or “A” anywhere in the title.
     */
    public ArrayList<ArtItem> search(String keyword) {
        ArrayList<ArtItem> matchedList = new ArrayList<>();
        for(ArtItem artItem : catalogArtItems){
            if(artItem.searchKeyword(keyword)){
                matchedList.add(artItem);
            }
        }
        return matchedList;
    }

    /**
     * This should retrieve all items in the catalog that have an exact match for the given author.
     * As only Books have authors, it is expected that the collection returned will not contain any Music.
     */

    public ArrayList<ArtItem> search(Author author) {
        ArrayList<ArtItem> matchedListBook = new ArrayList<>();
        //for each
        for(ArtItem artItem : catalogArtItems ){
            //is the object belongs to Author???
            if(artItem.creator instanceof Author){
                if(artItem.creator.firstName.equals(author.firstName) && artItem.creator.lastName.equals(author.lastName)) {
                    matchedListBook.add(artItem);
                }
            }
        }
        return matchedListBook;
    }

    /**
     * It retrieves all items in the catalog that have an exact match for the given artist. As only
     * Music items have RecordingArtists, it is expected that the collection returned will not
     * contain any Books. The artist may be the sole creator of the Music or one member of a Band.
     */
    public ArrayList<ArtItem> search(RecordingArtist artist) {
        ArrayList<ArtItem> matchedListMusic = new ArrayList<>();
        for(ArtItem artItem : catalogArtItems){
            if(artItem.creator instanceof Band){
                for(RecordingArtist member : ((Band)artItem.creator).bandMember){
                    if(member.firstName.equals(artist.firstName) && member.lastName.equals(artist.lastName)){
                        matchedListMusic.add(artItem);
                    }
                }
            } else if (artItem.creator instanceof RecordingArtist) {
                if(artItem.creator.firstName.equals(artist.firstName) && artItem.creator.lastName.equals(artist.lastName)){
                    matchedListMusic.add(artItem);
                }
            }
        }
        return matchedListMusic;
    }

    public ArrayList<ArtItem> getCatalogArtItems() {
        return catalogArtItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Catalog catalog)) {
            return false;
        }
        return Objects.equals(catalogArtItems, catalog.catalogArtItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogArtItems);
    }

    @Override
    public String
    toString() {
        return "Catalog{" +
            "catalogArtItems=" + catalogArtItems +
            '}';
    }
}
