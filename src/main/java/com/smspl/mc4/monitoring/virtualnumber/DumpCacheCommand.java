package com.smspl.mc4.monitoring.virtualnumber;

import com.smspl.mc4.monitoring.virtualnumber.commands.CheckStateStoreCommand;
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
        sb.append("\ncache dump at: " + getHeartbeatEvent().getDueNext(0).getTime() );
        for (CheckState state : getCheckStateStore().getStates()) {
            sb.append("\n" + state.toString());
        }
        getLog().info(sb.toString());
    }
}
