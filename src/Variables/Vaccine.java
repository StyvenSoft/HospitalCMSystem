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
public class Vaccine {
    
    private int id_vaccine;
    private String vaccine_name;
    private String vaccine_type;
    private String expiration_date;

    public int getId_vaccine() {
        return id_vaccine;
    }

    public void setId_vaccine(int id_vaccine) {
        this.id_vaccine = id_vaccine;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        this.vaccine_name = vaccine_name;
    }

    public String getVaccine_type() {
        return vaccine_type;
    }

    public void setVaccine_type(String vaccine_type) {
        this.vaccine_type = vaccine_type;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Vaccine(int id_vaccine, String vaccine_name, String vaccine_type, String expiration_date) {
        this.id_vaccine = id_vaccine;
        this.vaccine_name = vaccine_name;
        this.vaccine_type = vaccine_type;
        this.expiration_date = expiration_date;
    }
    
    private static ConnectionDB connex = new ConnectionDB();
    
    public void insertVaccine() throws SQLException {
        
        connex.setupConnection();
        String selection = "INSERT INTO `vacuna`(`id_vacuna`, `nombre_vacuna`, `tipo_vacuna`, `fecha_vencimiento`)"+ " VALUES (?,?,?,?)";
        
        PreparedStatement ps = connex.conn.prepareStatement(selection);
        
        try{
            ps.setInt(1, id_vaccine);
            ps.setString(2, vaccine_name);
            ps.setString(3, vaccine_type);
            ps.setString(4, expiration_date);
            ps.executeUpdate();
        } catch(SQLException e) {
            System.err.println(e);
        } finally {
            connex.closeConnection();
            System.out.println("Conexion cerrada");
        }
    }
    
}
