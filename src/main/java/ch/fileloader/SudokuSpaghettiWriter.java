// THIS CLASS IS TO CREATE NEW JSON STRINGS OUT OF A SUDOKU (int[][]) ARRAY
// TO GENERATE A NEW STRING PASTE THE NEW ARRAY BELOW, AND LET THE CLASS RUN
// THE NEWLY GENERATED STRING WILL BE STORED AS "newspagettistring.json"


package main.java.ch.fileloader;

import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SudokuSpaghettiWriter {
    public static void main(String[] args) throws FileNotFoundException {


//        // Level Easy
//        int[][] puzzle = {
//                {0, 3, 0, 6, 7, 8, 9, 0, 2},
//                {0, 7, 2, 1, 9, 5, 3, 4, 8},
//                {0, 9, 8, 3, 4, 2, 5, 6, 7},
//                {8, 5, 9, 7, 6, 1, 4, 2, 3},
//                {4, 2, 6, 8, 5, 3, 7, 9, 1},
//                {7, 1, 3, 9, 2, 4, 8, 5, 6},
//                {9, 6, 1, 5, 3, 7, 2, 8, 4},
//                {2, 8, 7, 4, 1, 9, 6, 3, 5},
//                {3, 4, 5, 2, 8, 6, 1, 7, 9}
//        };


//        // Level Medium
//        int puzzle[][] = {
//                {8, 0, 1, 0, 0, 3, 9, 0, 6},
//                {0, 0, 9, 0, 0, 7, 8, 5, 0},
//                {2, 5, 0, 1, 0, 0, 4, 7, 0},
//                {5, 0, 0, 0, 6, 1, 7, 0, 4},
//                {7, 6, 0, 8, 3, 0, 0, 0, 0},
//                {0, 3, 2, 0, 0, 0, 0, 0, 0},
//                {0, 2, 0, 0, 1, 9, 5, 0, 0},
//                {0, 0, 5, 0, 0, 0, 3, 0, 2},
//                {0, 0, 0, 4, 5, 2, 1, 9, 7}
//        };


        // Level Hardcore
        int[][] puzzle = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };


        // Create spaghetti string from sudoku array:
        String sudokuSpaghetti = "";

        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle.length; col++) {
                sudokuSpaghetti += String.valueOf(puzzle[row][col]);
            }
        }

        // Create JSONObject
        JSONObject jsonObject = new JSONObject();

        // Put data to JSONObject
        jsonObject.put("puzzle", sudokuSpaghetti);

        // Write JSON to file:
        PrintWriter printWriter = new PrintWriter("newspagettistring.json");
        printWriter.write(jsonObject.toJSONString());
        printWriter.flush();
        printWriter.close();
    }
}
