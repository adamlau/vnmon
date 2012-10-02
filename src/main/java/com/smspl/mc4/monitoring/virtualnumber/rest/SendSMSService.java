package com.smspl.mc4.monitoring.virtualnumber.rest;

import javax.ws.rs.*;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 2/10/12
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Produces("application/json")
public interface SendSMSService {

    @GET
    @Path("/sendSingle2")
    SubmitStatusEx sendSingle2(@QueryParam("username")String username,
                       @QueryParam("password")String password,
                       @QueryParam("recipient")String recipient,
                       @QueryParam("text")String text
                       );

}
