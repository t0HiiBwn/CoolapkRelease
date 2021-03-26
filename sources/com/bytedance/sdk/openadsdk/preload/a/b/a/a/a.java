package com.bytedance.sdk.openadsdk.preload.a.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* compiled from: ISO8601Utils */
public class a {
    private static final TimeZone a = TimeZone.getTimeZone("UTC");

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cf A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b4 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc }] */
    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i6 = index + 4;
            int a2 = a(str, index, i6);
            if (a(str, i6, '-')) {
                i6++;
            }
            int i7 = i6 + 2;
            int a3 = a(str, i6, i7);
            if (a(str, i7, '-')) {
                i7++;
            }
            int i8 = i7 + 2;
            int a4 = a(str, i7, i8);
            boolean a5 = a(str, i8, 'T');
            if (a5 || str.length() > i8) {
                if (a5) {
                    int i9 = i8 + 1;
                    int i10 = i9 + 2;
                    int a6 = a(str, i9, i10);
                    if (a(str, i10, ':')) {
                        i10++;
                    }
                    int i11 = i10 + 2;
                    int a7 = a(str, i10, i11);
                    if (a(str, i11, ':')) {
                        i11++;
                    }
                    if (str.length() <= i11 || (charAt = str.charAt(i11)) == 'Z' || charAt == '+' || charAt == '-') {
                        i3 = a7;
                        i2 = 0;
                        i4 = a6;
                        i8 = i11;
                    } else {
                        int i12 = i11 + 2;
                        i = a(str, i11, i12);
                        if (i > 59 && i < 63) {
                            i = 59;
                        }
                        if (a(str, i12, '.')) {
                            int i13 = i12 + 1;
                            int a8 = a(str, i13 + 1);
                            int min = Math.min(a8, i13 + 3);
                            int a9 = a(str, i13, min);
                            int i14 = min - i13;
                            if (i14 == 1) {
                                a9 *= 100;
                            } else if (i14 == 2) {
                                a9 *= 10;
                            }
                            i3 = a7;
                            i2 = a9;
                            i4 = a6;
                            i8 = a8;
                        } else {
                            i3 = a7;
                            i4 = a6;
                            i8 = i12;
                            i2 = 0;
                        }
                        if (str.length() <= i8) {
                            char charAt2 = str.charAt(i8);
                            if (charAt2 == 'Z') {
                                timeZone = a;
                                i5 = i8 + 1;
                            } else {
                                if (charAt2 != '+') {
                                    if (charAt2 != '-') {
                                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                                    }
                                }
                                String substring = str.substring(i8);
                                if (substring.length() < 5) {
                                    substring = substring + "00";
                                }
                                i5 = i8 + substring.length();
                                if (!"+0000".equals(substring)) {
                                    if (!"+00:00".equals(substring)) {
                                        String str3 = "GMT" + substring;
                                        TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                                        String id = timeZone2.getID();
                                        if (!id.equals(str3)) {
                                            if (!id.replace(":", "").equals(str3)) {
                                                throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                                            }
                                        }
                                        timeZone = timeZone2;
                                    }
                                }
                                timeZone = a;
                            }
                            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                            gregorianCalendar.setLenient(false);
                            gregorianCalendar.set(1, a2);
                            gregorianCalendar.set(2, a3 - 1);
                            gregorianCalendar.set(5, a4);
                            gregorianCalendar.set(11, i4);
                            gregorianCalendar.set(12, i3);
                            gregorianCalendar.set(13, i);
                            gregorianCalendar.set(14, i2);
                            parsePosition.setIndex(i5);
                            return gregorianCalendar.getTime();
                        }
                        throw new IllegalArgumentException("No time zone indicator");
                    }
                } else {
                    i4 = 0;
                    i3 = 0;
                    i2 = 0;
                }
                i = 0;
                if (str.length() <= i8) {
                }
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(a2, a3 - 1, a4);
                parsePosition.setIndex(i8);
                return gregorianCalendar2.getTime();
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i4 = i;
            i3 = 0;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
