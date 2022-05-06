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
        
    public void setupConnection(){
        
        String dataBase = "hospital_cms_db";
        String url = "jdbc:mysql://localhost:3307/"+dataBase;
        String user = "root";
        String pass = "";
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado!!");
         
        }catch(SQLException e){
            System.out.println("Error" + e.getMessage());
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
