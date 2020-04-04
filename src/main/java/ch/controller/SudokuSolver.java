package main.java.ch.controller;


import main.java.ch.fileloader.Loader;

public class SudokuSolver {

public int[][] LoaderSudoku;

    public void testobdieVariableGespeichertWurde() {
        System.out.println("Length is : " + LoaderSudoku.length);
    }

    public void solver() {
        System.out.println("Sudoku solver wird ausgeführt");

        Loader createtLoader = new Loader();

        LoaderSudoku = createtLoader.loadSudokuArray();
        System.out.println("Length is : " + LoaderSudoku.length);
    }












}
