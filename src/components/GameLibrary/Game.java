package components.GameLibrary;

public class Game {

    private String title;
    private int playtime;

    public Game(String title, int playtime) {
        this.title = title;
        this.playtime = playtime;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPlayTime() {
        return this.playtime;
    }

    @Override
    public String toString() {
        return "Game{title = " + this.title + " playtime = " + this.playtime
                + " }";
    }

}
