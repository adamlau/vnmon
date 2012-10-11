package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;
import com.smspl.mc4.monitoring.virtualnumber.state.DeliveryReceiptState;

import javax.inject.Inject;

/**
 * User: adam
 * Date: 11/10/12
 */
public class ProcessDeliveryReceiptCommand extends CheckStateStoreCommand {

    private DeliveryReceiptState deliveryReceiptState;

    @Inject
    public void setDeliveryReceiptCommandState(DeliveryReceiptState deliveryReceiptState)
    {
        this.deliveryReceiptState = deliveryReceiptState;
    }

    @Override
    protected void doExecute() {
        CheckState stateToUpdate = checkStateStore.get(this.deliveryReceiptState.getStateId());
        CheckStateBuilder.update(stateToUpdate).withDeliveryStatus(this.deliveryReceiptState);
    }
}
