package components.GameLibrary;

/**
 * GameLibrary kernel implementation made with 2 arrays.
 *
 * @Convention 0 <= librarySize <= MAX_SIZE
 *
 *             for all i: gameArr[i] != null playtimeArr[i] >= 0 No duplicate
 *             games are allowed in gameArr[i]
 *
 * @Correspondence this = {(gameArr[i], playtimeArr[i])}
 */
public class GameLibraryOnArray extends Standard<Game> {

    public static final int MAX_SIZE = 1000;
    private final Game[] gameArr;
    private final int[] playtimeArr;
    private int librarySize;

    /**
     * Default constructor that makes an empty GameLibrary.
     */
    public GameLibraryOnArray() {
        this.createNewRep();
    }

    /**
     * Initializes everything for the constructor.
     */
    public void createNewRep() {
        this.gameArr = new Game[MAX_SIZE];
        this.playtimeArr = new int[MAX_SIZE];
        this.librarySize = 0;
    }

    /**
     *
     * Adds a new game with its playtime to the library.
     *
     * @param game
     *            the game to add
     * @param playtime
     *            the playtime to add
     */
    @Override
    public void add(Game game, int playtime) {
        if (this.librarySize >= MAX_SIZE) {
            throw new IllegalStateException("Game library is already full.");
        }
        if (this.hasGame(game)) {
            throw new IllegalArgumentException("Game already exists.");
        }

        this.gameArr[this.librarySize] = game;
        this.playtimeArr[this.librarySize] = playtime;
        this.librarySize++;
    }

    /**
     * Removes and returns an arbritrary game from the library.
     *
     * @return the removed game
     */
    @Override
    public Game removeAny() {
        if (this.librarySize == 0) {
            throw new IllegalStateException("Library is empty.");
        }

        Game removedGame = this.gameArr[0];

        for (int i = 1; i < this.librarySize; i++) {
            this.gameArr[i - 1] = this.gameArr[i];
            this.playtimeArr[i - 1] = this.playtimeArr[i];
        }

        this.librarySize--;
        return removedGame;
    }

    /**
     * removes the indicated game from the library.
     *
     * @param game
     *            the game that will be removed
     */
    @Override
    public void remove(Game game) {
        boolean isFound = false;

        for (int i = 0; i < this.librarySize; i++) {
            if (!isFound && this.gameArr[i] == game) {
                isFound = true;
            }
            if (isFound && i < this.librarySize - 1) {
                this.gameArr[i] = this.gameArr[i + 1];
                this.playtimeArr[i] = this.playtimeArr[i + 1];
            }
        }

        if (!isFound) {
            throw new IllegalArgumentException("Game not in Library");
        }
        this.librarySize--;
    }

    /**
     *
     * returns the playtime for a given Game.
     *
     * @param game
     *            the game for which the playtime is associated with
     * @return the playtime of the game
     */
    @Override
    public int playtime(Game game) {
        int pt = 0;
        for (int i = 0; i < this.librarySize; i++) {
            if (this.gameArr[i] == game) {
                pt = this.playtimeArr[i];
            }
        }
        return pt;
    }

    /**
     *
     * Checks if the game is in the library.
     *
     * @param game
     *            the game being checked for
     * @return true if the game is found, false otherwise
     */
    @Override
    public boolean hasGame(Game game) {
        boolean foundGame = false;
        for (int i = 0; i < this.librarySize; i++) {
            if (this.gameArr[i] == game) {
                foundGame = true;
            }
        }
        return foundGame;
    }

    /**
     *
     * returns the size of the current library.
     *
     * @return the size of the library
     */
    @Override
    public int size() {
        return this.librarySize;
    }
}
