package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class EncodeUtil {
    private static final String TAG = "EncodeUtil";
    private static final char[] f = {',', '.', '_'};
    private static final String[] g = new String[256];

    static {
        for (char c = 0; c < 255; c = (char) (c + 1)) {
            if ((c < '0' || c > '9') && ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z'))) {
                g[c] = b(c).intern();
            } else {
                g[c] = null;
            }
        }
    }

    public static String encodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(f, str);
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "encode js: " + e.getMessage());
            return "";
        }
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            a aVar = new a(str);
            while (aVar.hasNext()) {
                Character a = a(aVar);
                if (a != null) {
                    sb.append(a);
                } else {
                    sb.append(aVar.b());
                }
            }
            return sb.toString();
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "decode js: " + e.getMessage());
            return "";
        }
    }

    private static String a(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(a(cArr, Character.valueOf(str.charAt(i))));
        }
        return sb.toString();
    }

    private static String a(char[] cArr, Character ch) {
        if (a(ch.charValue(), cArr)) {
            return "" + ch;
        } else if (a(ch.charValue()) == null) {
            return "" + ch;
        } else {
            String hexString = Integer.toHexString(ch.charValue());
            if (ch.charValue() < 256) {
                return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
            }
            return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
    }

    private static boolean a(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    private static String a(char c) {
        if (c < 255) {
            return g[c];
        }
        return b(c);
    }

    private static String b(char c) {
        return Integer.toHexString(c);
    }

    private static Character a(a aVar) {
        aVar.f();
        Character b = aVar.b();
        if (b == null) {
            aVar.reset();
            return null;
        } else if (b.charValue() != '\\') {
            aVar.reset();
            return null;
        } else {
            Character b2 = aVar.b();
            if (b2 == null) {
                aVar.reset();
                return null;
            } else if (b2.charValue() == 'b') {
                return '\b';
            } else {
                if (b2.charValue() == 't') {
                    return '\t';
                }
                if (b2.charValue() == 'n') {
                    return '\n';
                }
                if (b2.charValue() == 'v') {
                    return 11;
                }
                if (b2.charValue() == 'f') {
                    return '\f';
                }
                if (b2.charValue() == 'r') {
                    return '\r';
                }
                if (b2.charValue() == '\"') {
                    return '\"';
                }
                if (b2.charValue() == '\'') {
                    return '\'';
                }
                if (b2.charValue() == '\\') {
                    return '\\';
                }
                int i = 0;
                if (Character.toLowerCase(b2.charValue()) == 'x') {
                    StringBuilder sb = new StringBuilder();
                    while (i < 2) {
                        Character c = aVar.c();
                        if (c != null) {
                            sb.append(c);
                            i++;
                        } else {
                            aVar.reset();
                            return null;
                        }
                    }
                    try {
                        int parseInt = Integer.parseInt(sb.toString(), 16);
                        if (Character.isValidCodePoint(parseInt)) {
                            return Character.valueOf((char) parseInt);
                        }
                    } catch (NumberFormatException unused) {
                        aVar.reset();
                        return null;
                    }
                } else if (Character.toLowerCase(b2.charValue()) == 'u') {
                    StringBuilder sb2 = new StringBuilder();
                    while (i < 4) {
                        Character c2 = aVar.c();
                        if (c2 != null) {
                            sb2.append(c2);
                            i++;
                        } else {
                            aVar.reset();
                            return null;
                        }
                    }
                    try {
                        int parseInt2 = Integer.parseInt(sb2.toString(), 16);
                        if (Character.isValidCodePoint(parseInt2)) {
                            return Character.valueOf((char) parseInt2);
                        }
                    } catch (NumberFormatException unused2) {
                        aVar.reset();
                        return null;
                    }
                } else if (a.c(b2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b2);
                    Character b3 = aVar.b();
                    if (!a.c(b3)) {
                        aVar.a(b3);
                    } else {
                        sb3.append(b3);
                        Character b4 = aVar.b();
                        if (!a.c(b4)) {
                            aVar.a(b4);
                        } else {
                            sb3.append(b4);
                        }
                    }
                    try {
                        int parseInt3 = Integer.parseInt(sb3.toString(), 8);
                        if (Character.isValidCodePoint(parseInt3)) {
                            return Character.valueOf((char) parseInt3);
                        }
                    } catch (NumberFormatException unused3) {
                        aVar.reset();
                        return null;
                    }
                }
                return b2;
            }
        }
    }
}
