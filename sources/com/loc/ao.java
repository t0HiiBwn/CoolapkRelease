package com.loc;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class ao implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final Charset b = Charset.forName("US-ASCII");
    static final Charset c = Charset.forName("UTF-8");
    static ThreadPoolExecutor d;
    private static final ThreadFactory r;
    private static final OutputStream t = new OutputStream() {
        /* class com.loc.ao.AnonymousClass3 */

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    };
    private final File e;
    private final File f;
    private final File g;
    private final File h;
    private final int i;
    private long j;
    private final int k;
    private long l = 0;
    private Writer m;
    private int n = 1000;
    private final LinkedHashMap<String, c> o = new LinkedHashMap<>(0, 0.75f, true);
    private int p;
    private long q = 0;
    private final Callable<Void> s = new Callable<Void>() {
        /* class com.loc.ao.AnonymousClass2 */

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (ao.this) {
                if (ao.this.m == null) {
                    return null;
                }
                ao.this.l();
                if (ao.this.j()) {
                    ao.this.i();
                    ao.this.p = 0;
                }
                return null;
            }
        }
    };

    /* compiled from: DiskLruCache */
    public final class a {
        private final c b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        /* renamed from: com.loc.ao$a$a  reason: collision with other inner class name */
        /* compiled from: DiskLruCache */
        private class C0084a extends FilterOutputStream {
            private C0084a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0084a(a aVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }
        }

        private a(c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[ao.this.k];
        }

        /* synthetic */ a(ao aoVar, c cVar, byte b2) {
            this(cVar);
        }

        public final OutputStream a() throws IOException {
            FileOutputStream fileOutputStream;
            C0084a aVar;
            if (ao.this.k > 0) {
                synchronized (ao.this) {
                    if (this.b.e == this) {
                        if (!this.b.d) {
                            this.c[0] = true;
                        }
                        File b2 = this.b.b(0);
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused) {
                            ao.this.e.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(b2);
                            } catch (FileNotFoundException unused2) {
                                return ao.t;
                            }
                        }
                        aVar = new C0084a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + ao.this.k);
        }

        public final void b() throws IOException {
            if (this.d) {
                ao.this.a(this, false);
                ao.this.c(this.b.b);
            } else {
                ao.this.a(this, true);
            }
            this.e = true;
        }

        public final void c() throws IOException {
            ao.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    public final class b implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        private b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        /* synthetic */ b(ao aoVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b2) {
            this(str, j, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.d) {
                ao.a(inputStream);
            }
        }
    }

    /* compiled from: DiskLruCache */
    private final class c {
        private final String b;
        private final long[] c;
        private boolean d;
        private a e;
        private long f;

        private c(String str) {
            this.b = str;
            this.c = new long[ao.this.k];
        }

        /* synthetic */ c(ao aoVar, String str, byte b2) {
            this(str);
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length == ao.this.k) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        cVar.c[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        public final File a(int i) {
            File file = ao.this.e;
            return new File(file, this.b + "." + i);
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.c;
            for (long j : jArr) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final File b(int i) {
            File file = ao.this.e;
            return new File(file, this.b + "." + i + ".tmp");
        }
    }

    static {
        AnonymousClass1 r8 = new ThreadFactory() {
            /* class com.loc.ao.AnonymousClass1 */
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
            }
        };
        r = r8;
        d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
    }

    private ao(File file, long j2) {
        this.e = file;
        this.i = 1;
        this.f = new File(file, "journal");
        this.g = new File(file, "journal.tmp");
        this.h = new File(file, "journal.bkp");
        this.k = 1;
        this.j = j2;
    }

    public static ao a(File file, long j2) throws IOException {
        if (j2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            ao aoVar = new ao(file, j2);
            if (aoVar.f.exists()) {
                try {
                    aoVar.g();
                    aoVar.h();
                    aoVar.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aoVar.f, true), b));
                    return aoVar;
                } catch (Throwable unused) {
                    aoVar.d();
                }
            }
            file.mkdirs();
            ao aoVar2 = new ao(file, j2);
            aoVar2.i();
            return aoVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void a() {
        ThreadPoolExecutor threadPoolExecutor = d;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            d.shutdown();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(a aVar, boolean z) throws IOException {
        c cVar = aVar.b;
        if (cVar.e == aVar) {
            if (z && !cVar.d) {
                for (int i2 = 0; i2 < this.k; i2++) {
                    if (!aVar.c[i2]) {
                        aVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!cVar.b(i2).exists()) {
                        aVar.c();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.k; i3++) {
                File b2 = cVar.b(i3);
                if (!z) {
                    a(b2);
                } else if (b2.exists()) {
                    File a2 = cVar.a(i3);
                    b2.renameTo(a2);
                    long j2 = cVar.c[i3];
                    long length = a2.length();
                    cVar.c[i3] = length;
                    this.l = (this.l - j2) + length;
                }
            }
            this.p++;
            cVar.e = null;
            if (cVar.d || z) {
                cVar.d = true;
                this.m.write("CLEAN " + cVar.b + cVar.a() + '\n');
                if (z) {
                    long j3 = this.q;
                    this.q = 1 + j3;
                    cVar.f = j3;
                }
            } else {
                this.o.remove(cVar.b);
                this.m.write("REMOVE " + cVar.b + '\n');
            }
            this.m.flush();
            if (this.l > this.j || j()) {
                f().submit(this.s);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    private synchronized a d(String str) throws IOException {
        k();
        e(str);
        c cVar = this.o.get(str);
        if (cVar == null) {
            cVar = new c(this, str, (byte) 0);
            this.o.put(str, cVar);
        } else if (cVar.e != null) {
            return null;
        }
        a aVar = new a(this, cVar, (byte) 0);
        cVar.e = aVar;
        Writer writer = this.m;
        writer.write("DIRTY " + str + '\n');
        this.m.flush();
        return aVar;
    }

    private static void e(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private static ThreadPoolExecutor f() {
        try {
            ThreadPoolExecutor threadPoolExecutor = d;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return d;
    }

    private void g() throws IOException {
        String a2;
        String a3;
        String a4;
        String a5;
        String a6;
        String a7;
        int indexOf;
        String str;
        ap apVar = new ap(new FileInputStream(this.f), b);
        try {
            a2 = apVar.a();
            a3 = apVar.a();
            a4 = apVar.a();
            a5 = apVar.a();
            a6 = apVar.a();
        } finally {
            a(apVar);
        }
        if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.i).equals(a4) || !Integer.toString(this.k).equals(a5) || !"".equals(a6)) {
            throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
        }
        int i2 = 0;
        while (true) {
            try {
                a7 = apVar.a();
                indexOf = a7.indexOf(32);
            } catch (EOFException unused) {
                this.p = i2 - this.o.size();
                return;
            }
            if (indexOf != -1) {
                int i3 = indexOf + 1;
                int indexOf2 = a7.indexOf(32, i3);
                if (indexOf2 == -1) {
                    str = a7.substring(i3);
                    if (indexOf == 6 && a7.startsWith("REMOVE")) {
                        this.o.remove(str);
                        i2++;
                    }
                } else {
                    str = a7.substring(i3, indexOf2);
                }
                c cVar = this.o.get(str);
                if (cVar == null) {
                    cVar = new c(this, str, (byte) 0);
                    this.o.put(str, cVar);
                }
                if (indexOf2 != -1 && indexOf == 5 && a7.startsWith("CLEAN")) {
                    String[] split = a7.substring(indexOf2 + 1).split(" ");
                    cVar.d = true;
                    cVar.e = null;
                    c.a(cVar, split);
                    i2++;
                } else if (indexOf2 == -1 && indexOf == 5 && a7.startsWith("DIRTY")) {
                    cVar.e = new a(this, cVar, (byte) 0);
                    i2++;
                } else if (indexOf2 != -1 || indexOf != 4 || !a7.startsWith("READ")) {
                    break;
                } else {
                    i2++;
                }
            } else {
                throw new IOException("unexpected journal line: " + a7);
            }
        }
        throw new IOException("unexpected journal line: " + a7);
    }

    private void h() throws IOException {
        a(this.g);
        Iterator<c> it2 = this.o.values().iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.k) {
                    this.l += next.c[i2];
                    i2++;
                }
            } else {
                next.e = null;
                while (i2 < this.k) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void i() throws IOException {
        Writer writer = this.m;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g), b));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.k));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.o.values()) {
                bufferedWriter.write(cVar.e != null ? "DIRTY " + cVar.b + '\n' : "CLEAN " + cVar.b + cVar.a() + '\n');
            }
            bufferedWriter.close();
            if (this.f.exists()) {
                a(this.f, this.h, true);
            }
            a(this.g, this.f, false);
            this.h.delete();
            this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f, true), b));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public boolean j() {
        int i2 = this.p;
        return i2 >= 2000 && i2 >= this.o.size();
    }

    private void k() {
        if (this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    public void l() throws IOException {
        while (true) {
            if (this.l > this.j || this.o.size() > this.n) {
                c(this.o.entrySet().iterator().next().getKey());
            } else {
                return;
            }
        }
    }

    public final synchronized b a(String str) throws IOException {
        k();
        e(str);
        c cVar = this.o.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.k];
        int i2 = 0;
        for (int i3 = 0; i3 < this.k; i3++) {
            try {
                inputStreamArr[i3] = new FileInputStream(cVar.a(i3));
            } catch (FileNotFoundException unused) {
                while (i2 < this.k && inputStreamArr[i2] != null) {
                    a(inputStreamArr[i2]);
                    i2++;
                }
                return null;
            }
        }
        this.p++;
        this.m.append((CharSequence) ("READ " + str + '\n'));
        if (j()) {
            f().submit(this.s);
        }
        return new b(this, str, cVar.f, inputStreamArr, cVar.c, (byte) 0);
    }

    public final void a(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 10000) {
            i2 = 10000;
        }
        this.n = i2;
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    public final File b() {
        return this.e;
    }

    public final synchronized void c() throws IOException {
        k();
        l();
        this.m.flush();
    }

    public final synchronized boolean c(String str) throws IOException {
        k();
        e(str);
        c cVar = this.o.get(str);
        if (cVar != null) {
            if (cVar.e == null) {
                for (int i2 = 0; i2 < this.k; i2++) {
                    File a2 = cVar.a(i2);
                    if (a2.exists()) {
                        if (!a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                    }
                    this.l -= cVar.c[i2];
                    cVar.c[i2] = 0;
                }
                this.p++;
                this.m.append((CharSequence) ("REMOVE " + str + '\n'));
                this.o.remove(str);
                if (j()) {
                    f().submit(this.s);
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.m != null) {
            Iterator it2 = new ArrayList(this.o.values()).iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                if (cVar.e != null) {
                    cVar.e.c();
                }
            }
            l();
            this.m.close();
            this.m = null;
        }
    }

    public final void d() throws IOException {
        close();
        b(this.e);
    }
}
