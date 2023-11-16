package org.junit.jupiter;// Java production code for ISE worksheet 8.

import java.io.*;
import java.util.*;

public class Utils
{
    public static void main(String[] args) {
        // Example usage of Utils methods
        Utils.printCoordinates(1.0, 2.0, 3.0);

        char validChar = Utils.readChar("abc");
        System.out.println("Valid char: " + validChar);

        String result = Utils.guessingGame(5, 5);
        System.out.println(result);

        double sum = Utils.sumFile("numbers.txt");
        System.out.println("Sum from file: " + sum);

        boolean saveSuccess = Utils.saveData("player.txt", "John", 80, 120);
        System.out.println("Save success: " + saveSuccess);
    }
    public static void printCoordinates(double x, double y, double z)
    {
        System.out.printf("(%.2f,%.2f,%.2f)\n", x, y, z);
    }

    public static char readChar(String validChars, Scanner scanner) {
        String line = scanner.nextLine();
        while (line.length() != 1 || !validChars.contains(line)) {
            line = scanner.nextLine();
        }
        return line.charAt(0);
    }

    public static char readChar(String validChars) {
        Scanner scanner = new Scanner(System.in);
        char result = readChar(validChars, scanner);

        // If the result is invalid, return a default value (e.g., 'a')
        if (!validChars.contains(String.valueOf(result))) {
            result = 'a';
        }

        return result;
    }

    public static boolean isValidChar(char ch) {
        // Define your logic to determine if the character is valid
        return Character.isLetter(ch);
    }

    public static String guessingGame(int guess, int number) {
        if (guess == number) {
            return "Correct!";
        } else if (guess > number) {
            return "Too high.";
        } else {
            return "Too low.";
        }
    }

    public static double sumFile(String filename)
    {
        double sum = 0.0;
        try
        {
            Scanner sc = new Scanner(new File(filename)); // <-- Throws IOException
            while(sc.hasNextDouble())
            {
                sum += sc.nextDouble();
            }
        }
        catch(IOException e)
        {
            sum = -1.0;
        }
        return sum;
    }

    public static boolean saveData(String filename, String name, int health, int score)
    {
        boolean success = true;
        try(PrintWriter writer = new PrintWriter(filename)) // <-- Throws IOException
        {
            writer.println("name: " + name);
            writer.println("health: " + health);
            writer.println("score: " + score);
            if(health <= 0.0)
            {
                writer.println("status: dead");
            }
            else
            {
                if(score >= 100)
                {
                    writer.println("status: won");
                }
                else
                {
                    writer.println("status: alive");
                }
            }
        }
        catch(IOException e)
        {
            success = false;
        }
        return success;
    }
}