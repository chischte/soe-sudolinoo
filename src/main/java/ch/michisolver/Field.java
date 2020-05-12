package main.java.ch.michisolver;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Field {

    private boolean isSolved;
    private boolean hasBeenProcessed; // true if solved and related fields processed
    private int rowNo; // 0-8
    private int columnNo; // 0-8
    private int fieldValue; // 1-9
    private int sectorNo; // 1-9
    private TreeSet<Integer> possibilities = new TreeSet<>();

    public Field() {
        isSolved = false;
        hasBeenProcessed = false;
        // Create possibilities Set:
        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Collections.addAll(this.possibilities = new TreeSet<Integer>(Arrays.asList(arr)));
    }

    // SETTER AND METHODS TO CHANGE VALUES:

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }

    public void setSectorNo(int sectorNo) {
        this.sectorNo = sectorNo;
    }

    public void removePossibleNo(int numberToRemove) {
        this.possibilities.remove(numberToRemove);
    }

    public void setFieldValue(int fieldValue) {
        this.fieldValue = fieldValue;
    }

    public void setSolved() {
        isSolved = true;
        this.possibilities.clear(); // removes all possibilities
    }

    public void setProcessed() {
        this.hasBeenProcessed = true;
    }

    // GETTER AND METHODS TO REQUEST VALUES :

    public boolean isSolved() {
        return this.isSolved;
    }

    public int getColumnNo() {
        return columnNo;
    }

    public int getRowNo() {
        return rowNo;
    }

    public int getSectorNo() {
        return sectorNo;
    }

    public int getFieldValue() {
        return fieldValue;
    }

    public int countPossibleNumbers() {
        int noOfPossibilities = possibilities.size();
        return noOfPossibilities;
    }

    public boolean hasBeenProcessed() {
        return hasBeenProcessed;
    }

    public int getAPossibleValueByRandom() {
        int noOfPossibilities = possibilities.size();
        int random = ThreadLocalRandom.current().nextInt(0, noOfPossibilities);
        Integer[] possibilityArray = new Integer[possibilities.size()];
        possibilities.toArray(possibilityArray);
        return possibilityArray[random];
    }
}