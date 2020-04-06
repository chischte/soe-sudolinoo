package main.java.ch.controller;

import main.java.ch.fileloader.Loader;

public class SudokuSolver {

    public int[][] LoaderSudoku;
    public int[][] SolvedSudoku;
    private int GirdsziseSudoku;
    private int row = 0;
    private int col = 0;


    private boolean isFull() {

        System.out.println("Funktion is Full wird ausgeführt");
        System.out.println(LoaderSudoku[row][col] + " " + "wert nach dem schreiben in dem leeren feld");

        boolean s = true;
        for (int y = 0; y < GirdsziseSudoku; y++) {
            for (int x = 0; x < GirdsziseSudoku; x++) {
                if (LoaderSudoku[x][y] == 0) {
                    System.out.println("isFull = false");
                    s = false;
                }

            }
        }
        System.out.println("return der funktion isFull");
        return s;
    }


    public int[][] startsolver() {
        // Create Loder
        Loader createtLoader = new Loader();

        // Set the Loader return Value = the Local two dimentional Array
        System.out.println("**************************************************************************************");
        LoaderSudoku = createtLoader.loadSudokuArray();
        System.out.println("Length is : " + LoaderSudoku.length);

        GirdsziseSudoku = LoaderSudoku.length;



        System.out.println("Der startsolver startet den solver");
        if (solver()) {
            System.out.println("Der return der funktion solve wird gemacht");
        }

        System.out.println("der return der Startsolver methode erfolgt");
        return SolvedSudoku;
    }

    // Jeck if the Actuall Possition is Valid
    public int[] possibleEntries () {
        int rowEntries = row;
        int colEntries = col;
        int k = 0;
        int l = 0;
        int[] possibilityArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println("Array posibilities wurde geöffnet");


        //Jeck if the Horizontal row is Valid
        System.out.println("Jeck if the Horizontal row is Valid");
        System.out.println(rowEntries + " " + colEntries);

        for (int y = 0; y < GirdsziseSudoku; y++) {
            int b = 0;
            for (int a = 1; a < 10; a++) {
                if (LoaderSudoku[row][y] == a) {
                    System.out.println(a);
                    possibilityArray[b] = 1;
                }
                b++;
            }
        }

        // just for test case
        System.out.println("nach dem Horizontal test");
        for (int a = 0; a < GirdsziseSudoku; a++) {
            System.out.println(possibilityArray[a] + "");
        }

        // Jeck if the vertical col is valid
        System.out.println("Jeck if the vertical col is valid");
        for (int x = 0; x < GirdsziseSudoku; x++) {
            int b = 0;
            for (int a = 1; a < 10; a++) {
                if (LoaderSudoku[x][col] == a) {
                    System.out.println(a);
                    possibilityArray[b] = 1;
                }
                b++;
            }
        }

        // just for test case
        System.out.println("nach dem vertical test");
        for (int a = 0; a < GirdsziseSudoku; a++) {
            System.out.println(possibilityArray[a] + "");
        }


        // Jeck if the 3x3 Sudoku rule is valid
        System.out.println("Jeck if the 3x3 Sudoku rule is valid");

        if (row >= 0 && row <= 2) {
            k = 0;
        } else if (row >= 3 && row <= 5) {
            k = 3;
        } else {
            k = 6;
        }

        System.out.println(k + " den wert K nach der zuweisung ");

        if (col >= 0 && col <= 2) {
            l = 0;
        } else if (col >= 3 && col <= 5) {
            l = 3;
        } else {
            l = 6;
        }
        System.out.println(l + " den wert K nach der zuweisung ");


        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                int t = k + x;
                int v = l + y;

//                System.out.println(t + " " + v + " Position von K/l");
//                System.out.println(LoaderSudoku[t][v] + " wert in K/l");
                if (LoaderSudoku[t][v] != 0) {
                    for (int a = 1; a < 10; a++) {
                        int b = a - 1;
                        if (LoaderSudoku[t][v] == a) {
                            possibilityArray[b] = 1;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("nach dem 3x3");
        for (int a = 0; a < GirdsziseSudoku; a++) {
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

        for (int a = 0; a < GirdsziseSudoku; a++) {
            System.out.println(possibilityArray[a] + "");
        }
        System.out.println("Das Possibility Array wurde von der Funktion zurück gegeben");
        return possibilityArray;
    }


    public boolean solver () {
        int rowsolver = 0;
        int colsolver = 0;
        int[] possibilityArraysolver = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        // Jeck if Function is running
        System.out.println("Sudoku solver wird ausgeführt");
        System.out.println("die aktuellen werte row und col von dem solver");
        System.out.println(rowsolver + "" + colsolver);


        if (isFull()) {
            // this is the place where the solved sudoku goes to the Gui
            SolvedSudoku = LoaderSudoku;
            System.out.println("Das Sudoku ist voll --------------------------------------");
        return true;

        } else {

            search:
            {
                System.out.println("Das Sudoku ist nicht voll");
                System.out.println("finde das erste leere Feld");
                // find first empty field
                for (int x = 0; x < GirdsziseSudoku; x++) {
                    for (int y = 0; y < GirdsziseSudoku; y++) {
                        if (LoaderSudoku[x][y] == 0) {
                            System.out.println("Das erste leere feld gefunden");
                            System.out.println(LoaderSudoku[x][y] + " wert in dem leeren Feld ");
                            System.out.println(x + " " + y);
                            row = x;
                            col = y;
                            break search;
                        }
                    }
                }
            }


            System.out.println(row + " " + col);
            rowsolver = row;
            colsolver = col;

            System.out.println("Array posibleEntries wird aufgerufen");
            possibilityArraysolver = possibleEntries();

            System.out.println("Das erste leere Feld befindet sich hir");
            System.out.println(row + " " + col);

            System.out.println("die aktuellen werte row und col von dem solver");
            System.out.println(rowsolver + "" + colsolver);

            System.out.println("anzeige Solver Possibiliti Array");
            for (int a = 0; a < GirdsziseSudoku; a++) {
                System.out.println(possibilityArraysolver[a] + "");
            }

            for (int a = 0; a < GirdsziseSudoku; a++) {
                if (isFull()) {
                    break;
                }
                System.out.println("steppen durch die möglichkeiten");
                System.out.println(a + " " + "den wert wollen wir aus dem arrap vergleichen ");
                System.out.println(rowsolver + " " + colsolver + " Feld in dem wir uns befinden");
                if (possibilityArraysolver[a] != 0) {
                    System.out.println("Die folgende Zahl wird in das feld geschrieben");
                    System.out.println(possibilityArraysolver[a]);
                    System.out.println(LoaderSudoku[rowsolver][colsolver] + "wert vor dem schreiben in dem leeren feld");

                    LoaderSudoku[rowsolver][colsolver] = possibilityArraysolver[a];

                    System.out.println(LoaderSudoku[rowsolver][colsolver] + " " + "wert nach dem schreiben in dem leeren feld");
                    System.out.println(rowsolver + " " + colsolver + "wert nach dem schreiben in dem leeren feld");


                    solver();

                } else if (a == 8) {
                    System.out.println("Das Feld hat keine Lösung gehe einen Schritt zurück");
                    LoaderSudoku[rowsolver][colsolver] = 0;
                }
            }

        }

        return false;
    }
}