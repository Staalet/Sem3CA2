/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception.mappers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.AddressNotFoundException;
import exception.ErrorMessage;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author christian
 */
public class AddressNotFoundMapper implements ExceptionMapper<exception.AddressNotFoundException>{

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public Response toResponse(AddressNotFoundException e) {
        ErrorMessage errMsg = new ErrorMessage(404, e.getMessage());
        return Response.status(404)
                .entity(gson.toJson(errMsg))
                .type(MediaType.APPLICATION_JSON).build();
    }
    
}
