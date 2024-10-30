package GAME;

import java.util.InputMismatchException;
import java.util.Scanner;

// Main class to manage the game flow
public class Game
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize player with starting stats
        PlayerCharacter player = new PlayerCharacter("Hero", 100, 30, 3);
        int maxLevels = 3;  // Total number of game levels
        int currentLevel = 1;

        // Game loop for levels
        while (player.isAlive() && currentLevel <= maxLevels)
        {
            System.out.println("\n--- Level " + currentLevel + " ---");

            // Create enemies for the current level
            GameEnemy[] enemies = createEnemiesForLevel(currentLevel);
            int enemyIndex = 0;

            // Battle loop for each enemy
            while (player.isAlive() && enemyIndex < enemies.length)
            {
                GameEnemy currentEnemy = enemies[enemyIndex];
                System.out.println("\nA wild " + currentEnemy.name + " appears!");

                // Combat loop between player and enemy
                while (player.isAlive() && currentEnemy.isAlive())
                {
                    System.out.println("\nPlayer's health: " + player.health);
                    System.out.println("Enemy's health: " + currentEnemy.health);
                    System.out.println("1. Attack");
                    System.out.println("2. Use Potion");
                    System.out.print("Choose your action: ");

                    int choice = 0;
                    boolean validInput = false;

                    // Error handling for user input
                    while (!validInput)
                    {
                        try
                        {
                            choice = scanner.nextInt();
                            if (choice == 1 || choice == 2)
                            {
                                validInput = true;  // Valid input
                            }
                            else
                            {
                                System.out.println("Invalid choice. Enter 1 to Attack or 2 to Use Potion.");
                            }
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Invalid input. Please enter a number (1 for Attack or 2 for Potion).");
                            scanner.next();  // Clear invalid input
                        }
                    }

                    // Handle player's action
                    switch (choice)
                    {
                        case 1:
                            player.attack(currentEnemy);
                            if (currentEnemy.isAlive())
                            {
                                currentEnemy.attack(player);  // Enemy retaliates if still alive
                            }
                            else
                            {
                                System.out.println(currentEnemy.name + " has been defeated!");
                                enemyIndex++;
                            }
                            break;

                        case 2:
                            player.usePotion();
                            if (currentEnemy.isAlive())
                            {
                                currentEnemy.attack(player);  // Enemy retaliates if still alive
                            }
                            break;

                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }
            }

            // Level up if all enemies are defeated
            if (player.isAlive())
            {
                System.out.println("\nYou've cleared Level " + currentLevel + "!");
                levelUp(player);
                currentLevel++;
            }
        }

        // End game messages
        if (player.isAlive())
        {
            System.out.println("\nCongratulations! You've defeated all levels!");
        }
        else
        {
            System.out.println("\nGame Over! The enemies defeated you.");
        }

        scanner.close();
    }

    // Method to create enemies for a specific level
    public static GameEnemy[] createEnemiesForLevel(int level)
    {
        return new GameEnemy[]
        {
            new GameEnemy("Goblin", 40 + level * 10, 15 + level * 5),
            new GameEnemy("Orc", 60 + level * 15, 20 + level * 5),
            new GameEnemy("Dragon", 120 + level * 20, 35 + level * 10)
        };
    }

    // Method to level up the player
    private static void levelUp(PlayerCharacter player)
    {
        player.health += 30;  // Increase health on level up
        player.attackPower += 10;  // Increase attack power on level up
        System.out.println("\nLevel Up! Your health and attack power have increased!");
        System.out.println("New Health: " + player.health + ", New Attack Power: " + player.attackPower);
    }
}
