package components.GameLibrary;

public class Game {

    // title + 2 other pieces of optional meta data
    private String title;
    private int releaseYear;
    private boolean isMultiplayer;

    // default Game configuration.
    public Game(String title, int releaseYear, boolean isMultiplayer) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.isMultiplayer = isMultiplayer;
    }

    // Game with just title.
    public Game(String title) {
        this(title, 0, false);
    }

    // Game with title and releaseYear
    public Game(String title, int releaseYear) {
        this(title, releaseYear, false);
    }

    // Game with title and isMultiplayer
    public Game(String title, boolean isMultiplayer) {
        this(title, 0, isMultiplayer);
    }

    /*
     * get and return all Game variables
     */
    public String getTitle() {
        return this.title;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public boolean isMultiplayer() {
        return this.isMultiplayer;
    }

    /*
     * How game will be represented when it's printed out. releaseYear: 0 means
     * that there is no release year included/stored.
     */
    @Override
    public String toString() {
        return "title: " + this.title + ", releaseYear: " + this.releaseYear
                + ", isMultiplayer:" + this.isMultiplayer;
    }

}
