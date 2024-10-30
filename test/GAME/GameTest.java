package GAME;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// Unit tests for the game functionality
public class GameTest
{
    @Before
    public void setUp()
    {
        // Initialize the game object before each test
        Game game = new Game();
    }

    @Test
    public void testCreateEnemiesForLevel()
    {
        // Test enemy creation for level 1
        GameEnemy[] enemies = Game.createEnemiesForLevel(1);
        assertEquals("Expected 3 enemies for level 1", 3, enemies.length);
        assertEquals("Expected Goblin as the first enemy", "Goblin", enemies[0].name);
        assertEquals("Goblin's health should be 50", 50, enemies[0].health);  // 40 + 1*10
        assertEquals("Goblin's attack power should be 20", 20, enemies[0].attackPower); // 15 + 1*5

        // Test enemy creation for level 2
        enemies = Game.createEnemiesForLevel(2);
        assertEquals("Expected 3 enemies for level 2", 3, enemies.length);
        assertEquals("Expected Goblin as the first enemy", "Goblin", enemies[0].name);
        assertEquals("Goblin's health should be 60", 60, enemies[0].health); // 40 + 2*10
        assertEquals("Goblin's attack power should be 25", 25, enemies[0].attackPower); // 15 + 2*5
    }
}
