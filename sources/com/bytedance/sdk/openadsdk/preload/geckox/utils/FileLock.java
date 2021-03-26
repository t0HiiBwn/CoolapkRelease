package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileLock {
    private static final Map<String, Integer> a = new HashMap();
    private final int b;
    private final String c;

    private static native int nGetFD(String str) throws Exception;

    private static native void nLockFile(int i) throws Exception;

    private static native void nLockFileSegment(int i, int i2) throws Exception;

    private static native void nRelease(int i) throws Exception;

    private static native boolean nTryLock(int i) throws Exception;

    private static native void nUnlockFile(int i) throws Exception;

    static {
        g.a("file_lock_pg");
    }

    private FileLock(String str, int i) {
        this.c = str;
        this.b = i;
    }

    public static FileLock a(String str) {
        try {
            int d = d(str);
            nLockFile(d);
            return new FileLock(str, d);
        } catch (Exception e) {
            throw new RuntimeException("lock failed, file:" + str + ", pid:" + Process.myPid() + " caused by:" + e.getMessage());
        }
    }

    public static FileLock b(String str) {
        try {
            int d = d(str);
            if (!nTryLock(d)) {
                return null;
            }
            return new FileLock(str, d);
        } catch (Exception e) {
            throw new RuntimeException("try lock failed, file:" + str + " caused by:" + e.getMessage());
        }
    }

    public static FileLock c(String str) throws Exception {
        try {
            int d = d(str);
            if (nTryLock(d)) {
                return new FileLock(str, d);
            }
            new FileLock(str, d).b();
            return null;
        } catch (Exception e) {
            throw new RuntimeException("try lock failed, file:" + str + " caused by:" + e.getMessage());
        }
    }

    public static FileLock a(String str, int i) {
        try {
            int d = d(str);
            nLockFileSegment(d, i);
            return new FileLock(str, d);
        } catch (Exception e) {
            throw new RuntimeException("lock segment failed, file:" + str + " caused by:" + e.getMessage());
        }
    }

    private static int d(String str) throws Exception {
        Integer num;
        Map<String, Integer> map = a;
        synchronized (map) {
            num = map.get(str);
            if (num == null) {
                new File(str).getParentFile().mkdirs();
                num = Integer.valueOf(nGetFD(str));
                map.put(str, num);
            }
        }
        return num.intValue();
    }

    public void a() {
        try {
            nUnlockFile(this.b);
        } catch (Exception unused) {
            throw new RuntimeException("release lock failed，path:" + this.c);
        }
    }

    public void b() {
        Integer remove;
        Map<String, Integer> map = a;
        synchronized (map) {
            remove = map.remove(this.c);
        }
        try {
            nRelease(remove.intValue());
        } catch (Exception e) {
            throw new RuntimeException("release lock failed, file:" + this.c + " caused by:" + e.getMessage());
        }
    }
}
