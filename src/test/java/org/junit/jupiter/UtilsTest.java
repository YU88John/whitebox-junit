package org.junit.jupiter;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UtilsTest {

    @Test
    public void testPrintCoordinates() {
        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method that prints coordinates
        Utils.printCoordinates(3.14, -2.5, 0.0);

        // Reset System.out
        System.setOut(System.out);

        // Check the printed output
        assertEquals("(3.14,-2.50,0.00)\n", outputStream.toString());
    }


    @Test
    public void testReadChar() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("b\n".getBytes()));
        assertEquals('b', Utils.readChar("abc", scanner));

        scanner = new Scanner(new ByteArrayInputStream("a\n".getBytes()));
        assertEquals('a', Utils.readChar("abc", scanner));
    }


    @Test
    public void testGuessingGame() {
        // Test Case 4
        assertEquals("Correct!", Utils.guessingGame(42, 42));

        // Test Case 5
        assertEquals("Correct!", Utils.guessingGame(10, 10));
    }

    @Test
    public void testSumFile() {
        // Test Case 6
        // This will fail as the testing expects 7.5 and we are asserting the value of 0.01 instead
        double sumFromFile = Utils.sumFile("numbers.txt");
        System.out.println("Actual sum from file: " + sumFromFile);
        assertEquals(Double.valueOf(7.5), Double.valueOf(sumFromFile), 0.01);

        // Test Case 7
        double sumFromNonexistentFile = Utils.sumFile("nonexistent.txt");
        System.out.println("Actual sum from nonexistent file: " + sumFromNonexistentFile);
        assertEquals(Double.valueOf(-1.0), Double.valueOf(sumFromNonexistentFile), 0.01);
    }


    @Test
    public void testSaveData() {
        // Test Case 8
        assertTrue(Utils.saveData("player.txt", "John", 80, 120));

        // Test Case 9
        assertFalse(Utils.saveData("nonexistent_folder/player.txt", "Alice", 50, 80));

        // Test Case 10
        assertTrue(Utils.saveData("dead_player.txt", "Bob", 0, 40));

        // Test Case 11
        assertTrue(Utils.saveData("winner.txt", "Eve", 70, 120));

        // Test Case 12
        assertTrue(Utils.saveData("alive_player.txt", "Charlie", 60, 90));
    }

    // This test is to be updated. Contain some bugs.
    /* @Test
    public void testInvalidInput() {
        // Simulate a scenario where the input is invalid
        // For example, if readChar is not supposed to accept digits
        char result = Utils.readChar("abc123");

        // Assume that the result is valid. If not, skip the test step.
        Assumptions.assumeTrue(Utils.isValidChar(result));

        // Assert that the result is a default or expected value (e.g., 'a')
        assertEquals('a', result);
    } */
}

