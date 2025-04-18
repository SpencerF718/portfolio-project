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
public class GameLibraryOnArray extends GameLibrarySecondary {

    /**
     * The maximum number of games that the library can hold.
     */
    public static final int MAX_SIZE = 1000;
    /**
     * Array to store Games in the library.
     */
    private final Game[] gameArr;
    /**
     * Array to store the playtimes in the library.
     */
    private final int[] playtimeArr;
    /**
     * The current size of the library.
     */
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

    @Override
    public void add(Game game, int playtime) {
        assert this.librarySize < MAX_SIZE : "Game library is already full";
        assert !this.hasGame(game) : "Game already exists";

        this.gameArr[this.librarySize] = game;
        this.playtimeArr[this.librarySize] = playtime;
        this.librarySize++;
    }

    @Override
    public Game removeAny() {
        assert this.librarySize > 0 : "Library is empty";
        Game removedGame = this.gameArr[0];

        for (int i = 1; i < this.librarySize; i++) {
            this.gameArr[i - 1] = this.gameArr[i];
            this.playtimeArr[i - 1] = this.playtimeArr[i];
        }

        this.librarySize--;
        return removedGame;
    }

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

        assert isFound : "Game not in Library";
        this.librarySize--;
    }

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

    @Override
    public int size() {
        return this.librarySize;
    }

    @Override
    public void clear() {
        this.librarySize = 0;
    }

    @Override
    public GameLibrary newInstance() {
        return new GameLibraryOnArray();
    }

    @Override
    public void transferFrom(GameLibrary source) {
        assert source instanceof GameLibraryOnArray : "Source must be equivalent to GameLibraryOnArray";

        GameLibraryOnArray gl2 = (GameLibraryOnArray) source;
        this.librarySize = gl2.librarySize;

        for (int i = 0; i < this.librarySize; i++) {
            this.gameArr[i] = gl2.gameArr[i];
            this.playtimeArr[i] = gl2.playtimeArr[i];
        }
        gl2.createNewRep();
    }
}
