package com.bytedance.sdk.openadsdk.preload.a.b;

import com.bytedance.sdk.openadsdk.preload.a.b.a.n;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.d.d;
import com.bytedance.sdk.openadsdk.preload.a.p;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* compiled from: Streams */
public final class l {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.bytedance.sdk.openadsdk.preload.a.m(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.bytedance.sdk.openadsdk.preload.a.t(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.bytedance.sdk.openadsdk.preload.a.n.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.bytedance.sdk.openadsdk.preload.a.t(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.bytedance.sdk.openadsdk.preload.a.t(r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: d (r2v4 'e' com.bytedance.sdk.openadsdk.preload.a.d.d A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    public static com.bytedance.sdk.openadsdk.preload.a.l a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws p {
        boolean z;
        try {
            aVar.f();
            z = false;
            return n.X.b(aVar);
        } catch (EOFException e) {
            EOFException e2 = e;
            z = true;
            if (!z) {
            }
        } catch (d e3) {
        } catch (IOException e4) {
        } catch (NumberFormatException e5) {
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.a.l lVar, c cVar) throws IOException {
        n.X.a(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* compiled from: Streams */
    private static final class a extends Writer {
        private final Appendable a;
        private final C0062a b = new C0062a();

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        a(Appendable appendable) {
            this.a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.b.a = cArr;
            this.a.append(this.b, i, i2 + i);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.a.append((char) i);
        }

        /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.l$a$a  reason: collision with other inner class name */
        /* compiled from: Streams */
        static class C0062a implements CharSequence {
            char[] a;

            C0062a() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.a[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.a, i, i2 - i);
            }
        }
    }
}
