/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockitio;

import entities.Person;
import exception.PersonNotFoundException;
import facade.FacadeCurrent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import rest.PersonResource;
import schemaCreater.CreateSchema;

/**
 *
 * @author Staal
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    private EntityManagerFactory emf;

    @Mock
    CreateSchema cs;

    @Mock
    PersonResource pr;

    @InjectMocks
    FacadeCurrent f = new FacadeCurrent(emf);

    @Test
    public void getPersonsTest() throws PersonNotFoundException {

        EntityManager em = emf.createEntityManager();
        Person p = new Person();

//        String jsonPerson = "{\n"
//                + "  \"firstName\": \"bjarne\",\n"
//                + "  \"lastName\": \"bjarne\",\n"
//                + "  \"hobbies\": [],\n"
//                + "  \"id\": 2,\n"
//                + "  \"email\": \"sf@hej.com\",\n"
//                + "  \"phones\": []\n"
//                + "}";
        
        when(em.find(Person.class, p.getId())).thenReturn(p);
        
        assertThat(f.getPerson(1), instanceOf(Person.class));
  

        verify(f).getPerson(1);

    }

}
