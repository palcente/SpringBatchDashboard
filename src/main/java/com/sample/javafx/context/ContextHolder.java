package com.sample.javafx.context;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;

/**
 * Created by matt on 01/08/2015.
 */
public class ContextHolder {

    private static ContextHolder instance = null;
    private static ApplicationContext context;

    private ContextHolder() {
    }

    public static ContextHolder getInstance() {
        if (instance == null) {
            return new ContextHolder();
        }
        return instance;
    }

    public static void init(ApplicationContext context) {
        if(context!=null){
            throw new RuntimeException("Context has already been initialized");
        }
        ContextHolder.context = context;
    }

    public static ApplicationContext getContext() {
        if (context == null) {
            throw new IllegalStateException("Context needs to be initialized explicitly");
        }
        return context;
    }
}
