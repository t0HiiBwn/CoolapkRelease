package com.pgl.a.b;

import android.content.Context;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class e {
    private static List<String> a = new ArrayList();

    private static File a(Context context) {
        if (context == null || context.getFilesDir() == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "libso");
        if (!file.exists()) {
            b.a(file.getAbsolutePath());
        }
        return file;
    }

    private static String a(Context context, String str, File file) {
        InputStream inputStream;
        Throwable th;
        ZipFile zipFile;
        String message;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            try {
                ZipEntry entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
                if (entry == null) {
                    int indexOf = Build.CPU_ABI.indexOf(45);
                    StringBuilder sb = new StringBuilder();
                    sb.append("lib/");
                    String str2 = Build.CPU_ABI;
                    if (indexOf <= 0) {
                        indexOf = Build.CPU_ABI.length();
                    }
                    sb.append(str2.substring(0, indexOf));
                    sb.append("/");
                    sb.append(System.mapLibraryName(str));
                    String sb2 = sb.toString();
                    ZipEntry entry2 = zipFile.getEntry(sb2);
                    if (entry2 == null) {
                        message = "Library entry not found:" + sb2;
                        b.a((Closeable) null);
                        b.a((Closeable) null);
                        b.a(zipFile);
                        return message;
                    }
                    entry = entry2;
                }
                file.createNewFile();
                inputStream2 = zipFile.getInputStream(entry);
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                try {
                    message = th.getMessage();
                    b.a(fileOutputStream2);
                    b.a(inputStream);
                    b.a(zipFile);
                    return message;
                } catch (Throwable th3) {
                    b.a(fileOutputStream2);
                    b.a(inputStream);
                    b.a(zipFile);
                    throw th3;
                }
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th4) {
                inputStream = inputStream2;
                th = th4;
                message = th.getMessage();
                b.a(fileOutputStream2);
                b.a(inputStream);
                b.a(zipFile);
                return message;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        b.a(file.getAbsolutePath(), 493);
                        b.a(fileOutputStream);
                        b.a(inputStream2);
                        b.a(zipFile);
                        return null;
                    }
                }
            } catch (Throwable th5) {
                fileOutputStream2 = fileOutputStream;
                inputStream = inputStream2;
                th = th5;
                message = th.getMessage();
                b.a(fileOutputStream2);
                b.a(inputStream);
                b.a(zipFile);
                return message;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            zipFile = null;
            message = th.getMessage();
            b.a(fileOutputStream2);
            b.a(inputStream);
            b.a(zipFile);
            return message;
        }
    }

    public static synchronized boolean a(Context context, String str) {
        synchronized (e.class) {
            if (a.contains(str)) {
                return true;
            }
            try {
                System.loadLibrary(str);
                a.add(str);
            } catch (UnsatisfiedLinkError unused) {
                File b = b(context, str);
                if (b == null) {
                    return false;
                }
                if (b.exists()) {
                    b.delete();
                }
                if (a(context, str, b) != null) {
                    return false;
                }
                System.load(b.getAbsolutePath());
                a.add(str);
            } catch (Throwable unused2) {
                return false;
            }
            return true;
        }
    }

    private static File b(Context context, String str) {
        String mapLibraryName = System.mapLibraryName(str);
        File a2 = a(context);
        if (a2 != null) {
            return new File(a2, mapLibraryName);
        }
        return null;
    }
}
