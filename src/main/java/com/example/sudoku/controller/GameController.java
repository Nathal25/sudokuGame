package com.example.sudoku.controller;

import com.example.sudoku.model.Board;
import com.example.sudoku.model.TextFieldAdder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


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

    private Button activeButton = null;

    @FXML
    public void initialize() {

        board = new Board();

        btnDelete.setOnAction(event ->{
            activeButton = btnDelete;
            activeButton.setText("");
        });

        //activeButton will establish base on the button selected
        btnOne.setOnAction(event -> {activeButton = btnOne;});
        btnTwo.setOnAction(event -> {activeButton = btnTwo;});
        btnThree.setOnAction(event -> {activeButton = btnThree;});
        btnFour.setOnAction(event -> {activeButton = btnFour;});
        btnFive.setOnAction(event -> {activeButton = btnFive;});
        btnSix.setOnAction(event -> {activeButton = btnSix;});
        btnSeven.setOnAction(event -> {activeButton = btnSeven;});
        btnEight.setOnAction(event -> {activeButton = btnEight;});
        btnNine.setOnAction(event ->{activeButton = btnNine;});


        int[][] boardIncomplete = board.getBoardIncomplete();
        int[][] copyBoardIncomplete = new int[9][9];
        //Allows the copyBoardIncomplete to update based on the number put on the textField
        for (int i = 0; i < 9; i++) {
            System.arraycopy(boardIncomplete[i], 0, copyBoardIncomplete[i], 0, 9);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String id = String.valueOf(i).concat(String.valueOf(j));
                TextFieldAdder textFieldAdder = new TextFieldAdder(id);
                TextField textField = textFieldAdder.getTextField();
                // Insertar números en los espacios vacíos mediante clic del mouse
                textField.setOnMouseClicked(event -> {
                    if (activeButton != null) { // Verifica si hay un botón activo
                        addNumberToTextField(id, textField, activeButton.getText(), boardIncomplete, copyBoardIncomplete);
                    }
                });

                // Insertar números en las casillas vacías mediante el teclado
                textField.setOnKeyPressed(event -> {
                    String keyPressed = event.getText();
                    if (keyPressed.matches("[1-9]")) { // Verifica si la tecla presionada es un número del 1 al 9
                        addNumberToTextField(id, textField, keyPressed, boardIncomplete, copyBoardIncomplete);
                    }
                });

                // Establece el textoFields basado en los valores en la matriz seleccionada en Board
                if (copyBoardIncomplete[i][j] == 0) {
                    textField.setText(" ");
                } else {
                    textField.setText(String.valueOf(boardIncomplete[i][j]));
                    textField.setStyle("-fx-background-color: #eaeaea;");
                }

                if (id.equals("01")) {
                    System.out.println("El valor de este campo es " + textField.getText());
                }

                gridPaneSudoku.add(textField, i, j);
                textFieldNumberGiven(textField, i, j);
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
    private void addNumberToTextField(String id, TextField textField, String numberToAdd, int[][] boardIncomplete, int[][] copyBoardIncomplete) {
        int a = Character.getNumericValue(id.charAt(0));
        int b = Character.getNumericValue(id.charAt(1));
        if (boardIncomplete[a][b] == 0) { // Verifica si el textField estaba originalmente vacío
            textField.setText(numberToAdd); // Establece el texto basado en el número a agregar
            copyBoardIncomplete[a][b] = Integer.parseInt(numberToAdd); // Actualiza copyBoardIncomplete
            System.out.println("Se agregó el número " + numberToAdd + " a la casilla con ID: " + id);
        }
    }
    private void textFieldNumberGiven(TextField textField, int i, int j){

        textField.setOnKeyPressed(event -> {
        });

    }
    @FXML
    void onHandleButtonRestartGame(ActionEvent event) {
        //Restarts the necessary values to their original state
        board = new Board();
        activeButton = null;

        //Deletes all the elements in the gridPaneSudoku
        gridPaneSudoku.getChildren().clear();

        //Calls back the method initialize() to restart properly
        initialize();
    }
}
