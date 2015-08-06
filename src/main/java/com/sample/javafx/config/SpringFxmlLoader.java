package com.sample.javafx.config;

/**
 * Created by matt on 31/07/2015.
 */
import com.sample.javafx.context.ContextHolder;
import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

@Configurable
public class SpringFxmlLoader {

    private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SimpleBeanFactory.class);

    public Object load(String url) {
        try (InputStream fxmlStream = SpringFxmlLoader.class
                .getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> clazz) {
                    return applicationContext.getBean(clazz);
                }
            });
            return loader.load(fxmlStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}