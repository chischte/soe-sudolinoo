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
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SudokuParser {

    private int[][] puzzle = new int[9][9];

    public int[][] convertJsonToSudokuArray(File sudokuStringJson) {
        try {
            this.puzzle = parseJson(sudokuStringJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return puzzle;
    }

    public int[][] parseJson(File sudokuStringJson) {
        Object object;
        int[][] puzzle = new int[9][9];

        // Parse json file
        try {
            object = new JSONParser().parse(new FileReader(sudokuStringJson));// Typecast obj to JSONObject
            JSONObject jo = (JSONObject) object;

            String sudokuInputStringFromFile = (String) jo.get("puzzle");

            if (sudokuInputStringFromFile.length() == 81) {
                // Create sudoku array from sudokuInputStringFromFile:
                for (int row = 0; row < puzzle.length; row++) {
                    for (int col = 0; col < puzzle.length; col++) {
                        int charNumber = row * puzzle.length + col;
                        // Select a char from the string, convert it to a string and parse it as an integer :)
                        puzzle[row][col] = Integer.parseInt(String.valueOf(sudokuInputStringFromFile.charAt(charNumber)));
                    }
                }
            }

            return puzzle;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return puzzle;
    }
}