package com.smspl.mc4.monitoring.virtualnumber.state;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 12/10/12
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class InboundSmsPushState {
    private String sender;
    private String recipient;
    private String text;

    public InboundSmsPushState(String sender, String recipient, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }
}
