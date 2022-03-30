package org.acme;

import javax.ws.rs.core.Response;

public class Resource1Impl implements Resource1 {

    @Override
    public Response test() {
        var e = new MyResponseEntity();
        e.setData("Datadata");

        return Response.ok().entity(e).build();
    }

}
