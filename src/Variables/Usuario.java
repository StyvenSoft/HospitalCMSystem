/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Variables;

import ModelConnection.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Usuario {
    private int id_user;
    private String username;
    private String user_type;
    private String password;
    private String state;
    
    public Usuario() {
        
    }

    public Usuario(int id_user, String username, String user_type, String password, String state) {
        this.id_user = id_user;
        this.username = username;
        this.user_type = user_type;
        this.password = password;
        this.state = state;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    private static ConnectionDB connex = new ConnectionDB();
    
    public boolean loginn(Usuario usr) {
        
        PreparedStatement ps;
        ResultSet rs;
        connex.setupConnection();
        
        String sql = "SELECT * FROM `usuario` WHERE `nombre_usuario` =?";
        
        try{
            ps = connex.conn.prepareStatement(sql);
            ps.setString(1, usr.getUsername());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString(4))) {
                    
                    usr.setId_user(rs.getInt(1));
                    usr.setUsername(rs.getString(2));
                    usr.setUser_type(rs.getString(3));
                    usr.setPassword(rs.getString(4));
                    usr.setState(rs.getString(5));
                    
                    return true;
                } else {
                    return false;
                }
            }
        } catch(SQLException ex) {
            System.err.println(ex);
            return false;
        }
        
        return false;
        
    }
}
