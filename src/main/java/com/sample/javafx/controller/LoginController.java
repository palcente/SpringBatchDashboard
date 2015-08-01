package com.sample.javafx.controller;

/**
 * Created by matt on 31/07/2015.
 */
import com.sample.javafx.config.SpringFxmlLoader;
import com.sample.javafx.model.Authentication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Configurable
public class LoginController {

    static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    ApplicationContext context;
    @Autowired
    DriverManagerDataSource dataSource;

    @FXML
    private Text errorMessage;
    @FXML
    private TextField addressField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;


    public void print()
    {
        String address = addressField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        DataSource dataSource= getDataSource(username, password, address);
    }


    private DataSource getDataSource(String username, String password, String url){
        LOGGER.trace("Getting Data Source {} {} {}", username, password, url);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        try {
            Connection conn = dataSource.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}