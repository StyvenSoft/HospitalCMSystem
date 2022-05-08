/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Variables;

import ModelConnection.ConnectionDB;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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
        
        String selection = "INSERT INTO `funcionario`(`id_funcionario`, `tipo_id`, `numero_id_funcionario`, `nombres_funcionario`, `apellidos_funcionario`, `tipo_funcionario`, `fecha_nacimiento`, `correo_electronico`, `profesion`, `num_celular`, `genero`)"
                + " VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement preStat = connex.conn.PreparedStatement(selection);
        preStat.setString(1, officer_type);
        
    }
    
    
    
    
}
