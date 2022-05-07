/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Variables;

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
    
    
}
