package com.sample.javafx.scene;

import com.sample.javafx.config.SpringFxmlLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by matt on 01/08/2015.
 */
public class DashBoardScene extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
            SpringFxmlLoader loader = new SpringFxmlLoader();
            Parent root = (Parent) loader.load("/fxml/dashboard.fxml");
            Scene scene = new Scene(root, 1200,800 );
            stage.setScene(scene);
            stage.setTitle("Spring Batch Dashboard");
            stage.show();
        }
    }
