package com.smspl.mc4.monitoring.virtualnumber.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 2/10/12
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/process")
public class ProcessEndPoint {

    @GET
    @Path("/dr")
    @Produces(MediaType.APPLICATION_JSON)
    public String processDeliveryReceipt(@QueryParam("documentId") String documentId,
                                         @QueryParam("status") String status,
                                         @QueryParam("timeStamp") String timeStamp,
                                         @QueryParam("sourceAddress") String sourceAddress
                                        )
    {
        return "OK";
    }
}
