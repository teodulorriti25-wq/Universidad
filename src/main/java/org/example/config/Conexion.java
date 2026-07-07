package org.example.config;

import java.sql.*;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/Universidad";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion correctamente establecida");
        } catch (SQLException e) {
            e.getMessage();
        }
        return conn;
    }
}
