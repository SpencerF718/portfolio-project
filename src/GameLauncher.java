
/**
 * Demo to demonstrate that GameLibrary could be used as part of a game
 * launcher. A client could add onto this, assigning a game library for a
 * storefront or user profile.
 *
 */
public class GameLauncher {

    private GameLibrary library;

    public GameLauncher() {
        this.library = new GameLibraryOnArray;
    }

    /**
     * Method to log a game into a launcher. If the game already exists, its
     * playtime is just updated.
     *
     * @param title
     *            title of game
     * @param releaseYear
     *            release year of the game
     * @param isMultiplayer
     *            if the game is multiplayer or not
     * @param hours
     *            the number of hours played
     */
    public void logGame(String title, int releaseYear, boolean isMultiplayer,
            int hours) {
        Game g = new Game(title, releaseYear, isMultiplayer);
        if (!this.library.hasGame(g)) {
            this.library.add(g, hours);
        } else {
            this.library.updateTime(g, hours);
        }
    }

    /**
     * Indicates how many games have been logged already.
     *
     * @return the number of games logged
     */
    public int totalGames() {
        return this.library.size();
    }

    /**
     * Sample main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        GameLauncher launcher = new GameLauncher();
        launcher.logGame("Outer Wilds", 2017, false, 12);
        launcher.logGame("Escape From Tarkov", 2025, true, 88);

        System.out.println("Games logged: " + launcher.totalGames());
    }

}
