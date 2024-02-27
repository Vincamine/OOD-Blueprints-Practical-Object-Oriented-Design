package problem4;

public class VideoGamesCatalog implements VideoGamesCatalogSupport{
    VideoGame firstVideoGame;
    VideoGamesCatalog restVideoGames;
    Integer DOWNLOAD_NUMBER = 5000;

    public VideoGamesCatalog(VideoGame firstVideoGame, VideoGamesCatalog restVideoGames) {
        this.firstVideoGame = firstVideoGame;
        this.restVideoGames = restVideoGames;
    }

    public VideoGamesCatalog(VideoGame firstVideoGame) {
        this.firstVideoGame = firstVideoGame;
        this.restVideoGames = null;
    }

    /**
     *
     * Count the number of VideoGames in the catalog.
     * @return Integer
     */
    @Override
    public Integer countNumberOfVideoGames() {
        if(this.firstVideoGame == null){return 0;}
        if (this.restVideoGames == null) {return 1;}
        return 1 + this.restVideoGames.countNumberOfVideoGames();
    }

    /**
     * Add a VideoGame into the catalog. Please note that
     * the system allows duplicate VideoGames in the catalog.
     *
     * @return VideoGamesCatalogSupport
     */
    @Override
    public VideoGamesCatalogSupport addVideoGames(VideoGame videoGame) {
        if(this.firstVideoGame == null) {
            return new VideoGamesCatalog(videoGame, null);
        }
        return new VideoGamesCatalog(videoGame, this);
    }

    /**
     * helper method to do empty check.
     * @return Boolean
     */
    public Boolean checkEmpty(){
        if(this.firstVideoGame == null || this.restVideoGames == null) {return Boolean.FALSE;}
        return Boolean.TRUE;
    }

    /**
     * Find and return all VideoGames from the VideoGamesCatalog that
     * have more than 50000 downloads,
     *  and whose game rating is set to EVERYONE_10_PLUS.
     * @return VideoGamesCatalogSupport
     */
    @Override
    public VideoGamesCatalogSupport findNeededVideoGames() {
        if(this.checkEmpty()) {return null;}

        if(((this.firstVideoGame.getNumDownloads() - DOWNLOAD_NUMBER) > 0)
            && this.firstVideoGame.getVideoGameRating().equals(VideoGameRating.EVERYONE_10_PLUS)){
            return new VideoGamesCatalog(this.firstVideoGame,
                (VideoGamesCatalog) this.restVideoGames.findNeededVideoGames());
        }
        else {
            return this.restVideoGames.findNeededVideoGames();
        }
    }
}
