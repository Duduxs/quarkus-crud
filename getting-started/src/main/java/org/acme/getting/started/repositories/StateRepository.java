package org.acme.getting.started.repositories;

import javax.enterprise.context.ApplicationScoped;

import org.acme.getting.started.entities.State;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StateRepository implements PanacheRepository<State>{


}
