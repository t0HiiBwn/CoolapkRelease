package com.bytedance.sdk.openadsdk.preload.a.b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: PreJava9DateFormatProvider */
public class j {
    public static DateFormat a(int i, int i2) {
        return new SimpleDateFormat(a(i) + " " + b(i2), Locale.US);
    }

    private static String a(int i) {
        if (i == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i == 1) {
            return "MMMM d, yyyy";
        }
        if (i == 2) {
            return "MMM d, yyyy";
        }
        if (i == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i);
    }

    private static String b(int i) {
        if (i == 0 || i == 1) {
            return "h:mm:ss a z";
        }
        if (i == 2) {
            return "h:mm:ss a";
        }
        if (i == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i);
    }
}
