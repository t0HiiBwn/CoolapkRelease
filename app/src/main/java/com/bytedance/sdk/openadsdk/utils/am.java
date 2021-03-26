package com.bytedance.sdk.openadsdk.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ZipUtils */
public class am {
    public static List<File> a(String str, String str2) throws IOException {
        return a(str, str2, (String) null);
    }

    public static List<File> a(String str, String str2, String str3) throws IOException {
        return a(a(str), a(str2), str3);
    }

    public static List<File> a(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        try {
            if (b(str)) {
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String name = zipEntry.getName();
                    if (name.contains("../")) {
                        u.d("ZipUtils", "entryName: " + name + " is dangerous!");
                    } else if (!a(file2, arrayList, zipFile, zipEntry, name)) {
                        return arrayList;
                    }
                }
            } else {
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry2 = (ZipEntry) entries.nextElement();
                    String name2 = zipEntry2.getName();
                    if (name2.contains("../")) {
                        u.d("ZipUtils", "entryName: " + name2 + " is dangerous!");
                    } else if (name2.contains(str) && !a(file2, arrayList, zipFile, zipEntry2, name2)) {
                        zipFile.close();
                        return arrayList;
                    }
                }
            }
            zipFile.close();
            return arrayList;
        } finally {
            zipFile.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063  */
    private static boolean a(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Throwable th2;
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return a(file2);
        }
        if (!b(file2)) {
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (Throwable th3) {
                    th2 = th3;
                    bufferedOutputStream = null;
                    th = th2;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th2 = th4;
                bufferedOutputStream = null;
                bufferedInputStream = null;
                th = th2;
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                        return true;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th2 = th6;
            bufferedOutputStream = null;
            fileOutputStream = null;
            bufferedInputStream = null;
            th = th2;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static File a(String str) {
        if (b(str)) {
            return null;
        }
        return new File(str);
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
