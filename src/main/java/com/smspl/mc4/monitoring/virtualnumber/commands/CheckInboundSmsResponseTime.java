package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.Phase;

/**
 * User: adam
 * Date: 11/10/12
 */
public class CheckInboundSmsResponseTime extends CheckStateCommand {

    @Override
    protected boolean accept(CheckState state) {
        return state.isInPhase(Phase.DELIVERY_RECEIPT_PROCESSED);
    }

    @Override
    protected void process(CheckState state) {
        if( !state.hasReceivedInboundSmsInTime(getTimeOutConfig()))
            flagStateForRemoval(state, "Inbound sms was not received in time: " + state.toString());
    }
}
