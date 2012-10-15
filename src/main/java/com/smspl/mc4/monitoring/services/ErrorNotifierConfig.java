package com.smspl.mc4.monitoring.services;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 3:48 PM
 */
public class ErrorNotifierConfig {

    private String[] emailRecipients;
    private String[] mobileRecipients;
    private String username;
    private String password;

    public String[] getEmailRecipients() {
        return emailRecipients;
    }

    public void setEmailRecipients(String[] emailRecipients) {
        this.emailRecipients = emailRecipients;
    }

    public String[] getMobileRecipients() {
        return mobileRecipients;
    }

    public void setMobileRecipients(String[] mobileRecipients) {
        this.mobileRecipients = mobileRecipients;
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
}
