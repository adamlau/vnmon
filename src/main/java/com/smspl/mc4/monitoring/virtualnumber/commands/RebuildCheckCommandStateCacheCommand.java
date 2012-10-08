package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.*;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckCommandState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckCommandStateBuilder;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckCommandStateCache;

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
    public void doExecute(CheckCommandStateCache checkCommandStateCache) {
        checkCommandStateCache.clear();

        for( VirtualNumberTestConfig config : configManager.getConfigs())
        {
            CheckCommandState state = CheckCommandStateBuilder.create().withTestConfig(config).build();
            checkCommandStateCache.addState(state);
        }
        configManager.dumpVirtualNumberConfigs();
        checkCommandStateCache.dumpCache();
    }
}
