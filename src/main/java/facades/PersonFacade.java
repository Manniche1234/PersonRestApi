package facades;

import dtos.PersonDTO;
import entities.Person;
import errorhandling.ExceptionDTO;
import errorhandling.PersonNotFoundException;

import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade implements IPersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {
    }


    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    @Override
    public PersonDTO addPerson(String fName, String lName, String phone) {
        EntityManager em = emf.createEntityManager();
        PersonDTO personDTO = new PersonDTO(fName, lName, phone);
        Person person = new Person(personDTO);
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return new PersonDTO(person);
        } finally {
            em.close();
        }

    }

    @Override
    public PersonDTO deletePerson(Long id) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            Person p = em.find(Person.class, id);
            if (p == null) {
                throw new PersonNotFoundException("Person not found");
            } else {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
                return new PersonDTO(p);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO getPerson(Long id) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            Person person = em.find(Person.class, id);
            if (person == null) {
                throw new PersonNotFoundException("Person not found");
            } else {
                return new PersonDTO(person);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> persons = query.getResultList();
            List<PersonDTO> personDTOS = PersonDTO.getDtos(persons);
            return personDTOS;
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO editPerson(PersonDTO p) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            if(em.find(Person.class,p.getId())==null){
                throw new PersonNotFoundException("Person not found");
            }else {
                Person person = em.merge(new Person(p));
                return new PersonDTO(person);
            }

        } finally {
            em.close();
        }
    }


}
