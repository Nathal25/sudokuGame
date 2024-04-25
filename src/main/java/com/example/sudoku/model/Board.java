package com.example.sudoku.model;

import java.util.ArrayList;

public class Board {
    private int boardSolution[][];
    private int boardIncomplete[][];
    public Board() {
        boardSolution=new int[9][9];
        boardIncomplete=new int[9][9];

        //Sudokus Completes

        int sudokuComplete1[][]={
                {2,6,1,3,7,9,8,5,4},
                {8,3,5,6,1,4,2,9,7},
                {7,4,9,8,5,2,3,1,6},
                {1,9,4,2,8,6,5,7,3},
                {5,2,3,7,9,1,4,6,8},
                {6,8,7,5,4,3,9,2,1},
                {9,5,8,4,6,7,1,3,2},
                {4,7,2,1,3,5,6,8,9},
                {3,1,6,9,2,8,7,4,5}
        };
        int sudokuComplete2[][]={
                {2,5,4,3,6,7,8,1,9},
                {1,9,7,8,2,5,3,4,6},
                {3,8,6,1,9,4,2,7,5},
                {4,7,2,6,1,9,5,3,8},
                {9,1,5,4,3,8,6,2,7},
                {8,6,3,7,5,2,4,9,1},
                {6,3,8,9,4,1,7,5,2},
                {5,4,9,2,7,6,1,8,3},
                {7,2,1,5,8,3,9,6,4}
        };
        int sudokuComplete3[][]={
                {1,9,2,3,7,6,5,4,8},
                {4,5,6,9,8,1,7,3,2},
                {7,3,8,2,5,4,9,6,1},
                {3,1,7,8,6,9,4,2,5},
                {6,2,5,4,1,7,3,8,9},
                {8,4,9,5,2,3,1,7,6},
                {9,7,1,6,3,2,8,5,4},
                {2,8,4,7,9,5,6,1,3},
                {5,6,3,1,4,8,2,9,7}


        };
        int sudokuComplete4[][]={
                {8,1,6,3,7,9,5,2,4},
                {3,4,9,5,6,2,1,7,8},
                {7,5,2,1,8,4,9,6,3},
                {1,2,5,1,8,4,9,6,3},
                {4,6,7,2,1,5,8,3,9},
                {9,8,3,6,4,7,2,5,1},
                {2,7,1,4,9,6,3,8,5},
                {5,3,4,8,2,1,7,9,6},
                {6,9,8,7,5,3,4,1,2},

        };
        int sudokuComplete5[][]={
                {4,5,3,7,1,2,8,6,9},
                {1,6,8,3,5,9,2,7,4},
                {2,7,9,4,8,6,5,1,3},
                {3,9,2,5,4,7,1,8,6},
                {7,4,6,8,9,1,3,5,2},
                {5,8,1,2,6,3,4,9,7},
                {9,2,4,1,7,8,6,3,5},
                {8,3,7,6,2,5,9,4,1},
                {6,1,5,9,3,4,7,2,8},


        };

        int sudokuComplete6[][]={
                {9,3,6,5,1,2,7,4,8},
                {1,2,5,4,8,7,3,6,9},
                {8,4,7,3,9,6,5,1,2},
                {3,1,4,9,7,5,8,2,6},
                {5,6,8,2,3,4,1,9,7},
                {7,9,2,1,6,8,4,5,3},
                {2,8,3,6,4,1,9,7,5},
                {4,5,9,7,2,3,6,8,1},
                {6,7,1,8,5,9,2,3,4},


        };

        //Sudokus Incompletes

        int sudokuIncomplete1[][]={
            {2,6,0,3,0,0,0,5,0},
            {8,3,0,6,0,4,2,9,0},
            {0,0,0,0,5,0,0,0,6},
            {0,9,0,2,0,6,0,0,0},
            {0,2,0,0,9,1,4,0,8},
            {6,0,7,0,0,0,0,2,1},
            {0,0,0,4,0,0,1,0,2},
            {4,7,2,0,0,5,0,0,9},
            {0,1,0,9,2,0,7,0,0}
        };

        int sudokuIncomplete2[][]={
                {0,5,4,0,0,7,0,1,0},
                {1,0,0,8,2,0,3,4,0},
                {0,8,0,1,0,0,0,7,0},
                {0,7,0,6,1,0,5,0,8},
                {9,0,0,0,0,8,0,2,0},
                {8,0,3,0,5,0,4,0,0},
                {0,0,8,0,4,0,7,0,2},
                {5,0,9,0,7,0,0,8,0},
                {0,0,1,0,8,3,0,0,4}
        };
        int sudokuIncomplete3[][]={
                {0,9,0,0,0,0,0,0,0},
                {0,0,6,0,0,1,7,3,0},
                {7,0,0,0,0,0,0,6,0},
                {3,1,7,0,0,9,0,0,0},
                {0,0,5,4,0,7,3,0,0},
                {0,0,9,5,2,0,1,7,6},
                {9,0,1,0,3,2,8,5,0},
                {2,0,4,7,0,5,0,0,3},
                {0,0,0,0,0,0,0,9,0}
        };
        int sudokuIncomplete4[][]={
                {0,0,0,3,0,0,5,0,0},
                {3,4,9,0,6,0,0,0,8},
                {7,5,0,0,0,0,9,6,3},
                {0,2,0,9,0,8,0,0,7},
                {4,6,0,2,1,0,0,0,0},
                {0,0,0,0,4,7,2,5,1},
                {0,0,0,4,0,0,3,8,5},
                {0,3,4,0,0,0,0,9,0},
                {6,9,0,0,0,3,0,0,0},

        };
        int sudokuIncomplete5[][]={
                {4,0,0,0,1,0,0,0,9},
                {1,0,8,0,5,0,0,0,0},
                {2,7,0,4,0,6,0,1,3},
                {0,0,0,5,4,0,0,8,6},
                {7,4,0,8,0,1,3,0,2},
                {0,0,1,0,6,3,0,0,7},
                {0,2,0,0,0,0,6,0,0},
                {0,0,7,6,0,0,0,4,0},
                {0,1,0,0,3,0,7,0,8},
        };

        int sudokuIncomplete6[][]={
                {9,3,6,0,0,0,7,0,0},
                {1,0,0,4,0,7,3,0,0},
                {0,4,0,0,0,0,5,0,2},
                {0,0,4,0,0,5,0,0,6},
                {0,0,8,0,3,4,1,9,0},
                {7,9,0,0,6,0,4,5,3},
                {0,8,3,0,4,0,0,0,5},
                {0,0,9,0,0,0,0,0,0},
                {0,0,1,8,5,0,2,3,0},

        };

        //Sets all the inCompleteSudokus in one arrayList
        ArrayList<int[][]> incompleteSudokus=new ArrayList<>();
        incompleteSudokus.add(sudokuIncomplete1);
        incompleteSudokus.add(sudokuIncomplete2);
        incompleteSudokus.add(sudokuIncomplete3);
        incompleteSudokus.add(sudokuIncomplete4);
        incompleteSudokus.add(sudokuIncomplete5);
        incompleteSudokus.add(sudokuIncomplete6);

        //Sets all the completeSudokus in one arrayList
        ArrayList<int[][]> completeSudokus=new ArrayList<>();
        completeSudokus.add(sudokuComplete1);
        completeSudokus.add(sudokuComplete2);
        completeSudokus.add(sudokuComplete3);
        completeSudokus.add(sudokuComplete4);
        completeSudokus.add(sudokuComplete5);
        completeSudokus.add(sudokuComplete6);

        //Allows that one of the given sudoku to be generated
        int randomSudoku=(int)(Math.random()*incompleteSudokus.size());
        boardIncomplete=incompleteSudokus.get(randomSudoku);  //Selects of the sudokus on the arrayList based on a random number and the position that corresponds in the arrayList
        boardSolution=completeSudokus.get(randomSudoku);      //Based on the same previous random number a complete sudoku is selected in the arrayList

    }
    public int[][] getBoardSolution() {
        return boardSolution;
    }

    public int[][] getBoardIncomplete() {
        return boardIncomplete;
    }

    public void setBoardIncomplete(int[][] boardIncomplete) {
        this.boardIncomplete = boardIncomplete;
    }
    public void setBoardSolution(int[][] boardSolution) {
        this.boardSolution = boardSolution;
    }
}
