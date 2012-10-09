package com.smspl.mc4.monitoring.virtualnumber.state;

import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberTestConfig;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 8/10/12
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class CheckStateBuilder {

    private CheckState checkCommandState;

    private CheckStateBuilder()
    {
        checkCommandState = new CheckState();
    }

    public static CheckStateBuilder create()
    {
        return new CheckStateBuilder();
    }

    public CheckStateBuilder withTestConfig(VirtualNumberTestConfig testConfig)
    {
        checkCommandState.setTestConfig(testConfig);
        return this;
    }

    public CheckState build() {
        return checkCommandState;
    }
}
