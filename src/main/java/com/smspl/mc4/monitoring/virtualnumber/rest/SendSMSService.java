package com.smspl.mc4.monitoring.virtualnumber.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
