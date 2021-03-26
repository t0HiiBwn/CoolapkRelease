package com.coolapk.market.download;

public final class HttpException extends Exception {
    private final int code;
    private final String message;
    private final transient DownloadResponse response;

    public HttpException(DownloadResponse downloadResponse) {
        super("HTTP " + downloadResponse.getCode() + " " + downloadResponse.getMessage());
        this.code = downloadResponse.getCode();
        this.message = downloadResponse.getMessage();
        this.response = downloadResponse;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public DownloadResponse response() {
        return this.response;
    }
}
