package com.smspl.mc4.monitoring.virtualnumber.rest;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.commands.ProcessDeliveryReceiptCommand;
import com.smspl.mc4.monitoring.virtualnumber.commands.ProcessInboundSmsCommand;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;
import com.smspl.mc4.monitoring.virtualnumber.state.DeliveryReceiptPushState;
import com.smspl.mc4.monitoring.virtualnumber.state.InboundSmsPushState;
import org.jboss.solder.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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

    @Inject
    ProcessDeliveryReceiptCommand processDeliveryReceiptCommand;

    @Inject
    ProcessInboundSmsCommand processInboundSmsCommand;

    /**
     * REST endpoint for receiving Delivery Receipt updates from the gateway
     *
     * @param documentId
     * @param status
     * @return OK_RESPONSE regardless of outcome
     */
    @GET
    @Path("/dr")
    @Produces(MediaType.APPLICATION_JSON)
    public String processDeliveryReceipt(@QueryParam("documentId") String documentId,
                                         @QueryParam("status") String status)
    {
        try {
            DeliveryReceiptPushState deliveryReceiptPushState = new DeliveryReceiptPushState(status,documentId);
            processDeliveryReceiptCommand.setPushState(deliveryReceiptPushState);
            processDeliveryReceiptCommand.execute(new HeartbeatEvent());
        } catch (Exception e) {
            log.error(e);
        }
        return OK_RESPONSE;
    }

    /**
     * REST endpoint for receiving an inbound sms from the gateway
     *
     * @param sender
     * @param recipient
     * @param text contains the UUID of the CheckStore entry to match to
     * @return OK_RESPONSE regardless of outcome
     */
    @GET
    @Path("/sms")
    @Produces(MediaType.APPLICATION_JSON)
    public String processInboundSms(@QueryParam("sender") String sender,
                                    @QueryParam("recipient") String recipient,
                                    @QueryParam("text") String text )
    {
        try {
            InboundSmsPushState inboundSmsPushState = new InboundSmsPushState(sender, recipient, text);
            processInboundSmsCommand.setPushState(inboundSmsPushState);
            processInboundSmsCommand.execute(new HeartbeatEvent());
        } catch (Exception e) {
            log.error(e);
        }
        return OK_RESPONSE;
    }
}
