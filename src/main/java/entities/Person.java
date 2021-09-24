package entities;

import dtos.PersonDTO;

import javax.persistence.*;
import java.util.Date;

@Table(name = "person")
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private Date created;
    private Date lastEdited;


    public Person(PersonDTO personDTO) {
        this.id = personDTO.getId();
        this.firstName = personDTO.getfName();
        this.lastName = personDTO.getlName();
        this.phone = personDTO.getPhone();
        this.created = new Date();
        this.lastEdited = new Date();
    }

    public Person() {
    }

    public Person(String fName, String lName, String phone, Date created, Date lastEdited) {
        this.firstName = fName;
        this.lastName = lName;
        this.phone = phone;
        this.created = created;
        this.lastEdited = lastEdited;
    }

    public String getfFirstName() {
        return firstName;
    }

    public void setfFirstName(String fName) {
        this.firstName = fName;
    }

    public String getlLastName() {
        return lastName;
    }

    public void setlLastName(String lName) {
        this.lastName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}