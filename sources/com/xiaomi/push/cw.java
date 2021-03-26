package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.j;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public abstract class cw extends j.a {
    protected int c;
    protected Context d;

    public cw(Context context, int i) {
        this.c = i;
        this.d = context;
    }

    public static void a(Context context, gq gqVar) {
        ch b = ci.a().b();
        String a = b == null ? "" : b.a();
        if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(gqVar.c())) {
            a(context, gqVar, a);
        }
    }

    private static void a(Context context, gq gqVar, String str) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        IOException e;
        FileLock lock;
        byte[] b = cm.b(str, ht.a(gqVar));
        if (b != null && b.length != 0) {
            synchronized (cn.a) {
                FileLock fileLock = null;
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    jg.c(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        lock = randomAccessFile.getChannel().lock();
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream = null;
                        try {
                            e.printStackTrace();
                            try {
                                fileLock.release();
                            } catch (IOException unused) {
                            }
                            jg.a(bufferedOutputStream);
                            jg.a(randomAccessFile);
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused2) {
                                }
                            }
                            jg.a(bufferedOutputStream);
                            jg.a(randomAccessFile);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                        fileLock.release();
                        jg.a(bufferedOutputStream);
                        jg.a(randomAccessFile);
                        throw th;
                    }
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                        try {
                            bufferedOutputStream.write(d.a(b.length));
                            bufferedOutputStream.write(b);
                            bufferedOutputStream.flush();
                            if (lock != null) {
                                if (lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                            }
                            jg.a(bufferedOutputStream);
                        } catch (IOException e3) {
                            e = e3;
                            fileLock = lock;
                            e.printStackTrace();
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            jg.a(bufferedOutputStream);
                            jg.a(randomAccessFile);
                        } catch (Throwable th4) {
                            th = th4;
                            fileLock = lock;
                            fileLock.release();
                            jg.a(bufferedOutputStream);
                            jg.a(randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = null;
                        fileLock = lock;
                        e.printStackTrace();
                        fileLock.release();
                        jg.a(bufferedOutputStream);
                        jg.a(randomAccessFile);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = null;
                        fileLock = lock;
                        fileLock.release();
                        jg.a(bufferedOutputStream);
                        jg.a(randomAccessFile);
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                    e.printStackTrace();
                    fileLock.release();
                    jg.a(bufferedOutputStream);
                    jg.a(randomAccessFile);
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                    fileLock.release();
                    jg.a(bufferedOutputStream);
                    jg.a(randomAccessFile);
                    throw th;
                }
                jg.a(randomAccessFile);
            }
        }
    }

    public abstract String b();

    public abstract gk c();

    protected boolean d() {
        return cm.a(this.d, String.valueOf(a()), (long) this.c);
    }

    protected boolean e() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (d()) {
            c.a("DC run job mutual: " + a());
            return;
        }
        ch b = ci.a().b();
        String a = b == null ? "" : b.a();
        if (!TextUtils.isEmpty(a) && e()) {
            String b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                gq gqVar = new gq();
                gqVar.a(b2);
                gqVar.a(System.currentTimeMillis());
                gqVar.a(c());
                a(this.d, gqVar, a);
            }
        }
    }
}
