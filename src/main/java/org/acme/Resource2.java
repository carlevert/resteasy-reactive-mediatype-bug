package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("res2")
public interface Resource2 {

    @GET
    @Produces({MediaType.APPLICATION_JSON, "application/vnd.ms-excel", MediaType.TEXT_PLAIN})
    Response test();

}
