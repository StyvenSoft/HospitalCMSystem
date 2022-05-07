/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Variables;

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
    
    
    
}
