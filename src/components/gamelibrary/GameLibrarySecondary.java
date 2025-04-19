package components.gamelibrary;

/**
 * Implements all 3 secondary methods as well as toString and equals.
 */
public abstract class GameLibrarySecondary
        implements GameLibrarySecondaryInterface {

    @Override
    public Game selectAny() {
        Game selectedGame = this.removeAny();
        this.add(selectedGame, this.playtime(selectedGame));
        return selectedGame;
    }

    @Override
    public void updateTime(Game game, int playtime) {
        this.remove(game);
        this.add(game, playtime);
    }

    @Override
    public Game hasTime(int playtime) {
        Game foundGame = null;
        for (int i = 0; i < this.size(); i++) {
            Game currGame = this.removeAny();
            if (this.playtime(currGame) == playtime) {
                foundGame = currGame;
            }
            this.add(currGame, this.playtime(currGame));
        }
        return foundGame;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GameLibrarySecondaryInterface)) {
            return false;
        }

        GameLibrarySecondaryInterface gl2 = (GameLibrarySecondaryInterface) obj;
        if (this.size() != gl2.size()) {
            return false;
        }

        boolean isEqual = true;
        for (int i = 0; i < this.size(); i++) {
            Game currGame = this.removeAny();
            if (!gl2.hasGame(currGame)
                    || gl2.playtime(currGame) != this.playtime(currGame)) {
                isEqual = false;
            }
            this.add(currGame, this.playtime(currGame));
        }

        return isEqual;
    }

}
