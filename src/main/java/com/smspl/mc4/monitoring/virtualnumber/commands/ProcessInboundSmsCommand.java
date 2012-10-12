package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.rest.InboundSmsPushState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateBuilder;

import java.util.UUID;

/**
 * User: adam
 * Date: 11/10/12
 */
public class ProcessInboundSmsCommand extends CheckStateStoreCommand {

    private InboundSmsPushState pushState;
    private UUID stateId;

    public void setPushState(InboundSmsPushState inboundSmsPushState) {
        this.pushState = inboundSmsPushState;
    }

    @Override
    protected boolean canExecute() {
        if (pushState == null) {
            getLog().warn("pushState not set. Call setPushState(InboundSmsPushState pushState) before execution");
            return false;
        }
        if (pushState.getText() == null || pushState.getText().isEmpty() ) {
            getLog().warn("text is not set in pushState.");
            return false;
        }

        try
        {
        stateId = UUID.fromString(pushState.getText());
        } catch (Exception e) {
            getLog().warnf("text can not be converted to UUID: %s", pushState.getText());
            return false;
        }

        return true;
    }

    @Override
    protected void doExecute() {
        CheckState stateToUpdate = getCheckStateStore().get(stateId);

        if( stateToUpdate != null )
            CheckStateBuilder.update(stateToUpdate).withInboundSmsStatus(pushState, getHeartbeatEvent().getDueNext(0));
        else
            getLog().warnf("Inbound SMS could not be matched for stateId: %s", stateId);
    }

}
