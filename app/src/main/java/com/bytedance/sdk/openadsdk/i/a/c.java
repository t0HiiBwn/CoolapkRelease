package com.bytedance.sdk.openadsdk.i.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: DiskLruCache */
public class c extends a {
    public final File a;
    private final LinkedHashMap<String, File> b = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock c;
    private final ReentrantReadWriteLock.ReadLock d;
    private final ReentrantReadWriteLock.WriteLock e;
    private final Set<a> f;
    private volatile long g;
    private volatile float h;
    private final b i;
    private final Runnable j;
    private final Handler k;

    /* compiled from: DiskLruCache */
    public interface a {
        void a(String str);

        void a(Set<String> set);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f.add(aVar);
        }
    }

    public c(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.e = reentrantReadWriteLock.writeLock();
        this.f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.g = 104857600;
        this.h = 0.5f;
        this.i = new b();
        this.j = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.i.a.c.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                e.a().execute(new g(1) {
                    /* class com.bytedance.sdk.openadsdk.i.a.c.AnonymousClass1.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b(c.this.g);
                    }
                });
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            if (file == null) {
                str = " dir null";
            } else {
                str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
            }
            throw new IOException("dir error!  " + str);
        }
        this.a = file;
        e.a().execute(new g(5) {
            /* class com.bytedance.sdk.openadsdk.i.a.c.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                c.this.b();
            }
        });
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public void b() {
        this.e.lock();
        try {
            File[] listFiles = this.a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() {
                    /* class com.bytedance.sdk.openadsdk.i.a.c.AnonymousClass3 */

                    /* renamed from: a */
                    public int compare(File file, File file2) {
                        int i = ((((Long) hashMap.get(file)).longValue() - ((Long) hashMap.get(file2)).longValue()) > 0 ? 1 : ((((Long) hashMap.get(file)).longValue() - ((Long) hashMap.get(file2)).longValue()) == 0 ? 0 : -1));
                        if (i < 0) {
                            return -1;
                        }
                        return i > 0 ? 1 : 0;
                    }
                });
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    File file2 = (File) it2.next();
                    this.b.put(a(file2), file2);
                }
            }
            this.e.unlock();
            c();
        } catch (Throwable th) {
            this.e.unlock();
            throw th;
        }
    }

    public void a(long j2) {
        this.g = j2;
        c();
    }

    private void c() {
        this.k.removeCallbacks(this.j);
        this.k.postDelayed(this.j, 10000);
    }

    public void a() {
        d.c().d();
        Context a2 = com.bytedance.sdk.openadsdk.i.e.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.i.b.c.a(a2).a(0);
        }
        this.k.removeCallbacks(this.j);
        e.a().execute(new g(1) {
            /* class com.bytedance.sdk.openadsdk.i.a.c.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(0);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.a(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.b(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public File c(String str) {
        this.d.lock();
        File file = this.b.get(str);
        this.d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.a, str);
        this.e.lock();
        this.b.put(str, file2);
        this.e.unlock();
        for (a aVar : this.f) {
            aVar.a(str);
        }
        c();
        return file2;
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public File d(String str) {
        if (!this.d.tryLock()) {
            return null;
        }
        File file = this.b.get(str);
        this.d.unlock();
        return file;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e4 A[LOOP:3: B:40:0x00de->B:42:0x00e4, LOOP_END] */
    public void b(long j2) {
        HashSet hashSet;
        Throwable th;
        final HashSet hashSet2 = new HashSet();
        this.e.lock();
        long j3 = 0;
        HashSet hashSet3 = null;
        try {
            for (Map.Entry<String, File> entry : this.b.entrySet()) {
                j3 += entry.getValue().length();
            }
            if (j3 <= j2) {
                this.e.unlock();
                return;
            }
            long j4 = (long) (((float) j2) * this.h);
            hashSet = new HashSet();
            try {
                for (Map.Entry<String, File> entry2 : this.b.entrySet()) {
                    File value = entry2.getValue();
                    if (value == null || !value.exists()) {
                        hashSet.add(entry2.getKey());
                    } else if (!this.i.c(a(value))) {
                        long length = value.length();
                        File file = new File(value.getAbsolutePath() + "-tmp");
                        if (value.renameTo(file)) {
                            hashSet2.add(file);
                            j3 -= length;
                            hashSet.add(entry2.getKey());
                        }
                    }
                    if (j3 <= j4) {
                        break;
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    this.b.remove((String) it2.next());
                }
                this.e.unlock();
            } catch (Throwable th2) {
                th = th2;
                hashSet3 = hashSet;
                try {
                    th.printStackTrace();
                    this.e.unlock();
                    hashSet = hashSet3;
                    while (r13.hasNext()) {
                    }
                    e.a().execute(new g(1) {
                        /* class com.bytedance.sdk.openadsdk.i.a.c.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            Iterator it2 = hashSet2.iterator();
                            while (it2.hasNext()) {
                                try {
                                    ((File) it2.next()).delete();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    });
                } catch (Throwable th3) {
                    this.e.unlock();
                    throw th3;
                }
            }
            for (a aVar : this.f) {
                aVar.a(hashSet);
            }
            e.a().execute(new g(1) {
                /* class com.bytedance.sdk.openadsdk.i.a.c.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = hashSet2.iterator();
                    while (it2.hasNext()) {
                        try {
                            ((File) it2.next()).delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            this.e.unlock();
            hashSet = hashSet3;
            while (r13.hasNext()) {
            }
            e.a().execute(new g(1) {
                /* class com.bytedance.sdk.openadsdk.i.a.c.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = hashSet2.iterator();
                    while (it2.hasNext()) {
                        try {
                            ((File) it2.next()).delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }

    private String a(File file) {
        return file.getName();
    }

    /* compiled from: DiskLruCache */
    private static final class b {
        private final Map<String, Integer> a;

        private b() {
            this.a = new HashMap();
        }

        synchronized void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.a.get(str);
                if (num == null) {
                    this.a.put(str, 1);
                } else {
                    this.a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        synchronized void b(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.a.remove(str);
                } else {
                    this.a.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        synchronized boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.a.containsKey(str);
        }
    }
}
