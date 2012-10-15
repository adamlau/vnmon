package com.smspl.mc4.monitoring.services;

import com.smspl.mc4.monitoring.virtualnumber.rest.SendSMSService;
import com.smspl.mc4.monitoring.virtualnumber.rest.SubmitStatusEx;
import org.jboss.seam.rest.client.RestClient;

import javax.inject.Inject;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 3:53 PM
 */
public class SMSSubmitService {

    @Inject
    @RestClient("http://primary.smartmessagingservices.net:8080/mc5")
    SendSMSService sendSMSService;

    public SubmitStatusEx submit(String username, String password, String recipient, String message)
    {
        return sendSMSService.sendSingle2(username, password, recipient, message);
    }
}
