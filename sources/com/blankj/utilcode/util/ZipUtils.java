package com.blankj.utilcode.util;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class ZipUtils {
    private static final int BUFFER_LEN = 8192;

    private ZipUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean zipFiles(Collection<String> collection, String str) throws IOException {
        return zipFiles(collection, str, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    public static boolean zipFiles(Collection<String> collection, String str, String str2) throws IOException {
        Throwable th;
        if (collection == null || str == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                for (String str3 : collection) {
                    if (!zipFile(UtilsBridge.getFileByPath(str3), "", zipOutputStream2, str2)) {
                        zipOutputStream2.finish();
                        zipOutputStream2.close();
                        return false;
                    }
                }
                zipOutputStream2.finish();
                zipOutputStream2.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (zipOutputStream != null) {
            }
            throw th;
        }
    }

    public static boolean zipFiles(Collection<File> collection, File file) throws IOException {
        return zipFiles(collection, file, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    public static boolean zipFiles(Collection<File> collection, File file, String str) throws IOException {
        Throwable th;
        if (collection == null || file == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file));
            try {
                for (File file2 : collection) {
                    if (!zipFile(file2, "", zipOutputStream2, str)) {
                        zipOutputStream2.finish();
                        zipOutputStream2.close();
                        return false;
                    }
                }
                zipOutputStream2.finish();
                zipOutputStream2.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (zipOutputStream != null) {
            }
            throw th;
        }
    }

    public static boolean zipFile(String str, String str2) throws IOException {
        return zipFile(UtilsBridge.getFileByPath(str), UtilsBridge.getFileByPath(str2), (String) null);
    }

    public static boolean zipFile(String str, String str2, String str3) throws IOException {
        return zipFile(UtilsBridge.getFileByPath(str), UtilsBridge.getFileByPath(str2), str3);
    }

    public static boolean zipFile(File file, File file2) throws IOException {
        return zipFile(file, file2, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
    public static boolean zipFile(File file, File file2, String str) throws IOException {
        Throwable th;
        if (file == null || file2 == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
            try {
                boolean zipFile = zipFile(file, "", zipOutputStream2, str);
                zipOutputStream2.close();
                return zipFile;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (zipOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095  */
    private static boolean zipFile(File file, String str, ZipOutputStream zipOutputStream, String str2) throws IOException {
        Throwable th;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(UtilsBridge.isSpace(str) ? "" : File.separator);
        sb.append(file.getName());
        String sb2 = sb.toString();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                ZipEntry zipEntry = new ZipEntry(sb2 + '/');
                zipEntry.setComment(str2);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.closeEntry();
                return true;
            }
            for (File file2 : listFiles) {
                if (!zipFile(file2, sb2, zipOutputStream, str2)) {
                    return false;
                }
            }
            return true;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                ZipEntry zipEntry2 = new ZipEntry(sb2);
                zipEntry2.setComment(str2);
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream2.read(bArr, 0, 8192);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        zipOutputStream.closeEntry();
                        bufferedInputStream2.close();
                        return true;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public static List<File> unzipFile(String str, String str2) throws IOException {
        return unzipFileByKeyword(str, str2, (String) null);
    }

    public static List<File> unzipFile(File file, File file2) throws IOException {
        return unzipFileByKeyword(file, file2, (String) null);
    }

    public static List<File> unzipFileByKeyword(String str, String str2, String str3) throws IOException {
        return unzipFileByKeyword(UtilsBridge.getFileByPath(str), UtilsBridge.getFileByPath(str2), str3);
    }

    public static List<File> unzipFileByKeyword(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        try {
            if (UtilsBridge.isSpace(str)) {
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String replace = zipEntry.getName().replace("\\", "/");
                    if (replace.contains("../")) {
                        Log.e("ZipUtils", "entryName: " + replace + " is dangerous!");
                    } else if (!unzipChildFile(file2, arrayList, zipFile, zipEntry, replace)) {
                        return arrayList;
                    }
                }
            } else {
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry2 = (ZipEntry) entries.nextElement();
                    String replace2 = zipEntry2.getName().replace("\\", "/");
                    if (replace2.contains("../")) {
                        Log.e("ZipUtils", "entryName: " + replace2 + " is dangerous!");
                    } else if (replace2.contains(str) && !unzipChildFile(file2, arrayList, zipFile, zipEntry2, replace2)) {
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

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056  */
    private static boolean unzipChildFile(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        Throwable th2;
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return UtilsBridge.createOrExistsDir(file2);
        }
        if (!UtilsBridge.createOrExistsFile(file2)) {
            return false;
        }
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th3) {
                th2 = th3;
                bufferedOutputStream = null;
                th = th2;
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
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
                        return true;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th2 = th5;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            th = th2;
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
    }

    public static List<String> getFilesPath(String str) throws IOException {
        return getFilesPath(UtilsBridge.getFileByPath(str));
    }

    public static List<String> getFilesPath(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            String replace = ((ZipEntry) entries.nextElement()).getName().replace("\\", "/");
            if (replace.contains("../")) {
                Log.e("ZipUtils", "entryName: " + replace + " is dangerous!");
                arrayList.add(replace);
            } else {
                arrayList.add(replace);
            }
        }
        zipFile.close();
        return arrayList;
    }

    public static List<String> getComments(String str) throws IOException {
        return getComments(UtilsBridge.getFileByPath(str));
    }

    public static List<String> getComments(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            arrayList.add(((ZipEntry) entries.nextElement()).getComment());
        }
        zipFile.close();
        return arrayList;
    }
}
