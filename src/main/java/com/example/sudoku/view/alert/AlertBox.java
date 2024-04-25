package com.example.sudoku.view.alert;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class AlertBox implements IAlertBox{
    @Override
    public void showMessage(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void showMessageWinner(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setGraphic(new ImageView(String.valueOf(getClass().getResource("/com/example/sudoku/image/winnerIcon.png"))));
        alert.showAndWait();
    }
    @Override
    public void showMessageLoser(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setGraphic(new ImageView(String.valueOf(getClass().getResource("/com/example/sudoku/image/tryAgainIcon.png"))));
        alert.showAndWait();
    }
}
