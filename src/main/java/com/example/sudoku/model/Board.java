package com.example.sudoku.model;

import java.util.ArrayList;

public class Board {
    private int boardSolution[][];
    private int boardIncomplete[][];
    public Board() {
        boardSolution=new int[9][9];
        boardIncomplete=new int[9][9];

        //Sudoku Complete

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
                {5,6,3,1,6,8,2,9,7}
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

        }
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

        }

        //Sudoku Incomplete

        int sudokuIncomplete1[][]={
            {0,6,0,3,0,0,0,0,0},
            {0,3,0,6,0,0,2,9,0},
            {0,0,0,0,5,0,0,0,6},
            {0,9,0,2,0,6,0,0,0},
            {0,2,0,0,9,1,4,0,8},
            {6,0,7,0,0,3,9,2,1},
            {0,0,0,0,0,0,1,3,2},
            {4,7,2,0,0,5,6,0,9},
            {0,0,0,9,2,0,7,0,5}
        };
        int sudokuIncomplete2[][]={
                {0,0,4,0,0,7,0,1,0},
                {1,0,0,8,2,0,3,4,0},
                {0,0,0,1,9,0,0,0,0},
                {0,0,0,6,1,0,5,3,8},
                {9,0,0,0,0,8,6,2,0},
                {8,0,3,0,5,0,4,0,0},
                {0,0,8,0,0,0,7,0,2},
                {5,0,9,0,7,0,0,8,3},
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
        }
        ArrayList<int[][]> sudokusIncompletesAvailables=new ArrayList<>();
        sudokusIncompletesAvailables.add(sudokuIncomplete1);
        sudokusIncompletesAvailables.add(sudokuIncomplete2);
        sudokusIncompletesAvailables.add(sudokuIncomplete3);
        sudokusIncompletesAvailables.add(sudokuIncomplete4);
        sudokusIncompletesAvailables.add(sudokuIncomplete5);
        sudokusIncompletesAvailables.add(sudokuIncomplete6);

        ArrayList<int[][]> sudokusCompletesAvailables=new ArrayList<>();
        sudokusCompletesAvailables.add(sudokuComplete1);
        sudokusCompletesAvailables.add(sudokuComplete2);
        sudokusCompletesAvailables.add(sudokuComplete3);
        sudokusCompletesAvailables.add(sudokuComplete4);
        sudokusCompletesAvailables.add(sudokuComplete5);
        sudokusCompletesAvailables.add(sudokuComplete6);

        //Permite que se genere alguno de los sudokus preparados
        int sudokuAleatorio=(int)(Math.random()*sudokusIncompletesAvailables.size());
        boardIncomplete=sudokusIncompletesAvailables.get(sudokuAleatorio);  //se selecciona un sudoku de la lista en base al numero aleatorio
        boardSolution=sudokusCompletesAvailables.get(sudokuAleatorio);      //Se selecciona el sudoku respuesta con el mismo numero que el anterior

    }
    public int[][] getBoardSolution() {return boardSolution;}
    public int[][] getBoardIncomplete() {return boardIncomplete;}

    public void setBoardIncomplete(int[][] boardIncomplete) {
        this.boardIncomplete = boardIncomplete;
    }
    public void setBoardSolution(int[][] boardSolution) {
        this.boardSolution = boardSolution;
    }
}
