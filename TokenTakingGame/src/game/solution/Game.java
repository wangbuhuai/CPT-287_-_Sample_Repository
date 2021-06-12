// Created by Dayu Wang (dwang@stchas.edu) on 2021-04-14

// Last updated by Dayu Wang (dwang@stchas.edu) on 2021-06-11


package game.solution;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Game {
    // Data fields
    private final int target;  // The number of tokens has to be reached to win the game
    private int turns;  // The maximum number of turns allowed
    private ArrayList<Character> path;  // The sequence to reach {target} within {turns}

    // Constructor
    public Game(int target, int turns) {
        this.target = target;
        this.turns = turns;
        path = new ArrayList<>();
    }

    // Method

    /** Plays the game to reach {target} with {turns}.
        @param tokens: the current number of tokens
        @return: {true} if a valid sequence is found; {false} otherwise
    */
    public boolean play(int tokens) {
        // Base cases
        if (tokens == target) { return true; }
        if (turns == 0) { return false; }
        
        // Try asking 39 more tokens.
        path.add('A');
        turns--;
        if (play(tokens + 39)) { return true; }
        path.remove(path.size() - 1);
        turns++;

        // Try giving back half of the tokens.
        path.add('B');
        turns--;
        if (tokens % 2 == 0 && play(tokens / 2)) { return true; }
        path.remove(path.size() - 1);
        turns++;

        return false;
    }

    /** Writes the game result to an output file.
        @param writer: a PrintWriter linked to an open output file
    */
    public void printResult(PrintWriter writer) {
        if (path.isEmpty()) { writer.print("Dead End"); }
        else {
            for (char ch : path) { writer.print(ch); }
        }
        writer.println();
    }
}