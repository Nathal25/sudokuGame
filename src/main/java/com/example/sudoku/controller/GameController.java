package com.example.sudoku.controller;

import com.example.sudoku.model.Board;
import com.example.sudoku.model.TextFieldAdder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class GameController {
    @FXML
    private Button btnEight;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnTwo;
    @FXML
    private GridPane gridPaneSudoku;

    private Board board;

    private TextFieldAdder textFieldAdder;
    private TextField campoText;
    private TextField campoTextEnfocado;

    private ArrayList<Integer>[] numerosEnFila;
    private ArrayList<Integer>[] numerosEnColumna;
    private Button activeButton = null; // Botón activo

    private String buttonText;

    @FXML
    public void initialize() {
        numerosEnFila = new ArrayList[9];
        numerosEnColumna = new ArrayList[9];
        board = new Board();

        for (int i = 0; i < 9; i++) {
            numerosEnFila[i] = new ArrayList<>();
            numerosEnColumna[i] = new ArrayList<>();
        }

        btnOne.setOnAction(event -> {
            activeButton = btnOne; // Establecer btnOne como el botón activo
        });

        btnTwo.setOnAction(event -> {
            activeButton = btnTwo; // Establecer btnTwo como el botón activo
        });
        btnThree.setOnAction(event -> {
            activeButton = btnThree;
        });
        btnFour.setOnAction(event -> {
            activeButton = btnFour;
        });
        btnFive.setOnAction(event -> {
            activeButton = btnFive;
        });
        btnSix.setOnAction(event -> {
            activeButton = btnSix;
        });
        btnSeven.setOnAction(event -> {
            activeButton = btnSeven;
        });
        btnEight.setOnAction(event -> {
            activeButton = btnEight;
        });
        btnNine.setOnAction(event ->{
            activeButton = btnNine;
        });
        int[][] boardIncomplete = board.getBoardIncomplete();
        int[][] copyBoardIncomplete=boardIncomplete;
        int[][] boardComplete = board.getBoardSolution();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttonText=new String();
                String id = String.valueOf(i).concat(String.valueOf(j));
                TextFieldAdder textFieldAdder = new TextFieldAdder(id);
                TextField campoText = textFieldAdder.getTextField();
                //Hace que se agreguen los valores en las casillas vacias
                campoText.setOnMouseClicked(event -> {
                    if (activeButton != null) { // Verificar si hay un botón activo
                        if (campoText.getText().trim().isEmpty()) { // Verificar si el campo de texto está vacío
                            buttonText = activeButton.getText();
                            campoText.setText(buttonText); // Establecer el texto del campo de texto según el botón activo
                            System.out.println("Se agregó el número " + buttonText + " a la casilla con ID: " + id);

                        }
                    }
                });

                // Establece el texto del campo de texto según los valores de la matriz
                if (copyBoardIncomplete[i][j] == 0) {
                    campoText.setText(" ");
                    campoText.setEditable(true);
                } else {
                    campoText.setText(String.valueOf(boardIncomplete[i][j]));
                    campoText.setEditable(false);
                }

                if (id.equals("01")) {
                    System.out.println("El valor de este campo es " + campoText.getText());
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
    @FXML
    void onHandleButtonRestartGame(ActionEvent event) {
        // Reiniciar valores necesarios al estado inicial
        board = new Board();
        activeButton = null;

        // Eliminar todos los nodos existentes en gridPaneSudoku
        gridPaneSudoku.getChildren().clear();

        // Volver a llamar al método initialize para volver a generar todo
        initialize();
    }
}
