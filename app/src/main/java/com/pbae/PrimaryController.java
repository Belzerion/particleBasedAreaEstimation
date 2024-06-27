package com.pbae;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController {

    private Stage stage;

    public void setStage(final Stage stage)
    {
        this.stage = stage;
    }

    @FXML
    private Button loadMapButton;

    @FXML
    private void loadMap() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("choose the map");
        File mapFile = fileChooser.showOpenDialog(stage);

        if (mapFile != null)
        {
            
        }
    }


}
