package main.java.ch.fileloader;

public class Loader {

    private int puzzle[][] = {
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

    public int[][] loadSudokuArray() {
        System.out.println("Loader Works");

        return puzzle;
    }
}


