package components.GameLibrary;

public class GameLibrarySecondary extends GameLibraryKernel {

    // selects the first game in the library
    public Game selectAny() {
        return this.getGames()[0];
    }

}
