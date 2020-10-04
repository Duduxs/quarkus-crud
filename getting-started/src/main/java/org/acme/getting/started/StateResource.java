package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.getting.started.pages.PageRequest;
import org.acme.getting.started.services.StateService;

@Path("/states")
@Produces(MediaType.APPLICATION_JSON)
public class StateResource {

	@Inject
	StateService stateService;

	@GET
	@Path("/count")
	public long count() {
		return stateService.count();
	}

	@GET
	public Response getAll(@BeanParam PageRequest pageRequest) {
		return stateService.getAll(pageRequest);
	}

}
