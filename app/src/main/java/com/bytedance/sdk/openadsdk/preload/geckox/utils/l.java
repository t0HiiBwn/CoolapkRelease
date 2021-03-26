package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: UnZipUtils */
public class l {
    private static byte[] a = {80, 75, 3, 4};
    private static byte[] b = {80, 75, 5, 6};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void a(InputStream inputStream, String str, String str2) throws Exception {
        Throwable th;
        Throwable th2;
        ZipInputStream zipInputStream = null;
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            ZipInputStream zipInputStream2 = new ZipInputStream(inputStream);
            boolean z = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry != null) {
                        z = true;
                        String name = nextEntry.getName();
                        if (!a(name)) {
                            if (!name.startsWith(str2 + File.separator)) {
                                throw new RuntimeException("the zip package outermost folder is not named by channel channel:" + str2);
                            } else if (nextEntry.isDirectory()) {
                                File file = new File(canonicalPath, name);
                                if (file.getCanonicalPath().startsWith(canonicalPath)) {
                                    file.mkdirs();
                                } else {
                                    throw new RuntimeException("directory traversal, dir:" + name + ", channel:" + str2);
                                }
                            } else {
                                String canonicalPath2 = new File(canonicalPath, name).getCanonicalPath();
                                if (canonicalPath2.startsWith(canonicalPath)) {
                                    File file2 = new File(canonicalPath2);
                                    file2.getParentFile().mkdirs();
                                    try {
                                        ?? fileOutputStream = new FileOutputStream(file2);
                                        try {
                                            d.a(zipInputStream2, fileOutputStream);
                                            b.a((Closeable) fileOutputStream);
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            zipInputStream = fileOutputStream;
                                            b.a(zipInputStream);
                                            throw th2;
                                        }
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        b.a(zipInputStream);
                                        throw th2;
                                    }
                                } else {
                                    throw new RuntimeException("directory traversal, file name:" + name);
                                }
                            }
                        }
                    } else if (!z) {
                        inputStream.reset();
                        if (!a(inputStream)) {
                            throw new RuntimeException("not zip file  channel:" + str2);
                        }
                        throw new RuntimeException("unzip file: channel:" + str2);
                    } else {
                        b.a(zipInputStream2);
                        return;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    zipInputStream = zipInputStream2;
                    b.a(zipInputStream);
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            b.a(zipInputStream);
            throw th;
        }
    }

    private static boolean a(String str) {
        return str.startsWith("__MACOSX/") || str.equals(".DS_Store");
    }

    private static boolean a(InputStream inputStream) throws Exception {
        try {
            byte[] bArr = new byte[4];
            boolean z = false;
            if (inputStream.read(bArr, 0, 4) == 4) {
                if (Arrays.equals(a, bArr) || Arrays.equals(b, bArr)) {
                    z = true;
                }
                return z;
            }
            b.a(inputStream);
            return false;
        } finally {
            b.a(inputStream);
        }
    }
}
