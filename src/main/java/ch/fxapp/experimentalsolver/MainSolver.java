package main.java.ch.fxapp.experimentalsolver;

public class MainSolver {

    static int puzzle[][] = {
            {8, 0, 1, 0, 0, 3, 9, 0, 6},
            {0, 0, 9, 0, 0, 7, 8, 5, 0},
            {2, 5, 0, 1, 0, 0, 4, 7, 0},
            {5, 0, 0, 0, 6, 1, 7, 0, 4},
            {7, 6, 0, 8, 3, 0, 0, 0, 0},
            {0, 3, 2, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 1, 9, 5, 0, 0},
            {0, 0, 5, 0, 0, 0, 3, 0, 2},
            {0, 0, 0, 4, 5, 2, 1, 9, 7}
    };

    public static void main(String[] args) {
        SolverTools solverTools = new SolverTools();

        // CONFIGURE ALL FIELDS
        printStarline("CONFIGURE ALL FIELDS");
        solverTools.configureAllFields(puzzle);

        // ITERATE THROUGH ALL SOLVED FIELDS ...
        // ...AND REMOVE THEIR NUMBERS FROM ALL FIELDS...
        // ...IN SAME ROW, COLUMN, OR SECTOR;
        printStarline("REMOVE SOLVED NUMBERS");
        solverTools.removeSolvedNumbersFromOtherFields();


        //REMOVE POSSIBILITIES IN COLUMN

        // REMOVE POSSIBILITIES IN SECTOR

        // FIND FIELD WITH THE LEAST POSSIBILITIES
        // ...SELECT A NUMBER
        // ...AND MARE IT "SOLVED"

        // CHECK IF ALL FIELDS ARE SOLVED
        // ...AND REPEAT UNTIL ALL FIELDS ARE SOLVED

        // WRITE ARRAY OF OBJECTS TO SOLVED SUDOKU ARRAY
        // ...RETURN THE SOLVED SUDOK ARRAY

    }

    public static void printStarline(String chapter){
        for(int i=0;i<3;i++) {
            System.out.print("*****" + chapter + "******");
        }
        System.out.println("");

    }


}
