package com.smspl.mc4.monitoring.virtualnumber.state;

import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberConfig;
import org.joda.time.Instant;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * User: adamlau
 * Date: 3/10/12
 */
public class CheckState {
    private final UUID stateId;
    private final GregorianCalendar startTime;
    private String documentId;
    private GregorianCalendar submitTime;
    private String submitStatus;
    private GregorianCalendar deliveryReceiptTime;
    private String deliveryReceiptStatus;
    private GregorianCalendar receiveTime;
    private VirtualNumberConfig testConfig;

    public CheckState() {
        this.stateId = UUID.randomUUID();
        this.startTime = new GregorianCalendar();
    }

    public UUID getStateId() {
        return stateId;
    }

    public GregorianCalendar getStartTime() {
        return startTime;
    }

    public String getDocumentId() {
        return documentId;
    }

    public GregorianCalendar getSubmitTime() {
        return submitTime;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setSubmitTime(GregorianCalendar submitTime) {
        this.submitTime = submitTime;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus;
    }

    public void setDeliveryReceiptTime(GregorianCalendar deliveryReceiptTime) {
        this.deliveryReceiptTime = deliveryReceiptTime;
    }

    public void setDeliveryReceiptStatus(String deliveryReceiptStatus) {
        this.deliveryReceiptStatus = deliveryReceiptStatus;
    }

    public void setReceiveTime(GregorianCalendar receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public GregorianCalendar getDeliveryReceiptTime() {
        return deliveryReceiptTime;
    }

    public String getDeliveryReceiptStatus() {
        return deliveryReceiptStatus;
    }

    public GregorianCalendar getReceiveTime() {
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
        sb.append("st[" + ((startTime == null) ? "" : startTime.getTime()) + "]");
        sb.append("su[" + ((submitTime == null) ? "" : submitTime.getTime()) + "]");
        return sb.toString();
    }
}
