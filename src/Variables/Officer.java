/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Variables;

import ModelConnection.ConnectionDB;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class Officer extends Person {
    
    public String officer_type;
    public String email;
    public String profession;

    public String getOfficer_type() {
        return officer_type;
    }

    public String getEmail() {
        return email;
    }

    public String getProfession() {
        return profession;
    }

    public void setOfficer_type(String officer_type) {
        this.officer_type = officer_type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Officer(String officer_type, String email, String profession, int id, String id_type, String names, String lastNames, String birtDate, String phoneNumber, String gender) {
        super(id, id_type, names, lastNames, birtDate, phoneNumber, gender);
        this.officer_type = officer_type;
        this.email = email;
        this.profession = profession;
    }
    
    private static ConnectionDB connex = new ConnectionDB();
        
    public void insertOfficer() throws SQLException {
        
        connex.setupConnection();
        String selection = "INSERT INTO `funcionario`(`id_funcionario`, `tipo_id`, `nombres_funcionario`, `apellidos_funcionario`, `tipo_funcionario`, `fecha_nacimiento`, `correo_electronico`, `profesion`, `num_celular`, `genero`)"+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = connex.conn.prepareStatement(selection);
        
        try{
            ps.setInt(1, id);
            ps.setString(2, id_type);
            ps.setString(3, names);
            ps.setString(4, lastNames);
            ps.setString(5, officer_type);
            ps.setString(6, birtDate);
            ps.setString(7, email);
            ps.setString(8, profession);
            ps.setString(9, phoneNumber);
            ps.setString(10, gender);
            ps.executeUpdate();
        } catch(SQLException e) {
            System.err.println(e);
        } finally {
            connex.closeConnection();
            System.out.println("Conexion cerrada");
        }
        
    }
    
    public void updateOfficer() throws SQLException {
        connex.setupConnection();
        String selection = "UPDATE `funcionario` SET `id_funcionario`=?,`tipo_id`=?,`nombres_funcionario`=?,`apellidos_funcionario`=?,`tipo_funcionario`=?,`fecha_nacimiento`=?,`correo_electronico`=?,`profesion`=?,`num_celular`=?,`genero`=? WHERE `id_funcionario`=?";
        
        PreparedStatement ps = connex.conn.prepareStatement(selection);
        
        try{
            ps.executeUpdate(selection);
        } catch(SQLException e) {
            System.err.println(e);
        } finally {
            connex.closeConnection();
            System.out.println("Conexion cerrada");
        }
    }
}
