package org.acme.getting.started.repositories;

import org.acme.getting.started.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long>{

}
