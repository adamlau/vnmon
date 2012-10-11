package com.smspl.mc4.monitoring.virtualnumber.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * User: adamlau
 * Date: 2/10/12
 */
@Produces(MediaType.APPLICATION_JSON)
public interface SendSMSService {

    @GET
    @Path("/sendSingle2")
    SubmitStatusEx sendSingle2(@QueryParam("username")String username,
                       @QueryParam("password")String password,
                       @QueryParam("recipient")String recipient,
                       @QueryParam("text")String text
                       );

}
