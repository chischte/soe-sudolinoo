package main.java.ch.fileloader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class SudokuLoader {
    private int[][] puzzle = new int[9][9];

    public int[][] getPuzzle(String jsonName) {
        try {
            this.puzzle = parseJson(jsonName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return puzzle;
    }

    public static int[][] parseJson(String jsonName) throws Exception {

        String puzzlePath = "src/main/java/ch/fileloader/";
        String puzzleName = jsonName;

        // Parse json file
        Object obj = new JSONParser().parse(new FileReader(puzzlePath + puzzleName));

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


