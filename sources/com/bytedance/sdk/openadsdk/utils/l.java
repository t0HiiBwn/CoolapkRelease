package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* compiled from: FileUtils */
public class l {
    public static File a(Context context, boolean z, String str, String str2) {
        String a2 = a(context);
        if (z) {
            str = "/" + aa.a(context) + "-" + str;
        }
        String str3 = a2 + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File b(Context context, boolean z, String str, String str2) {
        String b = b(context);
        if (z) {
            str = "/" + aa.a(context) + "-" + str;
        }
        String str3 = b + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    private static String a(Context context) {
        if (context == null) {
            return null;
        }
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable() ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            return null;
        }
        return externalCacheDir.getPath();
    }

    private static String b(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static List<File> a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new a());
        return asList;
    }

    public static void b(File file) throws IOException {
        if (file.exists()) {
            u.f("splashLoadAd", "当文件存在更新文件的修改时间");
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                e(file);
                if (file.lastModified() < currentTimeMillis) {
                    u.d("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        }
    }

    public static void c(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            c(file2);
                        } else {
                            try {
                                file2.delete();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    private static void e(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            f(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            try {
                randomAccessFile2.seek(j);
                byte readByte = randomAccessFile2.readByte();
                randomAccessFile2.seek(j);
                randomAccessFile2.write(readByte);
                randomAccessFile2.close();
            } catch (Throwable unused) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile == null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable unused2) {
            if (randomAccessFile == null) {
            }
        }
    }

    private static void f(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }

    /* compiled from: FileUtils */
    private static final class a implements Comparator<File> {
        private int a(long j, long j2) {
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }

        private a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        if (r2 != null) goto L_0x0043;
     */
    public static byte[] d(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long valueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[valueOf.intValue()];
                    if (((long) fileInputStream.read(bArr)) == valueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }
}
