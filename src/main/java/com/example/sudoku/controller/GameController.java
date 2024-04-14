package com.example.sudoku.controller;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class GameController {
    //Test second commit
    @FXML
    private GridPane gridPaneSudoku;

   private int numRandom;
    @FXML
    public void initialize(){

        System.out.println("El numero actual es: "+numRandom);
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                numRandom = (int) (Math.random()*9+1);
                TextField textField = new TextField();
                textField.setEditable(false);
                textField.setMaxWidth(37);
                textField.setMaxHeight(37);
                textField.setStyle("-fx-border-color: black;");
                textField.setText(String.valueOf(numRandom));
                gridPaneSudoku.add(textField, i, j);
                textFieldLetterGiven(textField, i, j);
            }
        }
    }
    private void textFieldLetterGiven(TextField textField, int i, int j){
        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }
}
