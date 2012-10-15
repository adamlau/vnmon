package com.smspl.mc4.monitoring.virtualnumber.commands;

import org.joda.time.DateTime;

/**
 * User: adam
 * Date: 11/10/12
 */
public abstract class PeriodicStateStoreCommand extends CheckStateStoreCommand {

    protected static DateTime due = null;
    protected static Integer periodInSeconds = 20;

    @Override
    protected void doPreExecute() {
        if( due == null ) makeDueNow();

        if( !isDue() )
            getLog().infof("%s due to run after %s", this.getClass().getSimpleName(), due.toString());
    }

    @Override
    protected void doPostExecute() {
        setNextDue();
    }

    @Override
    protected boolean canExecute() {
        return isDue();
    }

    private boolean isDue() {
        return getHeartbeatEvent().isDue(due);
    }

    private void makeDueNow()
    {
        due = getHeartbeatEvent().getDueNext(-1);
    }

    private void setNextDue()
    {
        due = getHeartbeatEvent().getDueNext(periodInSeconds);
    }

}
