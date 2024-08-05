package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    Connection conn = null;

    public DBConnect(String URL, String userName, String pass) {
        try {
            // Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Connect
            conn = DriverManager.getConnection(URL, userName, pass);
            System.out.println("Connection successful");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, "Driver not found", ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, "Failed to connect to the database", ex);
        }
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        Statement state;
        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, "Failed to execute query", e);
        }
        return rs;
    }

    public DBConnect() {
        this("jdbc:sqlserver://localhost:1433;databaseName=CarMarket1_0", "sa", "123456");
    }

    public static void main(String[] args) {
        new DBConnect();
    }
}


