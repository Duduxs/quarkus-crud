package org.acme.getting.started.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.getting.started.entities.State;
import org.acme.getting.started.repositories.StateRepository;


@ApplicationScoped
public class StateService {

	@Inject
	StateRepository stateRepository;
	
	@Transactional
	public List<State> findAll(){
		return stateRepository.findAll();
	}
}
