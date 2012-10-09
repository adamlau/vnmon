package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberTestConfig;
import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberTestConfigManager;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 9/10/12
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddNewChecksCommand extends CheckStateStoreCommand {

    @Inject
    VirtualNumberTestConfigManager configManager;

    @Override
    protected void doExecute() {

        for( VirtualNumberTestConfig config : configManager.getConfigs())
        {
            CheckState state = CheckStateBuilder.create().withTestConfig(config).build();
            getCheckStateStore().addState(state);
        }
    }

    @Override
    protected boolean canExecute() {
        return isDue();
    }

}
