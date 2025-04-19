package components.gamelibrary;

/**
 * Implements all 3 secondary methods as well as toString(in Game.java) and
 * equals.
 */
public abstract class GameLibrarySecondary
        implements GameLibrarySecondaryInterface {

    @Override
    public final Game selectAny() {
        Game selectedGame = this.removeAny();
        this.add(selectedGame, this.playtime(selectedGame));
        return selectedGame;
    }

    @Override
    public final void updateTime(Game game, int playtime) {
        this.remove(game);
        this.add(game, playtime);
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof GameLibraryOnArray)) {
            return false;
        }

        GameLibraryOnArray other = (GameLibraryOnArray) obj;

        if (this.size() != other.size()) {
            return false;
        }

        boolean isEqual = true;
        int n = this.size();

        for (int i = 0; i < n; i++) {
            Game g1 = this.removeAny();
            int pt1 = this.playtime(g1);

            boolean foundMatch = false;
            for (int j = 0; j < other.size(); j++) {
                Game g2 = other.removeAny();
                int pt2 = other.playtime(g2);
                other.add(g2, pt2);

                if (g1 == g2 && pt1 == pt2) {
                    foundMatch = true;
                }
            }

            this.add(g1, pt1);

            if (!foundMatch) {
                isEqual = false;
            }
        }

        return isEqual;
    }
}
