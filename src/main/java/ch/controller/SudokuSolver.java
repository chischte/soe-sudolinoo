package main.java.ch.controller;

import main.java.ch.fileloader.Loader;

public class SudokuSolver {

    public int[][] LoaderSudoku;
    public int[][] SolvedSudoku;
    private int GirdsziseSudoku = 9;
    private int row = 0;
    private int col = 0;
    private int puzzle[][] = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 0, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 0, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public int [][] startsolver() {
        // Create Loder
        Loader createtLoader = new Loader();

        // Set the Loader return Value = the Local two dimentional Array
        LoaderSudoku = createtLoader.loadSudokuArray();
        System.out.println("Length is : " + LoaderSudoku.length);

        GirdsziseSudoku = LoaderSudoku.length;

        if (solver()){
            System.out.println("Der return der funktion solve wird gemacht");
        }
        return SolvedSudoku;
    }


    private boolean isFull() {
        System.out.println("Funktion is Full wird ausgeführt");

        boolean s = true;
        for (int x = 0; x < GirdsziseSudoku; x++) {
            for (int y = 0; y < GirdsziseSudoku; y++) {
                if (LoaderSudoku[x][y] == 0) {
                    System.out.println("isFull = false");
                    s = false;
                }

            }
        }
        System.out.println("return der funktion isFull");
        return s;
    }


    // Jeck if the Actuall Possition is Valid
    public int[] possibleEntries() {
        int[] possibilityArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int k = 0;
        int l = 0;

        System.out.println("Array posibilities wurde geöffnet");
        //Jeck if the Horizontal row is Valid
        System.out.println("Jeck if the Horizontal row is Valid");
        System.out.println(row + "" + col);


        for (int x = 0; x < GirdsziseSudoku; x++) {
            int b = 0;
            for (int a = 1; a < 10; a++) {
                if (LoaderSudoku[row][x] == a) {
                    System.out.println(a);
                    possibilityArray[b] = 1;
                }
                b++;
            }
        }

        // just for test case
        System.out.println("nach dem Horizontal test");
        for (int a = 0; a < GirdsziseSudoku; a++){
            System.out.println(possibilityArray[a] + "");
        }

        // Jeck if the vertical col is valid
        System.out.println("Jeck if the vertical col is valid");
        for (int y = 0; y < GirdsziseSudoku; y++) {
            int b = 0;
            for (int a = 1; a < 10; a++) {
                if (LoaderSudoku[y][col] == a) {
                    System.out.println(a);
                    possibilityArray[b] = 1;
                }
                b++;
            }
        }

        // just for test case
        System.out.println("nach dem vertical test");
        for (int a = 0; a < GirdsziseSudoku; a++){
            System.out.println(possibilityArray[a] + "");
        }

        // Jeck if the 3x3 Sudoku rule is valid
        System.out.println("Jeck if the 3x3 Sudoku rule is valid");
        if (col >= 0 && col <= 2) {
            k = 0;
        } else if (col >= 3 && col <= 5) {
            k = 3;
        } else {
            k = 6;
        }

        if (row >= 0 && row <= 2) {
            l = 0;
        } else if (row >= 3 && row <= 5) {
            l = 3;
        } else {
            l = 6;
        }

        for (int x = 0; x < 2; x++) {
            k = k + x;
            for (int y = 0; y < 2; y++) {
                l = l + y;
                for (int a = 1; a < 10; a++) {
                    int b = 0;
                    b = b + 1;
                    if (LoaderSudoku[k][l] == a) {
                        possibilityArray[b] = 1;
                    }
                }
            }
        }
        System.out.println("nach dem 3x3");
        for (int a = 0; a < GirdsziseSudoku; a++){
            System.out.println(possibilityArray[a] + "");
        }


        System.out.println("Umwandlung");
        // Das Array wieder umwandeln von den einsen in Zahlen die möglichwähren
        int UmwandlungpossibilityArray = 1;
        for (int b = 0; b < GirdsziseSudoku; b++) {
                if (possibilityArray[b] == 1) {
                    possibilityArray[b] = 0;
                } else {
                    possibilityArray[b] = UmwandlungpossibilityArray;
                }
                UmwandlungpossibilityArray++;
        }

        for (int a = 0; a < GirdsziseSudoku; a++){
            System.out.println(possibilityArray[a] + "");
        }
        System.out.println("Das Possibility Array wurde von der Funktion zurück gegeben");
        return possibilityArray;
    }







    public boolean solver() {
        int[] possibilities;

        // Jeck if Function is running
        System.out.println("Sudoku solver wird ausgeführt");


        if (isFull()) {
            // this is the place where the solved sudoku goes to the Gui
            SolvedSudoku = LoaderSudoku;
            System.out.println("Das Sudoku ist voll");
            return true;

        } else search:{
            System.out.println("Das Sudoku ist nicht voll");
            // find first empty field
            for (int x = 0; x < GirdsziseSudoku; x++) {
                for (int y = 0; y < GirdsziseSudoku; y++) {
                    if (LoaderSudoku[x][y] == 0) {
                        System.out.println(LoaderSudoku[x][y]);
                        row = x;
                        col = y;
                        break search;
                    }
                }
            }
        }

        System.out.println(row + "" + col);
        System.out.println("Array posibleEntries wird aufgerufen");
        possibilities = possibleEntries();


        System.out.println("test ob das Array an den solver übergeben wurde");
        for (int a = 0; a < GirdsziseSudoku; a++){
            System.out.println(possibilities[a] + "");
        }


        for (int a = 0; a < 9; a++) {
            if (possibilities[a] != 0) {
                System.out.println(a + "");
                LoaderSudoku[row][col] = possibilities[a];
                solver();
            } else {
                LoaderSudoku[row][col] = 0;
            }
        }
        return false;
    }
}