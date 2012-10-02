package com.smspl.mc4.monitoring.virtualnumber.rest;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 2/10/12
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubmitStatusEx {

    private String documentId;
    private String recipient;
    private int messageStatus;

    public SubmitStatusEx(String documentId, String recipient, int messageStatus) {
        this.documentId = documentId;
        this.recipient = recipient;
        this.messageStatus = messageStatus;
    }

    public SubmitStatusEx() {
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }
}
