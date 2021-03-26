package com.bytedance.sdk.openadsdk.preload.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: JsonWriter */
public class c implements Closeable, Flushable {
    private static final String[] a = new String[128];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            a[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.g = ":";
        this.k = true;
        Objects.requireNonNull(writer, "out == null");
        this.c = writer;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f = null;
            this.g = ":";
            return;
        }
        this.f = str;
        this.g = ": ";
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public boolean g() {
        return this.h;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public final boolean h() {
        return this.i;
    }

    public final void d(boolean z) {
        this.k = z;
    }

    public final boolean i() {
        return this.k;
    }

    public c b() throws IOException {
        j();
        return a(1, '[');
    }

    public c c() throws IOException {
        return a(1, 2, ']');
    }

    public c d() throws IOException {
        j();
        return a(3, '{');
    }

    public c e() throws IOException {
        return a(3, 5, '}');
    }

    private c a(int i2, char c2) throws IOException {
        m();
        a(i2);
        this.c.write(c2);
        return this;
    }

    private c a(int i2, int i3, char c2) throws IOException {
        int a2 = a();
        if (a2 != i3 && a2 != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.j == null) {
            this.e--;
            if (a2 == i3) {
                k();
            }
            this.c.write(c2);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.j);
        }
    }

    private void a(int i2) {
        int i3 = this.e;
        int[] iArr = this.d;
        if (i3 == iArr.length) {
            this.d = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.d;
        int i4 = this.e;
        this.e = i4 + 1;
        iArr2[i4] = i2;
    }

    private int a() {
        int i2 = this.e;
        if (i2 != 0) {
            return this.d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void b(int i2) {
        this.d[this.e - 1] = i2;
    }

    public c a(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.j != null) {
            throw new IllegalStateException();
        } else if (this.e != 0) {
            this.j = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    private void j() throws IOException {
        if (this.j != null) {
            l();
            d(this.j);
            this.j = null;
        }
    }

    public c b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        j();
        m();
        d(str);
        return this;
    }

    public c f() throws IOException {
        if (this.j != null) {
            if (this.k) {
                j();
            } else {
                this.j = null;
                return this;
            }
        }
        m();
        this.c.write("null");
        return this;
    }

    public c a(boolean z) throws IOException {
        j();
        m();
        this.c.write(z ? "true" : "false");
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return f();
        }
        j();
        m();
        this.c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c a(long j2) throws IOException {
        j();
        m();
        this.c.write(Long.toString(j2));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        j();
        String obj = number.toString();
        if (this.h || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            m();
            this.c.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.e != 0) {
            this.c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
        int i2 = this.e;
        if (i2 > 1 || (i2 == 1 && this.d[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    private void d(String str) throws IOException {
        String str2;
        String[] strArr = this.i ? b : a;
        this.c.write(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                this.c.write(str, i2, i3 - i2);
            }
            this.c.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.c.write(str, i2, length - i2);
        }
        this.c.write(34);
    }

    private void k() throws IOException {
        if (this.f != null) {
            this.c.write(10);
            int i2 = this.e;
            for (int i3 = 1; i3 < i2; i3++) {
                this.c.write(this.f);
            }
        }
    }

    private void l() throws IOException {
        int a2 = a();
        if (a2 == 5) {
            this.c.write(44);
        } else if (a2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void m() throws IOException {
        int a2 = a();
        if (a2 == 1) {
            b(2);
            k();
        } else if (a2 == 2) {
            this.c.append(',');
            k();
        } else if (a2 != 4) {
            if (a2 != 6) {
                if (a2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        } else {
            this.c.append((CharSequence) this.g);
            b(5);
        }
    }
}
