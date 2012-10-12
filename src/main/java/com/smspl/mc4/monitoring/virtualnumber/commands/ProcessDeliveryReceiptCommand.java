package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;
import com.smspl.mc4.monitoring.virtualnumber.state.DeliveryReceiptPushState;

/**
 * User: adam
 * Date: 11/10/12
 */
public class ProcessDeliveryReceiptCommand extends CheckStateStoreCommand {

    private DeliveryReceiptPushState pushState;

    public void setPushState(DeliveryReceiptPushState pushState) {
        this.pushState = pushState;
    }

    @Override
    protected boolean canExecute() {
        if (pushState == null) {
            getLog().warn("pushState not set. Call setPushState(DeliveryReceiptPushState pushState) before execution");
            return false;
        }

        if (pushState.getDocumentId() == null) {
            getLog().warn("documentId not set in pushState.");
            return false;
        }

        return true;
    }

    @Override
    protected void doExecute() {
        CheckState stateToUpdate = getCheckStateStore().getByDocumentId(pushState.getDocumentId());

        if( stateToUpdate != null )
            CheckStateBuilder.update(stateToUpdate).withDeliveryStatus(pushState, getHeartbeatEvent().getDueNext(0));
        else
            getLog().warnf("Delivery receipt could not be matched for documentId: %s", pushState.getDocumentId());
    }

}
