package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.service.an;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public abstract class ds extends ai.a {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    protected Context f321a;

    public ds(Context context, int i) {
        this.a = i;
        this.f321a = context;
    }

    public static void a(Context context, hk hkVar) {
        dg a2 = dh.a().m199a();
        String a3 = a2 == null ? "" : a2.a();
        if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(hkVar.a())) {
            a(context, hkVar, a3);
        }
    }

    private static void a(Context context, hk hkVar, String str) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        IOException e;
        FileLock lock;
        byte[] b = dl.b(str, im.a(hkVar));
        if (b != null && b.length != 0) {
            synchronized (dm.a) {
                FileLock fileLock = null;
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    y.m681a(file);
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
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused2) {
                                }
                            }
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                        fileLock.release();
                        y.a(bufferedOutputStream);
                        y.a(randomAccessFile);
                        throw th;
                    }
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                        try {
                            bufferedOutputStream.write(ac.a(b.length));
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
                            y.a(bufferedOutputStream);
                        } catch (IOException e3) {
                            e = e3;
                            fileLock = lock;
                            e.printStackTrace();
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
                        } catch (Throwable th4) {
                            th = th4;
                            fileLock = lock;
                            fileLock.release();
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = null;
                        fileLock = lock;
                        e.printStackTrace();
                        fileLock.release();
                        y.a(bufferedOutputStream);
                        y.a(randomAccessFile);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = null;
                        fileLock = lock;
                        fileLock.release();
                        y.a(bufferedOutputStream);
                        y.a(randomAccessFile);
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                    e.printStackTrace();
                    fileLock.release();
                    y.a(bufferedOutputStream);
                    y.a(randomAccessFile);
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                    fileLock.release();
                    y.a(bufferedOutputStream);
                    y.a(randomAccessFile);
                    throw th;
                }
                y.a(randomAccessFile);
            }
        }
    }

    private String c() {
        return "dc_job_result_time_" + mo141a();
    }

    private String d() {
        return "dc_job_result_" + mo141a();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract he mo141a();

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    protected boolean mo205a() {
        return dl.a(this.f321a, String.valueOf(mo141a()), (long) this.a);
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    protected boolean m206b() {
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    protected boolean m207c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            if (mo205a()) {
                b.m41a("DC run job mutual: " + mo141a());
                return;
            }
            dg a2 = dh.a().m199a();
            String a3 = a2 == null ? "" : a2.a();
            if (!TextUtils.isEmpty(a3) && m206b()) {
                if (m207c()) {
                    SharedPreferences sharedPreferences = this.f321a.getSharedPreferences("mipush_extra", 0);
                    if (bi.a(b).equals(sharedPreferences.getString(d(), null))) {
                        long j = sharedPreferences.getLong(c(), 0);
                        int a4 = an.a(this.f321a).a(hh.DCJobUploadRepeatedInterval.a(), 604800);
                        if ((System.currentTimeMillis() - j) / 1000 >= ((long) this.a)) {
                            if ((System.currentTimeMillis() - j) / 1000 < ((long) a4)) {
                                b = "same_" + j;
                            }
                        } else {
                            return;
                        }
                    }
                }
                hk hkVar = new hk();
                hkVar.a(b);
                hkVar.a(System.currentTimeMillis());
                hkVar.a(mo141a());
                a(this.f321a, hkVar, a3);
            }
        }
    }
}
