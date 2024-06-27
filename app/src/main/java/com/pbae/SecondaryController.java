package com.pbae;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SecondaryController {

    @FXML
    private Canvas canvas;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("choixCarte");
    }

    @FXML
    public void initialize() {
        initDraw(canvas.getGraphicsContext2D());
    }

    private void initDraw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        // Ajouter des écouteurs d'événements pour dessiner à la main
        canvas.setOnMousePressed(e -> {
            gc.beginPath();
            gc.moveTo(e.getX(), e.getY());
            gc.stroke();
        });

        canvas.setOnMouseDragged(e -> {
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
        });
    }

}