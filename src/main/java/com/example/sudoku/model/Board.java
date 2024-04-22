package com.example.sudoku.model;

import java.util.ArrayList;

public class Board {
    private int boardSolution[][];
    private int boardIncomplete[][];
    public Board() {
        boardSolution=new int[9][9];
        boardIncomplete=new int[9][9];


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
        int sudokuImcomplete2[][]={
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
        ArrayList<int[][]> sudokusIncompletesAvailables=new ArrayList<>();
        sudokusIncompletesAvailables.add(sudokuImcomplete2);
        sudokusIncompletesAvailables.add(sudokuIncomplete1);

        //Permite que se genere alguno de los sudokus preparados
        int sudokuAleatorio=(int)(Math.random()*2);
        boardIncomplete=sudokusIncompletesAvailables.get(sudokuAleatorio);
        if(boardIncomplete==sudokuIncomplete1){
            boardSolution=sudokuComplete1;
        }
        else {
            boardSolution=sudokuComplete2;
        }
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