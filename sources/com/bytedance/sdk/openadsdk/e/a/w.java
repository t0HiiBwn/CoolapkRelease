package com.bytedance.sdk.openadsdk.e.a;

import android.text.TextUtils;

/* compiled from: PermissionGroup */
public enum w {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    static w a(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        if (TextUtils.equals("private", lowerCase)) {
            return PRIVATE;
        }
        return PUBLIC;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        if (this == PRIVATE) {
            return "private";
        }
        return this == PROTECTED ? "protected" : "public";
    }
}
