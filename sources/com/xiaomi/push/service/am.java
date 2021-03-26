package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.gm;
import com.xiaomi.push.jg;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

final class am implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ gm b;

    am(Context context, gm gmVar) {
        this.a = context;
        this.b = gmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Exception e;
        synchronized (al.a) {
            FileLock fileLock = null;
            try {
                File file = new File(this.a.getFilesDir(), "tiny_data.lock");
                jg.c(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    al.c(this.a, this.b);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                c.a(e2);
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        c.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                c.a(e4);
                            }
                        }
                        jg.a(randomAccessFile);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            c.a(e5);
                        }
                        jg.a(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                c.a(e);
                fileLock.release();
                jg.a(randomAccessFile);
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                jg.a(randomAccessFile);
                throw th;
            }
            jg.a(randomAccessFile);
        }
    }
}
