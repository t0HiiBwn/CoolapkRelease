package com.bytedance.sdk.a.b.a.h;

import com.bytedance.sdk.a.a.j;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.g.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PublicSuffixDatabase */
public final class a {
    private static final byte[] a = {42};
    private static final String[] b = new String[0];
    private static final String[] c = {"*"};
    private static final a d = new a();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final CountDownLatch f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    public static a a() {
        return d;
    }

    public String a(String str) {
        int i;
        int i2;
        Objects.requireNonNull(str, "domain == null");
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a2 = a(split);
        if (split.length == a2.length && a2[0].charAt(0) != '!') {
            return null;
        }
        if (a2[0].charAt(0) == '!') {
            i2 = split.length;
            i = a2.length;
        } else {
            i2 = split.length;
            i = a2.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i3 = i2 - i; i3 < split2.length; i3++) {
            sb.append(split2[i3]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[LOOP:3: B:33:0x0066->B:38:0x0074, LOOP_START, PHI: r1 
      PHI: (r1v2 int) = (r1v0 int), (r1v3 int) binds: [B:32:0x0064, B:38:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0091  */
    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i = 0;
        if (this.e.get() || !this.e.compareAndSet(false, true)) {
            try {
                this.f.await();
            } catch (InterruptedException unused) {
            }
        } else {
            b();
        }
        synchronized (this) {
            if (this.g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(c.e);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.g, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            int i4 = 0;
            while (true) {
                if (i4 >= bArr2.length - 1) {
                    break;
                }
                bArr2[i4] = a;
                str3 = a(this.g, bArr2, i4);
                if (str3 != null) {
                    break;
                }
                i4++;
            }
            if (str3 != null) {
                while (true) {
                    if (i >= length - 1) {
                        break;
                    }
                    String a2 = a(this.h, bArr, i);
                    if (a2 != null) {
                        str = a2;
                        break;
                    }
                    i++;
                }
            }
            if (str == null) {
                return ("!" + str).split("\\.");
            } else if (str2 == null && str3 == null) {
                return c;
            } else {
                String[] split = str2 != null ? str2.split("\\.") : b;
                String[] split2 = str3 != null ? str3.split("\\.") : b;
                return split.length > split2.length ? split : split2;
            }
        }
        str3 = null;
        if (str3 != null) {
        }
        if (str == null) {
        }
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else if (i10 == bArr2.length - 1) {
                        break;
                    } else {
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, c.e);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void b() {
        boolean z = false;
        while (true) {
            try {
                c();
                break;
            } catch (InterruptedIOException unused) {
                z = true;
            } catch (IOException e2) {
                e.b().a(5, "Failed to read public suffix list", e2);
                if (z) {
                    Thread.currentThread().interrupt();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void c() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            com.bytedance.sdk.a.a.e a2 = l.a(new j(l.a(resourceAsStream)));
            try {
                byte[] bArr = new byte[a2.j()];
                a2.a(bArr);
                byte[] bArr2 = new byte[a2.j()];
                a2.a(bArr2);
                synchronized (this) {
                    this.g = bArr;
                    this.h = bArr2;
                }
                this.f.countDown();
            } finally {
                c.a(a2);
            }
        }
    }
}
