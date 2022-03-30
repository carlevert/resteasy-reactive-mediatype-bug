package org.acme;

import javax.ws.rs.core.Response;

public class Resource2Impl implements Resource2 {

    @Override
    public Response test() {
        var e = new MyResponseEntity();
        e.setData("Datadata");

        return Response.ok().entity(e).build();
    }

}
