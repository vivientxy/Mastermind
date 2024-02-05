## Mastermind Game

Welcome to the Mastermind game.
You will be playing against the computer.

There are 3 levels of difficulties to choose from: EASY, MEDIUM, HARD.
- EASY has 8 rounds, and 4 possible color combinations (represented by alphabets A B C D)
- MEDIUM has 10 rounds, and 6 possible color combinations (represented by alphabets A B C D E F)
- HARD has 12 rounds, and 8 possible color combinations (represented by alphabets A B C D E F G H)

## Rules

You'll start off the game by choosing a difficulty level.

The answer will be 4 random colors chosen from the possible color pool as decided by your difficulty level. The colors will be in random order.

You will then be prompted to enter a guess. Only inputs of 4 alphabets contained in the possible color pool will be accepted.

After each answer, feedback will be given based on the matches of your guess against the correct answer.
- GREEN means correct color in correct position
- RED means correct color in wrong position
- BLACK means wrong color
The sequence of GREEN/RED/BLACK does not matter, only the count matters.

You have to make the correct guess within the specified number of rounds, else you lose the game.

## Java Version

This project runs on Java 21.
