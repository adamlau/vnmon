package com.smspl.mc4.monitoring.virtualnumber;

import org.jboss.solder.logging.Logger;

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
