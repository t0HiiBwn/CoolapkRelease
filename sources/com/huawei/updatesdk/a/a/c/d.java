package com.huawei.updatesdk.a.a.c;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class d {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:3:0x000c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0079, code lost:
        if (r2 != null) goto L_0x0036;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0053 A[Catch:{ NoSuchAlgorithmException -> 0x0072, FileNotFoundException -> 0x0068, IOException -> 0x005e, IllegalArgumentException -> 0x0054, IndexOutOfBoundsException -> 0x004a, all -> 0x0048, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005d A[Catch:{ NoSuchAlgorithmException -> 0x0072, FileNotFoundException -> 0x0068, IOException -> 0x005e, IllegalArgumentException -> 0x0054, IndexOutOfBoundsException -> 0x004a, all -> 0x0048, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0067 A[Catch:{ NoSuchAlgorithmException -> 0x0072, FileNotFoundException -> 0x0068, IOException -> 0x005e, IllegalArgumentException -> 0x0054, IndexOutOfBoundsException -> 0x004a, all -> 0x0048, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0071 A[Catch:{ NoSuchAlgorithmException -> 0x0072, FileNotFoundException -> 0x0068, IOException -> 0x005e, IllegalArgumentException -> 0x0054, IndexOutOfBoundsException -> 0x004a, all -> 0x0048, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0081 A[SYNTHETIC, Splitter:B:54:0x0081] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static String a(String str, String str2) {
        Throwable th;
        NoSuchAlgorithmException e;
        FileInputStream fileInputStream;
        FileNotFoundException e2;
        FileInputStream fileInputStream2;
        IOException e3;
        FileInputStream fileInputStream3;
        IllegalArgumentException e4;
        FileInputStream fileInputStream4;
        IndexOutOfBoundsException e5;
        FileInputStream fileInputStream5;
        ?? isEmpty = TextUtils.isEmpty(str);
        String str3 = null;
        str3 = null;
        FileInputStream fileInputStream6 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        if (isEmpty != 0) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str2);
            FileInputStream fileInputStream7 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                long j = 0;
                while (true) {
                    int read = fileInputStream7.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                    j += (long) read;
                }
                fileInputStream5 = fileInputStream7;
                if (j > 0) {
                    str3 = b.a(instance.digest());
                    fileInputStream5 = fileInputStream7;
                }
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                fileInputStream = fileInputStream7;
                a.a("FileUtil", "getFileHashData NoSuchAlgorithmException", e);
                fileInputStream5 = fileInputStream;
            } catch (FileNotFoundException e7) {
                e2 = e7;
                fileInputStream2 = fileInputStream7;
                a.a("FileUtil", "getFileHashData FileNotFoundException", e2);
                if (fileInputStream2 != null) {
                }
                return str3;
            } catch (IOException e8) {
                e3 = e8;
                fileInputStream3 = fileInputStream7;
                a.a("FileUtil", "getFileHashData IOException", e3);
                if (fileInputStream3 != null) {
                }
                return str3;
            } catch (IllegalArgumentException e9) {
                e4 = e9;
                fileInputStream4 = fileInputStream7;
                a.a("FileUtil", "getFileHashData IllegalArgumentException", e4);
                if (fileInputStream4 != null) {
                }
                return str3;
            } catch (IndexOutOfBoundsException e10) {
                e5 = e10;
                isEmpty = fileInputStream7;
                a.a("FileUtil", "getFileHashData IndexOutOfBoundsException", e5);
                if (isEmpty != 0) {
                }
                return str3;
            }
        } catch (NoSuchAlgorithmException e11) {
            e = e11;
            fileInputStream = null;
            a.a("FileUtil", "getFileHashData NoSuchAlgorithmException", e);
            fileInputStream5 = fileInputStream;
        } catch (FileNotFoundException e12) {
            e2 = e12;
            fileInputStream2 = null;
            a.a("FileUtil", "getFileHashData FileNotFoundException", e2);
            if (fileInputStream2 != null) {
                fileInputStream5 = fileInputStream2;
                fileInputStream5.close();
            }
            return str3;
        } catch (IOException e13) {
            e3 = e13;
            fileInputStream3 = null;
            a.a("FileUtil", "getFileHashData IOException", e3);
            if (fileInputStream3 != null) {
                fileInputStream5 = fileInputStream3;
                fileInputStream5.close();
            }
            return str3;
        } catch (IllegalArgumentException e14) {
            e4 = e14;
            fileInputStream4 = null;
            a.a("FileUtil", "getFileHashData IllegalArgumentException", e4);
            if (fileInputStream4 != null) {
                fileInputStream5 = fileInputStream4;
                fileInputStream5.close();
            }
            return str3;
        } catch (IndexOutOfBoundsException e15) {
            e5 = e15;
            isEmpty = 0;
            a.a("FileUtil", "getFileHashData IndexOutOfBoundsException", e5);
            if (isEmpty != 0) {
                fileInputStream5 = isEmpty;
                fileInputStream5.close();
            }
            return str3;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream6 = isEmpty;
            if (fileInputStream6 != null) {
            }
            throw th;
        }
        try {
            fileInputStream5.close();
        } catch (IOException unused) {
            a.d("FileUtil", "Close FileInputStream failed!");
        }
        return str3;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                a.a("FileUtil", "Closeable exception", e);
            }
        }
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        return file.delete();
    }
}
