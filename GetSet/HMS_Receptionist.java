
package GetSet;

/**
 *
 * @author Mekhala Sewwandi
 */
public class HMS_Receptionist extends User{
    
    String experience;
    String startDate;

    public HMS_Receptionist(String experience, String startDate, String id, String firstname, String secondname, String nic, String gender, String age, String birthday, String mstatus, String phone, String address) {
        super(id, firstname, secondname, nic, gender, age, birthday, mstatus, phone, address);
        this.experience = experience;
        this.startDate = startDate;
    }

    public HMS_Receptionist() {
        super();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    
    
    
    
    
}
