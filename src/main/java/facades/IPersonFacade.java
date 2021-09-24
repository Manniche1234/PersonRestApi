package facades;

import dtos.PersonDTO;
import errorhandling.PersonNotFoundException;

import java.util.List;

public interface IPersonFacade {
    public PersonDTO addPerson(String fName, String lName, String phone);
    public PersonDTO deletePerson(Long id) throws PersonNotFoundException;
    public PersonDTO getPerson(Long id) throws PersonNotFoundException;
    public List<PersonDTO> getAllPersons();
    public PersonDTO editPerson(PersonDTO p) throws PersonNotFoundException;
}
