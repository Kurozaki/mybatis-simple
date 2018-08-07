package com.yotwei.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by YotWei on 2018/8/7.
 */
public class ConnectionManager {

    public static Connection get() throws SQLException {
        return DriverManager.getConnection(
                Config.DEFAULT.getUrl(),
                Config.DEFAULT.getUser(),
                Config.DEFAULT.getPwd()
        );
    }
}
