/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Variables;

/**
 *
 * @author Acer
 */
public class Person {
    
    public int id;
    public String id_type;
    public String names;
    public String lastNames;
    public String birtDate;
    public String phoneNumber;
    public String gender;

    public void setId(int id) {
        this.id = id;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public void setBirtDate(String birtDate) {
        this.birtDate = birtDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getId_type() {
        return id_type;
    }

    public String getNames() {
        return names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public String getBirtDate() {
        return birtDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public Person(int id, String id_type, String names, String lastNames, String birtDate, String phoneNumber, String gender) {
        this.id = id;
        this.id_type = id_type;
        this.names = names;
        this.lastNames = lastNames;
        this.birtDate = birtDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    
    
}
