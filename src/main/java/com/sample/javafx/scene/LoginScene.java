package com.sample.javafx.scene;

import com.sample.javafx.config.SpringFxmlLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by matt on 01/08/2015.
 */
public class LoginScene extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        SpringFxmlLoader loader = new SpringFxmlLoader();
        Parent root = (Parent) loader.load("/fxml/login.fxml");
        Scene scene = new Scene(root, 420, 220);
        stage.setScene(scene);
        stage.setTitle("Spring Batch Dashboard");
        stage.show();
    }
}
