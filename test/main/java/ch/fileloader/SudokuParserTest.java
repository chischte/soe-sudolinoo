package main.java.ch.fileloader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SudokuParserTest {
    private SudokuParser sudokuParser;
    private String filePath;
    private String filePathAndName;
    private File jsonFile;
    private int[][] puzzle;

    @BeforeEach
    void initialize(){
        sudokuParser = new SudokuParser();
        filePath = new File("").getAbsolutePath();
        filePathAndName = filePath + "\\out\\production\\Sudolinoo\\sudokustrings\\sudokustring_03_advanced.json";
        jsonFile = new File(filePathAndName);
    }

    @Test
    void shouldConvertJsonToSudokuArray() {
        // when
        int[][] resArray = sudokuParser.convertJsonToSudokuArray(jsonFile);

        // then
        assertEquals(9, resArray.length);

        for(int i = 0; i < 9; i++){
            assertEquals(9, resArray[i].length);
        }
    }

    @Test
    void shouldParseJson() {
        // given
        int[][] tester = new int[9][9];
        // when
        puzzle = sudokuParser.parseJson(jsonFile);
        // then
        assert(puzzle.length == tester.length);
    }
}