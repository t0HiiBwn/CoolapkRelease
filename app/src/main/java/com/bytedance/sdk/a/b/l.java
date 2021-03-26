package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.c.d;
import com.bytedance.sdk.a.b.a.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Cookie */
public final class l {
    private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f1277l;
    private final boolean m;

    private l(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.e = str;
        this.f = str2;
        this.g = j2;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.f1277l = z4;
    }

    public String a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || c.c(str)) {
            return false;
        }
        return true;
    }

    public static l a(s sVar, String str) {
        return a(System.currentTimeMillis(), sVar, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0128  */
    static l a(long j2, s sVar, String str) {
        long j3;
        String f2;
        String str2;
        l lVar;
        String str3;
        String str4;
        int lastIndexOf;
        int length = str.length();
        char c2 = ';';
        int a2 = c.a(str, 0, length, ';');
        char c3 = '=';
        int a3 = c.a(str, 0, a2, '=');
        if (a3 == a2) {
            return null;
        }
        String c4 = c.c(str, 0, a3);
        if (c4.isEmpty() || c.b(c4) != -1) {
            return null;
        }
        String c5 = c.c(str, a3 + 1, a2);
        if (c.b(c5) != -1) {
            return null;
        }
        int i2 = a2 + 1;
        String str5 = null;
        String str6 = null;
        long j4 = -1;
        long j5 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i2 < length) {
            int a4 = c.a(str, i2, length, c2);
            int a5 = c.a(str, i2, a4, c3);
            String c6 = c.c(str, i2, a5);
            String c7 = a5 < a4 ? c.c(str, a5 + 1, a4) : "";
            if (c6.equalsIgnoreCase("expires")) {
                try {
                    j5 = a(c7, 0, c7.length());
                } catch (IllegalArgumentException unused) {
                }
            } else if (c6.equalsIgnoreCase("max-age")) {
                j4 = a(c7);
            } else {
                if (c6.equalsIgnoreCase("domain")) {
                    str6 = b(c7);
                    z3 = false;
                } else if (c6.equalsIgnoreCase("path")) {
                    str5 = c7;
                } else if (c6.equalsIgnoreCase("secure")) {
                    z = true;
                } else if (c6.equalsIgnoreCase("httponly")) {
                    z2 = true;
                }
                i2 = a4 + 1;
                c2 = ';';
                c3 = '=';
            }
            z4 = true;
            i2 = a4 + 1;
            c2 = ';';
            c3 = '=';
        }
        long j6 = Long.MIN_VALUE;
        if (j4 != Long.MIN_VALUE) {
            if (j4 != -1) {
                j6 = j2 + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
                if (j6 < j2 || j6 > 253402300799999L) {
                    j3 = 253402300799999L;
                }
            } else {
                j3 = j5;
            }
            f2 = sVar.f();
            if (str6 != null) {
                str2 = f2;
                lVar = null;
            } else if (!a(f2, str6)) {
                return null;
            } else {
                lVar = null;
                str2 = str6;
            }
            if (f2.length() == str2.length() && a.a().a(str2) == null) {
                return lVar;
            }
            str3 = "/";
            if (str5 != null || !str5.startsWith(str3)) {
                String h2 = sVar.h();
                lastIndexOf = h2.lastIndexOf(47);
                if (lastIndexOf != 0) {
                    str3 = h2.substring(0, lastIndexOf);
                }
                str4 = str3;
            } else {
                str4 = str5;
            }
            return new l(c4, c5, j3, str2, str4, z, z2, z3, z4);
        }
        j3 = j6;
        f2 = sVar.f();
        if (str6 != null) {
        }
        if (f2.length() == str2.length()) {
        }
        str3 = "/";
        if (str5 != null) {
        }
        String h2 = sVar.h();
        lastIndexOf = h2.lastIndexOf(47);
        if (lastIndexOf != 0) {
        }
        str4 = str3;
        return new l(c4, c5, j3, str2, str4, z, z2, z3, z4);
    }

    private static long a(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = d.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(d).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 != -1 || !matcher.usePattern(c).matches()) {
                if (i7 == -1) {
                    Pattern pattern = b;
                    if (matcher.usePattern(pattern).matches()) {
                        i7 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i4 == -1 && matcher.usePattern(a).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i6 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(c.g);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (!str.matches("-?\\d+")) {
                throw e2;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    private static String b(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String a2 = c.a(str);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<l> a(s sVar, r rVar) {
        List<String> b2 = rVar.b("Set-Cookie");
        int size = b2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            l a2 = a(sVar, b2.get(i2));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return a(false);
    }

    String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append('=');
        sb.append(this.f);
        if (this.f1277l) {
            if (this.g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(d.a(new Date(this.g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.h);
        }
        sb.append("; path=");
        sb.append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.e.equals(this.e) && lVar.f.equals(this.f) && lVar.h.equals(this.h) && lVar.i.equals(this.i) && lVar.g == this.g && lVar.j == this.j && lVar.k == this.k && lVar.f1277l == this.f1277l && lVar.m == this.m) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.g;
        return ((((((((((((((((527 + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.j ? 1 : 0)) * 31) + (!this.k ? 1 : 0)) * 31) + (!this.f1277l ? 1 : 0)) * 31) + (!this.m ? 1 : 0);
    }
}
