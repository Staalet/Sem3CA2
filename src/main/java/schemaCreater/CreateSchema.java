/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schemaCreater;

import javax.persistence.Persistence;

/**
 *
 * @author Staal
 */
public class CreateSchema {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("pu");
        Persistence.generateSchema("pu", null);
    }
}
