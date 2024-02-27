package problem4;

public interface VideoGamesCatalogSupport {
    public Integer countNumberOfVideoGames();
    public VideoGamesCatalogSupport addVideoGames(VideoGame videoGame);
    public VideoGamesCatalogSupport findNeededVideoGames();

}
