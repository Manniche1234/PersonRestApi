package facades;

import dtos.PersonDTO;
import entities.Address;
import errorhandling.PersonNotFoundException;

import java.util.List;

public interface IPersonFacade {
    public PersonDTO addPerson(String fName, String lName, String phone, Address address);
    public PersonDTO deletePerson(Long id) throws PersonNotFoundException;
    public PersonDTO getPerson(Long id) throws PersonNotFoundException;
    public List<PersonDTO> getAllPersons();
    public PersonDTO editPerson(PersonDTO p) throws PersonNotFoundException;
}
