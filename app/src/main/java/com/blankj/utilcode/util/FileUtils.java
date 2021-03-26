package com.blankj.utilcode.util;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

public final class FileUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    public interface OnReplaceListener {
        boolean onReplace(File file, File file2);
    }

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static File getFileByPath(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean isFileExists(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return isFileExists(file.getAbsolutePath());
    }

    public static boolean isFileExists(String str) {
        File fileByPath = getFileByPath(str);
        if (fileByPath == null) {
            return false;
        }
        if (fileByPath.exists()) {
            return true;
        }
        return isFileExistsApi29(str);
    }

    private static boolean isFileExistsApi29(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = Utils.getApp().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
                if (openAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    openAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || UtilsBridge.isSpace(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        if (file2.exists() || !file.renameTo(file2)) {
            return false;
        }
        return true;
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isDir(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createFileByDeleteOldFile(String str) {
        return createFileByDeleteOldFile(getFileByPath(str));
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean copy(String str, String str2) {
        return copy(getFileByPath(str), getFileByPath(str2), (OnReplaceListener) null);
    }

    public static boolean copy(String str, String str2, OnReplaceListener onReplaceListener) {
        return copy(getFileByPath(str), getFileByPath(str2), onReplaceListener);
    }

    public static boolean copy(File file, File file2) {
        return copy(file, file2, (OnReplaceListener) null);
    }

    public static boolean copy(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return copyDir(file, file2, onReplaceListener);
        }
        return copyFile(file, file2, onReplaceListener);
    }

    private static boolean copyDir(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveDir(file, file2, onReplaceListener, false);
    }

    private static boolean copyFile(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveFile(file, file2, onReplaceListener, false);
    }

    public static boolean move(String str, String str2) {
        return move(getFileByPath(str), getFileByPath(str2), (OnReplaceListener) null);
    }

    public static boolean move(String str, String str2, OnReplaceListener onReplaceListener) {
        return move(getFileByPath(str), getFileByPath(str2), onReplaceListener);
    }

    public static boolean move(File file, File file2) {
        return move(file, file2, (OnReplaceListener) null);
    }

    public static boolean move(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return moveDir(file, file2, onReplaceListener);
        }
        return moveFile(file, file2, onReplaceListener);
    }

    public static boolean moveDir(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveDir(file, file2, onReplaceListener, true);
    }

    public static boolean moveFile(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveFile(file, file2, onReplaceListener, true);
    }

    private static boolean copyOrMoveDir(File file, File file2, OnReplaceListener onReplaceListener, boolean z) {
        if (file == null || file2 == null) {
            return false;
        }
        String str = file2.getPath() + File.separator;
        if (!(!str.contains(file.getPath() + File.separator) && file.exists() && file.isDirectory() && createOrExistsDir(file2))) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file3 : listFiles) {
                File file4 = new File(str + file3.getName());
                if (file3.isFile()) {
                    if (!copyOrMoveFile(file3, file4, onReplaceListener, z)) {
                        return false;
                    }
                } else if (file3.isDirectory() && !copyOrMoveDir(file3, file4, onReplaceListener, z)) {
                    return false;
                }
            }
        }
        if (!z || deleteDir(file)) {
            return true;
        }
        return false;
    }

    private static boolean copyOrMoveFile(File file, File file2, OnReplaceListener onReplaceListener, boolean z) {
        if (file != null && file2 != null && !file.equals(file2) && file.exists() && file.isFile()) {
            if (file2.exists()) {
                if (onReplaceListener != null && !onReplaceListener.onReplace(file, file2)) {
                    return true;
                }
                if (!file2.delete()) {
                    return false;
                }
            }
            if (!createOrExistsDir(file2.getParentFile())) {
                return false;
            }
            try {
                if (!UtilsBridge.writeFileFromIS(file2.getAbsolutePath(), new FileInputStream(file))) {
                    return false;
                }
                if (!z || deleteFile(file)) {
                    return true;
                }
                return false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean delete(String str) {
        return delete(getFileByPath(str));
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return deleteDir(file);
        }
        return deleteFile(file);
    }

    private static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean deleteAllInDir(String str) {
        return deleteAllInDir(getFileByPath(str));
    }

    public static boolean deleteAllInDir(File file) {
        return deleteFilesInDirWithFilter(file, new FileFilter() {
            /* class com.blankj.utilcode.util.FileUtils.AnonymousClass1 */

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return true;
            }
        });
    }

    public static boolean deleteFilesInDir(String str) {
        return deleteFilesInDir(getFileByPath(str));
    }

    public static boolean deleteFilesInDir(File file) {
        return deleteFilesInDirWithFilter(file, new FileFilter() {
            /* class com.blankj.utilcode.util.FileUtils.AnonymousClass2 */

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isFile();
            }
        });
    }

    public static boolean deleteFilesInDirWithFilter(String str, FileFilter fileFilter) {
        return deleteFilesInDirWithFilter(getFileByPath(str), fileFilter);
    }

    public static boolean deleteFilesInDirWithFilter(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !deleteDir(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static List<File> listFilesInDir(String str) {
        return listFilesInDir(str, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(File file) {
        return listFilesInDir(file, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(String str, Comparator<File> comparator) {
        return listFilesInDir(getFileByPath(str), false, comparator);
    }

    public static List<File> listFilesInDir(File file, Comparator<File> comparator) {
        return listFilesInDir(file, false, comparator);
    }

    public static List<File> listFilesInDir(String str, boolean z) {
        return listFilesInDir(getFileByPath(str), z);
    }

    public static List<File> listFilesInDir(File file, boolean z) {
        return listFilesInDir(file, z, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(String str, boolean z, Comparator<File> comparator) {
        return listFilesInDir(getFileByPath(str), z, comparator);
    }

    public static List<File> listFilesInDir(File file, boolean z, Comparator<File> comparator) {
        return listFilesInDirWithFilter(file, new FileFilter() {
            /* class com.blankj.utilcode.util.FileUtils.AnonymousClass3 */

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return true;
            }
        }, z, comparator);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter) {
        return listFilesInDirWithFilter(file, fileFilter, false, (Comparator<File>) null);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, Comparator<File> comparator) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, comparator);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, Comparator<File> comparator) {
        return listFilesInDirWithFilter(file, fileFilter, false, comparator);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, boolean z) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, z);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, boolean z) {
        return listFilesInDirWithFilter(file, fileFilter, z, (Comparator<File>) null);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, boolean z, Comparator<File> comparator) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, z, comparator);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, boolean z, Comparator<File> comparator) {
        List<File> listFilesInDirWithFilterInner = listFilesInDirWithFilterInner(file, fileFilter, z);
        if (comparator != null) {
            Collections.sort(listFilesInDirWithFilterInner, comparator);
        }
        return listFilesInDirWithFilterInner;
    }

    private static List<File> listFilesInDirWithFilterInner(File file, FileFilter fileFilter, boolean z) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (isDir(file) && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z && file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilterInner(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }

    public static long getFileLastModified(String str) {
        return getFileLastModified(getFileByPath(str));
    }

    public static long getFileLastModified(File file) {
        if (file == null) {
            return -1;
        }
        return file.lastModified();
    }

    public static String getFileCharsetSimple(String str) {
        return getFileCharsetSimple(getFileByPath(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054 A[SYNTHETIC, Splitter:B:33:0x0054] */
    public static String getFileCharsetSimple(File file) {
        Throwable th;
        IOException e;
        if (file == null) {
            return "";
        }
        if (isUtf8(file)) {
            return "UTF-8";
        }
        int i = 0;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                i = bufferedInputStream2.read() + (bufferedInputStream2.read() << 8);
                try {
                    bufferedInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e = e3;
                bufferedInputStream = bufferedInputStream2;
                try {
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                    if (i != 65279) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (i != 65279) {
            }
        }
        if (i != 65279) {
            return i != 65534 ? "GBK" : "Unicode";
        }
        return "UTF-16BE";
    }

    public static boolean isUtf8(String str) {
        return isUtf8(getFileByPath(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0048 A[SYNTHETIC, Splitter:B:32:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A[SYNTHETIC, Splitter:B:38:0x0053] */
    public static boolean isUtf8(File file) {
        Throwable th;
        IOException e;
        boolean z = false;
        if (file == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            byte[] bArr = new byte[24];
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                int read = bufferedInputStream2.read(bArr);
                if (read != -1) {
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    if (isUtf8(bArr2) == 100) {
                        z = true;
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return z;
                }
                try {
                    bufferedInputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return false;
            } catch (IOException e4) {
                e = e4;
                bufferedInputStream = bufferedInputStream2;
                try {
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            e.printStackTrace();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            return false;
        }
    }

    private static int isUtf8(byte[] bArr) {
        if (bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return 100;
        }
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (true) {
            int i4 = 0;
            while (i < length) {
                if ((bArr[i] & -1) == -1 || (bArr[i] & -2) == -2) {
                    break loop0;
                } else if (i4 == 0) {
                    if ((bArr[i] & Byte.MAX_VALUE) == bArr[i] && bArr[i] != 0) {
                        i2++;
                    } else if ((bArr[i] & -64) == -64) {
                        int i5 = i4;
                        for (int i6 = 0; i6 < 8; i6++) {
                            byte b = (byte) (128 >> i6);
                            if ((bArr[i] & b) != b) {
                                break;
                            }
                            i5 = i6;
                        }
                        i3++;
                        i4 = i5;
                    }
                    i++;
                } else {
                    if (bArr.length - i <= i4) {
                        i4 = bArr.length - i;
                    }
                    boolean z = false;
                    for (int i7 = 0; i7 < i4; i7++) {
                        int i8 = i + i7;
                        if ((bArr[i8] & Byte.MIN_VALUE) != -128) {
                            if ((bArr[i8] & Byte.MAX_VALUE) == bArr[i8] && bArr[i] != 0) {
                                i2++;
                            }
                            z = true;
                        }
                    }
                    if (z) {
                        i3--;
                        i++;
                    } else {
                        i3 += i4;
                        i += i4;
                    }
                }
            }
            if (i2 == length) {
                return 100;
            }
            return (int) ((((float) (i3 + i2)) / ((float) length)) * 100.0f);
        }
        return 0;
    }

    public static int getFileLines(String str) {
        return getFileLines(getFileByPath(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r6 >= r3) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r1[r6] != 10) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        r3 = r2.read(r1, 0, 1024);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r3 == -1) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r6 >= r3) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        if (r1[r6] != 13) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (com.blankj.utilcode.util.FileUtils.LINE_SEP.endsWith("\n") != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r3 = r2.read(r1, 0, 1024);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (r3 == -1) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0061 A[SYNTHETIC, Splitter:B:40:0x0061] */
    public static int getFileLines(File file) {
        Throwable th;
        IOException e;
        int i = 1;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[1024];
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream = bufferedInputStream2;
                try {
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return i;
        }
    }

    public static String getSize(String str) {
        return getSize(getFileByPath(str));
    }

    public static String getSize(File file) {
        if (file == null) {
            return "";
        }
        if (file.isDirectory()) {
            return getDirSize(file);
        }
        return getFileSize(file);
    }

    private static String getDirSize(File file) {
        long dirLength = getDirLength(file);
        if (dirLength == -1) {
            return "";
        }
        return UtilsBridge.byte2FitMemorySize(dirLength);
    }

    private static String getFileSize(File file) {
        long fileLength = getFileLength(file);
        if (fileLength == -1) {
            return "";
        }
        return UtilsBridge.byte2FitMemorySize(fileLength);
    }

    public static long getLength(String str) {
        return getLength(getFileByPath(str));
    }

    public static long getLength(File file) {
        if (file == null) {
            return 0;
        }
        if (file.isDirectory()) {
            return getDirLength(file);
        }
        return getFileLength(file);
    }

    private static long getDirLength(File file) {
        long j;
        long j2 = 0;
        if (!isDir(file)) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    j = getDirLength(file2);
                } else {
                    j = file2.length();
                }
                j2 += j;
            }
        }
        return j2;
    }

    public static long getFileLength(String str) {
        if (str.matches("[a-zA-z]+://[^\\s]*")) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setRequestProperty("Accept-Encoding", "identity");
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    return (long) httpsURLConnection.getContentLength();
                }
                return -1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getFileLength(getFileByPath(str));
    }

    private static long getFileLength(File file) {
        if (!isFile(file)) {
            return -1;
        }
        return file.length();
    }

    public static String getFileMD5ToString(String str) {
        return getFileMD5ToString(UtilsBridge.isSpace(str) ? null : new File(str));
    }

    public static String getFileMD5ToString(File file) {
        return UtilsBridge.bytes2HexString(getFileMD5(file));
    }

    public static byte[] getFileMD5(String str) {
        return getFileMD5(getFileByPath(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC, Splitter:B:31:0x004b] */
    public static byte[] getFileMD5(File file) {
        Throwable th;
        Exception e;
        DigestInputStream digestInputStream;
        DigestInputStream digestInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            digestInputStream = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance("MD5"));
            try {
                do {
                } while (digestInputStream.read(new byte[262144]) > 0);
                byte[] digest = digestInputStream.getMessageDigest().digest();
                try {
                    digestInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return digest;
            } catch (IOException | NoSuchAlgorithmException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (digestInputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    digestInputStream2 = digestInputStream;
                    if (digestInputStream2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException | NoSuchAlgorithmException e4) {
            e = e4;
            digestInputStream = null;
            e.printStackTrace();
            if (digestInputStream != null) {
                try {
                    digestInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (digestInputStream2 != null) {
                try {
                    digestInputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String getDirName(File file) {
        return file == null ? "" : getDirName(file.getAbsolutePath());
    }

    public static String getDirName(String str) {
        int lastIndexOf;
        if (!UtilsBridge.isSpace(str) && (lastIndexOf = str.lastIndexOf(File.separator)) != -1) {
            return str.substring(0, lastIndexOf + 1);
        }
        return "";
    }

    public static String getFileName(File file) {
        return file == null ? "" : getFileName(file.getAbsolutePath());
    }

    public static String getFileName(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public static String getFileNameNoExtension(File file) {
        return file == null ? "" : getFileNameNoExtension(file.getPath());
    }

    public static String getFileNameNoExtension(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf2 == -1) {
            return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
        }
        if (lastIndexOf == -1 || lastIndexOf2 > lastIndexOf) {
            return str.substring(lastIndexOf2 + 1);
        }
        return str.substring(lastIndexOf2 + 1, lastIndexOf);
    }

    public static String getFileExtension(File file) {
        return file == null ? "" : getFileExtension(file.getPath());
    }

    public static String getFileExtension(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf == -1 || lastIndexOf2 >= lastIndexOf) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static void notifySystemToScan(String str) {
        notifySystemToScan(getFileByPath(str));
    }

    public static void notifySystemToScan(File file) {
        if (file != null && file.exists()) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.parse("file://" + file.getAbsolutePath()));
            Utils.getApp().sendBroadcast(intent);
        }
    }

    public static long getFsTotalSize(String str) {
        long j;
        long j2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getBlockCountLong();
        } else {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getBlockCount();
        }
        return j2 * j;
    }

    public static long getFsAvailableSize(String str) {
        long j;
        long j2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getAvailableBlocks();
        }
        return j2 * j;
    }
}
