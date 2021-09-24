package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import errorhandling.PersonNotFoundException;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import java.util.List;


@Path("/person")
public class PersonResource {
    private final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final PersonFacade pf = PersonFacade.getPersonFacade(EMF);


    @GET
    @Produces("application/json")
    public String getAllPersons() {
        List<PersonDTO> personDTOS = pf.getAllPersons();

        return GSON.toJson(personDTOS);
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String createPerson(String person){
        PersonDTO personDTO = GSON.fromJson(person,PersonDTO.class);
        PersonDTO personDTO1 = pf.addPerson(personDTO.getfName(),personDTO.getlName(),personDTO.getPhone());

        return GSON.toJson(personDTO1);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getPersonById(@PathParam("id") Long id)throws PersonNotFoundException{
        PersonDTO personDTO = pf.getPerson(id);

        return GSON.toJson(personDTO);
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public String editPerson(String id)throws PersonNotFoundException {
        PersonDTO personDTO = GSON.fromJson(id,PersonDTO.class);
        PersonDTO personDTO1 = pf.editPerson(personDTO);

        return GSON.toJson(personDTO1);
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public String deletePerson(@PathParam("id")Long id)throws PersonNotFoundException{
        PersonDTO personDTO1 = pf.deletePerson(id);

        return GSON.toJson(personDTO1);
    }
}