/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Person;
import facade.FacadeCurrent;
import static groovy.xml.Entity.times;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import static org.hamcrest.Matchers.containsString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import schemaCreater.CreateSchema;

/**
 *
 * @author madsr
 */
public class PersonResourceTest {

    private static FacadeCurrent fc;

    public PersonResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        fc = new FacadeCurrent(Persistence.createEntityManagerFactory("pu_test"));
        Persistence.generateSchema("pu_test", null);

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/Sem3CA2/";
        RestAssured.defaultParser = Parser.JSON;

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Persistence.createEntityManagerFactory("pu_test");
        Person p = new Person();
        p.setFirstName("John");
        p.setLastName("Doe");
        p.setEmail("@gmail.com");
        fc.addPerson(p);
        System.out.println("Added person");
    }

    @After
    public void tearDown() {
        Persistence.createEntityManagerFactory("pu_test");
        fc.deletePerson(1);
    }

    @Test
    public void getPerson() {
        given().when().get("/api/person/complete/1").then().statusCode(200);
    }
    
}
