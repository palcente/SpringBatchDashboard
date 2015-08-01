package com.sample.javafx;

import com.sample.javafx.config.SimpleBeanFactory;
import com.sample.javafx.config.SpringFxmlLoader;
import com.sample.javafx.controller.LoginController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;


public class Main extends Application {

    static Logger LOGGER = LoggerFactory.getLogger(Main.class);


    @Override
    public void start(Stage stage) throws Exception{
/*      Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        Button btn = new Button();
        btn.setText("I'm the button");
        btn.setOnAction((event) -> System.out.println("aaaa"));
        primaryStage.show();*/

        SpringFxmlLoader loader = new SpringFxmlLoader();
        Parent root = (Parent) loader.load("/fxml/login.fxml");
        Scene scene = new Scene(root, 320, 240);
        stage.setScene(scene);
        stage.setTitle("Spring Batch Dashboard");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
        Runtime r=Runtime.getRuntime();

        r.addShutdownHook(new Thread(() -> LOGGER.info("Shutdown Hook Releases JDBC Connections")));

    }
}

