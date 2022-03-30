package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("res1")
public interface Resource1 {

    @GET
    @Produces({"application/vnd.ms-excel", MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    Response test();

}
