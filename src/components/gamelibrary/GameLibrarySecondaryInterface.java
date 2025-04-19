package components.gamelibrary;

/**
 * GameLibrary component with secondary methods.
 */
public interface GameLibrarySecondaryInterface
        extends GameLibraryKernelInterface {

    /**
     * Selects a game from the library.
     *
     * @return a Game from the library
     * @requires this.size() > 0
     * @ensures Game selectAny is in the library
     */
    Game selectAny();

    /**
     * Updates a games playtime from the library.
     *
     * @param game
     *            the Game that will have its playtime updated
     * @param playtime
     *            the new playtime value
     * @requires this.hasGame(game) and time != 0
     * @updates this
     * @ensures #(Game game, int playtime) = (Game game, int #playtime)
     *
     */
    void updateTime(Game game, int playtime);

    /**
     * Checks and returns if there is a game in the library with the given
     * playtime
     *
     * @param playtime
     *            the playtime that will be checked in the library
     * @return a game with a matching playtime value
     * @ensures playtime is in the library if returning a Game value
     */
    Game hasTime(int playtime);

}
