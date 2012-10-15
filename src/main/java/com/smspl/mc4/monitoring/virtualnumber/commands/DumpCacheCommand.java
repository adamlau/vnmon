package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;

/**
 * User: adamlau
 * Date: 12/10/12
 * Time: 3:36 PM
 */
public class DumpCacheCommand extends CheckStateStoreCommand {

    @Override
    protected void doExecute() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cache dump at: " + getHeartbeatEvent().getTime() );
        for (CheckState state : getCheckStateStore().getStates()) {
            sb.append("\n" + state.toString());
        }
        getLog().info(sb.toString());
    }
}
