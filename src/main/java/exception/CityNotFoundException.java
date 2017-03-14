/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author christian
 */
public class CityNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>CityNotFoundException</code> without
     * detail message.
     */
    public CityNotFoundException() {
    }

    /**
     * Constructs an instance of <code>CityNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CityNotFoundException(String msg) {
        super(msg);
    }
}
