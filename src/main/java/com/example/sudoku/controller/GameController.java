package com.example.sudoku.controller;

import com.example.sudoku.model.TextFieldAdder;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    @FXML
    private GridPane gridPaneSudoku;

    private TextFieldAdder textFieldAdder;
    private TextField campoText;
    private List<String> copyOriginalList;
   private int numRandom;

    @FXML
    public void initialize(){


        System.out.println("El numero actual es: "+numRandom);
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                textFieldAdder = new TextFieldAdder();
                numRandom = (int) (Math.random()*9+1);
                int numRandom2 = (int) (Math.random()*2+1);
                campoText=textFieldAdder.getTextField();
                campoText.setText(String.valueOf(numRandom));
                if (numRandom2!=1){
                    campoText.setStyle("-fx-text-fill: white; -fx-border-color: black;");
                }
                gridPaneSudoku.add(campoText, i, j);
                textFieldLetterGiven(campoText, i, j);
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
