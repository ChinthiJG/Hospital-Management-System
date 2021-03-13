package GetSet;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mekhala Sewwandi
 */
public class Occupation {
    
    private String id;
    private String username;
    private String occupation;
    private String password;

    public Occupation(String id, String username, String occupation, String password) {
        this.id = id;
        this.username = username;
        this.occupation = occupation;
        this.password = password;
    }

    public Occupation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
