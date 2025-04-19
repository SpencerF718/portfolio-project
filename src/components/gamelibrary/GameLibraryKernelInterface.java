package components.gamelibrary;

import components.standard.Standard;

/**
 * GameLibrary Kernel component with primary methods.
 */
public interface GameLibraryKernelInterface
        extends Standard<GameLibraryOnArray> {

    /**
     * Adds a given game with its corresponding playtime to the library.
     *
     * @param game
     *            the custome Game object that is added
     * @param playtime
     *            the playtime of the game
     * @requires playtime >= 0
     * @updates this
     * @ensures #this = this - {game, playtime}
     */
    void add(Game game, int playtime);

    /**
     * Removes and returns a game from the library.
     *
     * @return the Game object that was removed
     * @requires this.size() > 0
     * @updates this
     * @ensures this != #this
     */
    Game removeAny();

    /**
     * Removes a specified game from the library.
     *
     * @param game
     *            the Game that will be removed
     * @requires this.hasGame(game) = true
     * @updates this
     * @ensures this = #this * game
     */
    void remove(Game game);

    /**
     * Indicates the total playtime of a given game.
     *
     * @param game
     *            the Game that will have its playtime retrieved
     * @return the total playtime of the given Game
     * @requires this.hasGame(game) = true
     * @ensures playtime is a playtime in the library
     */
    int playtime(Game game);

    /**
     * Indicates if the given game is already in the library or not.
     *
     * @param game
     *            the Game that is compared to the library of games
     * @return true if the given game is in the library
     * @ensures there is a game in the library equivalent to Game game
     */
    boolean hasGame(Game game);

    /**
     * Indicates the number of games in the library.
     *
     * @return the total number of games in the library
     * @ensures size = |this|
     */
    int size();

    /**
     * Clears the game library, removing everything.
     *
     * @updates this
     * @ensures this.size() = 0
     *
     */
    void clear();

    /**
     * Creates and returns a new empty game library.
     *
     * @return a new GameLibraryOnArray instance with no games.
     * @ensures returned objects is of the same type and empty.
     */
    GameLibraryOnArray newInstance();

    /**
     * * Transfers the contents from the source library into this library, and
     * clears the source library in the process.
     *
     * @param source
     *            the GameLibraryOnArray whose contents will be moved
     * @replaces this
     * @clears source
     * @requires source is of type GameLibraryOnArray
     * @ensures this = #source and source.size() = 0
     */
    void transferFrom(GameLibraryOnArray source);

}
