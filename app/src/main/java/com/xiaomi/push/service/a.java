package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.y;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class a {
    private static volatile a a;

    /* renamed from: a  reason: collision with other field name */
    private Context f926a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f927a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final String f928a = "mipush_region";
    private final Object b = new Object();

    /* renamed from: b  reason: collision with other field name */
    private final String f929b = "mipush_country_code";
    private final String c = "mipush_region.lock";
    private final String d = "mipush_country_code.lock";
    private volatile String e;
    private volatile String f;

    public a(Context context) {
        this.f926a = context;
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private String a(Context context, String str, String str2, Object obj) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        Exception e2;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            b.m41a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                y.m681a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception e3) {
                    e2 = e3;
                    fileLock = null;
                    try {
                        b.a(e2);
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            b.a(e4);
                        }
                        y.a(randomAccessFile);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileLock2 = fileLock;
                        try {
                            fileLock2.release();
                        } catch (IOException e5) {
                            b.a(e5);
                        }
                        y.a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileLock2.release();
                    y.a(randomAccessFile);
                    throw th;
                }
                try {
                    String a2 = y.a(file);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                b.a(e6);
                            }
                        }
                    }
                    y.a(randomAccessFile);
                    return a2;
                } catch (Exception e7) {
                    e2 = e7;
                    b.a(e2);
                    fileLock.release();
                    y.a(randomAccessFile);
                    return null;
                }
            } catch (Exception e8) {
                e2 = e8;
                randomAccessFile = null;
                fileLock = null;
                b.a(e2);
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                y.a(randomAccessFile);
                return null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                if (fileLock2 != null && fileLock2.isValid()) {
                    fileLock2.release();
                }
                y.a(randomAccessFile);
                throw th;
            }
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Exception e2;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                File file = new File(context.getFilesDir(), str3);
                y.m681a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    y.a(new File(context.getFilesDir(), str2), str);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                b.a(e3);
                            }
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    try {
                        b.a(e2);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                b.a(e5);
                            }
                        }
                        y.a(randomAccessFile);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            b.a(e6);
                        }
                        y.a(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e2 = e7;
                randomAccessFile = null;
                b.a(e2);
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

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = a(this.f926a, "mipush_region", "mipush_region.lock", this.f927a);
        }
        return this.e;
    }

    public void a(String str) {
        if (!TextUtils.equals(str, this.e)) {
            this.e = str;
            a(this.f926a, this.e, "mipush_region", "mipush_region.lock", this.f927a);
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = a(this.f926a, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
        return this.f;
    }

    public void b(String str) {
        if (!TextUtils.equals(str, this.f)) {
            this.f = str;
            a(this.f926a, this.f, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
    }
}
