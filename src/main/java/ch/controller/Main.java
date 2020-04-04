package main.java.ch.controller;

import javafx.application.Application;
import main.java.ch.fxapp.FxApp;



public final class Main {

    public static void main(String[] args) {

        System.out.println("Main luft");
        SudokuSolver test = new SudokuSolver();
        test.solver();
        test.testobdieVariableGespeichertWurde();

        // Launch the JavaFX Sudoku GUI:
        Application.launch(FxApp.class, args);

    }


}