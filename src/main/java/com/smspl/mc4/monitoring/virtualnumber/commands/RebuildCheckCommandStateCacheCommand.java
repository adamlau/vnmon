package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.*;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 8/10/12
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class RebuildCheckCommandStateCacheCommand extends BaseCommandStateCacheCommand {

    @Inject
    VirtualNumberTestConfigManager configManager;

    @Override
    public void doExecute(CheckStateStore checkCommandStateCache) {
        checkCommandStateCache.clear();

        for( VirtualNumberTestConfig config : configManager.getConfigs())
        {
            CheckState state = CheckStateBuilder.create().withTestConfig(config).build();
            checkCommandStateCache.addState(state);
        }
        configManager.dumpVirtualNumberConfigs();
        checkCommandStateCache.dumpCache();
    }
}
