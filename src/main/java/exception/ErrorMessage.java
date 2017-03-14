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
public class ErrorMessage {
    private int code; //<-- Hvad sker der hvis du ikke skriver public eller private på.
    private String eMsg;

    public ErrorMessage(int code, String eMsg) {
        this.code = code;
        this.eMsg = eMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String geteMsg() {
        return eMsg;
    }

    public void seteMsg(String eMsg) {
        this.eMsg = eMsg;
    }
   
}
