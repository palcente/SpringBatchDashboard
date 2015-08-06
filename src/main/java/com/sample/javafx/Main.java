package com.sample.javafx;

import com.sample.javafx.config.SimpleBeanFactory;
import com.sample.javafx.config.SpringFxmlLoader;
import com.sample.javafx.scene.LoginScene;
import com.sample.javafx.util.SceneFactory;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;


public class Main extends Application {

    static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public void start(Stage stage) throws Exception{
        Application scene = SceneFactory.getSceneByName("LoginScene");
        scene.start(stage);
    }
    public static void main(String[] args) {
        launch(args);
        Runtime r=Runtime.getRuntime();
        r.addShutdownHook(new Thread(() -> {LOGGER.info("Shutting down");}));

    }
}

