package com.example.tretapp.data;

import java.sql.Connection;

public class DataBaseFunctions {
    private final Connection conn;

    public DataBaseFunctions(Connection connection){
        this.conn = DataBaseConnector.getConnection();
    }
}
