package com.smspl.mc4.monitoring.virtualnumber;

import org.joda.time.Instant;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 3/10/12
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class CheckCommandState {
    private final UUID stateId;
    private final String documentId;
    private Instant submitTime;
    private String submitStatus;
    private Instant deliveryReceiptTime;
    private String deliveryReceiptStatus;
    private Instant receiveTime;

    public CheckCommandState(String documentId) {
        this.stateId = UUID.randomUUID();
        this.documentId = documentId;
    }

    public UUID getStateId() {
        return stateId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public Instant getSubmitTime() {
        return submitTime;
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
}
