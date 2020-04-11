package main.java.ch.fxapp;

import org.w3c.dom.html.HTMLFieldSetElement;

public class FieldClassMain {
    public static void main(String[] args){
        FieldAsClass fieldAsClass= new FieldAsClass();
        fieldAsClass.printPossibleNo();
        fieldAsClass.removePossibleNo(5);
        fieldAsClass.printPossibleNo();
    }

    // CREATE SUDOKU FIELD ARRAY
    public static void createFieldArray(){
        //FieldAsClass[] fieldAsClassArray = new FieldAsClass[];

    }

    // ENTER DEFINED FIELDS FROM PUZZLE

    // REMOVE POSSIBILITIES IN SECTOR

    //REMOVE POSSIBILITIES IN COLUMN

    //REMOVE POSSIBILITIES IN ROW

    // FIND FIELD WITH THE LEAST POSSIBILITIES
    // ...AND MAKE IT "SOLVED"

    // CHECK IF ALL FIELDS ARE SOLVED
    // ...AND REPEAT UNTIL ALL FIELDS ARE SOLVED

}
