package com.sample.javafx.config;

/**
 * Created by matt on 31/07/2015.
 */

import com.sample.javafx.controller.LoginController;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SimpleBeanFactory {
    static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SimpleBeanFactory.class);

    @Autowired
    ApplicationContext context;

    @Bean
    public LoginController loginController() {
        LOGGER.trace("loginController fetched");
        return new LoginController();
    }

    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        LOGGER.trace("DriverManagerDataSource fetched");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        return dataSource;
    }

    @Bean
    public ApplicationContext applicationContext(){
        return this.context;
    }
}
