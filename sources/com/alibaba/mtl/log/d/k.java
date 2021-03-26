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
    static FileChannel f63a;

    /* renamed from: a  reason: collision with other field name */
    static FileLock f64a;

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
            if (f63a == null) {
                try {
                    f63a = new RandomAccessFile(a, "rw").getChannel();
                } catch (Exception unused2) {
                    return false;
                }
            }
            try {
                fileLock = f63a.tryLock();
                if (fileLock != null) {
                    f64a = fileLock;
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
            FileLock fileLock = f64a;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    f64a = null;
                    throw th;
                }
                f64a = null;
            }
            FileChannel fileChannel = f63a;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    f63a = null;
                    throw th2;
                }
                f63a = null;
            }
        }
    }
}
