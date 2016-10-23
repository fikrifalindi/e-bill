/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Fikri-Falndi
 */
public class DBConnection {
    
    private Connection connection = null;
    private Statement statement = null;
    private String driver = "org.sqlite.JDBC";
    private String url = "jdbc:sqlite:ebill.db";
    
    public DBConnection(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(true);
            statement = this.connection.createStatement();
//            System.out.println("Database Connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }
    }
    
    public Connection connect(){
        return connection;
    }
    
    public Statement statement(){
        return statement;
    }
    
}
