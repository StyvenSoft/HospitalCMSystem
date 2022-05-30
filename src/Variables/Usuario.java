/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Variables;

import ModelConnection.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Acer
 */
public class Usuario {
    private String username;
    private String user_type;
    private String password;
    private String state;
    
    public Usuario() {
        
    }

    public Usuario(String username, String user_type, String password, String state) {
        this.username = username;
        this.user_type = user_type;
        this.password = password;
        this.state = state;
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
    
    public void insertUser() throws SQLException {
        
        connex.setupConnection();
        String selection = "INSERT INTO `usuario`(`nombre_usuario`, `tipo_usuario`, `password`, `estado`)"+ " VALUES (?,?,?,?)";
        
        PreparedStatement ps = connex.conn.prepareStatement(selection);
        
        try{
            ps.setString(1, username);
            ps.setString(2, user_type);
            ps.setString(3, password);
            ps.setString(4, state);
            ps.executeUpdate();
        } catch(SQLException e) {
            System.err.println(e);
        } finally {
            connex.closeConnection();
            System.out.println("Conexion cerrada");
        }
    }
    
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
                    
                    //usr.setId_user(rs.getInt(1));
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
