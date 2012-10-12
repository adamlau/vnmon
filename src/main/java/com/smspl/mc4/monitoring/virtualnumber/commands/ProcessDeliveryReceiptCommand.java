package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;
import com.smspl.mc4.monitoring.virtualnumber.state.DeliveryReceiptState;

/**
 * User: adam
 * Date: 11/10/12
 */
public class ProcessDeliveryReceiptCommand extends CheckStateStoreCommand {

    private DeliveryReceiptState deliveryReceiptState;

    public void setDeliveryReceiptCommandState(DeliveryReceiptState deliveryReceiptState)
    {
        this.deliveryReceiptState = deliveryReceiptState;
    }

    @Override
    protected boolean canExecute() {
        boolean canExecute = hasRequiredState();

        if( !canExecute ) {
            getLog().warn("deliveryReceiptState not set. Call setDeliveryReceiptCommandState(DeliveryReceiptState deliveryReceiptState) before execution");
        }

        return canExecute;
    }

    @Override
    protected void doExecute() {
        CheckState stateToUpdate = getCheckStateStore().getByDocumentId(deliveryReceiptState.getDocumentId());

        if( stateToUpdate != null )
            CheckStateBuilder.update(stateToUpdate).withDeliveryStatus(deliveryReceiptState);
        else
            getLog().warnf("Delivery receipt could not be matched for documentId: %s", deliveryReceiptState);
    }

    private boolean hasRequiredState()
    {
        return deliveryReceiptState != null;
    }
}
