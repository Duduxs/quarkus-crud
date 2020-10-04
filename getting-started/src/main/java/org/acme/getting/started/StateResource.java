package org.acme.getting.started;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.acme.getting.started.entities.State;
import org.acme.getting.started.pages.PageRequest;
import org.acme.getting.started.services.StateService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/states")
@Produces(MediaType.APPLICATION_JSON)
public class StateResource {

	@Context
	UriInfo uriInfo;

	@Inject
	StateService stateService;
	
	@GET
	@Path("/count")
	@Transactional
	public long count() {
		return stateService.count();
	}

	@GET
	@Transactional
	public Response getAll(@BeanParam PageRequest pageRequest) {
		return stateService.getAll(pageRequest);
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response persist(State state) {
		return stateService.persist(state, uriInfo);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Transactional
	public Response update(@PathParam("id")Long id, State state) {
		return stateService.update(id, state);
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public Response delete(@PathParam("id")Long id) {
		return stateService.delete(id);
	}

}
