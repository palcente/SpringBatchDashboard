package com.sample.javafx.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by matt on 03/08/2015.
 */
public class DatabaseThreadFactory implements ThreadFactory{

    static final AtomicInteger poolNumber = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "Database-Connection-" + poolNumber.getAndIncrement() + "-thread");
        thread.setDaemon(true);
        return thread;
    }
}
