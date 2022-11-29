package za.co.mecer.res;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import za.co.mecer.controller.LibraryController;
import za.co.mecer.modelImpl.Client;
import za.co.mecer.serviceimpl.ClientServiceImpl;
import za.co.mecer.services.ClientService;

/**
 *
 * @author Dimakatso Sebatane
 */
@Path("/app")
public class LibraryMapping {

    @GET
    public String greeting() {
        return "Hello There";
    }

    @GET
    @Path("/clients")
    public Response getClients() throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        ClientService clientService = new ClientServiceImpl();
        List<Client> clients = clientService.getClients();
        URI location = new URI("/library/clients");
        URI uri = UriBuilder.fromUri(location).queryParam("clients", clients).build();
        Response rb = Response.ok().entity(clients.toString()).location(location).build();
        return Response.seeOther(uri).build();
    }
}
