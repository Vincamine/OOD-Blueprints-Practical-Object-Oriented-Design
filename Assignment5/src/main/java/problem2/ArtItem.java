package problem2;

import java.util.Objects;

public class ArtItem {
    protected String title;
    protected Integer year;
    protected Creator creator;

    public ArtItem(String title, Integer year, Creator creator) {
        this.title = title;
        this.year = year;
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Creator getCreator() {
        return creator;
    }


    public Boolean searchKeyword(String keyword){
        String changedTitle = this.title.toLowerCase();
        String changedKeyword = keyword.toLowerCase();
        return changedTitle.contains(changedKeyword);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ArtItem artItem)) {
            return false;
        }
        return Objects.equals(title, artItem.title) && Objects.equals(year,
            artItem.year) && Objects.equals(creator, artItem.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, creator);
    }

    @Override
    public String toString() {
        return "ArtItem{" +
            "title='" + title + '\'' +
            ", year=" + year +
            ", creator=" + creator +
            '}';
    }
}
