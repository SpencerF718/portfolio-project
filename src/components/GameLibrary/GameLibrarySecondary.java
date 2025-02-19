package components.GameLibrary;

public class GameLibrarySecondary extends GameLibraryKernel {

    /*
     * select the first game in the library. I may adjust this method in the
     * future considering it is very similar to removeAny() in practice.
     */
    public Game selectAny() {
        return this.getGames()[0];
    }

}
