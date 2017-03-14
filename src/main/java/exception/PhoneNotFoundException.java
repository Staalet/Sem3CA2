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
public class PhoneNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>PhoneNotFoundException</code> without
     * detail message.
     */
    public PhoneNotFoundException() {
    }

    /**
     * Constructs an instance of <code>PhoneNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PhoneNotFoundException(String msg) {
        super(msg);
    }
}
