package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.Phase;

/**
 * User: adamlau
 * Date: 12/10/12
 * Time: 2:50 PM
 */
public class ExpireNewChecksCommand extends CheckStateCommand {

    @Override
    protected boolean accept(CheckState state) {
        return state.isInPhase(Phase.ADDED);
    }

    @Override
    protected void process(CheckState state) {
        if(  !state.hasSubmittedNewMessageInTime(getTimeOutConfig()) )
            flagStateForRemoval(state,"New test message was not sent within the expected time: " + state.toString());
    }

}
