package com.example.sudoku.controller;

import com.example.sudoku.model.Board;
import com.example.sudoku.model.TextFieldAdder;
import com.example.sudoku.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
            activeButton.setText(" ");
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

        Button[] buttons = {btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine,btnDelete};
        //This cycle allows each button to change its color when is presed
        for (Button button : buttons) {
            button.setOnAction(eventB -> {
                activeButton = button;
                updateButtonStyles(buttons);
            });
        }

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
                textField.setId(id);
                //Puts the numbers on the empty fields using the mouse
                textField.setOnMouseClicked(event -> {
                    if(textField.getText().contains(" ")){
                        textField.setEditable(true);
                    }
                    if (activeButton != null) { // Verifies is there's the active boton setted
                        if(activeButton.equals(btnDelete)) {
                            textField.setText(" ");
                        }else{
                            addNumberToTextField(id, textField, activeButton.getText(), boardIncomplete, copyBoardIncomplete);
                        }
                    }
                });
                textField.setOnKeyTyped(eventK -> {
                    String input = eventK.getCharacter(); // Gets the character put by the user
                    //Verifies if the given character matches a number between 1-9
                    if (input.matches("[1-9]")) {
                        textField.setText(input); //Establish the text in the textField based on the text given
                        addNumberToTextField(id, textField, input, boardIncomplete, copyBoardIncomplete); //Inserts the number on the textField
                    } else {
                        //If the character given do not match a number then it will not be shown
                        textField.setText(" ");
                        eventK.consume();
                    }
                });

                //Inserts the numbers in the textFields based on the array selected from Board
                if (copyBoardIncomplete[i][j] == 0) {
                    textField.setText(" ");
                } else {
                    textField.setText(String.valueOf(boardIncomplete[i][j]));
                    textField.setStyle("-fx-background-color: #eaeaea;");//Sets a background color to the textFields with numbers assigned priorly
                }

                if (id.equals("01")) {
                    System.out.println("El valor de este campo es " + textField.getText());
                }

                gridPaneSudoku.add(textField, i, j);
            }

        }
        //Here the verification of the board it's done
        int[][] boardComplete = board.getBoardSolution();
        btnVerify.setOnAction(event -> {
            boolean areEqual = true;
            //Verifies if the arrays are equal by checking each element
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (boardComplete[i][j] != copyBoardIncomplete[i][j]) {
                        areEqual = false;
                        break; //No longer verifies when one inequality is found
                    }
                }
                if (!areEqual) {
                    break; //No longer verifies when one inequality is found
                }
            }
            if (areEqual) {

            System.out.println("Los tableros son iguales, has ganado el juego");
                String tittle="Juego Finalizado";
                String header ="¡GANASTE!";
                String content ="¡Felicidades! Has ganado el juego";
                AlertBox alertBox=new AlertBox();
                alertBox.showMessageWinner(tittle,header,content);
            } else {
                System.out.println("Sigue intentando");
                String tittle="Sigue intentando";
                String header ="¡AÚN PUEDES CONSEGUIRLO!";
                String content ="Sigue intentandolo!";
                AlertBox alertBox=new AlertBox();
                alertBox.showMessageLoser(tittle,header,content);
            }
        });
    }
    private void addNumberToTextField(String id, TextField textField, String numberToAdd, int[][] boardIncomplete, int[][] copyBoardIncomplete) {
        int a = Character.getNumericValue(id.charAt(0));
        int b = Character.getNumericValue(id.charAt(1));
        if (boardIncomplete[a][b] == 0) { //Verifies if the textField was originally empty -or it had a zero assigned in the array
            textField.setText(numberToAdd); //Establish the number based in the given number to add
            copyBoardIncomplete[a][b] = Integer.parseInt(numberToAdd); // Updates copyBoardIncomplete
            System.out.println("Se agregó el número " + numberToAdd + " a la casilla con ID: " + id);
        }
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

    @FXML
    void onHandleButtonHowToPlay(ActionEvent event) {
        String tittle="Cómo Jugar";
        String header ="Tutorial";
        String content ="El juego de sudoku se juega de la siguiente manera: " +
                "\nHaz de insertar números de 1 al 9 de tal manera que completes el tablero" +
                " sin que los numeros se repitan en la columna, en la fila o en el recuadro 3x3 en el que está" +
                " ubicado.";
        AlertBox alertBox=new AlertBox();
        alertBox.showMessage(tittle,header,content);
    }
    //Gives the style to the buttons
    private void updateButtonStyles(Button[] buttons) {
        for (Button button : buttons) {
            if (activeButton == button) {
                button.setStyle("-fx-background-color: #9fbd68;-fx-background-radius: 15; -fx-border-radius: 15");

            } else {
                button.setStyle("-fx-background-color: #bbd686;-fx-background-radius: 15; -fx-border-radius: 15");
            }
        }
    }
}
