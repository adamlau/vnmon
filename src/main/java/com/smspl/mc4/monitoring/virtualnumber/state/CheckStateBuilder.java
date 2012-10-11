package com.smspl.mc4.monitoring.virtualnumber.state;

import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberTestConfig;
import com.smspl.mc4.monitoring.virtualnumber.rest.SubmitStatusEx;

import java.util.GregorianCalendar;

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

    private CheckStateBuilder(CheckState checkState)
    {
        this.checkCommandState = checkState;
    }

    public static CheckStateBuilder update(CheckState checkState)
    {
        return new CheckStateBuilder(checkState);
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

    public CheckStateBuilder withSubmitStatus(SubmitStatusEx status)
    {
        checkCommandState.setDocumentId(status.getDocumentId());
        checkCommandState.setSubmitStatus(String.valueOf(status.getMessageStatus()));
        checkCommandState.setSubmitTime(new GregorianCalendar());
        return this;
    }

    public CheckState build() {
        return checkCommandState;
    }
}
