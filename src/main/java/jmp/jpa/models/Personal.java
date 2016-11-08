package jmp.jpa.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 06.11.2016.
 */
@Entity
public class Personal {

    @Id
    @GeneratedValue
    private String id;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

}
