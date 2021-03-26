package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: FileStorageModel */
public final class bw {
    public static final String a = bs.c("SYmFja3Vwcw");
    public static final String b = bs.c("SLmFkaXU");
    public static final String c = bs.c("JIw");

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[SYNTHETIC, Splitter:B:38:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096 A[SYNTHETIC, Splitter:B:42:0x0096] */
    public static synchronized void a(Context context, String str, String str2) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        synchronized (bw.class) {
            String a2 = a(context);
            if (!TextUtils.isEmpty(a2)) {
                String str3 = str + c + str2;
                File file = new File(a2 + File.separator + a);
                File file2 = new File(file, b);
                FileLock fileLock = null;
                try {
                    if (!file.exists() || file.isDirectory()) {
                        file.mkdirs();
                    }
                    file2.createNewFile();
                    randomAccessFile = new RandomAccessFile(file2, "rws");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                    } catch (Throwable unused) {
                        fileChannel = null;
                        if (0 != 0) {
                        }
                        if (fileChannel != null) {
                        }
                        a(randomAccessFile);
                    }
                    try {
                        FileLock tryLock = fileChannel.tryLock();
                        if (tryLock != null) {
                            fileChannel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                        }
                        if (tryLock != null) {
                            try {
                                tryLock.release();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        a(randomAccessFile);
                    } catch (Throwable unused4) {
                        if (0 != 0) {
                            try {
                                fileLock.release();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused6) {
                            }
                        }
                        a(randomAccessFile);
                    }
                } catch (Throwable unused7) {
                    fileChannel = null;
                    randomAccessFile = null;
                    if (0 != 0) {
                    }
                    if (fileChannel != null) {
                    }
                    a(randomAccessFile);
                }
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(Context context) {
        StorageManager storageManager = Build.VERSION.SDK_INT >= 9 ? (StorageManager) context.getSystemService("storage") : null;
        try {
            Class<?> cls = Class.forName(bs.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(bs.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(bs.c("ZZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(bs.c("AaXNSZW1vdmFibGUK"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }
}
