package com.example.sudoku.view.alert;

public interface IAlertBox {
    void showMessage(String title, String header, String content);

    void showMessageWinner(String title, String header, String content);

    void showMessageLoser(String title, String header, String content);
}
