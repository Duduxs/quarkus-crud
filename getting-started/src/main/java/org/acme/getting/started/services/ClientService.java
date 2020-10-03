package org.acme.getting.started.services;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.getting.started.entities.Client;

@ApplicationScoped
public class ClientService {

	public List<Client> findAll(){
		return Arrays.asList( 
				new Client(1L,"Dudu","Duduxss3@gmail.com"),
				new Client(2L,"Maria","Maria@hotmail.com"
			));
	}
}
