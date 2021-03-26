package com.coolapk.market.processor;

import java.util.Locale;

public class SamePackageException extends Exception {
    private final String packageName;
    private final int versionCode;
    private final String versionName;

    public SamePackageException(String str, String str2, int i) {
        super(String.format(Locale.US, "packageName: %s, versionName: %s, versionCode: %d", str, str2, Integer.valueOf(i)));
        this.packageName = str;
        this.versionName = str2;
        this.versionCode = i;
    }
}
