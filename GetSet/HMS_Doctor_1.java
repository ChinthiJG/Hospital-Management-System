/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetSet;

/**
 *
 * @author Mekhala Sewwandi
 */
public class HMS_Doctor_1 extends User{
 
    String speciality;
    String assignedward;
    String room;

    public HMS_Doctor_1(String id, String firstname, String secondname, String nic, String gender, String age, String birthday, String mstatus, String phone, String address,String speciality, String assignedward, String room) {
        super(id, firstname, secondname, nic, gender, age, birthday, mstatus, phone, address);
        this.speciality = speciality;
        this.assignedward = assignedward;
        this.room = room;
    }
    
    public HMS_Doctor_1(){
        super();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAssignedward() {
        return assignedward;
    }

    public void setAssignedward(String assignedward) {
        this.assignedward = assignedward;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    
    
    
    
}
