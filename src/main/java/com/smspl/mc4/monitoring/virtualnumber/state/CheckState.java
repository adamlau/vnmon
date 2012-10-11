package com.smspl.mc4.monitoring.virtualnumber.state;

import com.smspl.mc4.monitoring.virtualnumber.VirtualNumberTestConfig;
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
    private Instant deliveryReceiptTime;
    private String deliveryReceiptStatus;
    private Instant receiveTime;
    private VirtualNumberTestConfig testConfig;

    public CheckState() {
        this.stateId = UUID.randomUUID();
        this.startTime = new GregorianCalendar();
    }

    public boolean hasSmsMessageBeenSubmitted()
    {
        return ( documentId != null || submitStatus != null || submitTime != null );
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

    public void setDeliveryReceiptTime(Instant deliveryReceiptTime) {
        this.deliveryReceiptTime = deliveryReceiptTime;
    }

    public void setDeliveryReceiptStatus(String deliveryReceiptStatus) {
        this.deliveryReceiptStatus = deliveryReceiptStatus;
    }

    public void setReceiveTime(Instant receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public Instant getDeliveryReceiptTime() {
        return deliveryReceiptTime;
    }

    public String getDeliveryReceiptStatus() {
        return deliveryReceiptStatus;
    }

    public Instant getReceiveTime() {
        return receiveTime;
    }

    public void setTestConfig(VirtualNumberTestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public VirtualNumberTestConfig getTestConfig() {
        return testConfig;
    }
}
