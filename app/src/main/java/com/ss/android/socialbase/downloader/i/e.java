package com.ss.android.socialbase.downloader.i;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.network.g;
import com.ss.android.ttmd5.TTMd5;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* compiled from: DownloadUtils */
public class e {
    private static final String a = "e";
    private static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String c = null;
    private static volatile SparseArray<Boolean> d = new SparseArray<>();
    private static volatile SparseArray<List<aj>> e = new SparseArray<>();
    private static final char[] f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern g = null;
    private static Pattern h = null;
    private static ConnectivityManager i;
    private static Boolean j;
    private static Boolean k;

    public static double a(long j2) {
        return ((double) j2) / 1048576.0d;
    }

    public static boolean a(int i2) {
        return i2 == 0 || i2 == 2;
    }

    public static boolean b(long j2) {
        return j2 == -1;
    }

    public static boolean c(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 0;
    }

    public static boolean d(int i2) {
        return i2 == 206 || i2 == 200;
    }

    public static String a(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i2 < 0 || i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3 * 2;
        char[] cArr = new char[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i6 + i2] & 255;
            int i8 = i5 + 1;
            char[] cArr2 = f;
            cArr[i5] = cArr2[i7 >> 4];
            i5 = i8 + 1;
            cArr[i8] = cArr2[i7 & 15];
        }
        return new String(cArr, 0, i4);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static long a(g gVar) {
        if (gVar == null) {
            return -1;
        }
        String b2 = b(gVar, "Content-Length");
        if (TextUtils.isEmpty(b2) && a.a(1)) {
            return b(gVar);
        }
        try {
            return Long.parseLong(b2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static long b(g gVar) {
        if (gVar == null) {
            return -1;
        }
        String b2 = b(gVar, "Content-Range");
        if (TextUtils.isEmpty(b2)) {
            return -1;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(b2);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e2) {
            String str = a;
            a.d(str, "parse content-length from content-range failed " + e2);
        }
        return -1;
    }

    public static long b(String str) {
        if (str == null) {
            return -1;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                String str2 = a;
                a.d(str2, "parse instance length failed with " + str);
            }
        }
        return -1;
    }

    private static String i(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (g == null) {
                g = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            Matcher matcher = g.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (h == null) {
                h = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = h.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static String a(g gVar, String str) {
        String i2 = i(gVar.a("Content-Disposition"));
        return TextUtils.isEmpty(i2) ? e(str) : i2;
    }

    public static com.ss.android.socialbase.downloader.model.e a(String str, String str2, int i2) throws BaseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new BaseException(1021, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        if (!file.exists() || !file.isDirectory()) {
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (file2.exists()) {
                            file2.delete();
                            throw new BaseException(1031, "download savePath is not directory");
                        } else if (!file2.mkdirs()) {
                            throw new BaseException(1030, "download savePath directory can not created");
                        }
                    }
                    file.createNewFile();
                } catch (IOException e2) {
                    throw new BaseException(1036, e2);
                }
            }
            return new com.ss.android.socialbase.downloader.model.e(file, i2);
        }
        throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
    }

    public static List<b> a(List<b> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (b bVar : list) {
            if (bVar != null) {
                if (bVar.d()) {
                    sparseArray.put(bVar.s(), bVar);
                    List<b> list2 = (List) sparseArray2.get(bVar.s());
                    if (list2 != null) {
                        for (b bVar2 : list2) {
                            bVar2.a(bVar);
                        }
                        bVar.a(list2);
                    }
                } else {
                    b bVar3 = (b) sparseArray.get(bVar.b());
                    if (bVar3 != null) {
                        List<b> g2 = bVar3.g();
                        if (g2 == null) {
                            g2 = new ArrayList<>();
                            bVar3.a(g2);
                        }
                        bVar.a(bVar3);
                        g2.add(bVar);
                    } else {
                        List list3 = (List) sparseArray2.get(bVar.b());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(bVar.b(), list3);
                        }
                        list3.add(bVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String a(String str, String str2, String str3) {
        String str4;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            str4 = a(str2, str3);
        } else {
            str4 = a(str, str3);
        }
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        return String.format("%s.tp", str4);
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            return !TextUtils.isEmpty(str2) ? str2 : str;
        }
        return null;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static long b(List<b> list) {
        long j2 = 0;
        for (b bVar : list) {
            j2 += bVar.o();
        }
        return j2;
    }

    public static void a(DownloadInfo downloadInfo) {
        a(downloadInfo, true);
    }

    public static void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo != null) {
            if (z) {
                try {
                    c(downloadInfo.getSavePath(), downloadInfo.getName());
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            c(downloadInfo.getTempPath(), downloadInfo.getTempName());
            if (downloadInfo.isSavePathRedirected()) {
                b(downloadInfo);
            }
        }
    }

    public static void b(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.g.a a2;
        JSONObject d2;
        if (downloadInfo != null && (d2 = (a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId())).d("download_dir")) != null) {
            String optString = d2.optString("ins_desc");
            if (!TextUtils.isEmpty(optString)) {
                c(downloadInfo.getSavePath(), optString);
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = downloadInfo.getName();
            }
            String a3 = a(title, a2);
            String savePath = downloadInfo.getSavePath();
            if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(savePath)) {
                File file = new File(a3);
                File file2 = new File(savePath);
                while (file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName())) {
                    j(file2.getPath());
                    file = file.getParentFile();
                    file2 = file2.getParentFile();
                }
            }
        }
    }

    private static boolean j(String str) {
        String str2 = a;
        Log.w(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                Log.w(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static void c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            if (file.exists()) {
                String str3 = a;
                Log.e(str3, "deleteFile: " + str + "/" + str2);
                file.delete();
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        return true;
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return a(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean a(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists() && c(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                    return true;
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static int b(String str, String str2, String str3) {
        return TTMd5.checkMd5(str3, new File(str, str2));
    }

    public static boolean c(String str, String str2, String str3) {
        return a(b(str, str2, str3));
    }

    public static int a(File file, String str) {
        return TTMd5.checkMd5(str, file);
    }

    public static boolean b(File file, String str) {
        return a(TTMd5.checkMd5(str, file));
    }

    public static String b(int i2) {
        String str = "ttmd5 check code = " + i2 + ", ";
        if (i2 != 99) {
            switch (i2) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        } else {
            return str + "unknown error";
        }
    }

    public static long d(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e2) {
            throw new BaseException(1050, e2);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static void a(DownloadInfo downloadInfo, aj ajVar) {
        BaseException baseException;
        boolean z;
        String str = a;
        a.b(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            DownloadInfo downloadInfo2 = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.b.L()).getDownloadInfo(downloadInfo.getId());
            if (!file.exists()) {
                a.b(str, "tempFile not exist");
                if (file2.exists()) {
                    a.b(str, "targetFile exist");
                    if (b(file2, downloadInfo.getMd5())) {
                        a.b(str, "tempFile not exist , targetFile exists and md5 check valid");
                        if (ajVar != null) {
                            ajVar.a();
                            return;
                        }
                        return;
                    } else if (downloadInfo2 != null && downloadInfo2.isSaveTempFile()) {
                        downloadInfo2.registerTempFileSaveCallback(ajVar);
                        return;
                    }
                } else {
                    a.b(str, "targetFile not exist");
                    if (downloadInfo2 != null && downloadInfo2.isSaveTempFile()) {
                        downloadInfo2.registerTempFileSaveCallback(ajVar);
                        return;
                    }
                }
            } else if (file2.exists()) {
                a.b(str, "targetFile exist");
                int a2 = a(file2, downloadInfo.getMd5());
                if (a(a2)) {
                    a.b(str, "tempFile exist , targetFile exists and md5 check valid");
                    if (ajVar != null) {
                        ajVar.a();
                        return;
                    }
                    return;
                } else if (downloadInfo2 == null || !downloadInfo2.isSaveTempFile()) {
                    if (downloadInfo2 != null) {
                        downloadInfo2.setIsSaveTempFile(true);
                    }
                    Log.e(str, "saveFileAsTargetName: " + file2.getPath());
                    if (!file2.delete()) {
                        BaseException baseException2 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + b(a2));
                        if (ajVar != null) {
                            ajVar.a(baseException2);
                        }
                        if (downloadInfo2 != null) {
                            downloadInfo2.handleTempSaveCallback(false, baseException2);
                            return;
                        }
                        return;
                    }
                } else {
                    downloadInfo2.registerTempFileSaveCallback(ajVar);
                    return;
                }
            }
            if (downloadInfo2 != null) {
                downloadInfo2.setIsSaveTempFile(true);
            }
            try {
                z = !b(file, file2);
                baseException = null;
            } catch (BaseException e2) {
                baseException = e2;
                z = false;
            }
            if (z) {
                if (baseException == null) {
                    baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s), temp file is exist: %d", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), Boolean.valueOf(file.exists())));
                }
                if (ajVar != null) {
                    ajVar.a(baseException);
                }
                if (downloadInfo2 != null) {
                    downloadInfo2.handleTempSaveCallback(false, baseException);
                    return;
                }
                return;
            }
            int a3 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_finish_check_ttmd5", 2);
            if (a3 > 0) {
                int a4 = a(file2, downloadInfo.getMd5());
                downloadInfo.setTTMd5CheckStatus(a4);
                if (a3 >= 2 && !a(a4)) {
                    if (ajVar != null) {
                        ajVar.a(new BaseException(1034, b(a4)));
                    }
                    a(downloadInfo);
                    return;
                }
            }
            if (ajVar != null) {
                ajVar.a();
            }
            if (downloadInfo2 != null) {
                downloadInfo2.handleTempSaveCallback(true, null);
            }
        } catch (Throwable th) {
            a.b(a, "saveFileAsTargetName throwable " + th.getMessage());
            if (ajVar != null) {
                ajVar.a(new BaseException(1038, b(th, "saveFileAsTargetName")));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0194 A[SYNTHETIC, Splitter:B:53:0x0194] */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    public static void a(DownloadInfo downloadInfo, z zVar, aj ajVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        String str = a;
        a.b(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            synchronized (d) {
                if (d.get(downloadInfo.getId()) == Boolean.TRUE) {
                    a.b(str, "has another same task is saving temp file");
                    if (ajVar != null) {
                        List<aj> list = e.get(downloadInfo.getId());
                        if (list == null) {
                            list = new ArrayList<>();
                            e.put(downloadInfo.getId(), list);
                        }
                        list.add(ajVar);
                    }
                    return;
                }
                a.b(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                d.put(downloadInfo.getId(), Boolean.TRUE);
            }
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file2.exists()) {
                a.b(str, "targetFile exist");
                int a2 = a(file2, downloadInfo.getMd5());
                if (a(a2)) {
                    a.b(str, "tempFile not exist , targetFile exists and md5 check valid");
                    downloadInfo.setTTMd5CheckStatus(a2);
                    if (ajVar != null) {
                        ajVar.a();
                    }
                    a(downloadInfo.getId(), true, (BaseException) null);
                } else {
                    if (!file.exists()) {
                        BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), b(a2)));
                        if (ajVar != null) {
                            ajVar.a(baseException2);
                        }
                        a(downloadInfo.getId(), false, baseException2);
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!file2.delete()) {
                        if (z) {
                            BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + b(a2));
                            if (ajVar != null) {
                                ajVar.a(baseException3);
                            }
                            a(downloadInfo.getId(), false, baseException3);
                        } else if (zVar != null) {
                            com.ss.android.socialbase.downloader.d.a.a(zVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                        }
                    }
                    if (z) {
                        try {
                            z2 = !b(file, file2);
                            baseException = null;
                        } catch (BaseException e2) {
                            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_file_rename_failed")) {
                                baseException = e2;
                                z2 = true;
                            } else {
                                baseException = e2;
                                z2 = false;
                            }
                        }
                        if (z2) {
                            if (baseException == null) {
                                baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                            }
                            if (ajVar != null) {
                                ajVar.a(baseException);
                            }
                            a(downloadInfo.getId(), false, baseException);
                            return;
                        }
                        int a3 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_finish_check_ttmd5", 2);
                        if (a3 > 0) {
                            int a4 = a(file2, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(a4);
                            if (a3 >= 2 && !a(a4)) {
                                BaseException baseException4 = new BaseException(1034, b(a4));
                                if (ajVar != null) {
                                    ajVar.a(baseException4);
                                }
                                a(downloadInfo.getId(), false, baseException4);
                                a(downloadInfo);
                                return;
                            }
                        }
                        if (ajVar != null) {
                            ajVar.a();
                        }
                        a(downloadInfo.getId(), true, (BaseException) null);
                        return;
                    }
                    return;
                }
            } else if (!file.exists()) {
                BaseException baseException5 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                if (ajVar != null) {
                    ajVar.a(baseException5);
                }
                a(downloadInfo.getId(), false, baseException5);
            } else {
                z = true;
                if (z) {
                }
            }
            z = false;
            if (z) {
            }
        } catch (Throwable th) {
            a.b(a, "saveFileAsTargetName throwable " + th.getMessage());
            if (ajVar != null) {
                ajVar.a(new BaseException(1038, b(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void a(int i2, boolean z, BaseException baseException) {
        synchronized (d) {
            List<aj> list = e.get(i2);
            if (list != null) {
                for (aj ajVar : list) {
                    if (ajVar != null) {
                        if (z) {
                            ajVar.a();
                        } else {
                            ajVar.a(baseException);
                        }
                    }
                }
            }
            String str = a;
            a.b(str, "handleTempSaveCallback id:" + i2);
            d.remove(i2);
        }
    }

    public static void a(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo != null && !TextUtils.isEmpty(str) && !str.equals(downloadInfo.getName())) {
            File file = new File(downloadInfo.getSavePath(), str);
            File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            String str2 = a;
            Log.e(str2, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
            if (file2.exists() && !file2.delete()) {
                throw new BaseException(1037, "targetPath file exists but can't delete");
            } else if (!a(file, file2)) {
                throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
            }
        }
    }

    public static boolean a(File file, File file2) throws BaseException {
        return a(file, file2, true);
    }

    public static boolean a(File file, File file2, boolean z) throws BaseException {
        if (!(file == null || file2 == null)) {
            try {
                if (file.exists() && !file.isDirectory()) {
                    if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                        File parentFile = file2.getParentFile();
                        if (parentFile == null || parentFile.mkdirs() || parentFile.isDirectory()) {
                            String str = a;
                            Log.e(str, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                            if (!file2.exists() || file2.canWrite() || file2.delete()) {
                                b(file, file2, z);
                                return true;
                            }
                            throw new IOException("Destination '" + file2 + "' exists but is read-only and delete failed");
                        }
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                a(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c1, code lost:
        if (r11 != null) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d7, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00db, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00df, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e1, code lost:
        if (r9 != null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e8, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ec, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00f6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00f7, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00fb, code lost:
        throw r0;
     */
    private static void b(File file, File file2, boolean z) throws IOException {
        if (!file2.exists() || !file2.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            FileChannel channel2 = fileOutputStream.getChannel();
            long size = channel.size();
            long j2 = 0;
            while (j2 < size) {
                long j3 = size - j2;
                long transferFrom = channel2.transferFrom(channel, j2, j3 > 31457280 ? 31457280 : j3);
                if (transferFrom == 0) {
                    break;
                }
                j2 += transferFrom;
            }
            if (channel2 != null) {
                channel2.close();
            }
            fileOutputStream.close();
            if (channel != null) {
                channel.close();
            }
            fileInputStream.close();
            long length = file.length();
            long length2 = file2.length();
            if (length != length2) {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
            } else if (z) {
                file2.setLastModified(file.lastModified());
            }
        } else {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
    }

    public static boolean b(File file, File file2) throws BaseException {
        String str = a;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = a(file, file2);
            try {
                Log.e(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean a(int i2, String str) {
        if (a.a(16777216)) {
            return i2 == 206 || i2 == 1;
        }
        if (i2 >= 400) {
            return false;
        }
        if (i2 == 206 || i2 == 1 || "bytes".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (a.a(8)) {
            if ("chunked".equals(gVar.a("Transfer-Encoding")) || a(gVar) == -1) {
                return true;
            }
            return false;
        } else if (a(gVar) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static List<c> a(List<c> list, String str, b bVar) {
        return a(list, str, bVar.m(), bVar.p());
    }

    public static List<c> a(List<c> list, String str, long j2, long j3) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (c cVar : list) {
                if (cVar != null) {
                    arrayList.add(cVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new c("If-Match", str));
        }
        arrayList.add(new c("Accept-Encoding", "identity"));
        if (j3 <= 0) {
            str2 = String.format("bytes=%s-", String.valueOf(j2));
        } else {
            str2 = String.format("bytes=%s-%s", String.valueOf(j2), String.valueOf(j3));
        }
        arrayList.add(new c("Range", str2));
        String str3 = a;
        a.b(str3, " range CurrentOffset:" + j2 + " EndOffset:" + j3 + ", range = " + str2);
        return arrayList;
    }

    public static boolean a(int i2, String str, String str2) {
        return i2 == -3 && !d(str, str2);
    }

    public static ConnectivityManager a(Context context) {
        ConnectivityManager connectivityManager = i;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        i = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager a2 = a(context);
            if (a2 == null || (activeNetworkInfo = a2.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (!activeNetworkInfo.isAvailable()) {
                return false;
            }
            if (1 == activeNetworkInfo.getType()) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager a2 = a(context);
            if (a2 == null || (activeNetworkInfo = a2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String e(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(str.getBytes("UTF-8"));
                    return a(instance.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String d(Context context) {
        String str = c;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (a.a()) {
                            a.b("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        String str2 = runningAppProcessInfo.processName;
                        c = str2;
                        return str2;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String h2 = h();
        c = h2;
        return h2;
    }

    private static String h() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (a.a()) {
                    a.b("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                a(bufferedReader);
                return sb2;
            } catch (Throwable unused) {
                a(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            a(bufferedReader);
            return null;
        }
    }

    public static boolean a() {
        Boolean bool = j;
        if (bool != null) {
            return bool.booleanValue();
        }
        String d2 = d(com.ss.android.socialbase.downloader.downloader.b.L());
        boolean z = false;
        if (d2 == null || !d2.contains(":")) {
            if (d2 != null && d2.equals(com.ss.android.socialbase.downloader.downloader.b.L().getPackageName())) {
                z = true;
            }
            j = Boolean.valueOf(z);
        } else {
            j = false;
        }
        return j.booleanValue();
    }

    public static boolean b() {
        return !c() && com.ss.android.socialbase.downloader.downloader.b.c() && l.a(true).g();
    }

    public static boolean c() {
        Boolean bool = k;
        if (bool != null) {
            return bool.booleanValue();
        }
        String d2 = d(com.ss.android.socialbase.downloader.downloader.b.L());
        if (d2 != null) {
            if (d2.equals(com.ss.android.socialbase.downloader.downloader.b.L().getPackageName() + ":downloader")) {
                k = true;
                return k.booleanValue();
            }
        }
        k = false;
        return k.booleanValue();
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String d2 = d(com.ss.android.socialbase.downloader.downloader.b.L());
        if (d2 == null || !d2.equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String g(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        String i2 = i(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(i2)) {
                return false;
            }
            if (!i2.contains("time out") && !i2.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(Throwable th) {
        com.ss.android.socialbase.downloader.exception.b bVar;
        if (th == null) {
            return false;
        }
        String i2 = i(th);
        if ((th instanceof com.ss.android.socialbase.downloader.exception.b) && (((bVar = (com.ss.android.socialbase.downloader.exception.b) th) != null && bVar.a() == 403) || (!TextUtils.isEmpty(i2) && i2.contains("403")))) {
            return true;
        }
        if (TextUtils.isEmpty(i2) || !i2.contains("Forbidden")) {
            return false;
        }
        return true;
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        String i2 = i(th);
        if (TextUtils.isEmpty(i2) || !i2.contains("network not available")) {
            return false;
        }
        return true;
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        String i2 = i(th);
        if (TextUtils.isEmpty(i2) || !i2.contains("Exception in connect")) {
            return false;
        }
        return true;
    }

    public static boolean e(Throwable th) {
        if (th == null) {
            return false;
        }
        String i2 = i(th);
        if (TextUtils.isEmpty(i2) || !i2.contains("Precondition Failed")) {
            return false;
        }
        return true;
    }

    public static boolean f(Throwable th) {
        if (th == null) {
            return false;
        }
        String i2 = i(th);
        if (TextUtils.isEmpty(i2) || !i2.contains("Requested Range Not Satisfiable")) {
            return false;
        }
        return true;
    }

    public static boolean a(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static boolean b(BaseException baseException) {
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.b) {
            com.ss.android.socialbase.downloader.exception.b bVar = (com.ss.android.socialbase.downloader.exception.b) baseException;
            if (bVar.a() == 412 || bVar.a() == 416) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) {
            return true;
        }
        return false;
    }

    public static void a(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        } else if (th instanceof SSLHandshakeException) {
            throw new BaseException(1011, b(th, str2));
        } else if (a(th)) {
            throw new BaseException(1048, b(th, str2));
        } else if (e(th)) {
            throw new com.ss.android.socialbase.downloader.exception.b(1004, 412, b(th, str2));
        } else if (f(th)) {
            throw new com.ss.android.socialbase.downloader.exception.b(1004, 416, b(th, str2));
        } else if (b(th)) {
            throw new BaseException(1047, b(th, str2));
        } else if (c(th)) {
            throw new BaseException(1049, b(th, str2));
        } else if (d(th)) {
            throw new BaseException(1041, b(th, str2));
        } else if (th instanceof IOException) {
            a((IOException) th, str);
        } else {
            throw new BaseException(1000, b(th, str2));
        }
    }

    public static void a(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String b2 = b(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new BaseException(1041, b2);
        } else if (iOException instanceof UnknownHostException) {
            throw new BaseException(1055, b2);
        } else if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(1056, b2);
        } else if (iOException instanceof UnknownServiceException) {
            throw new BaseException(1057, b2);
        } else if (iOException instanceof PortUnreachableException) {
            throw new BaseException(1058, b2);
        } else if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(1048, b2);
        } else if (iOException instanceof SocketException) {
            throw new BaseException(1059, b2);
        } else if (iOException instanceof HttpRetryException) {
            throw new BaseException(1060, b2);
        } else if (iOException instanceof ProtocolException) {
            throw new BaseException(1061, b2);
        } else if (iOException instanceof MalformedURLException) {
            throw new BaseException(1062, b2);
        } else if (iOException instanceof FileNotFoundException) {
            throw new BaseException(1063, b2);
        } else if (iOException instanceof InterruptedIOException) {
            throw new BaseException(1064, b2);
        } else if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException(1065, b2);
        } else if (iOException instanceof EOFException) {
            throw new BaseException(1066, b2);
        } else if (iOException instanceof StreamResetException) {
            throw new BaseException(1067, b2);
        } else if (iOException instanceof SSLException) {
            throw new BaseException(1011, b2);
        } else if (g(iOException)) {
            throw new BaseException(1006, b2);
        } else {
            throw new BaseException(1023, b2);
        }
    }

    public static boolean g(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (!(errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064)) {
                return false;
            }
            String message = baseException.getMessage();
            if (TextUtils.isEmpty(message) || !message.contains("ENOSPC")) {
                return false;
            }
            return true;
        } else if (!(th instanceof IOException)) {
            return false;
        } else {
            String i2 = i(th);
            if (TextUtils.isEmpty(i2) || !i2.contains("ENOSPC")) {
                return false;
            }
            return true;
        }
    }

    public static boolean h(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        if (errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013) {
            return true;
        }
        return false;
    }

    public static boolean a(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        if (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) {
            return false;
        }
        return true;
    }

    public static String b(Throwable th, String str) {
        if (str == null) {
            return i(th);
        }
        return str + "-" + i(th);
    }

    public static String i(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static com.ss.android.socialbase.downloader.constants.g e(int i2) {
        com.ss.android.socialbase.downloader.constants.g gVar = com.ss.android.socialbase.downloader.constants.g.MAIN;
        if (i2 == com.ss.android.socialbase.downloader.constants.g.SUB.ordinal()) {
            return com.ss.android.socialbase.downloader.constants.g.SUB;
        }
        return i2 == com.ss.android.socialbase.downloader.constants.g.NOTIFICATION.ordinal() ? com.ss.android.socialbase.downloader.constants.g.NOTIFICATION : gVar;
    }

    public static <K> HashMap<Integer, K> a(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i2));
        }
        return hashMap;
    }

    public static <K> void a(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (!(map == null || sparseArray == null)) {
            for (Integer num : map.keySet()) {
                if (num != null) {
                    sparseArray.put(num.intValue(), map.get(num));
                }
            }
        }
    }

    public static long d(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1;
        }
        List<b> c2 = com.ss.android.socialbase.downloader.downloader.b.x().c(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (c2 == null || c2.size() <= 1) {
            return 0;
        }
        long c3 = c(c2);
        if (c3 >= 0) {
            return c3;
        }
        return 0;
    }

    private static long c(List<b> list) {
        if (list == null || list.isEmpty()) {
            return -1;
        }
        long j2 = -1;
        for (b bVar : list) {
            if (bVar != null && ((bVar.n() <= bVar.p() || bVar.p() == 0) && (j2 == -1 || j2 > bVar.n()))) {
                j2 = bVar.n();
            }
        }
        return j2;
    }

    public static long e(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        List<b> c2 = com.ss.android.socialbase.downloader.downloader.b.x().c(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = true;
        if (chunkCount <= 1) {
            z = false;
        }
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0;
        }
        if (!z) {
            return downloadInfo.getCurBytes();
        }
        if (c2 == null || chunkCount != c2.size()) {
            return 0;
        }
        return b(c2);
    }

    public static boolean a(List<c> list, List<c> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public static String a(String str, int i2) {
        if (i2 == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static String a(String str, com.ss.android.socialbase.downloader.g.a aVar) {
        JSONObject d2;
        String format;
        if (aVar == null || (d2 = aVar.d("download_dir")) == null) {
            return "";
        }
        String optString = d2.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static String e() {
        Context L = com.ss.android.socialbase.downloader.downloader.b.L();
        File globalSaveDir = Downloader.getInstance(L).getGlobalSaveDir();
        if (a(globalSaveDir)) {
            return globalSaveDir.getAbsolutePath();
        }
        int i2 = L.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT < 29 || ((i2 != 29 || Environment.isExternalStorageLegacy()) && i2 <= 29)) {
            File f2 = f();
            if (a(f2)) {
                return f2.getAbsolutePath();
            }
            File externalFilesDir = L.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (a(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            File externalFilesDir2 = L.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (a(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return L.getFilesDir().getAbsolutePath();
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            if ((file.exists() || file.mkdirs()) && file.isDirectory()) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static File f() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception unused) {
            str = "";
        }
        if ("mounted".equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static void a(List<c> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new c("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static long c(long j2) {
        return System.currentTimeMillis() - j2;
    }

    public static String b(g gVar, String str) {
        if (gVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String a2 = gVar.a(str);
        if (!com.ss.android.socialbase.downloader.g.a.c().b("fix_get_http_resp_head_ignore_case", true)) {
            return a2;
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = gVar.a(str.toLowerCase());
        }
        return TextUtils.isEmpty(a2) ? gVar.a(str.toUpperCase()) : a2;
    }

    public static int a(Object obj, int i2) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i2;
        }
    }

    public static String a(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean a(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public static boolean b(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && c(com.ss.android.socialbase.downloader.downloader.b.L());
    }

    public static boolean g() {
        Context L = com.ss.android.socialbase.downloader.downloader.b.L();
        return L != null && !b(L) && c(L);
    }

    public static long h(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (!matcher.find()) {
            return 0;
        }
        try {
            return Long.parseLong(matcher.group(1));
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }
}
