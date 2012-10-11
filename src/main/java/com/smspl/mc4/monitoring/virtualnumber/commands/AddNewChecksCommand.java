package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberConfig;
import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberConfigManager;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;

import javax.inject.Inject;

/**
 * User: adam
 * Date: 9/10/12
 */
public class AddNewChecksCommand extends PeriodicStateStoreCommand {

    @Inject
    VirtualNumberConfigManager configManager;

    @Override
    protected void doExecute() {

        for( VirtualNumberConfig config : configManager.getConfigs())
        {
            log.infof("Adding check: %s", config.toString());
            CheckState state = CheckStateBuilder.create().withTestConfig(config).build();
            checkStateStore.addState(state);
        }

    }

}
