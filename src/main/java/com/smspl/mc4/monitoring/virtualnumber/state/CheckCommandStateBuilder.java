package com.smspl.mc4.monitoring.virtualnumber.state;

import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberTestConfig;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 8/10/12
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class CheckCommandStateBuilder {

    private CheckCommandState checkCommandState;

    private CheckCommandStateBuilder()
    {
        checkCommandState = new CheckCommandState();
    }

    public static CheckCommandStateBuilder create()
    {
        return new CheckCommandStateBuilder();
    }

    public CheckCommandStateBuilder withTestConfig(VirtualNumberTestConfig testConfig)
    {
        checkCommandState.setTestConfig(testConfig);
        return this;
    }

    public CheckCommandState build() {
        return checkCommandState;
    }
}
