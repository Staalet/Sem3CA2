/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionMappers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import exception.AddressNotFoundException;
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
        JsonObject job = new JsonObject();
        job.addProperty("Status", 404);
        job.addProperty("Message", e.getMessage());
        return Response.status(404).entity(job).build();
    }
    
}
