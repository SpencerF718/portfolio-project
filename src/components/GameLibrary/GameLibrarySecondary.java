package components.GameLibrary;

/**
 * Implements all 3 secondary methods as well as toString and equals.
 */
public abstract class GameLibrarySecondary implements GameLibrary {

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
    public String toString() {
        return "title: " + this.title + ", releaseYear: " + this.releaseYear
                + ", isMultiplayer:" + this.isMultiplayer;
    }

    @Override
    public boolean equals(GameLibrary gl2) {
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
