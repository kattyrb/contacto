package sunat.resources;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import sunat.api.Result;
import sunat.db.ContactDAO;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@PermitAll
@Path("contacto-service")
@Produces(MediaType.APPLICATION_JSON)

public class ContactoResource {
    private ContactDAO contactDAO;

    public ContactoResource(ContactDAO contactDAO) {
        this.contactDAO=contactDAO;
    }


    @GET
    @Path("/lista/")
    @UnitOfWork
    public Result listarContactos() {
        List listContactos = contactDAO.getAll();

        return new Result(listContactos.size(),"success");
    }
}
