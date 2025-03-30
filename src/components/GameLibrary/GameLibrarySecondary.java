package components.GameLibrary;

/**
 * Implements all 3 secondary methods as well as toString and equals.
 */
public abstract class GameLibrarySecondary implements GameLibrary {

    /**
     * Selects an arbitrary game from the library.
     *
     * @return a random game from the library
     * @requires this.size() > 0
     * @ensures the selected game is added back to the library
     *
     */
    public Game selectAny() {
        // grab a game from the library.
        Game selectedGame = this.removeAny();
        // add game back to library.
        this.add(selectedGame, this.playtime(selectedGame));
        // return the selected game.
        return selectedGame;
    }

    /**
     * Updates a game with a new time.
     *
     * @param game
     *            the Game that will have its time updated.
     * @param playtime
     *            the time that will replace the previous time.
     * @updates this
     * @requires this.hasGame(game) and playtime >= 0
     * @ensures game and playtime are in this
     *
     */
    public void updateTime(Game game, int playtime) {

        // remove game
        this.remove(game);
        // add back the game with an updated time.
        this.add(game, playtime);
    }

    /**
     * Checks to see if anygame shares the specified playtime and then returns
     * it if so.
     *
     * @param playtime
     *            time value that will be searched for.
     * @return a game that has that specified playtime or null if none can be
     *         found
     * @ensures the playtime of the found game matches the parameter playtime.
     */
    public Game hasTime(int playtime) {
        // initially set as null in the case where no matching time is found.
        Game foundGame = null;
        // iterate of the library
        for (int i = 0; i < this.size(); i++) {
            // remove games one by one.
            Game currGame = this.removeAny();
            // check if the playtimes match.
            if (this.playtime(currGame) == playtime) {
                foundGame = currGame;
            }
            // add removed game back into the library.
            this.add(currGame, this.playtime(currGame));
        }
        return foundGame;
    }

    /**
     * returns the game library as a string.
     *
     * @return a string representation of the game library.
     */
    public String toString() {
        /*
         * note: this.title, this.releaseYear, and this.isMultiplayer will all
         * be included in the Game implementation. This was already shown in the
         * proof-of-concept.
         */
        return "title: " + this.title + ", releaseYear: " + this.releaseYear
                + ", isMultiplayer:" + this.isMultiplayer;
    }

    /**
     * Checks if 2 libraries are equal.
     *
     * @param gl2
     *            the other game libary that will be compared to.
     * @return true if both libraries are equal. Otherwise returns false.
     */
    public boolean equals(GameLibrary gl2) {

        boolean isEqual = true;

        // iterate over every thing in this.
        for (int i = 0; i < this.size(); i++) {
            // remove one game at a time.
            Game currGame = this.removeAny();
            // check if the current elements in the libraries don't match.
            if (!gl2.hasGame(currGame)
                    || gl2.playtime(currGame) != this.playtime(currGame)) {
                isEqual = false;
            }
            // add the removed game back.
            this.add(currGame, this.playtime(currGame));
        }
        return isEqual;
    }
}
