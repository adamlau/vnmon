package com.smspl.mc4.monitoring.virtualnumber.state;

import com.smspl.mc4.monitoring.virtualnumber.config.TimeOutConfig;
import com.smspl.mc4.monitoring.virtualnumber.config.VirtualNumberConfig;
import org.joda.time.DateTime;

import java.util.UUID;

/**
 * User: adamlau
 * Date: 3/10/12
 */
public class CheckState {
    private final UUID stateId;
    private final DateTime startTime;
    private String documentId;
    private DateTime submitTime;
    private String submitStatus;
    private DateTime deliveryReceiptTime;
    private String deliveryReceiptStatus;
    private DateTime receiveTime;
    private VirtualNumberConfig testConfig;

    public CheckState() {
        this.stateId = UUID.randomUUID();
        this.startTime = new DateTime();
    }

    public UUID getStateId() {
        return stateId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setSubmitTime(DateTime submitTime) {
        this.submitTime = submitTime;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus;
    }

    public void setDeliveryReceiptTime(DateTime deliveryReceiptTime) {
        this.deliveryReceiptTime = deliveryReceiptTime;
    }

    public void setDeliveryReceiptStatus(String deliveryReceiptStatus) {
        this.deliveryReceiptStatus = deliveryReceiptStatus;
    }

    public void setReceiveTime(DateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public void setTestConfig(VirtualNumberConfig testConfig) {
        this.testConfig = testConfig;
    }

    public boolean hasReceivedInboundSmsInTime(TimeOutConfig timeOutConfig) {
        return (receiveTime != null) || !timeOutConfig.hasTimedOut(deliveryReceiptTime);
    }

    public boolean hasReceivedDeliveryReceiptInTime(TimeOutConfig timeOutConfig) {
        return (deliveryReceiptTime != null) || !timeOutConfig.hasTimedOut(submitTime);
    }

    public boolean hasSubmittedNewMessageInTime(TimeOutConfig timeOutConfig) {
        return (startTime != null) || !timeOutConfig.hasTimedOut(startTime);
    }

    public VirtualNumberConfig getTestConfig() {
        return testConfig;
    }

    public Phase getCurrentPhase()
    {
        if( receiveTime != null )
            return Phase.INBOUND_SMS_PROCESSED;
        else if( deliveryReceiptTime != null )
            return Phase.DELIVERY_RECEIPT_PROCESSED;
        else if( submitTime != null )
            return Phase.SMS_SUBMITTED;
        else
            return Phase.ADDED;
    }

    public boolean isInPhase(Phase phase)
    {
        return phase.equals(getCurrentPhase());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id[" + stateId + "]");
        sb.append("doc[" + documentId + "]");
        sb.append("st[" + ((startTime == null) ? "" : startTime.toString("HH:mm:ss")) + "]");
        sb.append("su[" + ((submitTime == null) ? "" : submitTime.toString("HH:mm:ss")) + "]");
        sb.append("dr[" + ((deliveryReceiptTime == null) ? "" : deliveryReceiptTime.toString("HH:mm:ss")) + "]");
        sb.append("in[" + ((receiveTime == null) ? "" : receiveTime.toString("HH:mm:ss")) + "]");
        return sb.toString();
    }

}
