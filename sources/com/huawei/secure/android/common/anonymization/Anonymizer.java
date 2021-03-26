package com.huawei.secure.android.common.anonymization;

import android.text.TextUtils;
import android.util.Log;

public class Anonymizer {
    private static final String TAG = "Anonymizer";

    public static String maskName(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        return maskCommonString(str, 1, 0);
    }

    public static String maskBirthday(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return a.b(str, '*');
        }
        String[] split = a.split(str, 4);
        return a.b("", a.a(split, 0), a.a(a.a(split, 1), "0123456789", "*"));
    }

    public static String maskBankAccount(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return a.b(str, '*');
        }
        if (str.length() < 11 || str.length() >= 20) {
            return maskCommonString(str, 6, 4);
        }
        return maskCommonString(str, 4, 4);
    }

    public static String maskEmail(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            String[] split = a.split(str, 1);
            return a.b("", a.a(split, 0), a.b(a.a(split, 1), '*'));
        }
        String[] a = a.a(str, indexOf, indexOf + 1, str.lastIndexOf(46));
        return a.b("", a.b(a.a(a, 0), '*'), a.a(a, 1), a.b(a.a(a, 2), '*'), a.a(a, 3));
    }

    public static String maskPhone(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return a.b(str, '*');
        }
        if (str.length() < 8 || str.length() >= 11) {
            return maskCommonString(str, 3, 4);
        }
        return maskCommonString(str, 2, 2);
    }

    public static String maskIpV4(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return a.b(str, '*');
        }
        String[] split = a.split(str, lastIndexOf + 1);
        return a.b("", a.a(split, 0), a.b(a.a(split, 1), '*'));
    }

    public static String maskIpV6(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String[] a = a.a(str, ':');
        if (a.length <= 1) {
            return a.b(str, '*');
        }
        if (a.length != 8) {
            String[] split = a.split(str, str.indexOf(58) + 1);
            return a.b("", a.a(split, 0), a.a(a.a(split, 1), "0123456789ABCDEFabcdef", "*"));
        }
        a[2] = maskLower8Bit(a[2]);
        for (int i = 3; i < a.length; i++) {
            a[i] = a.b(a[i], '*');
        }
        return a.b(":", a);
    }

    public static String maskLower8Bit(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "maskLower8Bit: s is null");
            return "";
        } else if (str.length() <= 2) {
            return a.b(str, '*');
        } else {
            String[] split = a.split(str, str.length() - 2);
            return a.b("", a.a(split, 0), a.b(a.a(split, 1), '*'));
        }
    }

    public static String maskId(String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 12, 0);
    }

    public static String maskMac(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int a = a.a(str, '-', 2);
        if (a < 0) {
            return a.a(str, "0123456789ABCDEFabcdef", "*");
        }
        String[] split = a.split(str, a);
        return a.b("", a.a(split, 0), a.a(a.a(split, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static String maskImeiImsi(String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 4, 0);
    }

    public static String maskAccountId(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        if (str.length() < 8) {
            return maskCommonString(str, 0, 1);
        }
        return maskCommonString(str, 0, 4);
    }

    public static String maskCommonString(String str, int i, int i2) {
        int i3;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (str.length() <= i + i2) {
            i3 = str.length() - 1;
            i = 1;
        } else {
            i3 = str.length() - i2;
        }
        String[] a = a.a(str, i, i3);
        return a.b("", a.a(a, 0), a.b(a.a(a, 1), '*'), a.a(a, 2));
    }
}
