/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Acer
 */
public class ConnectionDB {
    Connection conn = null;
    
    public void connection() throws ClassNotFoundException {
        setupConnection();
    }
    
    public void setupConnection() throws ClassNotFoundException{
        String host = "localhost";
        String user = "root";
        String pass = "";
        String dataBase = "hospital_cms_db";
        String driver = "com.mysql.jdbc.Driver";
        
        try {
            
            Class.forName(driver);
            
            String newConnectionURL = "jdbc:mysql://"+host+"/"+dataBase+"?"+"user="+user+"&password="+pass;
            conn = DriverManager.getConnection(newConnectionURL);
            
            System.out.println("Conectado!!");
         
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void closeConnection() {
        try {
            conn.close();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
