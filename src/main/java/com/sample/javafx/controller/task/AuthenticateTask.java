package com.sample.javafx.controller.task;

import com.sample.javafx.util.DBTask;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by matt on 04/08/2015.
 */
public class AuthenticateTask extends DBTask<Boolean> {

    private final DataSource dataSource;

    public AuthenticateTask(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    protected Boolean call() throws Exception {
        Connection conn = dataSource.getConnection();
        conn.close();
        return true;
    }
}