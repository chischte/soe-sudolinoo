package main.java.ch.fileloader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class SudokuJsonParser {
    public static void main(String[] args) throws Exception {

        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("newspagettistring.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting firstName and lastName
        String spaghettistring = (String) jo.get("spaghettistring");
        System.out.println("here the string:");
        System.out.println(spaghettistring);
        int sudokuLength = 9;
        int[][] puzzle = new int[9][9];

        // Create spaghetti string from sudoku array:
        String sudokuSpaghetti = "";
        System.out.println("here the chars:");
        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle.length; col++) {
                int charNumber = row * puzzle.length + col;
                // Select a char from the string, convert it to a string and parse it as a char :)
                puzzle[row][col] = Integer.parseInt(String.valueOf(spaghettistring.charAt(charNumber)));
                System.out.print(spaghettistring.charAt(charNumber));
            }
        }
        System.out.println("now the array");

        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle.length; col++) {
                System.out.print(puzzle[row][col]);
            }
        }

    }
}
