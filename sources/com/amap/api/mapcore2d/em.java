package com.amap.api.mapcore2d;

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
public final class em implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static ThreadPoolExecutor b;
    private static final ThreadFactory q;
    private static final OutputStream s = new OutputStream() {
        /* class com.amap.api.mapcore2d.em.AnonymousClass3 */

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private final int i;
    private long j = 0;
    private Writer k;
    private int l = 1000;
    private final LinkedHashMap<String, c> m = new LinkedHashMap<>(0, 0.75f, true);
    private int n;
    private en o;
    private long p = 0;
    private final Callable<Void> r = new Callable<Void>() {
        /* class com.amap.api.mapcore2d.em.AnonymousClass2 */

        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (em.this) {
                if (em.this.k == null) {
                    return null;
                }
                em.this.l();
                if (em.this.j()) {
                    em.this.i();
                    em.this.n = 0;
                }
                return null;
            }
        }
    };

    static {
        AnonymousClass1 r8 = new ThreadFactory() {
            /* class com.amap.api.mapcore2d.em.AnonymousClass1 */
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
            }
        };
        q = r8;
        b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
    }

    public void a(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 10000) {
            i2 = 10000;
        }
        this.l = i2;
    }

    public static void a() {
        ThreadPoolExecutor threadPoolExecutor = b;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            b.shutdown();
        }
    }

    public static ThreadPoolExecutor b() {
        try {
            ThreadPoolExecutor threadPoolExecutor = b;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), q);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b;
    }

    private em(File file, int i2, int i3, long j2) {
        this.c = file;
        this.g = i2;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = i3;
        this.h = j2;
    }

    public static em a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            em emVar = new em(file, i2, i3, j2);
            if (emVar.d.exists()) {
                try {
                    emVar.g();
                    emVar.h();
                    emVar.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(emVar.d, true), ep.a));
                    return emVar;
                } catch (Throwable unused) {
                    emVar.e();
                }
            }
            file.mkdirs();
            em emVar2 = new em(file, i2, i3, j2);
            emVar2.i();
            return emVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void g() throws IOException {
        eo eoVar = new eo(new FileInputStream(this.d), ep.a);
        try {
            String a2 = eoVar.a();
            String a3 = eoVar.a();
            String a4 = eoVar.a();
            String a5 = eoVar.a();
            String a6 = eoVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.g).equals(a4) || !Integer.toString(this.i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    d(eoVar.a());
                    i2++;
                } catch (EOFException unused) {
                    this.n = i2 - this.m.size();
                    return;
                }
            }
        } finally {
            ep.a(eoVar);
        }
    }

    private void d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.m.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            c cVar = this.m.get(str2);
            if (cVar == null) {
                cVar = new c(str2);
                this.m.put(str2, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.d = true;
                cVar.e = null;
                cVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.e = new a(cVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void h() throws IOException {
        a(this.e);
        Iterator<c> it2 = this.m.values().iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.i) {
                    this.j += next.c[i2];
                    i2++;
                }
            } else {
                next.e = null;
                while (i2 < this.i) {
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
        Writer writer = this.k;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), ep.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.m.values()) {
                if (cVar.e != null) {
                    bufferedWriter.write("DIRTY " + cVar.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.b + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.d.exists()) {
                a(this.d, this.f, true);
            }
            a(this.e, this.d, false);
            this.f.delete();
            this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), ep.a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
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

    public synchronized b a(String str) throws IOException {
        k();
        e(str);
        c cVar = this.m.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.i; i3++) {
            try {
                inputStreamArr[i3] = new FileInputStream(cVar.a(i3));
            } catch (FileNotFoundException unused) {
                while (i2 < this.i && inputStreamArr[i2] != null) {
                    ep.a(inputStreamArr[i2]);
                    i2++;
                }
                return null;
            }
        }
        this.n++;
        this.k.append((CharSequence) ("READ " + str + '\n'));
        if (j()) {
            b().submit(this.r);
        }
        return new b(str, cVar.f, inputStreamArr, cVar.c);
    }

    public a b(String str) throws IOException {
        return a(str, -1);
    }

    private synchronized a a(String str, long j2) throws IOException {
        k();
        e(str);
        c cVar = this.m.get(str);
        if (j2 != -1 && (cVar == null || cVar.f != j2)) {
            return null;
        }
        if (cVar == null) {
            cVar = new c(str);
            this.m.put(str, cVar);
        } else if (cVar.e != null) {
            return null;
        }
        a aVar = new a(cVar);
        cVar.e = aVar;
        Writer writer = this.k;
        writer.write("DIRTY " + str + '\n');
        this.k.flush();
        return aVar;
    }

    public File c() {
        return this.c;
    }

    /* access modifiers changed from: private */
    public synchronized void a(a aVar, boolean z) throws IOException {
        c cVar = aVar.b;
        if (cVar.e == aVar) {
            if (z && !cVar.d) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    if (!aVar.c[i2]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!cVar.b(i2).exists()) {
                        aVar.b();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.i; i3++) {
                File b2 = cVar.b(i3);
                if (!z) {
                    a(b2);
                } else if (b2.exists()) {
                    File a2 = cVar.a(i3);
                    b2.renameTo(a2);
                    long j2 = cVar.c[i3];
                    long length = a2.length();
                    cVar.c[i3] = length;
                    this.j = (this.j - j2) + length;
                }
            }
            this.n++;
            cVar.e = null;
            if (cVar.d || z) {
                cVar.d = true;
                this.k.write("CLEAN " + cVar.b + cVar.a() + '\n');
                if (z) {
                    long j3 = this.p;
                    this.p = 1 + j3;
                    cVar.f = j3;
                }
            } else {
                this.m.remove(cVar.b);
                this.k.write("REMOVE " + cVar.b + '\n');
            }
            this.k.flush();
            if (this.j > this.h || j()) {
                b().submit(this.r);
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: private */
    public boolean j() {
        int i2 = this.n;
        return i2 >= 2000 && i2 >= this.m.size();
    }

    public synchronized boolean c(String str) throws IOException {
        k();
        e(str);
        c cVar = this.m.get(str);
        if (cVar != null) {
            if (cVar.e == null) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    File a2 = cVar.a(i2);
                    if (a2.exists()) {
                        if (!a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                    }
                    this.j -= cVar.c[i2];
                    cVar.c[i2] = 0;
                }
                this.n++;
                this.k.append((CharSequence) ("REMOVE " + str + '\n'));
                this.m.remove(str);
                if (j()) {
                    b().submit(this.r);
                }
                return true;
            }
        }
        return false;
    }

    private void k() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void d() throws IOException {
        k();
        l();
        this.k.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.k != null) {
            Iterator it2 = new ArrayList(this.m.values()).iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                if (cVar.e != null) {
                    cVar.e.b();
                }
            }
            l();
            this.k.close();
            this.k = null;
        }
    }

    /* access modifiers changed from: private */
    public void l() throws IOException {
        while (true) {
            if (this.j > this.h || this.m.size() > this.l) {
                String key = this.m.entrySet().iterator().next().getKey();
                c(key);
                en enVar = this.o;
                if (enVar != null) {
                    enVar.a(key);
                }
            } else {
                return;
            }
        }
    }

    public void e() throws IOException {
        close();
        ep.a(this.c);
    }

    private void e(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
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

        public InputStream a(int i) {
            return this.d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.d) {
                ep.a(inputStream);
            }
        }
    }

    /* compiled from: DiskLruCache */
    public final class a {
        private final c b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        private a(c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[em.this.i];
        }

        public OutputStream a(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0019a aVar;
            if (i < 0 || i >= em.this.i) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + em.this.i);
            }
            synchronized (em.this) {
                if (this.b.e == this) {
                    if (!this.b.d) {
                        this.c[i] = true;
                    }
                    File b2 = this.b.b(i);
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused) {
                        em.this.c.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused2) {
                            return em.s;
                        }
                    }
                    aVar = new C0019a(fileOutputStream);
                } else {
                    throw new IllegalStateException();
                }
            }
            return aVar;
        }

        public void a() throws IOException {
            if (this.d) {
                em.this.a(this, false);
                em.this.c(this.b.b);
            } else {
                em.this.a(this, true);
            }
            this.e = true;
        }

        public void b() throws IOException {
            em.this.a(this, false);
        }

        /* renamed from: com.amap.api.mapcore2d.em$a$a  reason: collision with other inner class name */
        /* compiled from: DiskLruCache */
        private class C0019a extends FilterOutputStream {
            private C0019a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    a.this.d = true;
                }
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
            this.c = new long[em.this.i];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.c;
            for (long j : jArr) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length == em.this.i) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.c[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            File file = em.this.c;
            return new File(file, this.b + "." + i);
        }

        public File b(int i) {
            File file = em.this.c;
            return new File(file, this.b + "." + i + ".tmp");
        }
    }
}
