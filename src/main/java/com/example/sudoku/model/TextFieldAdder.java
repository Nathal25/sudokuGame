package com.example.sudoku.model;

import javafx.scene.control.TextField;


public class TextFieldAdder {
    private String id;
    private TextField textField;

    public TextFieldAdder(String id) {
        this.id=id;
        textField = new TextField();
        textField.setEditable(false);
        textField.setMaxWidth(37);
        textField.setMaxHeight(37);
    }
    public TextField getTextField() {return textField;}

    public void setTextField(TextField textField) {this.textField = textField;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

}
