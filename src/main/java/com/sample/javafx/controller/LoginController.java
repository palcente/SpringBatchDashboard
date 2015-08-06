package com.sample.javafx.controller;

/**
 * Created by matt on 31/07/2015.
 */
import com.sample.javafx.controller.task.AuthenticateTask;
import com.sample.javafx.util.DBTask;
import com.sample.javafx.util.DatabaseThreadFactory;
import com.sample.javafx.util.SceneFactory;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configurable
public class LoginController {

    static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    DriverManagerDataSource dataSource;

    @FXML
    private Label errorMessage;
    @FXML
    private TextField addressField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button login;



    private void openDashboard() {
        try {
            Stage stage = (Stage) errorMessage.getScene().getWindow();
            Application scene = SceneFactory.getSceneByName("DashBoardScene");
            scene.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ExecutorService databaseExecutor = Executors.newFixedThreadPool(
            1,
            new DatabaseThreadFactory()
    );
    public void authenticate(){
        String address = addressField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        dataSource.setUrl(address);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        final AuthenticateTask authTask = new AuthenticateTask(dataSource);
        login.setDisable(true);

        authTask.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                errorMessage.setText(authTask.getException().getMessage());
            }
        });

        authTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                openDashboard();
            }

        });
        authTask.runningProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean wasRunning, Boolean isRunning) {
                if (!isRunning) {
                    login.setDisable(false);
                }
            }
        });
        databaseExecutor.submit(authTask);
    }

}