package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.rest.SendSMSService;
import com.smspl.mc4.monitoring.virtualnumber.rest.SubmitStatusEx;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;
import org.jboss.seam.rest.client.RestClient;

import javax.inject.Inject;

/**
 * User: adam
 * Date: 11/10/12
 */
public class SubmitSmsForNewChecks extends CheckStateCommand {

    @Inject
    @RestClient("http://primary.smartmessagingservices.net:8080/mc5")
    SendSMSService sendSMSService;

    @Override
    protected boolean accept(CheckState state) {
        return ( !state.hasSmsMessageBeenSubmitted() );
    }

    @Override
    protected void process(CheckState state) {
        log.infof("Submitting new message %s: %s", state.getStateId(), state.getTestConfig().toString());
        SubmitStatusEx status = sendSMSService.sendSingle2(
                state.getTestConfig().getUsername(),
                state.getTestConfig().getPassword(),
                state.getTestConfig().getRecipient(),
                state.getStateId().toString());

        CheckStateBuilder.update(state).withSubmitStatus(status);
    }
}
