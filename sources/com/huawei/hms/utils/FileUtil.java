package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;
    private static boolean a;
    private static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    public static void writeFile(final File file, final String str, final long j) {
        b.execute(new Runnable() {
            /* class com.huawei.hms.utils.FileUtil.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                Throwable th;
                IOException e;
                File file = file;
                if (file == null) {
                    HMSLog.e("FileUtil", "In writeFile Failed to get local file.");
                    return;
                }
                File parentFile = file.getParentFile();
                if (parentFile == null || (!parentFile.mkdirs() && !parentFile.isDirectory())) {
                    HMSLog.e("FileUtil", "In writeFile, Failed to create directory.");
                    return;
                }
                RandomAccessFile randomAccessFile = null;
                try {
                    long length = file.length();
                    if (length > j) {
                        String canonicalPath = file.getCanonicalPath();
                        if (!file.delete()) {
                            HMSLog.e("FileUtil", "last file delete failed.");
                        }
                        randomAccessFile = new RandomAccessFile(new File(canonicalPath), "rw");
                    } else {
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                        try {
                            randomAccessFile2.seek(length);
                            randomAccessFile = randomAccessFile2;
                        } catch (IOException e2) {
                            e = e2;
                            randomAccessFile = randomAccessFile2;
                            try {
                                HMSLog.e("FileUtil", "writeFile exception:", e);
                                IOUtils.closeQuietly(randomAccessFile);
                            } catch (Throwable th2) {
                                th = th2;
                                IOUtils.closeQuietly(randomAccessFile);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile = randomAccessFile2;
                            IOUtils.closeQuietly(randomAccessFile);
                            throw th;
                        }
                    }
                    randomAccessFile.writeBytes(str + System.getProperty("line.separator"));
                } catch (IOException e3) {
                    e = e3;
                    HMSLog.e("FileUtil", "writeFile exception:", e);
                    IOUtils.closeQuietly(randomAccessFile);
                }
                IOUtils.closeQuietly(randomAccessFile);
            }
        });
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j, int i) {
        if (file != null && file.isFile() && file.exists()) {
            if (!a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e("FileUtil", "file delete failed.");
                }
                a = true;
            }
            writeFile(file2, str + "|" + j + "|" + i, 10240);
        }
    }

    public static boolean verifyHash(String str, File file) {
        byte[] digest = SHA256.digest(file);
        if (digest == null || !HEX.encodeHexString(digest, true).equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
