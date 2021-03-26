package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: HttpUrl */
public final class s {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;
    final String b;
    final int c;
    private final String e;
    private final String f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    s(a aVar) {
        this.a = aVar.a;
        this.e = a(aVar.b, false);
        this.f = a(aVar.c, false);
        this.b = aVar.d;
        this.c = aVar.a();
        this.g = a(aVar.f, false);
        String str = null;
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : str;
        this.j = aVar.toString();
    }

    public URI a() {
        String aVar = n().b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        return this.a.equals("https");
    }

    public String d() {
        if (this.e.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.j;
        return this.j.substring(length, c.a(str, length, str.length(), ":@"));
    }

    public String e() {
        if (this.f.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.a.length() + 3) + 1, indexOf);
    }

    public String f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String h() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        String str = this.j;
        return this.j.substring(indexOf, c.a(str, indexOf, str.length(), "?#"));
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public List<String> i() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        String str = this.j;
        int a2 = c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = c.a(this.j, i2, a2, '/');
            arrayList.add(this.j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String j() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, c.a(str, indexOf, str.length(), '#'));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public String k() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public String l() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public String m() {
        return d("/...").b("").c("").c().toString();
    }

    public s c(String str) {
        a d2 = d(str);
        if (d2 != null) {
            return d2.c();
        }
        return null;
    }

    public a n() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = d();
        aVar.c = e();
        aVar.d = this.b;
        aVar.e = this.c != a(this.a) ? this.c : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.e(j());
        aVar.h = l();
        return aVar;
    }

    public a d(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0030a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public static s e(String str) {
        a aVar = new a();
        if (aVar.a(null, str) == a.EnumC0030a.SUCCESS) {
            return aVar.c();
        }
        return null;
    }

    public static s a(URL url) {
        return e(url.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).j.equals(this.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    /* compiled from: HttpUrl */
    public static final class a {
        String a;
        String b = "";
        String c = "";
        String d;
        int e = -1;
        final List<String> f;
        List<String> g;
        String h;

        /* renamed from: com.bytedance.sdk.a.b.s$a$a  reason: collision with other inner class name */
        /* compiled from: HttpUrl */
        enum EnumC0030a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        public a a(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public a b(String str) {
            Objects.requireNonNull(str, "username == null");
            this.b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a c(String str) {
            Objects.requireNonNull(str, "password == null");
            this.c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a d(String str) {
            Objects.requireNonNull(str, "host == null");
            String e2 = e(str, 0, str.length());
            if (e2 != null) {
                this.d = e2;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.e = i;
            return this;
        }

        int a() {
            int i = this.e;
            return i != -1 ? i : s.a(this.a);
        }

        public a e(String str) {
            this.g = str != null ? s.b(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        a b() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, s.a(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = s.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public s c() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.d != null) {
                return new s(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int a2 = a();
            if (a2 != s.a(this.a)) {
                sb.append(':');
                sb.append(a2);
            }
            s.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                s.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        EnumC0030a a(s sVar, String str) {
            int a2;
            int i;
            int a3 = c.a(str, 0, str.length());
            int b2 = c.b(str, a3, str.length());
            if (b(str, a3, b2) != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.a = "https";
                    a3 += 6;
                } else if (!str.regionMatches(true, a3, "http:", 0, 5)) {
                    return EnumC0030a.UNSUPPORTED_SCHEME;
                } else {
                    this.a = "http";
                    a3 += 5;
                }
            } else if (sVar == null) {
                return EnumC0030a.MISSING_SCHEME;
            } else {
                this.a = sVar.a;
            }
            int c2 = c(str, a3, b2);
            char c3 = '?';
            char c4 = '#';
            if (c2 >= 2 || sVar == null || !sVar.a.equals(this.a)) {
                int i2 = a3 + c2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = c.a(str, i2, b2, "@/\\?#");
                    char charAt = a2 != b2 ? str.charAt(a2) : 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a4 = c.a(str, i2, a2, ':');
                            i = a2;
                            String a5 = s.a(str, i2, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a5 = this.b + "%40" + a5;
                            }
                            this.b = a5;
                            if (a4 != i) {
                                this.c = s.a(str, a4 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = a2;
                            this.c += "%40" + s.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c3 = '?';
                    c4 = '#';
                }
                int d2 = d(str, i2, a2);
                int i3 = d2 + 1;
                if (i3 < a2) {
                    this.d = e(str, i2, d2);
                    int f2 = f(str, i3, a2);
                    this.e = f2;
                    if (f2 == -1) {
                        return EnumC0030a.INVALID_PORT;
                    }
                } else {
                    this.d = e(str, i2, d2);
                    this.e = s.a(this.a);
                }
                if (this.d == null) {
                    return EnumC0030a.INVALID_HOST;
                }
                a3 = a2;
            } else {
                this.b = sVar.d();
                this.c = sVar.e();
                this.d = sVar.b;
                this.e = sVar.c;
                this.f.clear();
                this.f.addAll(sVar.i());
                if (a3 == b2 || str.charAt(a3) == '#') {
                    e(sVar.j());
                }
            }
            int a6 = c.a(str, a3, b2, "?#");
            a(str, a3, a6);
            if (a6 < b2 && str.charAt(a6) == '?') {
                int a7 = c.a(str, a6, b2, '#');
                this.g = s.b(s.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, null));
                a6 = a7;
            }
            if (a6 < b2 && str.charAt(a6) == '#') {
                this.h = s.a(str, 1 + a6, b2, "", true, false, false, false, null);
            }
            return EnumC0030a.SUCCESS;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = com.bytedance.sdk.a.b.a.c.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.s.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = s.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (!f(a2)) {
                if (g(a2)) {
                    d();
                    return;
                }
                List<String> list = this.f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f.add(a2);
                }
                if (z) {
                    this.f.add("");
                }
            }
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void d() {
            List<String> list = this.f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
                return;
            }
            List<String> list2 = this.f;
            list2.set(list2.size() - 1, "");
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            return c.a(s.a(str, i, i2, false));
        }

        private static int f(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(s.a(str, i, i2, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z);
                return cVar.o();
            }
        }
        return str.substring(i2, i3);
    }

    static void a(com.bytedance.sdk.a.a.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = c.a(str.charAt(i2 + 1));
                int a3 = c.a(str.charAt(i4));
                if (!(a2 == -1 || a3 == -1)) {
                    cVar.i((a2 << 4) + a3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                cVar.i(32);
                i2 += Character.charCount(codePointAt);
            }
            cVar.a(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        if (i4 >= i3 || str.charAt(i2) != '%' || c.a(str.charAt(i2 + 1)) == -1 || c.a(str.charAt(i4)) == -1) {
            return false;
        }
        return true;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
            cVar.a(str, i2, i4);
            a(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return cVar.o();
        }
        return str.substring(i2, i3);
    }

    static void a(com.bytedance.sdk.a.a.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.a.a.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.b(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (cVar2 == null) {
                        cVar2 = new com.bytedance.sdk.a.a.c();
                    }
                    if (charset == null || charset.equals(c.e)) {
                        cVar2.a(codePointAt);
                    } else {
                        cVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!cVar2.e()) {
                        int h2 = cVar2.h() & 255;
                        cVar.i(37);
                        char[] cArr = d;
                        cVar.i((int) cArr[(h2 >> 4) & 15]);
                        cVar.i((int) cArr[h2 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
