package com.coolapk.market.processor;

import java.util.Locale;

public class ExpectPackageException extends Exception {
    private final String expectPackageName;
    private final String name;
    private final String packageName;

    public ExpectPackageException(String str, String str2, String str3, String str4, int i) {
        super(String.format(Locale.US, "expectPackageName: %s, packageName: %s, name: %s, versionName: %s, versionCode: %d", str, str2, str3, str4, Integer.valueOf(i)));
        this.expectPackageName = str;
        this.packageName = str2;
        this.name = str3;
    }

    public String getExpectPackageName() {
        return this.expectPackageName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getName() {
        return this.name;
    }
}
