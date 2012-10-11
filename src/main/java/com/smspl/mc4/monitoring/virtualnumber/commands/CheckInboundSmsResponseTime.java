package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;

/**
 * User: adam
 * Date: 11/10/12
 */
public class CheckInboundSmsResponseTime extends CheckStateCommand {

    @Override
    protected boolean accept(CheckState state) {
        return false;
    }

    @Override
    protected void process(CheckState state) {
    }
}
