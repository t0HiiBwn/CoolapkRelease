package com.coolapk.market.network;

public class ClientException extends Exception {
    private String forwardUrl;
    private String messageExtra;
    private String messageStatus;
    private int statusCode;

    public ClientException(Result result) {
        super(result.getMessage());
        this.statusCode = result.getStatusCode();
        this.forwardUrl = result.getForwardUrl();
        this.messageStatus = result.getMessageStatus();
        this.messageExtra = result.getMessageExtra();
    }

    public ClientException(int i, String str) {
        super(str);
        this.statusCode = i;
    }

    public String getMessageExtra() {
        return this.messageExtra;
    }

    public String getMessageStatus() {
        return this.messageStatus;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getForwardUrl() {
        return this.forwardUrl;
    }
}
