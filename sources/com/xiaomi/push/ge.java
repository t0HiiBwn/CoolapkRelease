package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.al;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

public class ge {
    private static boolean a;

    static class a implements Runnable {
        private Context a;
        private gh b;

        public a(Context context, gh ghVar) {
            this.b = ghVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ge.c(this.a, this.b);
        }
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void a(Context context, gh ghVar) {
        j.a(context).a(new a(context, ghVar));
    }

    private static void a(Context context, gh ghVar, File file, byte[] bArr) {
        Throwable th;
        Exception e;
        BufferedInputStream bufferedInputStream;
        int read;
        String str;
        int a2;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            str = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + a2;
            c.d(str);
            gf.a(context, ghVar, arrayList);
            if (file != null && file.exists() && !file.delete()) {
                c.a("TinyData delete reading temp file failed");
            }
            jg.a(bufferedInputStream);
            return;
        } catch (Exception e2) {
            e = e2;
            try {
                c.a(e);
                jg.a(bufferedInputStream2);
                return;
            } catch (Throwable th2) {
                th = th2;
                jg.a(bufferedInputStream2);
                throw th;
            }
        }
        loop0:
        while (true) {
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    read = bufferedInputStream.read(bArr2);
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream2 = bufferedInputStream;
                    c.a(e);
                    jg.a(bufferedInputStream2);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream2 = bufferedInputStream;
                    jg.a(bufferedInputStream2);
                    throw th;
                }
                if (read == -1) {
                    break loop0;
                } else if (read != 4) {
                    str = "TinyData read from cache file failed cause lengthBuffer error. size:" + read;
                    break loop0;
                } else {
                    a2 = d.a(bArr2);
                    if (a2 < 1) {
                        break loop0;
                    } else if (a2 > 10240) {
                        break loop0;
                    } else {
                        byte[] bArr3 = new byte[a2];
                        int read2 = bufferedInputStream.read(bArr3);
                        if (read2 != a2) {
                            str = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2;
                            break loop0;
                        }
                        byte[] a3 = fv.a(bArr, bArr3);
                        if (a3 != null) {
                            if (a3.length != 0) {
                                gm gmVar = new gm();
                                ht.a(gmVar, a3);
                                arrayList.add(gmVar);
                                i++;
                                i2 += a3.length;
                                if (i >= 8 || i2 >= 10240) {
                                    break;
                                }
                            }
                        }
                        c.d("TinyData read from cache file failed cause decrypt fail");
                    }
                }
            }
            gf.a(context, ghVar, arrayList);
            arrayList = new ArrayList();
        }
    }

    private static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd  */
    public static void c(Context context, gh ghVar) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        File file;
        IOException e;
        Exception e2;
        if (!a) {
            a = true;
            File file2 = new File(context.getFilesDir(), "tiny_data.data");
            if (!file2.exists()) {
                c.a("TinyData no ready file to get data.");
                return;
            }
            a(context);
            byte[] a2 = al.a(context);
            FileLock fileLock = null;
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                jg.c(file3);
                randomAccessFile = new RandomAccessFile(file3, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            e = e3;
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    try {
                        c.a(e2);
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            e = e5;
                        }
                        jg.a(randomAccessFile);
                        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                        if (file.exists()) {
                        }
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
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                jg.a(randomAccessFile);
                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                if (file.exists()) {
                }
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
            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
            if (file.exists()) {
                c.a("TinyData no ready file to get data.");
                return;
            }
            a(context, ghVar, file, a2);
            gd.a(false);
            b(context);
            a = false;
            return;
        }
        c.a("TinyData extractTinyData is running");
        return;
        c.a(e);
        jg.a(randomAccessFile);
        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        if (file.exists()) {
        }
    }
}
