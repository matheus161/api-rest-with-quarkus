package com.matheus161;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;

@Path("/unipds")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class UniPDSResource {
    private int i = 0;

    @GET
    public int getI() {
        return i;
    }

    @GET
    @Path("get-nano")
    public int getDateTime() {
        return LocalDateTime.now().getNano();
    }

    @POST
    public void addI(int i) {
        i++;
    }

    @DELETE
    public void removeI(int i) {
        i--;
    }

    @PUT
    public void setI(int i) {
        this.i = i;
    }
}