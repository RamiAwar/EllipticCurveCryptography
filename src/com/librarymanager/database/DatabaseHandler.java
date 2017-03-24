package com.librarymanager.database;

import java.sql.*;

/**
 * Created by ramiawar on 3/19/17.
 */
public class DatabaseHandler {

    private static DatabaseHandler handler;

    private static final String URL = "jdbc:mysql://34.206.52.140:3306/library_manager";
    private static Connection connection = null;
    private static Statement statement = null;

    private String username = "newuser";
    private String password = "password";

    public DatabaseHandler(){
        createConnection();
    }

    void createConnection(){
        try {
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query){
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public boolean executeAction(String query){
        try {
            statement = connection.createStatement();
            statement.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }



}
