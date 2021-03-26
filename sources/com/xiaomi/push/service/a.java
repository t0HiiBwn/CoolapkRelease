package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.jg;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class a {
    private static volatile a j;
    private final Object a = new Object();
    private final Object b = new Object();
    private final String c = "mipush_region";
    private final String d = "mipush_country_code";
    private final String e = "mipush_region.lock";
    private final String f = "mipush_country_code.lock";
    private volatile String g;
    private volatile String h;
    private Context i;

    public a(Context context) {
        this.i = context;
    }

    public static a a(Context context) {
        if (j == null) {
            synchronized (a.class) {
                if (j == null) {
                    j = new a(context);
                }
            }
        }
        return j;
    }

    private String a(Context context, String str, String str2, Object obj) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        Exception e2;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            c.a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                jg.c(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception e3) {
                    e2 = e3;
                    fileLock = null;
                    try {
                        c.a(e2);
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            c.a(e4);
                        }
                        jg.a(randomAccessFile);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileLock2 = fileLock;
                        try {
                            fileLock2.release();
                        } catch (IOException e5) {
                            c.a(e5);
                        }
                        jg.a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileLock2.release();
                    jg.a(randomAccessFile);
                    throw th;
                }
                try {
                    String b2 = jg.b(file);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                c.a(e6);
                            }
                        }
                    }
                    jg.a(randomAccessFile);
                    return b2;
                } catch (Exception e7) {
                    e2 = e7;
                    c.a(e2);
                    fileLock.release();
                    jg.a(randomAccessFile);
                    return null;
                }
            } catch (Exception e8) {
                e2 = e8;
                randomAccessFile = null;
                fileLock = null;
                c.a(e2);
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                jg.a(randomAccessFile);
                return null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                if (fileLock2 != null && fileLock2.isValid()) {
                    fileLock2.release();
                }
                jg.a(randomAccessFile);
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
                jg.c(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    jg.a(new File(context.getFilesDir(), str2), str);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                c.a(e3);
                            }
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    try {
                        c.a(e2);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                c.a(e5);
                            }
                        }
                        jg.a(randomAccessFile);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            c.a(e6);
                        }
                        jg.a(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e2 = e7;
                randomAccessFile = null;
                c.a(e2);
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

    public String a() {
        if (TextUtils.isEmpty(this.g)) {
            this.g = a(this.i, "mipush_region", "mipush_region.lock", this.a);
        }
        return this.g;
    }

    public void a(String str) {
        if (!TextUtils.equals(str, this.g)) {
            this.g = str;
            a(this.i, this.g, "mipush_region", "mipush_region.lock", this.a);
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.h)) {
            this.h = a(this.i, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
        return this.h;
    }

    public void b(String str) {
        if (!TextUtils.equals(str, this.h)) {
            this.h = str;
            a(this.i, this.h, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
    }
}
