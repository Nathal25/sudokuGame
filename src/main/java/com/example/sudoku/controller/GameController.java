package com.example.sudoku.controller;

import com.example.sudoku.model.Board;
import com.example.sudoku.model.TextFieldAdder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class GameController {
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnVerify;

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


    private Button activeButton = null; // Botón activo

    private String buttonText;

    @FXML
    public void initialize() {

        board = new Board();
        Button btnControlBorrador=new Button();
        btnControlBorrador.setText("");
        btnDelete.setOnAction(event ->{
            activeButton = btnDelete;
            activeButton.setText(btnControlBorrador.getText());
        });

        //El boton activo se va a establecer de acuerdo al boton seleccionado
        btnOne.setOnAction(event -> {
            activeButton = btnOne;
        });
        btnTwo.setOnAction(event -> {
            activeButton = btnTwo;
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
        int[][] copyBoardIncomplete = new int[9][9];
        //Permite que se vaya actualizando a medida que se pone un numero en el textField
        for (int i = 0; i < 9; i++) {
            System.arraycopy(boardIncomplete[i], 0, copyBoardIncomplete[i], 0, 9);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttonText=new String();
                String id = String.valueOf(i).concat(String.valueOf(j));
                TextFieldAdder textFieldAdder = new TextFieldAdder(id);
                TextField campoText = textFieldAdder.getTextField();
                //Hace que se agreguen los valores en las casillas vacias
                campoText.setOnMouseClicked(event -> {
                    if (activeButton != null) { // Verificar si hay un botón activo
                        int a = Character.getNumericValue(id.charAt(0));
                        int b = Character.getNumericValue(id.charAt(1));
                        if (copyBoardIncomplete[a][b] == 0){ // Verifica si el campo de texto estaba originalmente vacío
                            buttonText = activeButton.getText();
                            campoText.setText(buttonText); // Establecer el texto del campo de texto según el botón activo
                            copyBoardIncomplete[a][b] = Integer.parseInt(buttonText); // Actualiza copyBoardIncomplete
                            System.out.println("Se agregó el número " + buttonText + " a la casilla con ID: " + id);
                        }
                    }
                });

                // Establece el texto del campo de texto según los valores de la matriz
                if (copyBoardIncomplete[i][j] == 0) {
                    campoText.setText(" ");
                    //campoText.setEditable(true);
                } else {
                    campoText.setText(String.valueOf(boardIncomplete[i][j]));
                    campoText.setStyle("-fx-background-color: #E9E6E6;");
                    //campoText.setEditable(false);
                }

                if (id.equals("01")) {
                    System.out.println("El valor de este campo es " + campoText.getText());
                }
                gridPaneSudoku.add(campoText, i, j);
                textFieldLetterGiven(campoText, i, j);


            }
        }
        int[][] boardComplete = board.getBoardSolution();
        btnVerify.setOnAction(event -> {
            boolean areEqual = true;
            // Verifica si las matrices son iguales elemento por elemento
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (boardComplete[i][j] != copyBoardIncomplete[i][j]) {
                        areEqual = false;
                        break; // No es necesario seguir verificando si ya encontramos una diferencia
                    }
                }
                if (!areEqual) {
                    break; // No es necesario seguir verificando si ya encontramos una diferencia
                }
            }
            if (areEqual) {
                System.out.println("Los tableros son iguales, has ganado el juego");
            } else {
                System.out.println("Sigue intentando");
            }
        });
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
