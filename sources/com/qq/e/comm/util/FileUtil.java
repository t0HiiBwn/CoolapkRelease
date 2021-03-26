package com.qq.e.comm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
    public static boolean copyTo(InputStream inputStream, File file) {
        Throwable th;
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            tryClose(inputStream);
                            tryClose(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        GDTLogger.e(String.format("Exception while copy from InputStream to File %s", file.getAbsolutePath()), th);
                        tryClose(inputStream);
                        tryClose(fileOutputStream);
                        return false;
                    } catch (Throwable th3) {
                        tryClose(inputStream);
                        tryClose(fileOutputStream);
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            GDTLogger.e(String.format("Exception while copy from InputStream to File %s", file.getAbsolutePath()), th);
            tryClose(inputStream);
            tryClose(fileOutputStream);
            return false;
        }
        tryClose(inputStream);
        tryClose(fileOutputStream);
        return false;
    }

    public static String getFileName(String str) {
        return Md5Util.encode(str);
    }

    public static String getTempFileName(String str) {
        return Md5Util.encode(str) + ".temp";
    }

    public static boolean renameTo(File file, File file2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (!file.renameTo(file2)) {
            return copyTo(null, file2);
        }
        return true;
    }

    public static void tryClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void tryClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
