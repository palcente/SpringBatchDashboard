package com.sample.javafx.util;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by matt on 03/08/2015.
 */
public abstract class DBTask<T> extends Task<T> {
    static Logger LOGGER = LoggerFactory.getLogger(DBTask.class);
    public DBTask() {
        setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override public void handle(WorkerStateEvent t) {
                LOGGER.error(getException().getMessage());
            }
        });
    }
}
