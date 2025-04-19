package components.gamelibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test cases for GameLibraryOnArray.
 */
public class GameLibraryOnArrayTest {

    /**
     * Junit test for createNewRep.
     */
    @Test
    public void testCreateNewRep() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g1 = new Game("FirstGame", 123, true);
        gl.add(g1, 100);
        assertEquals(1, gl.size());
        assertTrue(gl.hasGame(g1));
        gl.createNewRep();
        assertEquals(0, gl.size());
        assertFalse(gl.hasGame(g1));
    }

    /**
     * Junit test for add.
     */
    @Test
    public void testAddGame() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g = new Game("TestGame", 2018, false);
        gl.add(g, 25);
        assertTrue(g.hasGame(g));
        assertEquals(1, gl.size());
        assertEquals(25, gl.playtime(g));
    }

    /**
     * Junit test for removeAny.
     */
    @Test
    public void testRemoveAnyGame() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g = new Game("AnotherTest", 9999, true);
        gl.add(g, 40);
        Game removed = gl.removeAny();
        assertEquals(g, removed);
        assertEquals(0, gl.size());
        assertFalse(gl.hasGame(g));
    }

    /**
     * Junit test for remove
     */
    @Test
    public void testRemoveSpecificGames() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g1 = new Game("AnotherGame", 2016, true);
        Game g2 = new Game("EvenMoreGames", 2011, true);
        gl.add(g1, 100);
        gl.add(g2, 200);
        gl.remove(g1);
        assertEquals(1, gl.size());
        assertFalse(gl.hasGame(g1));
        assertTrue(gl.hasGame(g2));
    }

    /**
     * Junit test for playtime.
     */
    @Test
    public void testPlaytimeMultipleGames() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g1 = new Game("TestTestTest", 2019, false);
        Game g2 = new Game("AddAnotherGame", 2020, true);
        gl.add(g1, 60);
        gl.add(g2, 300);
        assertEquals(60, gl.playtime(g1));
        assertEquals(300, gl.playtime(g2));
    }

    /**
     * Another Junit test for playtime.
     */
    @Test
    public void testPlaytimeSingleGame() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g1 = new Game("SingleGame", 2019, false);
        gl.add(g1, 60);
        assertEquals(60, gl.playtime(g1));
    }

    /**
     * Junit test for hasGame returning false.
     */
    @Test
    public void testHasGameFalse() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g = new Game("GameNotInLibrary", 2018, false);
        assertFalse(gl.hasGame(g));
    }

    /**
     * Junit test for hasGame returning true.
     */
    @Test
    public void testHasGameTrue() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g = new Game("GameInLibrary", 2018, false);
        gl.add(g, 25);
        assertTrue(gl.hasGame(g));
    }

    /**
     * Junit test for clear.
     */
    @Test
    public void testClear() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g1 = new Game("GameOne", 2016, true);
        Game g2 = new Game("GameTwo", 2016, false);
        gl.add(g1, 50);
        gl.add(g2, 10);
        gl.clear();
        assertEquals(0, gl.size());
    }

    /**
     * Junit tests for transferFrom.
     */
    @Test
    public void testTransferFrom() {
        GameLibraryOnArray gl1 = new GameLibraryOnArray();
        GameLibraryOnArray gl2 = new GameLibraryOnArray();
        Game g1 = new Game("MoreTestGames", 2011, true);
        Game g2 = new Game("AnotherGame", 2012, false);
        gl1.add(g1, 12);
        gl1.add(g2, 5);
        gl2.transferFrom(gl1);
        assertEquals(2, gl2.size());
        assertTrue(gl2.hasGame(g1));
        assertTrue(gl2.hasGame(g2));
        assertEquals(0, gl1.size());
    }

    /**
     * Junit test for newInstance.
     */
    @Test
    public void testNewInstance() {
        GameLibraryOnArray gl = new GameLibraryOnArray();
        Game g = new Game("LastGame", 2019, false);
        gl.add(g, 50);
        GameLibrary gl2 = gl.newInstance();
        assertEquals(0, gl2.size());
        assertFalse(gl2.hasGame(g));
        assertEquals(1, gl.size());
        assertTrue(gl.hasGame(g));
    }

}
