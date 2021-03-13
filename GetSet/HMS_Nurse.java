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
public class HMS_Nurse extends User{
 
    String qualification;
    String assignedward;

    public HMS_Nurse(String id, String firstname, String secondname, String nic, String gender, String age, String birthday, String mstatus, String phone, String address,String qualification, String assignedward) {
        super(id, firstname, secondname, nic, gender, age, birthday, mstatus, phone, address);
        this.qualification = qualification;
        this.assignedward = assignedward;
    }

    public HMS_Nurse() {
        super();
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAssignedward() {
        return assignedward;
    }

    public void setAssignedward(String assignedward) {
        this.assignedward = assignedward;
    }
    
    
    
    
    
    
}
