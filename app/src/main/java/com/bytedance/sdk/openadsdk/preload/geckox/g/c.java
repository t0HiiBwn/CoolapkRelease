package com.bytedance.sdk.openadsdk.preload.geckox.g;

import android.os.Process;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.d;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.f;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: UsingLock */
public class c {
    private static final Map<String, Pair<FileLock, AtomicLong>> a = new HashMap();

    public static void a(String str) throws Exception {
        Map<String, Pair<FileLock, AtomicLong>> map = a;
        synchronized (map) {
            Pair<FileLock, AtomicLong> pair = map.get(str);
            if (pair == null) {
                Pair<FileLock, AtomicLong> pair2 = new Pair<>(FileLock.a(str, Process.myPid()), new AtomicLong(0));
                map.put(str, pair2);
                pair = pair2;
            }
            ((AtomicLong) pair.second).incrementAndGet();
        }
    }

    public static void b(String str) throws Exception {
        Map<String, Pair<FileLock, AtomicLong>> map = a;
        synchronized (map) {
            Pair<FileLock, AtomicLong> pair = map.get(str);
            if (pair != null) {
                int i = (((AtomicLong) pair.second).decrementAndGet() > 0 ? 1 : (((AtomicLong) pair.second).decrementAndGet() == 0 ? 0 : -1));
                if (i < 0) {
                    throw new RuntimeException("using.lock count illegal");
                } else if (i == 0) {
                    ((FileLock) pair.first).a();
                    map.remove(str);
                }
            } else {
                throw new RuntimeException("using.lock illegal state");
            }
        }
    }

    public static void c(String str) throws Exception {
        Map<String, Pair<FileLock, AtomicLong>> map = a;
        synchronized (map) {
            FileLock b = FileLock.b(str);
            if (b != null) {
                Pair<FileLock, AtomicLong> pair = map.get(str);
                if (pair == null || ((AtomicLong) pair.second).get() == 0) {
                    File parentFile = new File(str).getParentFile();
                    final File file = new File(parentFile.getAbsolutePath() + "--pending-delete");
                    if (parentFile.renameTo(file)) {
                        b.a();
                        b.b();
                        f.a().execute(new Runnable() {
                            /* class com.bytedance.sdk.openadsdk.preload.geckox.g.c.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                d.a(file);
                            }
                        });
                    }
                    return;
                }
                b.a();
                FileLock.a(str, Process.myPid());
            }
        }
    }
}
