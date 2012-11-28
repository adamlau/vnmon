package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.Phase;

/**
 * User: adam
 * Date: 11/10/12
 */
public class CheckDeliveryReceiptResponseTime extends CheckStateCommand {

    @Override
    protected boolean accept(CheckState state) {
        return state.isInPhase(Phase.SMS_SUBMITTED);
    }

    @Override
    protected void process(CheckState state) {
        if( !state.hasReceivedDeliveryReceiptInTime(getTimeOutConfig()))
            flagStateForRemoval(state, "Delivery receipt was not processed in time");
    }
}
