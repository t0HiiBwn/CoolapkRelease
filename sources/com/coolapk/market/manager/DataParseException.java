package com.coolapk.market.manager;

import java.io.IOException;

public class DataParseException extends IOException {
    public DataParseException(String str) {
        super(str);
    }

    public DataParseException(String str, Throwable th) {
        super(str, th);
    }
}
