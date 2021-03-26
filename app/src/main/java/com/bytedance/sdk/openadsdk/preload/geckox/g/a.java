package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ChannelUpdateLock */
public class a {
    private static final Map<String, Lock> a = new HashMap();
    private FileLock b;
    private String c;

    private a(String str, FileLock fileLock) {
        this.c = str;
        this.b = fileLock;
    }

    public static a a(String str) throws Exception {
        Map<String, Lock> map = a;
        synchronized (map) {
            Lock lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
            if (!lock.tryLock()) {
                return null;
            }
            try {
                FileLock c2 = FileLock.c(str);
                if (c2 == null) {
                    lock.unlock();
                    return null;
                }
                return new a(str, c2);
            } catch (Exception e) {
                lock.lock();
                c.a(new RuntimeException(e));
                return null;
            }
        }
    }

    public void a() {
        Map<String, Lock> map = a;
        synchronized (map) {
            try {
                this.b.a();
                this.b.b();
                map.get(this.c).unlock();
            } catch (Throwable th) {
                a.get(this.c).unlock();
                throw th;
            }
        }
    }
}
