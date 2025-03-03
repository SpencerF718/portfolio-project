package components.GameLibrary;

public abstract class GameLibraryKernel {

    // there will be an upper bound of 1000 items in the library.
    private static final int MAX_SIZE = 1000;
    private final Game[] gameArr;
    private final int[] playtimeArr;
    private int librarySize;

    // create the game and playtime arrays.
    public GameLibraryKernel() {
        this.gameArr = new Game[MAX_SIZE];
        this.playtimeArr = new int[MAX_SIZE];
        this.librarySize = 0;
    }

    public void add(Game game, int playtime) {
        // check to see if our library is under 1000 games.
        if (this.librarySize < MAX_SIZE) {
            // place the game and playtime in their corresponding places.
            this.gameArr[this.librarySize] = game;
            this.playtimeArr[this.librarySize] = playtime;
            this.librarySize++;
        } else {
            //let user know that their library is too large.
            throw new IllegalStateException("Game library is full");
        }
    }

    public Game removeAny() {
        // check to see if library is not empty
        if (this.librarySize != 0) {
            // removes the first game in library
            Game removedGame = this.gameArr[0];
            // shift array to avoid blank spots.
            for (int i = 1; i < this.librarySize; i++) {
                this.gameArr[i - 1] = this.gameArr[i];
                this.playtimeArr[i - 1] = this.playtimeArr[i];
            }
            // decrement size
            this.librarySize--;
            // return the removed game
            return removedGame;
        } else {
            // throw error if library is empty.
            throw new IllegalStateException("Game library is empty");
        }
    }

    /*
     * get and return library size and game array.
     */
    public int size() {
        return this.librarySize;
    }

    protected Game[] getGames() {
        return this.gameArr;
    }

}
