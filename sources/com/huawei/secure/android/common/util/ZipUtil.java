package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipUtil {
    private static final String A = "..\\";
    private static final String TAG = "ZipUtil";
    private static final int w = 104857600;
    private static final int x = 100;
    private static final int y = 4096;
    private static final String z = "../";

    public static boolean unZip(String str, String str2, boolean z2) throws SecurityCommonException {
        return unZip(str, str2, 104857600, 100, z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fe  */
    public static boolean unZip(String str, String str2, long j, int i, boolean z2) throws SecurityCommonException {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        ZipInputStream zipInputStream;
        Throwable th;
        IOException e;
        String str3 = str2;
        boolean z3 = false;
        if (!a(str, str2, j, i)) {
            return false;
        }
        if (str3.endsWith(File.separator) && str2.length() > File.separator.length()) {
            str3 = str3.substring(0, str2.length() - File.separator.length());
        }
        byte[] bArr = new byte[4096];
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream2));
                FileOutputStream fileOutputStream2 = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        File file = new File(str3, nextEntry.getName());
                        if (z2 && file.exists()) {
                            a(file);
                        }
                        if (nextEntry.isDirectory()) {
                            c(file);
                            arrayList.add(file);
                        } else {
                            File parentFile = file.getParentFile();
                            if (parentFile != null && !parentFile.exists()) {
                                c(parentFile);
                            }
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                int i2 = 0;
                                while (((long) (i2 + 4096)) <= j) {
                                    try {
                                        int read = zipInputStream.read(bArr, 0, 4096);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                        i2 += read;
                                    } catch (IOException e2) {
                                        e = e2;
                                        fileInputStream = fileInputStream2;
                                        try {
                                            LogsUtil.e("ZipUtil", "Unzip IOException : " + e.getMessage());
                                            a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                            if (!z3) {
                                            }
                                            return z3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileInputStream = fileInputStream2;
                                        a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                        throw th;
                                    }
                                }
                                arrayList.add(file);
                                bufferedOutputStream.flush();
                                IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                IOUtil.closeSecure((OutputStream) fileOutputStream);
                                bufferedOutputStream2 = bufferedOutputStream;
                                fileOutputStream2 = fileOutputStream;
                            } catch (IOException e3) {
                                e = e3;
                                bufferedOutputStream = bufferedOutputStream2;
                                fileInputStream = fileInputStream2;
                                LogsUtil.e("ZipUtil", "Unzip IOException : " + e.getMessage());
                                a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                if (!z3) {
                                }
                                return z3;
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedOutputStream = bufferedOutputStream2;
                                fileInputStream = fileInputStream2;
                                a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                throw th;
                            }
                        }
                        zipInputStream.closeEntry();
                    } catch (IOException e4) {
                        e = e4;
                        fileOutputStream = fileOutputStream2;
                        bufferedOutputStream = bufferedOutputStream2;
                        fileInputStream = fileInputStream2;
                        LogsUtil.e("ZipUtil", "Unzip IOException : " + e.getMessage());
                        a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                        if (!z3) {
                        }
                        return z3;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        bufferedOutputStream = bufferedOutputStream2;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                        throw th;
                    }
                }
                IOUtil.closeSecure((InputStream) zipInputStream);
                IOUtil.closeSecure((InputStream) fileInputStream2);
                a(fileInputStream2, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                z3 = true;
            } catch (IOException e5) {
                e = e5;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                LogsUtil.e("ZipUtil", "Unzip IOException : " + e.getMessage());
                a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                if (!z3) {
                }
                return z3;
            } catch (Throwable th6) {
                th = th6;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
            LogsUtil.e("ZipUtil", "Unzip IOException : " + e.getMessage());
            a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
            if (!z3) {
            }
            return z3;
        } catch (Throwable th7) {
            th = th7;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
            a(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
            throw th;
        }
        if (!z3) {
            a(arrayList);
        }
        return z3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[SYNTHETIC, Splitter:B:32:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0045 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019 A[Catch:{ IOException -> 0x0051, all -> 0x004e }] */
    private static boolean a(String str, long j, int i) {
        Throwable th;
        IOException e;
        Enumeration<? extends ZipEntry> entries;
        long j2;
        int i2;
        boolean z2 = false;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                entries = zipFile2.entries();
                j2 = 0;
                i2 = 0;
                LogsUtil.e("ZipUtil", "File name is invalid or too many files or too big");
                try {
                    zipFile2.close();
                } catch (IOException unused) {
                    LogsUtil.e("ZipUtil", "close zipFile IOException ");
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
                try {
                    LogsUtil.e("ZipUtil", "not a valid zip file, IOException : " + e.getMessage());
                    if (zipFile != null) {
                    }
                    return z2;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            LogsUtil.e("ZipUtil", "close zipFile IOException ");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile = zipFile2;
                if (zipFile != null) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            LogsUtil.e("ZipUtil", "not a valid zip file, IOException : " + e.getMessage());
            if (zipFile != null) {
                zipFile.close();
            }
            return z2;
        }
        while (true) {
            if (!entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                j2 += zipEntry.getSize();
                i2++;
                if (d(zipEntry.getName()) || i2 >= i || j2 > j || zipEntry.getSize() == -1) {
                    break;
                }
                if (!entries.hasMoreElements()) {
                    z2 = true;
                    break;
                }
            }
        }
        return z2;
    }

    private static void a(File file) {
        if (file != null) {
            if (file.isFile()) {
                b(file);
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    b(file);
                    return;
                }
                for (File file2 : listFiles) {
                    a(file2);
                }
                b(file);
            }
        }
    }

    private static boolean a(String str, String str2, long j, int i) throws SecurityCommonException {
        if (TextUtils.isEmpty(str) || d(str)) {
            LogsUtil.e("ZipUtil", "zip file is not valid");
            return false;
        } else if (TextUtils.isEmpty(str2) || d(str2)) {
            LogsUtil.e("ZipUtil", "target directory is not valid");
            return false;
        } else if (a(str, j, i)) {
            return true;
        } else {
            LogsUtil.e("ZipUtil", "zip file contains valid chars or too many files");
            throw new SecurityCommonException("unsecure zipfile!");
        }
    }

    private static boolean a(List<File> list) {
        try {
            for (File file : list) {
                a(file);
            }
            return true;
        } catch (Exception e) {
            LogsUtil.e("ZipUtil", "unzip fail delete file failed" + e.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }

    private static void b(File file) {
        if (file != null && !file.delete()) {
            LogsUtil.e("ZipUtil", "delete file error");
        }
    }

    private static void c(File file) {
        if (file != null && !file.exists() && !file.mkdirs()) {
            LogsUtil.e("ZipUtil", "mkdirs error , files exists or IOException.");
        }
    }

    private static boolean d(String str) {
        return str.contains("../") || str.contains("..\\") || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
    }
}
