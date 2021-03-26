package com.coolapk.market.download;

public class DownloadException extends Exception {
    public static final int CODE_CONTENT_LENGTH_NOT_MATCH = 1;
    public static final int CODE_DIR_CAN_NOT_CREATE = 2;
    private int code;

    private static String getCodeMessage(int i) {
        return i != 1 ? i != 2 ? "" : "Dir can not create" : "Content length not match";
    }

    public DownloadException(int i) {
        super(getCodeMessage(i));
        this.code = i;
    }

    public DownloadException(String str) {
        super(str);
    }

    public int getCode() {
        return this.code;
    }
}
