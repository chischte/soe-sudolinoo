package main.java.ch.fxapp;

import java.util.*;

public class FieldAsClass {
    private boolean isSolved = false;
    private int columnNo=2;
    private int rowNo;

    public void setFieldValue(int fieldValue) {
        this.fieldValue = fieldValue;
    }

    private int fieldValue;
    private int sectorNo;
    private int remainingPossibilites = 9;
    private HashSet<Integer> possibilities = new HashSet<>();


    // THIS IS THE CONSTRUCTOR
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

    public boolean isSolved() {
        return this.isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
        System.out.println("This Field is solved = " + solved);
    }

    public int getColumnNo() {
        return columnNo;
    }

    public void setColumNo(int columnNo) {
        System.out.println("Sector= " + columnNo);
        this.columnNo = columnNo;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        System.out.println("This Field is on row number= " + rowNo);
        this.rowNo = rowNo;
    }

    public int getSectorNo() {
        return sectorNo;
    }

    public void setSectorNo(int sectorNo) {
        System.out.println("Sector= " + sectorNo);
        this.sectorNo = sectorNo;
    }
}