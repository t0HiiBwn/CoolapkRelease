package com.bytedance.sdk.openadsdk.preload.a.d;

import com.bytedance.sdk.openadsdk.preload.a.b.a.e;
import com.bytedance.sdk.openadsdk.preload.a.b.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: JsonReader */
public class a implements Closeable {
    int a = 0;
    private final Reader b;
    private boolean c = false;
    private final char[] d = new char[1024];
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private long i;
    private int j;
    private String k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f1337l;
    private int m;
    private String[] n;
    private int[] o;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f1337l = iArr;
        this.m = 0;
        this.m = 0 + 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.b = reader;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final boolean q() {
        return this.c;
    }

    public void a() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 3) {
            a(1);
            this.o[this.m - 1] = 0;
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + s());
    }

    public void b() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 4) {
            int i3 = this.m - 1;
            this.m = i3;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + s());
    }

    public void c() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 1) {
            a(3);
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + s());
    }

    public void d() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 2) {
            int i3 = this.m - 1;
            this.m = i3;
            this.n[i3] = null;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + s());
    }

    public boolean e() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public b f() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    int r() throws IOException {
        int b2;
        int[] iArr = this.f1337l;
        int i2 = this.m;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int b3 = b(true);
            if (b3 != 44) {
                if (b3 == 59) {
                    w();
                } else if (b3 == 93) {
                    this.a = 4;
                    return 4;
                } else {
                    throw b("Unterminated array");
                }
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5 && (b2 = b(true)) != 44) {
                if (b2 == 59) {
                    w();
                } else if (b2 == 125) {
                    this.a = 2;
                    return 2;
                } else {
                    throw b("Unterminated object");
                }
            }
            int b4 = b(true);
            if (b4 == 34) {
                this.a = 13;
                return 13;
            } else if (b4 == 39) {
                w();
                this.a = 12;
                return 12;
            } else if (b4 != 125) {
                w();
                this.e--;
                if (a((char) b4)) {
                    this.a = 14;
                    return 14;
                }
                throw b("Expected name");
            } else if (i3 != 5) {
                this.a = 2;
                return 2;
            } else {
                throw b("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int b5 = b(true);
            if (b5 != 58) {
                if (b5 == 61) {
                    w();
                    if (this.e < this.f || b(1)) {
                        char[] cArr = this.d;
                        int i4 = this.e;
                        if (cArr[i4] == '>') {
                            this.e = i4 + 1;
                        }
                    }
                } else {
                    throw b("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            if (this.c) {
                z();
            }
            this.f1337l[this.m - 1] = 7;
        } else if (i3 == 7) {
            if (b(false) == -1) {
                this.a = 17;
                return 17;
            }
            w();
            this.e--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int b6 = b(true);
        if (b6 == 34) {
            this.a = 9;
            return 9;
        } else if (b6 != 39) {
            if (!(b6 == 44 || b6 == 59)) {
                if (b6 == 91) {
                    this.a = 3;
                    return 3;
                } else if (b6 != 93) {
                    if (b6 != 123) {
                        this.e--;
                        int o2 = o();
                        if (o2 != 0) {
                            return o2;
                        }
                        int t = t();
                        if (t != 0) {
                            return t;
                        }
                        if (a(this.d[this.e])) {
                            w();
                            this.a = 10;
                            return 10;
                        }
                        throw b("Expected value");
                    }
                    this.a = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.a = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                w();
                this.e--;
                this.a = 7;
                return 7;
            }
            throw b("Unexpected value");
        } else {
            w();
            this.a = 8;
            return 8;
        }
    }

    private int o() throws IOException {
        String str;
        String str2;
        int i2;
        char c2 = this.d[this.e];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.e + i3 >= this.f && !b(i3 + 1)) {
                return 0;
            }
            char c3 = this.d[this.e + i3];
            if (!(c3 == str2.charAt(i3) || c3 == str.charAt(i3))) {
                return 0;
            }
        }
        if ((this.e + length < this.f || b(length + 1)) && a(this.d[this.e + length])) {
            return 0;
        }
        this.e += length;
        this.a = i2;
        return i2;
    }

    private int t() throws IOException {
        char c2;
        char[] cArr = this.d;
        int i2 = this.e;
        int i3 = this.f;
        int i4 = 0;
        int i5 = 0;
        char c3 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i3) {
                if (i5 == cArr.length) {
                    return i4;
                }
                if (!b(i5 + 1)) {
                    break;
                }
                i2 = this.e;
                i3 = this.f;
            }
            c2 = cArr[i2 + i5];
            if (c2 == '+') {
                i4 = 0;
                if (c3 != 5) {
                    return 0;
                }
            } else if (c2 == 'E' || c2 == 'e') {
                i4 = 0;
                if (c3 != 2 && c3 != 4) {
                    return 0;
                }
                c3 = 5;
                i5++;
            } else {
                if (c2 == '-') {
                    i4 = 0;
                    if (c3 == 0) {
                        c3 = 1;
                        z2 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i4 = 0;
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                } else if (c2 < '0' || c2 > '9') {
                    break;
                } else if (c3 == 1 || c3 == 0) {
                    j2 = (long) (-(c2 - '0'));
                    i4 = 0;
                    c3 = 2;
                } else {
                    if (c3 == 2) {
                        if (j2 == 0) {
                            return 0;
                        }
                        long j3 = (10 * j2) - ((long) (c2 - '0'));
                        int i6 = (j2 > -922337203685477580L ? 1 : (j2 == -922337203685477580L ? 0 : -1));
                        z &= i6 > 0 || (i6 == 0 && j3 < j2);
                        j2 = j3;
                    } else if (c3 == 3) {
                        i4 = 0;
                        c3 = 4;
                    } else if (c3 == 5 || c3 == 6) {
                        i4 = 0;
                        c3 = 7;
                    }
                    i4 = 0;
                }
                i5++;
            }
            c3 = 6;
            i5++;
        }
        if (a(c2)) {
            return 0;
        }
        if (c3 == 2 && z && ((j2 != Long.MIN_VALUE || z2) && (j2 != 0 || !z2))) {
            if (!z2) {
                j2 = -j2;
            }
            this.i = j2;
            this.e += i5;
            this.a = 15;
            return 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.j = i5;
            this.a = 16;
            return 16;
        }
    }

    private boolean a(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        w();
        return false;
    }

    public String g() throws IOException {
        String str;
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 14) {
            str = u();
        } else if (i2 == 12) {
            str = b('\'');
        } else if (i2 == 13) {
            str = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + s());
        }
        this.a = 0;
        this.n[this.m - 1] = str;
        return str;
    }

    public String h() throws IOException {
        String str;
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 10) {
            str = u();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b('\"');
        } else if (i2 == 11) {
            str = this.k;
            this.k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.i);
        } else if (i2 == 16) {
            str = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + s());
        }
        this.a = 0;
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 5) {
            this.a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.a = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + s());
        }
    }

    public void j() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 7) {
            this.a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + s());
    }

    public double k() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            this.a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.i;
        }
        if (i2 == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i2 == 8 || i2 == 9) {
            this.k = b(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.k = u();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + s());
        }
        this.a = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (this.c || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.k = null;
            this.a = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        throw new d("JSON forbids NaN and infinities: " + parseDouble + s());
    }

    public long l() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            this.a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.i;
        }
        if (i2 == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.k = u();
            } else {
                this.k = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.a = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + s());
        }
        this.a = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.k = null;
            this.a = 0;
            int[] iArr3 = this.o;
            int i5 = this.m - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.k + s());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r1 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r2) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        r1.append(r0, r2, r2 - r2);
        r9.e = r2;
     */
    private String b(char c2) throws IOException {
        char[] cArr = this.d;
        StringBuilder sb = null;
        do {
            int i2 = this.e;
            int i3 = this.f;
            while (true) {
                while (i2 < i3) {
                    int i4 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.e = i4;
                        int i5 = (i4 - i2) - 1;
                        if (sb == null) {
                            return new String(cArr, i2, i5);
                        }
                        sb.append(cArr, i2, i5);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.e = i4;
                        int i6 = (i4 - i2) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i6 + 1) * 2, 16));
                        }
                        sb.append(cArr, i2, i6);
                        sb.append(y());
                        i2 = this.e;
                        i3 = this.f;
                    } else {
                        if (c3 == '\n') {
                            this.g++;
                            this.h = i4;
                        }
                        i2 = i4;
                    }
                }
                break;
            }
        } while (b(1));
        throw b("Unterminated string");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        w();
     */
    private String u() throws IOException {
        int i2;
        String str;
        int i3 = 0;
        StringBuilder sb = null;
        while (true) {
            i2 = 0;
            while (true) {
                int i4 = this.e;
                if (i4 + i2 < this.f) {
                    char c2 = this.d[i4 + i2];
                    if (!(c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ')) {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (!(c2 == '/' || c2 == '=')) {
                                    if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= this.d.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.d, this.e, i2);
                    this.e += i2;
                    if (!b(1)) {
                    }
                } else if (b(i2 + 1)) {
                }
            }
        }
        i3 = i2;
        if (sb == null) {
            str = new String(this.d, this.e, i3);
        } else {
            sb.append(this.d, this.e, i3);
            str = sb.toString();
        }
        this.e += i3;
        return str;
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.d;
        do {
            int i2 = this.e;
            int i3 = this.f;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.e = i4;
                    return;
                } else if (c3 == '\\') {
                    this.e = i4;
                    y();
                    i2 = this.e;
                    i3 = this.f;
                } else {
                    if (c3 == '\n') {
                        this.g++;
                        this.h = i4;
                    }
                    i2 = i4;
                }
            }
            this.e = i2;
        } while (b(1));
        throw b("Unterminated string");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        w();
     */
    private void v() throws IOException {
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.e;
                if (i3 + i2 < this.f) {
                    char c2 = this.d[i3 + i2];
                    if (!(c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ')) {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (!(c2 == '/' || c2 == '=')) {
                                    if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.e = i3 + i2;
                }
            }
            this.e += i2;
            return;
        } while (b(1));
    }

    public int m() throws IOException {
        int i2 = this.a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            long j2 = this.i;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.a = 0;
                int[] iArr = this.o;
                int i4 = this.m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.i + s());
        }
        if (i2 == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.k = u();
            } else {
                this.k = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.a = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + s());
        }
        this.a = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.k = null;
            this.a = 0;
            int[] iArr3 = this.o;
            int i7 = this.m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.k + s());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a = 0;
        this.f1337l[0] = 8;
        this.m = 1;
        this.b.close();
    }

    public void n() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.a;
            if (i3 == 0) {
                i3 = r();
            }
            if (i3 == 3) {
                a(1);
            } else if (i3 == 1) {
                a(3);
            } else {
                if (i3 == 4) {
                    this.m--;
                } else if (i3 == 2) {
                    this.m--;
                } else if (i3 == 14 || i3 == 10) {
                    v();
                    this.a = 0;
                } else if (i3 == 8 || i3 == 12) {
                    c('\'');
                    this.a = 0;
                } else if (i3 == 9 || i3 == 13) {
                    c('\"');
                    this.a = 0;
                } else {
                    if (i3 == 16) {
                        this.e += this.j;
                    }
                    this.a = 0;
                }
                i2--;
                this.a = 0;
            }
            i2++;
            this.a = 0;
        } while (i2 != 0);
        int[] iArr = this.o;
        int i4 = this.m;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.n[i4 - 1] = "null";
    }

    private void a(int i2) {
        int i3 = this.m;
        int[] iArr = this.f1337l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f1337l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.f1337l;
        int i5 = this.m;
        this.m = i5 + 1;
        iArr2[i5] = i2;
    }

    private boolean b(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.d;
        int i5 = this.h;
        int i6 = this.e;
        this.h = i5 - i6;
        int i7 = this.f;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            Reader reader = this.b;
            int i9 = this.f;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f + read;
            this.f = i3;
            if (this.g == 0 && (i4 = this.h) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.e++;
                this.h = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.d;
        int i2 = this.e;
        int i3 = this.f;
        while (true) {
            if (i2 == i3) {
                this.e = i2;
                if (b(1)) {
                    i2 = this.e;
                    i3 = this.f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + s());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.g++;
                this.h = i4;
            } else if (!(c2 == ' ' || c2 == '\r' || c2 == '\t')) {
                if (c2 == '/') {
                    this.e = i4;
                    if (i4 == i3) {
                        this.e = i4 - 1;
                        boolean b2 = b(2);
                        this.e++;
                        if (!b2) {
                            return c2;
                        }
                    }
                    w();
                    int i5 = this.e;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.e = i5 + 1;
                        if (a("*/")) {
                            i2 = this.e + 2;
                            i3 = this.f;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.e = i5 + 1;
                        x();
                        i2 = this.e;
                        i3 = this.f;
                    }
                } else if (c2 == '#') {
                    this.e = i4;
                    w();
                    x();
                    i2 = this.e;
                    i3 = this.f;
                } else {
                    this.e = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private void w() throws IOException {
        if (!this.c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() throws IOException {
        char c2;
        do {
            if (this.e < this.f || b(1)) {
                char[] cArr = this.d;
                int i2 = this.e;
                int i3 = i2 + 1;
                this.e = i3;
                c2 = cArr[i2];
                if (c2 == '\n') {
                    this.g++;
                    this.h = i3;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != '\r');
    }

    private boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.e + length > this.f && !b(length)) {
                return false;
            }
            char[] cArr = this.d;
            int i2 = this.e;
            if (cArr[i2] == '\n') {
                this.g++;
                this.h = i2 + 1;
            } else {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.d[this.e + i3] == str.charAt(i3)) {
                    }
                }
                return true;
            }
            this.e++;
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + s();
    }

    String s() {
        return " at line " + (this.g + 1) + " column " + ((this.e - this.h) + 1) + " path " + p();
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f1337l[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.o[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.n;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    private char y() throws IOException {
        int i2;
        int i3;
        if (this.e != this.f || b(1)) {
            char[] cArr = this.d;
            int i4 = this.e;
            int i5 = i4 + 1;
            this.e = i5;
            char c2 = cArr[i4];
            if (c2 == '\n') {
                this.g++;
                this.h = i5;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return '\b';
                }
                if (c2 == 'f') {
                    return '\f';
                }
                if (c2 == 'n') {
                    return '\n';
                }
                if (c2 == 'r') {
                    return '\r';
                }
                if (c2 == 't') {
                    return '\t';
                }
                if (c2 != 'u') {
                    throw b("Invalid escape sequence");
                } else if (i5 + 4 <= this.f || b(4)) {
                    char c3 = 0;
                    int i6 = this.e;
                    int i7 = i6 + 4;
                    while (i6 < i7) {
                        char c4 = this.d[i6];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i2 = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.d, this.e, 4));
                            } else {
                                i2 = c4 - 'A';
                            }
                            i3 = i2 + 10;
                        } else {
                            i3 = c4 - '0';
                        }
                        c3 = (char) (c5 + i3);
                        i6++;
                    }
                    this.e += 4;
                    return c3;
                } else {
                    throw b("Unterminated escape sequence");
                }
            }
            return c2;
        }
        throw b("Unterminated escape sequence");
    }

    private IOException b(String str) throws IOException {
        throw new d(str + s());
    }

    private void z() throws IOException {
        b(true);
        int i2 = this.e - 1;
        this.e = i2;
        if (i2 + 5 <= this.f || b(5)) {
            char[] cArr = this.d;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.e += 5;
            }
        }
    }

    static {
        f.a = new f() {
            /* class com.bytedance.sdk.openadsdk.preload.a.d.a.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.preload.a.b.f
            public void a(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).o();
                    return;
                }
                int i = aVar.a;
                if (i == 0) {
                    i = aVar.r();
                }
                if (i == 13) {
                    aVar.a = 9;
                } else if (i == 12) {
                    aVar.a = 8;
                } else if (i == 14) {
                    aVar.a = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.s());
                }
            }
        };
    }
}
