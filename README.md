# Epic Quest: Battle for Survival

## Description

**Epic Quest: Battle for Survival** is a turn-based RPG game developed in Java where players battle through multiple levels against increasingly powerful enemies. Players can attack, use potions, and level up, enhancing their skills to survive the challenges ahead. Join the adventure today!

## Features

- Engaging turn-based combat system
- Multiple enemy types with varying strengths
- Leveling system to enhance player abilities
- Potion usage for health restoration
- Unit tests to ensure functionality and reliability

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE (such as IntelliJ IDEA, Eclipse, or any Java-compatible editor)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HChristopherNaoyuki/epic-quest-battle-for-survival.git
   ```

2. Navigate to the project directory:
   ```bash
   cd EpicQuest-BattleForSurvival
   ```

3. Compile and run the game:
   ```bash
   javac Game.java GameCharacter.java GameEnemy.java PlayerCharacter.java GameTest.java
   java Game
   ```

### Running Tests

To run the unit tests, ensure you have JUnit 4 in your classpath. Use the following command:
```bash
javac -cp .:junit-4.x.x.jar GameTest.java
java -cp .:junit-4.x.x.jar org.junit.runner.JUnitCore GameTest
```

## Contributing

Contributions are welcome! If you have suggestions or improvements, feel free to fork the repository and submit a pull request.
