package com.smspl.mc4.monitoring.virtualnumber.state;

import com.smspl.mc4.monitoring.virtualnumber.config.VirtualNumberConfig;
import com.smspl.mc4.monitoring.virtualnumber.rest.SubmitStatusEx;
import org.joda.time.DateTime;

/**
 * User: adamlau
 * Date: 8/10/12
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

    public CheckStateBuilder withTestConfig(VirtualNumberConfig testConfig)
    {
        checkCommandState.setTestConfig(testConfig);
        return this;
    }

    public CheckStateBuilder withSubmitStatus(SubmitStatusEx status)
    {
        checkCommandState.setDocumentId(status.getDocumentId());
        checkCommandState.setSubmitStatus(String.valueOf(status.getMessageStatus()));
        checkCommandState.setSubmitTime(new DateTime());
        return this;
    }

    public CheckStateBuilder withDeliveryStatus(DeliveryReceiptPushState deliveryReceiptPushState, DateTime timeStamp)
    {
        checkCommandState.setDeliveryReceiptStatus(deliveryReceiptPushState.getStatus());
        checkCommandState.setDeliveryReceiptTime(timeStamp);
        return this;
    }

    public CheckState build() {
        return checkCommandState;
    }

    public CheckStateBuilder withInboundSmsStatus(InboundSmsPushState inboundSmsPushState, DateTime timeStamp) {
        checkCommandState.setReceiveTime(timeStamp);
        return this;
    }
}
