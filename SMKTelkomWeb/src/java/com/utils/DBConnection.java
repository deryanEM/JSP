/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dibaj
 */
public class DBConnection {
    
    private Connection conn = null;
    private static DBConnection dBConn = null;
    static final String DB_URL = "jdbc:mysql://localhost:3306/db";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    private DBConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static DBConnection getInstance() {
        DBConnection conn = null;
        if (dBConn == null) {
            dBConn = new DBConnection();
            conn = dBConn;
        } else {
            conn = dBConn;
        }
        return conn;
    }

    public Connection getCon() throws SQLException {
        return this.conn;
    }
    
}
