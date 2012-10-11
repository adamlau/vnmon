package com.smspl.mc4.monitoring.virtualnumber.rest;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;
import com.smspl.mc4.monitoring.virtualnumber.state.DeliveryReceiptState;
import org.jboss.solder.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.GregorianCalendar;

/**
 * User: adamlau
 * Date: 2/10/12
 */
@Path("/process")
public class ProcessEndPoint {

    private static final String OK_RESPONSE = "OK";
    @Inject
    CheckStateStore checkStateStore;

    @Inject
    Logger log;

    /**
     * REST endpoint for receiving Delivery Receipt updates from the gateway
     *
     * @param documentId
     * @param status
     * @param timeStamp
     * @param sourceAddress
     * @return OK_RESPONSE regardless of outcome
     */
    @GET
    @Path("/dr")
    @Produces(MediaType.APPLICATION_JSON)
    public String processDeliveryReceipt(@QueryParam("documentId") String documentId,
                                         @QueryParam("status") String status,
                                         @QueryParam("timeStamp") String timeStamp,
                                         @QueryParam("sourceAddress") String sourceAddress)
    {
        try {
            //DeliveryReceiptState deliveryReceiptState = new DeliveryReceiptState();
        } catch (Exception e) {
            log.error(e);
        }
        return OK_RESPONSE;
    }

    /**
     * REST endpoint for receiving an inbound sms from the gateway
     *
     * @param documentId
     * @param status
     * @param timeStamp
     * @param sourceAddress
     * @return OK_RESPONSE regardless of outcome
     */
    @GET
    @Path("/sms")
    @Produces(MediaType.APPLICATION_JSON)
    public String processInboundSms(@QueryParam("documentId") String documentId,
                                    @QueryParam("status") String status,
                                    @QueryParam("timeStamp") String timeStamp,
                                    @QueryParam("sourceAddress") String sourceAddress)
    {
        try {
            // update inbound sms
        } catch (Exception e) {
            log.error(e);
        }
        return OK_RESPONSE;
    }
}
