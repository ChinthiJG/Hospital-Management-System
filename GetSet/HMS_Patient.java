/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetSet;

/**
 *
 * @author Chinthaka
 */
public class HMS_Patient extends User{
    String bloodgroup;
    String wardno;
    String bedno;
    String description;
    String date;
    
    public HMS_Patient(String id, String firstname,String secondname,String nic,String gender,String age,String birthday,String mstatus,String phone,String address, String bloodgroup,String wardno,String bedno,String description,String date){
        super(id,firstname,secondname,nic, gender, age, birthday, mstatus, phone, address);
        this.bloodgroup= bloodgroup;
        this.wardno = wardno;
        this.bedno=bedno;
        this.description=description;
        this.date=date;
        
    }
    public HMS_Patient(){
    super();
}

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getWardno() {
        return wardno;
    }

    public void setWardno(String wardno) {
        this.wardno = wardno;
    }

    public String getBedno() {
        return bedno;
    }

    public void setBedno(String bedno) {
        this.bedno = bedno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
   
   
    
}
