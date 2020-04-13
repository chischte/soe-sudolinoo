package main.java.ch.michisolver;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FieldAsClass {

    // PROPERTIES OF EVERY SUDOKU FIELD:
    private boolean isSolved = false;

    // Set "hasBeenProcessed" true if all fields in same row, column or sector have been cleared of the possibility of this number;
    private boolean hasBeenProcessed = false;
    private int fieldNo; // 0-80
    private int rowNo; // 0-8
    private int columnNo; // 0-8

    private int fieldValue;
    private int sectorNo; // 1-9
    private int remainingPossibilites = 9;
    private TreeSet<Integer> possibilities = new TreeSet<>();

    // THIS IS THE CONSTRUCTOR
    public FieldAsClass() {

        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Paste content of array to set
        Collections.addAll(this.possibilities = new TreeSet<Integer>(Arrays.asList(arr)));
    }

    //SETTER AND METHODS TO CHANGE VALUES:
    public void setFieldNo(int fieldNo) {
        this.fieldNo = fieldNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public void setColumNo(int columnNo) {
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
        //remove all possibilities
        this.possibilities.clear();
    }

    public void setProcessed() {
        this.hasBeenProcessed = true;
    }

    //GETTER AND METHODS TO REQUEST VALUES :

    public void getPossibleNo() {
        System.out.println(this.possibilities);
    }

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

        int aPossibleValue = possibilityArray[random];
        return aPossibleValue;
    }


    public void printFieldInfo() {
        System.out.print("FieldNo=" + fieldNo + " | ");
        System.out.print("RowNo=" + rowNo + " | ");
        System.out.print("ColumnNo=" + columnNo + " | ");
        System.out.print("SectorNo= " + sectorNo + " | ");
        System.out.print("VALUE=" + fieldValue + " | ");
        System.out.print("SOLVED=" + isSolved + " | ");
        System.out.print("NoOfPossibilities=" + countPossibleNumbers() + " | ");
        System.out.print("Possibilities:" + possibilities + " | ");
        System.out.println(" ");
    }
}