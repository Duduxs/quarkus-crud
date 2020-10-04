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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.getting.started.entities.City;
import org.acme.getting.started.pages.PageRequest;
import org.acme.getting.started.services.CityService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

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
	
	@GET
	@Transactional
	public Response getAll(@BeanParam PageRequest pageRequest) {
		return cityService.getAll(pageRequest);
	}
	
	@GET
	@Path("{id}")
	@Transactional
	public Response getAllByStateId(@PathParam("id")Long id, @BeanParam PageRequest pageRequest) {
		return cityService.getAllByStateId(id, pageRequest);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response persist(City city) {
		return cityService.persist(city);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Transactional
	public Response update(@PathParam("id")Long id, City city) {
		return cityService.update(id, city);
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public Response delete(@PathParam("id")Long id) {
		return cityService.delete(id);
	}

}
