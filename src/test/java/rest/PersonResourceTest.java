/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Person;
import facade.FacadeCurrent;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.util.List;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author madsr
 */
public class PersonResourceTest {

    public PersonResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
        Persistence.generateSchema("pu_test", null);
        
        

        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8084);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/Sem3CA2/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        FacadeCurrent fc = new FacadeCurrent(Persistence.createEntityManagerFactory("pu_test"));
        Person p = new Person();
        p.setFirstName("John");
        p.setLastName("Doe");
        p.setEmail("@gmail.com");
        fc.addPerson(p);
        System.out.println("Added person");
    }

    @After
    public void tearDown() {
    }
    
     @Test
    public void basicPingTest() {
        given().when().get("/api/person/complete/1").then().statusCode(200);
    }

    @Test
    public void getPerson() {
        System.out.println("Flot ja");

                given()
                .when()
                .get("/person/complete/1")
                .then()
                .body("Person.firstName", hasItem("John"));

        System.out.println("Ja flot");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
