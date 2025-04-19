package components.gamelibrary;

/**
 * Demo use case for GameLibrary. This demo is to show that GameLibrary can act
 * as its own standalone tool, acting literally as a game library.
 */
public final class GameLibraryDemo {

    /**
     * Private constructor to stop VSCode from yelling at me.
     */
    private GameLibraryDemo() {
    }

    /**
     * Demo of GameLibrary.
     *
     * @param args
     */
    public static void main(String[] args) {
        GameLibrary gl = new GameLibraryOnArray();

        Game g1 = new Game("Outer Wilds", 2019, false);
        Game g2 = new Game("Escape From Tarkov", 2025, true);

        gl.add(g1, 15);
        gl.add(g2, 25);

        System.out.println("Game count: " + gl.size());
        System.out.println("Game with 15 hours: " + gl.hasTime(15));
        System.out.println("Random game: " + gl.selectAny());

        gl.updateTime(g2, 30);
        System.out.println(
                "Updated time for Escape From Tarkov: " + gl.playtime(g2));
    }

}
