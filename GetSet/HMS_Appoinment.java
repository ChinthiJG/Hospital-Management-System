/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetSet;

/**
 *
 * @author ASUS
 */
public class HMS_Appoinment {
    
    String appoinmentno;
    private String doctorno;
    private String doctorname;
    
    private String date;
    private String time;
    private String patientname;
    private String age;
    private String phone;
    private String description;

    public HMS_Appoinment(String appoinmentno, String doctorno,String doctorname, String date, String time, String patientname, String age, String phone, String description) {
        this.appoinmentno = appoinmentno;
        this.doctorno = doctorno;
        this.doctorname=doctorname;
        this.date = date;
        this.time = time;
        this.patientname = patientname;
        this.age = age;
        this.phone = phone;
        this.description = description;
    }

    public HMS_Appoinment() {
    
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    

    public String getAppoinmentno() {
        return appoinmentno;
    }

    public void setAppoinmentno(String appoinmentno) {
        this.appoinmentno = appoinmentno;
    }

    public String getDoctorno() {
        return doctorno;
    }

    public void setDoctorno(String doctorno) {
        this.doctorno = doctorno;
    }

   

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }        
    
}
