package org.acme.getting.started;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.getting.started.entities.Client;
import org.acme.getting.started.services.ClientService;

@Path("/clients")
public class GreetingResource {

	@Inject
	private ClientService service;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> findAll() {
        return service.findAll();
    }
}
