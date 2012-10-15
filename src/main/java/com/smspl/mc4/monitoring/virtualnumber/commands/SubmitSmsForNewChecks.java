package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.services.SMSSubmitService;
import com.smspl.mc4.monitoring.virtualnumber.rest.SubmitStatusEx;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;
import com.smspl.mc4.monitoring.virtualnumber.state.Phase;

import javax.inject.Inject;

/**
 * User: adam
 * Date: 11/10/12
 */
public class SubmitSmsForNewChecks extends CheckStateCommand {

    @Inject
    SMSSubmitService smsSubmitService;

    @Override
    protected boolean accept(CheckState state) {
        return state.isInPhase(Phase.ADDED);
    }

    @Override
    protected void process(CheckState state) {
        getLog().infof("Submitting new message %s: %s", state.getStateId(), state.getTestConfig().toString());
        SubmitStatusEx status = smsSubmitService.submit(
                state.getTestConfig().getUsername(),
                state.getTestConfig().getPassword(),
                state.getTestConfig().getRecipient(),
                state.getStateId().toString());

        CheckStateBuilder.update(state).withSubmitStatus(status);
        getLog().infof("Submitted new message: %s", state.toString());
    }
}
