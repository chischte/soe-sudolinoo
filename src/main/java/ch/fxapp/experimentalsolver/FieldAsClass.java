package main.java.ch.fxapp.experimentalsolver;

import java.util.*;

public class FieldAsClass {

    // Properties of every field:
    private boolean isSolved = false;
    private int rowNo;
    private int columnNo;

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

    //SETTER AND METHODS TO CHANGE VALUES:

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

    public void printFieldInfo() {
        System.out.print("RowNo=" + rowNo+" | ");
        System.out.print("ColumnNo=" + columnNo+" | ");
        System.out.print("SectorNo= " + sectorNo+" | ");
        System.out.print("VALUE= " + fieldValue+" | ");
        System.out.print("SOLVED=" + isSolved+" | ");
        System.out.print("Possibilities:" + this.possibilities+" | ");
        System.out.println(" ");
    }
}