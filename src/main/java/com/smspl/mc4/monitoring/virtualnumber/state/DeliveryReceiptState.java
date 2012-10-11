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
    private final UUID stateId;

    public DeliveryReceiptState(GregorianCalendar deliveryReceiptTime, String deliveryReceiptStatus, UUID stateId) {
        this.deliveryReceiptTime = deliveryReceiptTime;
        this.deliveryReceiptStatus = deliveryReceiptStatus;
        this.stateId = stateId;
    }

    public GregorianCalendar getDeliveryReceiptTime() {
        return deliveryReceiptTime;
    }

    public String getDeliveryReceiptStatus() {
        return deliveryReceiptStatus;
    }

    public UUID getStateId() {
        return stateId;
    }
}
