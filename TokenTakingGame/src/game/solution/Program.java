// Created by Dayu Wang (dwang@stchas.edu) on 2021-04-14

// Last updated by Dayu Wang (dwang@stchas.edu) on 2021-06-11


package game.solution;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        // Open the input and output files.
        FileInputStream inputFile = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(inputFile);
        FileOutputStream outputFile = new FileOutputStream("output.txt");
        PrintWriter writer = new PrintWriter(outputFile);

        // Parse (read) the games stored in the input file one-by-one.
        while (scanner.hasNextInt()) {
            int target = scanner.nextInt(), turns = scanner.nextInt();
            Game game = new Game(target, turns);
            game.play(27);
            game.printResult(writer);
        }

        // Close the files.
        writer.close();
        outputFile.close();
        scanner.close();
        inputFile.close();
    }
}