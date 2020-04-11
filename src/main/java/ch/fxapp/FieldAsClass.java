package main.java.ch.fxapp;

import java.util.*;

public class FieldAsClass {
    private boolean isSolved = false;
    private int columNo;
    private int rowNo;
    private int sectorNo;
    private int remainingPossibilites = 9;
    private HashSet<Integer> possibilities = new HashSet<>();


    public FieldAsClass() {
        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Paste content of array to set
        Collections.addAll(this.possibilities = new HashSet<Integer>(Arrays.asList(arr)));
    }

    public void printPossibleNo() {
        System.out.println(this.possibilities);
    }

    public void removePossibleNo(int numberToRemove){
        this.possibilities.remove(numberToRemove);
    }

}