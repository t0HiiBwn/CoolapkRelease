package com.tencent.beacon.core.a;

import android.content.Context;
import com.tencent.beacon.core.d.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProcessTaskLocker */
public final class f {
    private static f c;
    private Context a = null;
    private Map<String, FileChannel> b = null;

    private f(Context context) {
        this.a = context;
        this.b = new HashMap(5);
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (c == null) {
                c = new f(context);
            }
            fVar = c;
        }
        return fVar;
    }

    public final synchronized boolean a(String str) {
        if (str.trim().length() <= 0) {
            return false;
        }
        if (this.b.containsKey(str)) {
            return true;
        }
        File b2 = b(str);
        if (b2 == null) {
            return true;
        }
        try {
            FileChannel fileChannel = this.b.get(str);
            if (fileChannel == null || !fileChannel.isOpen()) {
                b.b("[lock] file lock channel %s create successfully.", str);
                fileChannel = new FileOutputStream(b2).getChannel();
                this.b.put(str, fileChannel);
            }
            FileLock tryLock = fileChannel.tryLock();
            if (tryLock != null && tryLock.isValid()) {
                return true;
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return false;
    }

    private synchronized File b(String str) {
        File file = null;
        if (this.a.getFilesDir() == null) {
            return null;
        }
        try {
            File filesDir = this.a.getFilesDir();
            File file2 = new File(filesDir, "beacon_" + str + ".lock");
            if (!file2.exists()) {
                b.b("[lock] create lock file: %s", file2.getAbsolutePath());
                file2.createNewFile();
            }
            file = file2;
        } catch (IOException e) {
            b.a(e);
        }
        return file;
    }
}
