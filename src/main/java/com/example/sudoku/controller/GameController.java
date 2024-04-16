package com.example.sudoku.controller;

import com.example.sudoku.model.TextFieldAdder;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class GameController {

    @FXML
    private GridPane gridPaneSudoku;

    private TextFieldAdder textFieldAdder;
    private TextField campoText;

    private ArrayList<Integer>[] numerosEnFila;
    private ArrayList<Integer>[] numerosEnColumna;
   private int numRandom;
   private Random random;

    @FXML
    public void initialize(){
        Random random = new Random();
        numerosEnFila = new ArrayList[9];
        numerosEnColumna = new ArrayList[9];

        for (int i = 0; i < 9; i++) {
            numerosEnFila[i] = new ArrayList<>();
            numerosEnColumna[i] = new ArrayList<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                textFieldAdder = new TextFieldAdder();
                campoText= textFieldAdder.getTextField();
                boolean mostrarInicialmente = random.nextBoolean();
                if (mostrarInicialmente) {
                    int numero = generarNumeroUnico(i, j, random);
                    campoText.setText(String.valueOf(numero));
                    campoText.setEditable(false);
                }

                gridPaneSudoku.add(campoText, i, j);
                textFieldLetterGiven(campoText, i, j);
            }
        }
    }
    //Metodo para no genera el mismo núemro en una columna/fila
    private int generarNumeroUnico(int fila, int columna, Random random) {
        int numero;
        do {
            numero = random.nextInt(9) + 1;
            //reconoce que no haya más numeros
        } while (numerosEnFila[fila].contains(numero) || numerosEnColumna[columna].contains(numero));

        numerosEnFila[fila].add(numero);
        //añade los numeros
        numerosEnColumna[columna].add(numero);

        return numero;
    }
    private void textFieldLetterGiven(TextField textField, int i, int j){
        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }
}
