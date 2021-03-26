package com.alibaba.mtl.log.d;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: MutiProcessLock */
public class k {
    static File a;

    /* renamed from: a  reason: collision with other field name */
    static FileChannel f62a;

    /* renamed from: a  reason: collision with other field name */
    static FileLock f63a;

    public static synchronized boolean c(Context context) {
        FileLock fileLock;
        synchronized (k.class) {
            if (a == null) {
                a = new File(context.getFilesDir() + File.separator + "ap.Lock");
            }
            boolean exists = a.exists();
            if (!exists) {
                try {
                    exists = a.createNewFile();
                } catch (IOException unused) {
                }
            }
            if (!exists) {
                return true;
            }
            if (f62a == null) {
                try {
                    f62a = new RandomAccessFile(a, "rw").getChannel();
                } catch (Exception unused2) {
                    return false;
                }
            }
            try {
                fileLock = f62a.tryLock();
                if (fileLock != null) {
                    f63a = fileLock;
                    return true;
                }
            } catch (Throwable unused3) {
                fileLock = null;
            }
            Log.d("TAG", "mLock:" + fileLock);
            return false;
        }
    }

    public static synchronized void release() {
        synchronized (k.class) {
            FileLock fileLock = f63a;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    f63a = null;
                    throw th;
                }
                f63a = null;
            }
            FileChannel fileChannel = f62a;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    f62a = null;
                    throw th2;
                }
                f62a = null;
            }
        }
    }
}
