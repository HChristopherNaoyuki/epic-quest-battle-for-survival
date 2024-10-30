package GAME;

import java.util.Random;

// Base class representing a character in the game
public class GameCharacter
{
    String name;           // Character's name
    int health;           // Character's health points
    int attackPower;      // Character's attack power

    // Constructor to initialize a character
    public GameCharacter(String name, int health, int attackPower)
    {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Check if the character is still alive
    public boolean isAlive()
    {
        return this.health > 0;
    }

    // Method to apply damage to the character
    public void takeDamage(int damage)
    {
        this.health -= damage;
        if (this.health < 0)
        {
            this.health = 0;
        }
    }

    // Attack another character
    public void attack(GameCharacter enemy)
    {
        Random rand = new Random();
        int damage = rand.nextInt(attackPower);
        System.out.println(name + " attacks " + enemy.name + " for " + damage + " damage!");
        enemy.takeDamage(damage);
    }
}
