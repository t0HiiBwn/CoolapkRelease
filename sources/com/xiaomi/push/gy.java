package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bm;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

public class gy {
    private static boolean a;

    static class a implements Runnable {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private hb f535a;

        public a(Context context, hb hbVar) {
            this.f535a = hbVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            gy.c(this.a, this.f535a);
        }
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void a(Context context, hb hbVar) {
        ai.a(context).a(new a(context, hbVar));
    }

    private static void a(Context context, hb hbVar, File file, byte[] bArr) {
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
            b.d(str);
            gz.a(context, hbVar, arrayList);
            if (file != null && file.exists() && !file.delete()) {
                b.m41a("TinyData delete reading temp file failed");
            }
            y.a(bufferedInputStream);
            return;
        } catch (Exception e2) {
            e = e2;
            try {
                b.a(e);
                y.a(bufferedInputStream2);
                return;
            } catch (Throwable th2) {
                th = th2;
                y.a(bufferedInputStream2);
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
                    b.a(e);
                    y.a(bufferedInputStream2);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream2 = bufferedInputStream;
                    y.a(bufferedInputStream2);
                    throw th;
                }
                if (read == -1) {
                    break loop0;
                } else if (read != 4) {
                    str = "TinyData read from cache file failed cause lengthBuffer error. size:" + read;
                    break loop0;
                } else {
                    a2 = ac.a(bArr2);
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
                        byte[] a3 = h.a(bArr, bArr3);
                        if (a3 != null) {
                            if (a3.length != 0) {
                                hg hgVar = new hg();
                                im.a(hgVar, a3);
                                hgVar.a("item_size", String.valueOf(a3.length));
                                arrayList.add(hgVar);
                                i++;
                                i2 += a3.length;
                                if (i >= 8 || i2 >= 10240) {
                                    break;
                                }
                            }
                        }
                        b.d("TinyData read from cache file failed cause decrypt fail");
                    }
                }
            }
            gz.a(context, hbVar, arrayList);
            arrayList.clear();
        }
    }

    private static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb  */
    public static void c(Context context, hb hbVar) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        File file;
        IOException e;
        Exception e2;
        if (!a) {
            a = true;
            File file2 = new File(context.getFilesDir(), "tiny_data.data");
            if (!file2.exists()) {
                b.m41a("TinyData no ready file to get data.");
                return;
            }
            a(context);
            byte[] a2 = bm.a(context);
            FileLock fileLock = null;
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                y.m681a(file3);
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
                        b.a(e2);
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            e = e5;
                        }
                        y.a(randomAccessFile);
                        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                        if (file.exists()) {
                        }
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
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                y.a(randomAccessFile);
                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                if (file.exists()) {
                }
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
            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
            if (file.exists()) {
                b.m41a("TinyData no ready file to get data.");
                return;
            }
            a(context, hbVar, file, a2);
            gx.a(false);
            b(context);
            a = false;
            return;
        }
        b.m41a("TinyData extractTinyData is running");
        return;
        b.a(e);
        y.a(randomAccessFile);
        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        if (file.exists()) {
        }
    }
}
