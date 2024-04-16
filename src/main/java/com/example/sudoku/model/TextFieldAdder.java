package com.example.sudoku.model;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class TextFieldAdder {
    private TextField textField;
    private List<String> originalValues;
    public TextFieldAdder() {

        textField = new TextField();
        textField.setEditable(false);
        textField.setMaxWidth(37);
        textField.setMaxHeight(37);
        textField.setStyle("-fx-border-color: black;");

        originalValues = new ArrayList<>();
        originalValues.add("1");
        originalValues.add("2");
        originalValues.add("3");
        originalValues.add("4");
        originalValues.add("5");
        originalValues.add("6");
        originalValues.add("7");
        originalValues.add("8");
        originalValues.add("9");

    }
    public TextField getTextField() {return textField;}

    public void setTextField(TextField textField) {this.textField = textField;}

    public List<String> getOriginalValues() {return originalValues;}
    public void setOriginalValues(List<String> originalValues) {this.originalValues = originalValues;}
}
