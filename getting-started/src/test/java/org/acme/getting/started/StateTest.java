package org.acme.getting.started;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.getting.started.entities.State;
import org.acme.getting.started.repositories.StateRepository;
import org.acme.getting.started.services.StateService;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class StateTest {

	@Inject
	StateRepository stateRepository;
	
	@Inject
	StateService stateService;
	
	@Test
	public void testGetRegion() {
		State state = new State(27L, "Test", "test");
		assertEquals("test", state.getRegion());
	}
	
	@Test
	public void testSetRegion() {
		State state = new State(27L, "Test", "test");
		state.setRegion("test2");
		assertEquals("test2", state.getRegion());
	}
	
	@Test
	public void testCountService() {
		Long value = stateRepository.count();
		assertTrue(value > 0);
	}

	@Test
	public void testGetAllService() {
		List<State> states = stateRepository.listAll();
		assertTrue(states.size() > 0);
	}

	@Test
	@Transactional
	public void testPersistService() {
		State state = new State(null,"StateTest", "RegionTest");
		stateRepository.persist(state);
		assertTrue(stateRepository.isPersistent(state));
	}

	@Test
	@Transactional
	public void testUpdateService() {
		State state = new State(null,"StateTest", "RegionTest");
		stateRepository.persist(state);

		// can i returned state from db?
		assertNotNull(stateRepository.find("name", state.getName()));

		State updateState = stateRepository.findById(20L);

		// updateState name and region must be equals to state.
		updateState.setName(state.getName());
		updateState.setRegion(state.getRegion());

		assertEquals(updateState.getName(), state.getName());
		assertEquals(updateState.getRegion(), state.getRegion());
	}

	@Test
	@Transactional
	public void testDeleteService() {
		State state = stateRepository.findById(20L);

		stateRepository.delete(state);
		// State must be removed at db.
		assertFalse(stateRepository.isPersistent(state));
	}
	
	  @Test
	    public void testCountEndpoint() {
	        given()
	          .when().get("/states/count")
	          .then()
	             .statusCode(200)
	             .body(is("27"));
	    }
	  
	  @Test
	    public void testGetAllPagedEndpoint() {
	        given()
	          .when().get("/states?pageNum=0&pageSize=1")
	          .then()
	             .statusCode(200);
	    }
	  
	  @Test
	    public void testPersistEndpoint() {
	        given()
	          .when().post("/states")
	          .then() 
	             .statusCode(201)
	             .headers("Location", ("http://localhost:8080/states/28"));
	    }
	  
	  @Test
	    public void testUpdateEndpoint() {
	        given()
	          .when().put("/states/{id}", 21L)
	          .then() 
	             .statusCode(200);
	    }
	  
	  @Test
	    public void testDeleteEndpoint() {
	        given()
	          .when().delete("/states/{id}", 21L)
	          .then() 
	             .statusCode(204);  	
	    }
}
