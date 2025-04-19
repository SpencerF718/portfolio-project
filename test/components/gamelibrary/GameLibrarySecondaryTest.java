package components.gamelibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test cases for GameLibrarySecondary.
 */
public class GameLibrarySecondaryTest {

    /**
     * Junit test for selectAny().
     */
    @Test
    public void testSelectAny() {
        GameLibrary gl = new GameLibraryOnArray();
        Game g = new Game("TestGame", 2018, false);
        gl.add(g, 25);
        Game selected = gl.selectAny();
        assertTrue(gl.hasGame(selected));
        assertEquals(g, selected);
        assertEquals(1, gl.size());
    }

    /**
     * Junit test for updateTime.
     */
    @Test
    public void testUpdateTime() {
        GameLibrary gl = new GameLibraryOnArray();
        Game g = new Game("TestGame", 2019, true);
        gl.add(g, 20);
        gl.updateTime(g, 45);
        assertEquals(45, gl.playtime(g));
        assertEquals(1, gl.size());
    }

    /**
     * Junit test for hasTime with a game.
     */
    @Test
    public void testHasTimeWithGame() {
        GameLibrary gl = new GameLibraryOnArray();
        Game g1 = new Game("TestGame1", 2019, false);
        Game g2 = new Game("TestGame2", 2016, false);
        gl.add(g1, 10);
        gl.add(g2, 25);
        Game result = gl.hasTime(25);
        assertEquals(g2, result);
    }

    /**
     * Junit test for hasTime with a corresponding game.
     */
    @Test
    public void testHasTimeWithoutGame() {
        GameLibrary gl = new GameLibraryOnArray();
        gl.add(new Game("TestGame", 2015, true), 30);
        Game result = gl.hasTime(999);
        assertNull(result);
    }

    /**
     * Junit test for equals resulting in true.
     */
    @Test
    public void testEqualsTrue() {
        GameLibrary gl1 = new GameLibraryOnArray();
        GameLibrary gl2 = new GameLibraryOnArray();
        Game g = new Game("TestGame", 2012, false);
        gl1.add(g, 5);
        gl2.add(g, 5);
        assertTrue(gl1.equals(gl2));
    }

    /**
     * Junit test for equals resulting in false.
     */
    @Test
    public void testEqualsFalse() {
        GameLibrary gl1 = new GameLibraryOnArray();
        GameLibrary gl2 = new GameLibraryOnArray();
        Game g1 = new Game("TestGame1", 2007, true);
        Game g2 = new Game("TestGame2", 2011, true);
        gl1.add(g1, 10);
        gl2.add(g2, 10);
        assertFalse(gl1.equals(gl2));
    }

    /**
     * Junit test for toString.
     */
    @Test
    public void testToString() {
        GameLibrary gl = new GameLibraryOnArray();
        Game g1 = new Game("TestGame1", 2010, false);
        Game g2 = new Game("TestGame2", 2016, false);
        gl.add(g1, 5);
        gl.add(g2, 7);
        String output = gl.toString();
        assertTrue(output.contains("TestGame1"));
        assertTrue(output.contains("TestGame2"));
        assertTrue(output.contains("5"));
        assertTrue(output.contains("7"));
    }

}
