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
     * Compares GameLibrary with another object to see if they are equal.
     *
     * @param obj
     *            the object to compare against
     * @return true if equal, false if not
     */
    @Override
    boolean equals(Object obj);

}
