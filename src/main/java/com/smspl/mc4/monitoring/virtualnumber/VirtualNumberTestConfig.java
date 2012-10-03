package com.smspl.mc4.monitoring.virtualnumber;

import org.joda.time.Duration;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 3/10/12
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class VirtualNumberTestConfig {

    private String checkInstance;
    private int checkFrequency;
    private String username;
    private String password;
    private String recipient;
    private String sender;

    public String getCheckInstance() {
        return checkInstance;
    }

    public void setCheckInstance(String checkInstance) {
        this.checkInstance = checkInstance;
    }

    public int getCheckFrequency() {
        return checkFrequency;
    }

    public void setCheckFrequency(int checkFrequency) {
        this.checkFrequency = checkFrequency;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "username(" + username + ") password(" + password + ") recipient(" + recipient + ") sender(" + sender + ")";
    }
}
