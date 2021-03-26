package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.b.b.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

public class al {
    public static String a() {
        return Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL;
    }

    public static String a(Context context) {
        String b = ao.a(context).b("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String a = ah.a(20);
        ao.a(context).a("sp_client_report_status", "sp_client_report_key", a);
        return a;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e4, code lost:
        if (r7 == null) goto L_0x00e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0104  */
    public static void a(Context context, String str, String str2) {
        Throwable th;
        File file;
        RandomAccessFile randomAccessFile;
        Exception e;
        File externalFilesDir = context.getExternalFilesDir(str2);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            File externalFilesDir2 = context.getExternalFilesDir(str);
            if (externalFilesDir2 == null) {
                return;
            }
            if (!externalFilesDir2.exists()) {
                externalFilesDir2.mkdirs();
                return;
            }
            File[] listFiles = externalFilesDir2.listFiles(new am());
            if (listFiles != null && listFiles.length > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                FileLock fileLock = null;
                RandomAccessFile randomAccessFile2 = null;
                File file2 = null;
                for (File file3 : listFiles) {
                    if (file3 != null) {
                        try {
                            if (!TextUtils.isEmpty(file3.getAbsolutePath())) {
                                file = new File(file3.getAbsolutePath() + ".lock");
                                try {
                                    jg.c(file);
                                    randomAccessFile = new RandomAccessFile(file, "rw");
                                    try {
                                        fileLock = randomAccessFile.getChannel().lock();
                                        File file4 = new File(externalFilesDir.getAbsolutePath() + File.separator + file3.getName() + currentTimeMillis);
                                        try {
                                            jg.b(file3, file4);
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            file3.delete();
                                            file4.delete();
                                        }
                                        file3.delete();
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e3) {
                                                c.a(e3);
                                            }
                                        }
                                        jg.a(randomAccessFile);
                                    } catch (Exception e4) {
                                        e = e4;
                                        try {
                                            c.a(e);
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
                                            randomAccessFile2 = randomAccessFile;
                                            file2 = file;
                                            try {
                                                fileLock.release();
                                            } catch (IOException e6) {
                                                c.a(e6);
                                            }
                                            jg.a(randomAccessFile2);
                                            if (file2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception e7) {
                                    randomAccessFile = randomAccessFile2;
                                    e = e7;
                                    c.a(e);
                                    fileLock.release();
                                    jg.a(randomAccessFile);
                                } catch (Throwable th3) {
                                    th = th3;
                                    file2 = file;
                                    fileLock.release();
                                    jg.a(randomAccessFile2);
                                    if (file2 != null) {
                                    }
                                    throw th;
                                }
                                file.delete();
                                randomAccessFile2 = randomAccessFile;
                                file2 = file;
                            }
                        } catch (Exception e8) {
                            file = file2;
                            randomAccessFile = randomAccessFile2;
                            e = e8;
                            c.a(e);
                            fileLock.release();
                            jg.a(randomAccessFile);
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            jg.a(randomAccessFile2);
                            if (file2 != null) {
                                file2.delete();
                            }
                            throw th;
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e9) {
                            c.a(e9);
                        }
                    }
                    jg.a(randomAccessFile2);
                    if (file2 != null) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static void a(Context context, List<String> list) {
        if (list != null && list.size() > 0 && b(context)) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    a(context, str);
                }
            }
        }
    }

    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(ae.c(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    public static boolean b(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        File file = new File(str);
        long e = b.a(context).a().e();
        if (file.exists()) {
            try {
                if (file.length() > e) {
                    return false;
                }
            } catch (Exception e2) {
                c.a(e2);
                return false;
            }
        } else {
            jg.c(file);
        }
        return true;
    }

    public static File[] c(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new an());
        }
        return null;
    }
}
