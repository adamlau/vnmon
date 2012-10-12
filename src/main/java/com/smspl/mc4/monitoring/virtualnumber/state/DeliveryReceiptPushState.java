package com.smspl.mc4.monitoring.virtualnumber.state;

import java.util.GregorianCalendar;

/**
 * User: adam
 * Date: 11/10/12
 */
public class DeliveryReceiptPushState {
    private final String status;
    private final String documentId;

    public DeliveryReceiptPushState(String status, String documentId) {
        this.status = status;
        this.documentId = documentId;
    }

    public String getStatus() {
        return status;
    }

    public String getDocumentId() {
        return documentId;
    }

}
