/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Variables;

import ModelConnection.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class Patient extends Person {
    
    public String recidence_adress;
    public String age_group;

    public String getRecidence_adress() {
        return recidence_adress;
    }

    public String getAge_group() {
        return age_group;
    }

    public void setRecidence_adress(String recidence_adress) {
        this.recidence_adress = recidence_adress;
    }

    public void setAge_group(String age_group) {
        this.age_group = age_group;
    }

    public Patient(String recidence_adress, String age_group, int id, String id_type, String names, String lastNames, String birtDate, String phoneNumber, String gender) {
        super(id, id_type, names, lastNames, birtDate, phoneNumber, gender);
        this.recidence_adress = recidence_adress;
        this.age_group = age_group;
    }
    
     private static ConnectionDB connex = new ConnectionDB();
        
    public void insertPatient() throws SQLException {
        
        connex.setupConnection();
        String selection = "INSERT INTO `paciente`(`id_paciente`, `tipo_id`, `nombres_paciente`, `apellidos_paciente`, `fecha_nacimiente`, `direccion_residencia`, `num_celular`, `grupo_edad`, `genero_paciente`)"+ " VALUES (?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps = connex.conn.prepareStatement(selection);
        
        try{
            ps.setInt(1, id);
            ps.setString(2, id_type);
            ps.setString(3, names);
            ps.setString(4, lastNames);
            ps.setString(5, birtDate);
            ps.setString(6, recidence_adress);
            ps.setString(7, phoneNumber);
            ps.setString(8, age_group);
            ps.setString(9, gender);
            ps.executeUpdate();
        } catch(SQLException e) {
            System.err.println(e);
        } finally {
            connex.closeConnection();
            System.out.println("Conexion cerrada");
        }
    }
    
    public void updatePatient(int id, String id_type, String names, String lastNames, String birtDate, String recidence_adress, String phoneNumber, String age_group, String gender) throws SQLException {
        connex.setupConnection();
        String selection = "UPDATE `paciente` SET `tipo_id`='"+id_type+"',`nombres_paciente`='"+names+"',`apellidos_paciente`='"+lastNames+"',`fecha_nacimiente`='"+birtDate+"',`direccion_residencia`='"+recidence_adress+"',`num_celular`='"+phoneNumber+"',`grupo_edad`='"+age_group+"',`genero_paciente`='"+gender+"' WHERE `id_paciente`='"+id+"'";
       
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
