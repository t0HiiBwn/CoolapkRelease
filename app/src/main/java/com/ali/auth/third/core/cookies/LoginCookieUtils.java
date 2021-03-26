package com.ali.auth.third.core.cookies;

import android.text.TextUtils;
import com.ali.auth.third.core.trace.SDKLogger;
import org.json.JSONObject;

public class LoginCookieUtils {
    private static final int a = 6;
    private static final int b = 8;

    public static void expiresCookies(c cVar) {
        Long l2 = 1000L;
        cVar.e = l2.longValue();
    }

    public static String getHttpDomin(c cVar) {
        String str = cVar.a;
        if (!TextUtils.isEmpty(str) && str.startsWith(".")) {
            str = str.substring(1);
        }
        return "http://" + str;
    }

    public static JSONObject getKeyValues(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            String cookie = a.a().getCookie(".taobao.com");
            if (!TextUtils.isEmpty(cookie)) {
                String[] split = cookie.split(";");
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2) {
                        if (split2[0].contains(str)) {
                            if (split2.length == 2) {
                                jSONObject.put(split2[0].trim(), split2[1].trim());
                            } else {
                                jSONObject.put(split2[0].trim(), str2.substring(str2.indexOf("=") + 1));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static String getValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String cookie = a.a().getCookie(".taobao.com");
            if (!TextUtils.isEmpty(cookie)) {
                String[] split = cookie.split(";");
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2) {
                        if (str.equals(split2[0].trim())) {
                            return split2.length == 2 ? split2[1].trim() : str2.substring(str2.indexOf("=") + 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c2, code lost:
        if (r20.charAt(r7) == r8) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e5, code lost:
        if (r20.charAt(r7) == r8) goto L_0x00c4;
     */
    public static c parseCookie(String str) {
        StringBuilder sb;
        String str2;
        int indexOf;
        int indexOf2;
        String substring;
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < 0 || i >= length) {
                break;
            }
            char c = ' ';
            if (str.charAt(i) == ' ') {
                i++;
            } else {
                int indexOf3 = str.indexOf(59, i);
                char c2 = '=';
                int indexOf4 = str.indexOf(61, i);
                c cVar = new c();
                if ((indexOf3 == -1 || indexOf3 >= indexOf4) && indexOf4 != -1) {
                    cVar.c = str.substring(i, indexOf4);
                    if (indexOf4 >= length - 1 || str.charAt(indexOf4 + 1) != '\"' || (i = str.indexOf(34, indexOf4 + 2)) != -1) {
                        int indexOf5 = str.indexOf(59, i);
                        indexOf3 = indexOf5 == -1 ? length : indexOf5;
                        if (indexOf3 - indexOf4 > 4096) {
                            int i2 = indexOf4 + 1;
                            substring = str.substring(i2, i2 + 4096);
                        } else {
                            int i3 = indexOf4 + 1;
                            substring = (i3 == indexOf3 || indexOf3 < indexOf4) ? "" : str.substring(i3, indexOf3);
                        }
                        cVar.d = substring;
                    }
                } else {
                    if (indexOf3 == -1) {
                        indexOf3 = length;
                    }
                    cVar.c = str.substring(i, indexOf3);
                    cVar.d = null;
                }
                while (indexOf3 >= 0 && indexOf3 < length) {
                    if (str.charAt(indexOf3) != c && str.charAt(indexOf3) != ';') {
                        if (str.charAt(indexOf3) == ',') {
                            break;
                        }
                        int i4 = length - indexOf3;
                        int i5 = a;
                        if (i4 < i5 || !str.substring(indexOf3, indexOf3 + i5).equalsIgnoreCase("secure")) {
                            int i6 = b;
                            if (i4 < i6 || !str.substring(indexOf3, indexOf3 + i6).equalsIgnoreCase("httponly")) {
                                int indexOf6 = str.indexOf(c2, indexOf3);
                                if (indexOf6 > 0) {
                                    String lowerCase = str.substring(indexOf3, indexOf6).toLowerCase();
                                    if (lowerCase.equals("expires") && (indexOf2 = str.indexOf(44, indexOf6)) != -1 && indexOf2 - indexOf6 <= 10) {
                                        indexOf3 = indexOf2 + 1;
                                    }
                                    int indexOf7 = str.indexOf(59, indexOf3);
                                    indexOf3 = str.indexOf(44, indexOf3);
                                    if (indexOf7 == -1 && indexOf3 == -1) {
                                        indexOf3 = length;
                                    } else if (indexOf7 != -1) {
                                        if (indexOf3 != -1) {
                                            indexOf7 = Math.min(indexOf7, indexOf3);
                                        }
                                        indexOf3 = indexOf7;
                                    }
                                    String substring2 = str.substring(indexOf6 + 1, indexOf3);
                                    if (substring2.length() > 2 && substring2.charAt(0) == '\"' && (indexOf = substring2.indexOf(34, 1)) > 0) {
                                        substring2 = substring2.substring(1, indexOf);
                                    }
                                    if (lowerCase.equals("expires")) {
                                        try {
                                            cVar.e = b.a(substring2);
                                        } catch (IllegalArgumentException e) {
                                            e = e;
                                            sb = new StringBuilder();
                                            str2 = "illegal format for expires: ";
                                        }
                                    } else if (lowerCase.equals("max-age")) {
                                        try {
                                            long currentTimeMillis = System.currentTimeMillis();
                                            long parseLong = Long.parseLong(substring2);
                                            Long.signum(parseLong);
                                            cVar.e = currentTimeMillis + (parseLong * 1000);
                                        } catch (NumberFormatException e2) {
                                            e = e2;
                                            sb = new StringBuilder();
                                            str2 = "illegal format for max-age: ";
                                            sb.append(str2);
                                            sb.append(substring2);
                                            SDKLogger.e("login.LoginCookieUtils", sb.toString(), e);
                                            c = ' ';
                                            c2 = '=';
                                        }
                                    } else if (lowerCase.equals("path")) {
                                        if (substring2.length() > 0) {
                                            cVar.b = substring2;
                                        }
                                    } else if (lowerCase.equals("domain")) {
                                        int lastIndexOf = substring2.lastIndexOf(46);
                                        if (lastIndexOf == 0) {
                                            cVar.a = null;
                                        } else {
                                            try {
                                                Integer.parseInt(substring2.substring(lastIndexOf + 1));
                                            } catch (NumberFormatException unused) {
                                                String lowerCase2 = substring2.toLowerCase();
                                                if (lowerCase2.charAt(0) != '.') {
                                                    lowerCase2 = '.' + lowerCase2;
                                                }
                                                cVar.a = lowerCase2;
                                            }
                                        }
                                    }
                                } else {
                                    indexOf3 = length;
                                    c = ' ';
                                }
                            } else {
                                indexOf3 += i6;
                                cVar.g = true;
                                if (indexOf3 == length) {
                                    break;
                                }
                            }
                        } else {
                            indexOf3 += i5;
                            cVar.f = true;
                            if (indexOf3 == length) {
                                break;
                            }
                        }
                        indexOf3++;
                        c = ' ';
                    } else {
                        indexOf3++;
                    }
                    c = ' ';
                    c2 = '=';
                }
                return cVar;
            }
        }
        return null;
    }
}
