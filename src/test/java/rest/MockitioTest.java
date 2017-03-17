/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Person;
import facade.FacadeCurrent;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import schemaCreater.CreateSchema;

/**
 *
 * @author Staal
 */
public class MockitioTest {
    
     @RunWith(MockitoJUnitRunner.class)
    public class MockitoTest {

        @Mock
        Person p;
        
        @Mock
        CreateSchema cs;

        @Mock
        PersonResource pr;
        
        @Mock
        FacadeCurrent fc;
    
}
}
