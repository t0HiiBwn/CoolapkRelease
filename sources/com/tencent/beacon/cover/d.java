package com.tencent.beacon.cover;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CoverLocker */
public final class d {
    private static d c;
    private Context a = null;
    private Map<String, FileChannel> b = null;

    private d(Context context) {
        this.a = context;
        this.b = new HashMap(5);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (c == null) {
                c = new d(context);
            }
            dVar = c;
        }
        return dVar;
    }

    public final synchronized boolean a(String str) {
        if (str.trim().length() <= 0) {
            return false;
        }
        if (this.b.containsKey(str)) {
            return true;
        }
        File c2 = c(str);
        if (c2 == null) {
            return true;
        }
        try {
            FileChannel fileChannel = this.b.get(str);
            if (fileChannel == null || !fileChannel.isOpen()) {
                fileChannel = new FileOutputStream(c2).getChannel();
                this.b.put(str, fileChannel);
            }
            FileLock lock = fileChannel.lock();
            if (lock != null && lock.isValid()) {
                return true;
            }
        } catch (Throwable th) {
            g.a("W", "lock task error.", new Object[0]);
            th.printStackTrace();
        }
        return false;
    }

    public final synchronized void b(String str) {
        if (str.trim().length() > 0) {
            FileChannel fileChannel = this.b.get(str);
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Throwable th) {
                    g.a("W", "release task error.", new Object[0]);
                    th.printStackTrace();
                }
            }
        }
    }

    private synchronized File c(String str) {
        File file = null;
        if (this.a.getFilesDir() == null) {
            return null;
        }
        try {
            File filesDir = this.a.getFilesDir();
            File file2 = new File(filesDir, "beacon_cover_" + str + ".lock");
            if (!file2.exists()) {
                g.a("D", " create lock file: %s", file2.getAbsolutePath());
                file2.createNewFile();
            }
            file = file2;
        } catch (IOException unused) {
            g.a("W", "create lock file error.", new Object[0]);
        }
        return file;
    }
}
