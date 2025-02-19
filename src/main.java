
import components.GameLibrary.Game;
import components.GameLibrary.GameLibrarySecondary;

public class main {
    public static void main(String[] args) {

        // create a library
        GameLibrarySecondary library = new GameLibrarySecondary();

        // create a few different games.
        Game escapeFromTarkov = new Game("Escape From Tarkov", 2016, true);
        Game minecraft = new Game("Minecraft", 2009, true);
        Game eldenRing = new Game("Elden Ring", 2022, true);

        // add games do the library.
        library.add(escapeFromTarkov, 500);
        library.add(minecraft, 500);
        library.add(eldenRing, 500);

        // output size
        System.out.println(library.size());

        // output game from selectAny().
        Game selectedGame = library.selectAny();
        System.out.println(selectedGame);

        // output game from removeAny().
        Game removedGame = library.removeAny();
        System.out.println(removedGame);

        // output the size after removing a game.
        System.out.println(library.size());

    }

}
