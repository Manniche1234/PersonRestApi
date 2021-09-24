package dtos;

import entities.Address;
import entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    private Long id;
    private String fName;
    private String lName;
    private String phone;
    private Address address;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.fName = person.getfFirstName();
        this.lName = person.getlLastName();
        this.phone = person.getPhone();
        this.address = person.getAddress();
    }

    public PersonDTO() {
    }

    public PersonDTO(String fName, String lName, String phone, Address address) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = address;
    }

    public static List<PersonDTO> getDtos(List<Person> persons){
        List<PersonDTO> personDtos = new ArrayList();
        persons.forEach(pm->personDtos.add(new PersonDTO(pm)));
        return personDtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
