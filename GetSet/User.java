
package GetSet;


public class User {
   
    String id;
    private String firstname;
    private String secondname;
    private String nic;
    private String gender;
    private String age;
    private String birthday;
    private String mstatus;
    private String phone;
    private String address;
    
    public User(String id, String firstname,String secondname,String nic,String gender,String age,String birthday,String mstatus,String phone,String address){
        this.id=id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.nic = nic;
        this.gender = gender;
        this.age=age;
        this.birthday=birthday;
        this.mstatus=mstatus;
        this.phone=phone;
        this.address=address;
    }

    public User() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondphone) {
        this.secondname = secondphone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

    
}
