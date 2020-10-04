package org.acme.getting.started.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.acme.getting.started.entities.City;
import org.acme.getting.started.repositories.CityRepository;
import org.acme.getting.started.repositories.StateRepository;

@ApplicationScoped
public class CityService {

	@Inject
	StateRepository stateRepository;

	@Inject
	CityRepository cityRepository;

	public long count() {
		return cityRepository.count();
	}

	public Response persist(City city) {
		if (stateRepository.findById(city.getState().getId()) == null)
			throw new WebApplicationException("State not found!", Response.Status.NOT_FOUND);

		cityRepository.persist(city);

		return Response.ok(city).status(Response.Status.CREATED).build();
	}

}
