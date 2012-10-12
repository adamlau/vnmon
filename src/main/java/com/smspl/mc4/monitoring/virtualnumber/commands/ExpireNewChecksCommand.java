package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;

/**
 * User: adamlau
 * Date: 12/10/12
 * Time: 2:50 PM
 */
public class ExpireNewChecksCommand extends CheckStateCommand {

    private static final int DEFAULT_TIMEOUT = 120;

    private int timeOutInSeconds = DEFAULT_TIMEOUT;

    @Override
    protected boolean accept(CheckState state) {
        return state.isInPhase(CheckState.Phase.ADDED);
    }

    @Override
    protected void process(CheckState state) {
        if( stateTimedOut(state.getStartTime(), timeOutInSeconds) )
            flagStateForRemoval(state);
    }

}
