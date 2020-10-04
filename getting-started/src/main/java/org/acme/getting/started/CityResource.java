package org.acme.getting.started;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.getting.started.entities.City;
import org.acme.getting.started.services.CityService;

@Path("/cities")
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {

	@Inject
	CityService cityService;

	@GET
	@Path("/count")
	@Transactional
	public long count() {
		return cityService.count();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response persist(City city) {
		return cityService.persist(city);
	}

}
