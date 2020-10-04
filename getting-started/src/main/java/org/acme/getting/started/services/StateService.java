package org.acme.getting.started.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.acme.getting.started.pages.PageRequest;
import org.acme.getting.started.repositories.StateRepository;

import io.quarkus.panache.common.Page;

@ApplicationScoped
public class StateService {

	@Inject
	StateRepository stateRepository;
	
	public Long count() {
		return stateRepository.count();
	}
	

	public Response getAll(PageRequest pageRequest) {
	    return Response
	    	.ok(stateRepository.findAll().page(Page.of(pageRequest.getPageNum(), pageRequest.getPageSize())).list())
			.build();
	}
}
