package com.example.sudoku.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class GameController {
    //Test second commit
    @FXML
    private GridPane gridPaneSudoku;
    @FXML
    public void initialize(){

        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                TextField textField = new TextField();
                textField.setMaxWidth(37);
                textField.setMaxHeight(37);
                textField.setStyle("-fx-border-color: black;");
                gridPaneSudoku.add(textField, i, j);
                textFielLetterGiven(textField, i, j);
            }
        }
    }
    private void textFielLetterGiven(TextField textField, int i, int j){
        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }
}
