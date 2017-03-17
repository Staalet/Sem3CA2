///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package rest;
//
//import entities.Person;
//import facade.FacadeCurrent;
//import io.restassured.RestAssured;
//import static io.restassured.RestAssured.given;
//import io.restassured.parsing.Parser;
//import java.util.List;
//import javax.persistence.Persistence;
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.CoreMatchers.hasItem;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author madsr
// */
//public class PersonResourceTest {
//
//    public PersonResourceTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//
//        Persistence.generateSchema("pu_test", null);
//
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = 8084;
//        RestAssured.basePath = "/Sem3CA2";
//        RestAssured.defaultParser = Parser.JSON;
//
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        FacadeCurrent fc = new FacadeCurrent(Persistence.createEntityManagerFactory("pu_test"));
//        Person p = new Person();
//        p.setFirstName("John");
//        p.setLastName("Doe");
//        p.setEmail("@gmail.com");
//        fc.addPerson(p);
//        System.out.println("Added person");
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void basicPingTest() {
//
//        given().when().get("/api/person/complete/1").then().statusCode(404);
//
//    }
//
//    @Test
//    public void getPerson() {
//        System.out.println("Flot ja");
//
//        given()
//                .when()
//                .get("/person/complete/1")
//                .then()
//                .body("Person.firstName", hasItem("bjarne"));
//
//        System.out.println("Ja flot");
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {}
//}
