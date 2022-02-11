package com.example.tretapp.data.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
    // Propiedades
    private static Connection conn = null;

    // Constructor
    private DataBaseConnector(){
        String HostDB = "ec2-52-215-225-178.eu-west-1.compute.amazonaws.com";
        String NameDB = "d79cdro40gck3o";
        String UserDB = "zutlupqmhkdaix";
        String PasswordDB = "98992e944e0d746882d3779e24919d815be96d5a7b05bed2ff143b464f4574ce";
        try{
            String url = "jdbc:postgresql://" + HostDB + ":5432/" + NameDB;
            conn = DriverManager.getConnection(url, UserDB, PasswordDB);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    } // Fin constructor

    // Métodos
    public static Connection getConnection(){
        if (conn == null){
            new DataBaseConnector();
        }
        return conn;
    } // Fin getConnection
}
