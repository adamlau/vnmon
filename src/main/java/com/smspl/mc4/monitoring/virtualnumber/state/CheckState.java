package com.smspl.mc4.monitoring.virtualnumber.state;

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

    public DateTime getStartTime() {
        return startTime;
    }

    public String getDocumentId() {
        return documentId;
    }

    public DateTime getSubmitTime() {
        return submitTime;
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

    public String getSubmitStatus() {
        return submitStatus;
    }

    public DateTime getDeliveryReceiptTime() {
        return deliveryReceiptTime;
    }

    public String getDeliveryReceiptStatus() {
        return deliveryReceiptStatus;
    }

    public DateTime getReceiveTime() {
        return receiveTime;
    }

    public void setTestConfig(VirtualNumberConfig testConfig) {
        this.testConfig = testConfig;
    }

    public VirtualNumberConfig getTestConfig() {
        return testConfig;
    }

    public Phase getPhase()
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
        return phase.equals(getPhase());
    }

    public enum Phase { ADDED, SMS_SUBMITTED, DELIVERY_RECEIPT_PROCESSED, INBOUND_SMS_PROCESSED }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id[" + stateId + "]");
        sb.append("st[" + ((startTime == null) ? "" : startTime.toString()) + "]");
        sb.append("su[" + ((submitTime == null) ? "" : submitTime.toString()) + "]");
        return sb.toString();
    }
}
