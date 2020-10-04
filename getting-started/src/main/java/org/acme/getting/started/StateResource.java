package org.acme.getting.started;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.getting.started.entities.State;
import org.acme.getting.started.services.StateService;

@Path("/states")
public class StateResource {

	@Inject
	StateService service;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<State> findAll() {
        return service.findAll();
    }
}
