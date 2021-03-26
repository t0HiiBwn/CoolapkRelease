package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hg;
import com.xiaomi.push.y;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

final class bn implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hg f1005a;

    bn(Context context, hg hgVar) {
        this.a = context;
        this.f1005a = hgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Exception e;
        synchronized (bm.a) {
            FileLock fileLock = null;
            try {
                File file = new File(this.a.getFilesDir(), "tiny_data.lock");
                y.m681a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    bm.c(this.a, this.f1005a);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                b.a(e2);
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                b.a(e4);
                            }
                        }
                        y.a(randomAccessFile);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            b.a(e5);
                        }
                        y.a(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                b.a(e);
                fileLock.release();
                y.a(randomAccessFile);
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                y.a(randomAccessFile);
                throw th;
            }
            y.a(randomAccessFile);
        }
    }
}
