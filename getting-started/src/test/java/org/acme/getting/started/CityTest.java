package org.acme.getting.started;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.acme.getting.started.entities.City;
import org.acme.getting.started.entities.State;
import org.acme.getting.started.repositories.CityRepository;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CityTest {

	@Inject
	CityRepository cityRepository;

	@Test
	public void testGetCity() {
		City city = new City(1L,"CityTest", new State(27L,"StateTest","RegionTest"));
		assertEquals("StateTest", city.getState().getName());
	}
	
	@Test
	public void testSetCity() {
		City city = new City(1L,"CityTest", new State(27L,"StateTest","RegionTest"));
		city.getState().setName("test2");
		assertEquals("test2", city.getState().getName());
	}
	
	@Test
	public void testCountService() {
		Long value = cityRepository.count();
		assertTrue(value > 0);
	}

	@Test
	public void testGetAllService() {
		List<City> cities = cityRepository.listAll();
		assertTrue(cities.size() > 0);
	}

	  @Test
	    public void testGetAllPagedEndpoint() {
	        given()
	          .when().get("/cities?pageNum=0&pageSize=1")
	          .then()
	             .statusCode(200);
	    }
	  
	  @Test
	    public void testPersistEndpoint() {
	        given()
	          .when().post("/cities")
	          .then() 
	             .statusCode(201)
	             .headers("Location", ("http://localhost:8080/cities/2"));
	    }
	  
	  @Test
	    public void testUpdateEndpoint() {
	        given()
	          .when().put("/cities/{id}", 1L)
	          .then() 
	             .statusCode(200);
	    }
	  
	  @Test
	    public void testDeleteEndpoint() {
	        given()
	          .when().delete("/cities/{id}", 1L)
	          .then() 
	             .statusCode(204);
	    }
	  
	  @Test
	    public void testGetAllByStateIdEndpoint() {
	        given()
	          .when().get("/cities/{id}", 1L)
	          .then() 
	             .statusCode(200);	
	    }
	  
	  @Test
	    public void testGetAllByCityNameEndpoint() {
	        given()
	          .when().get("/cities/find/{name}", "Surubim")
	          .then() 
	             .statusCode(200);	
	    }
}
