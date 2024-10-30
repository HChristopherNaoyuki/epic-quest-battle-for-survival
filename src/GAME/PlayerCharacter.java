package GAME;

// Class representing the player character, inheriting from GameCharacter
public class PlayerCharacter extends GameCharacter
{
    int potionCount;  // Number of health potions available

    // Constructor to initialize a player
    public PlayerCharacter(String name, int health, int attackPower, int potionCount)
    {
        super(name, health, attackPower);
        this.potionCount = potionCount;
    }

    // Method to use a potion to restore health
    public void usePotion()
    {
        if (potionCount > 0)
        {
            health += 30;  // Restore health by 30 points
            potionCount--;  // Decrease potion count
            System.out.println(name + " uses a potion and restores 30 health!");
        }
        else
        {
            System.out.println(name + " has no potions left!");
        }
    }
}
