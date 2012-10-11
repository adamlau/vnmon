package com.smspl.mc4.monitoring.virtualnumber;

/**
 * User: adamlau
 * Date: 3/10/12
 */
public class VirtualNumberConfig {

    private String username;
    private String password;
    private String recipient;
    private String sender;

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
