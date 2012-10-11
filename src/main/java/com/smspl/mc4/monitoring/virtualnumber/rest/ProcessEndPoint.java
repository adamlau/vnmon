package com.smspl.mc4.monitoring.virtualnumber.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * User: adamlau
 * Date: 2/10/12
 */
@Path("/process")
public class ProcessEndPoint {

    /***
     * REST endpoint for receiving Delivery Receipt updates from the gateway
     * @param documentId
     * @param status
     * @param timeStamp
     * @param sourceAddress
     * @return
     */
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

    /***
     * REST endpoint for receiving an inbound sms from the gateway
     * @param documentId
     * @param status
     * @param timeStamp
     * @param sourceAddress
     * @return
     */
    @GET
    @Path("/sms")
    @Produces(MediaType.APPLICATION_JSON)
    public String processInboundSms(@QueryParam("documentId") String documentId,
                                         @QueryParam("status") String status,
                                         @QueryParam("timeStamp") String timeStamp,
                                         @QueryParam("sourceAddress") String sourceAddress
    )
    {
        return "OK";
    }
}
