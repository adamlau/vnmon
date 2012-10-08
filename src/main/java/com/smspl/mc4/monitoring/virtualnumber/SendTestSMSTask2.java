package com.smspl.mc4.monitoring.virtualnumber;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckCommandStateCache;
import com.smspl.mc4.monitoring.virtualnumber.rest.SendSMSService;
import com.smspl.mc4.monitoring.virtualnumber.rest.SubmitStatusEx;
import org.jboss.seam.rest.client.RestClient;
import org.jboss.solder.logging.Logger;
import org.joda.time.Instant;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 1/10/12
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class SendTestSMSTask2 {

    @Inject
    CheckCommandStateCache stateCache;

    @Inject
    Logger log;

    @Inject
    @RestClient("http://primary.smartmessagingservices.net:8080/mc5")
    SendSMSService sendSMSService;

    public void sendSMS() {
        try {
            log.info("sendSMS fired at");
            SubmitStatusEx statusEx = sendSMSService.sendSingle2("", "", "", "test: " + Instant.now().toString());
            log.infof("sendSMS returned: docid(%s) recipient(%s) status(%s)", statusEx.getDocumentId(), statusEx.getRecipient(), statusEx.getMessageStatus());
        } catch (Exception e) {
            log.warn("Failed sending sms");
        }
    }
}
