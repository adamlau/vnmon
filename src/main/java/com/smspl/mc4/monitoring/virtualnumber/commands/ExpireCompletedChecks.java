package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.Phase;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 1:43 PM
 */
public class ExpireCompletedChecks extends CheckStateCommand {

    @Override
    protected boolean accept(CheckState state) {
        return state.isInPhase(Phase.INBOUND_SMS_PROCESSED);
    }

    @Override
    protected void process(CheckState state) {
        getLog().infof("cleaning up: %s", state);
        getCheckStateStore().remove(state.getStateId());
    }
}
