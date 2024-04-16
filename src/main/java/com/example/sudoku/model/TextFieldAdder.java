package com.example.sudoku.model;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class TextFieldAdder {
    private TextField textField;

    public TextFieldAdder() {

        textField = new TextField();
        textField.setEditable(false);
        textField.setMaxWidth(37);
        textField.setMaxHeight(37);
    }
    public TextField getTextField() {return textField;}

    public void setTextField(TextField textField) {this.textField = textField;}

}
