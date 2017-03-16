/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception.mappers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.ErrorMessage;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author christian
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<WebApplicationException> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public Response toResponse(WebApplicationException e) {
            System.out.println("JEg er i generic ");
        if (e instanceof NotFoundException) {
            ErrorMessage notFound = new ErrorMessage(404, "Page Not Found.. Try another Page");
            return Response.
                    status(404).
                    entity(notFound).
                    type(MediaType.APPLICATION_JSON).
                    build();
        } else {
            ErrorMessage serverError = new ErrorMessage(500, "Something went wrong.. Please try again later");
            return Response.
                    status(500).
                    entity(serverError).
                    type(MediaType.APPLICATION_JSON).
                    build();
        }
    }
}
