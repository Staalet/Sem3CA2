/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schemaCreater;

import entities.Person;
import facade.FacadeCurrent;
import javax.persistence.Persistence;

/**
 *
 * @author Staal
 */
public class testClass {
    public static void main(String[] args) {
        FacadeCurrent fc = new FacadeCurrent(Persistence.createEntityManagerFactory("pu"));
        Person p = new Person();
        p.setFirstName("bjarne");
        p.setLastName("bjarne");
        p.setEmail("sf@hej.com");       
        fc.addPerson(p);
        System.out.println("person added in database");
        
      
    }
}
