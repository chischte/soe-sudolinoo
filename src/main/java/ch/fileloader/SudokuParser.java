/**
 * This class is made for parsing strings to array. This array
 * is later used to put on the sudoku grid with all the given
 * numbers from the file.
 *
 * @author Michael Wettstein
 * @version 0.1
 * @since 03.05.2020
 */


package main.java.ch.fileloader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class SudokuParser {

    private int[][] puzzle = new int[9][9];

    public int[][] convertJsonToSudokuarray(File sudokuStringJson) {
        try {
            this.puzzle = parseJson(sudokuStringJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return puzzle;
    }

    public static int[][] parseJson(File sudokuStringJson) throws Exception {

        // Parse json file
        Object obj = new JSONParser().parse(new FileReader(sudokuStringJson));

        // Typecast obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // Get spaghettistring
        String spaghettistring = (String) jo.get("puzzle");

        int[][] puzzle = new int[9][9];

        // Create sudoku array from spaghettistring:
        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle.length; col++) {
                int charNumber = row * puzzle.length + col;
                // Select a char from the string, convert it to a string and parse it as an integer :)
                puzzle[row][col] = Integer.parseInt(String.valueOf(spaghettistring.charAt(charNumber)));
            }
        }

        return puzzle;
    }
}