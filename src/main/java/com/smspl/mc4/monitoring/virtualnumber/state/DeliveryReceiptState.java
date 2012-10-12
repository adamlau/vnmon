package com.smspl.mc4.monitoring.virtualnumber.state;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * User: adam
 * Date: 11/10/12
 */
public class DeliveryReceiptState {
    private final GregorianCalendar deliveryReceiptTime;
    private final String deliveryReceiptStatus;
    private final String documentId;

    public DeliveryReceiptState(GregorianCalendar deliveryReceiptTime, String deliveryReceiptStatus, String documentId) {
        this.deliveryReceiptTime = deliveryReceiptTime;
        this.deliveryReceiptStatus = deliveryReceiptStatus;
        this.documentId = documentId;
    }

    public GregorianCalendar getDeliveryReceiptTime() {
        return deliveryReceiptTime;
    }

    public String getDeliveryReceiptStatus() {
        return deliveryReceiptStatus;
    }

    public String getDocumentId() {
        return documentId;
    }
}
