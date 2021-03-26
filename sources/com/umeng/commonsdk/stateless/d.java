package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: UMSLUtils */
public class d {
    public static int a;
    private static final byte[] b = {10, 1, 11, 5, 4, 15, 7, 9, 23, 3, 1, 6, 8, 12, 13, 91};
    private static Object c = new Object();

    public static boolean a(long j, long j2) {
        return j > j2;
    }

    public static boolean a(File file) {
        String[] list;
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
        if (0 == 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (0 == 0) goto L_0x0077;
     */
    public static int a(Context context, String str, String str2, byte[] bArr) {
        Throwable th;
        int i = 101;
        if (context != null) {
            FileOutputStream fileOutputStream = null;
            try {
                synchronized (c) {
                    try {
                        File file = new File(context.getFilesDir() + File.separator + str);
                        if (!file.isDirectory()) {
                            file.mkdir();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file.getPath() + File.separator + str2));
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.close();
                            i = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                }
            } catch (IOException e) {
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th4) {
                if (0 != 0) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th4;
            }
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0104, code lost:
        if (r2 == null) goto L_0x0109;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00df A[Catch:{ IOException -> 0x00e0, all -> 0x00b9, all -> 0x010b }] */
    public static boolean b(Context context, String str, String str2, byte[] bArr) {
        boolean z;
        IOException e;
        Throwable th;
        Throwable th2;
        if (context == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            synchronized (c) {
                try {
                    ULog.i("walle", "[stateless] begin write envelope, thread is " + Thread.currentThread());
                    File file = new File(context.getFilesDir() + "/stateless");
                    if (!file.isDirectory()) {
                        file.mkdir();
                    }
                    File file2 = new File(file.getPath() + "/" + str);
                    if (!file2.isDirectory()) {
                        file2.mkdir();
                    }
                    File file3 = new File(file2.getPath() + "/" + str2);
                    if (!file3.exists()) {
                        file3.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.close();
                        try {
                            return true;
                        } catch (Throwable th3) {
                            th2 = th3;
                            z = true;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        fileOutputStream = fileOutputStream2;
                        z = false;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th5) {
                                th2 = th5;
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    z = false;
                    while (true) {
                        break;
                    }
                    throw th2;
                }
            }
            try {
                throw th2;
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th7) {
                th = th7;
                ULog.i("walle", "[stateless] write envelope, e is " + th.getMessage());
                UMCrashManager.reportCrash(context, th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return z;
            }
        } catch (IOException e3) {
            e = e3;
            z = false;
            ULog.i("walle", "[stateless] write envelope, e is " + e.getMessage());
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th8) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th8;
        }
    }

    public static byte[] a(String str) throws IOException {
        byte[] bArr;
        synchronized (c) {
            FileChannel fileChannel = null;
            try {
                FileChannel channel = new RandomAccessFile(str, "r").getChannel();
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size()).load();
                bArr = new byte[((int) channel.size())];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable unused) {
                    }
                }
            } catch (IOException e) {
                ULog.i("walle", "[stateless] write envelope, e is " + e.getMessage());
                throw e;
            } catch (Throwable unused2) {
            }
        }
        return bArr;
        throw th;
    }

    public static File a(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File file = null;
        try {
            synchronized (c) {
                ULog.i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (!(context == null || context.getApplicationContext() == null)) {
                    String str = context.getApplicationContext().getFilesDir() + File.separator + "stateless";
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            for (File file3 : listFiles) {
                                if (file3 != null && file3.isDirectory() && (listFiles2 = file3.listFiles()) != null && listFiles2.length > 0) {
                                    Arrays.sort(listFiles2, new Comparator<File>() {
                                        /* class com.umeng.commonsdk.stateless.d.AnonymousClass1 */

                                        /* renamed from: a */
                                        public int compare(File file, File file2) {
                                            int i = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
                                            if (i > 0) {
                                                return 1;
                                            }
                                            return i == 0 ? 0 : -1;
                                        }
                                    });
                                    File file4 = listFiles2[0];
                                    if (file4 != null && (file == null || file.lastModified() > file4.lastModified())) {
                                        file = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                ULog.i("walle", "get last envelope end, thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return file;
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (c) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + ".emitter";
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (c) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        if (listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() {
                                /* class com.umeng.commonsdk.stateless.d.AnonymousClass2 */

                                /* renamed from: a */
                                public int compare(File file, File file2) {
                                    int i = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
                                    if (i > 0) {
                                        return 1;
                                    }
                                    return i == 0 ? 0 : -1;
                                }
                            });
                            return listFiles[0];
                        }
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        String str;
        if (context == null) {
            return null;
        }
        if (z) {
            try {
                str = context.getApplicationContext().getFilesDir() + File.separator + "stateless";
            } catch (Throwable unused) {
                return null;
            }
        } else {
            str = context.getApplicationContext().getFilesDir() + File.separator + ".emitter";
        }
        return str;
    }

    public static File[] c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (c) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + ".emitter";
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (c) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        if (listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() {
                                /* class com.umeng.commonsdk.stateless.d.AnonymousClass3 */

                                /* renamed from: a */
                                public int compare(File file, File file2) {
                                    int i = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
                                    if (i > 0) {
                                        return 1;
                                    }
                                    return i == 0 ? 0 : -1;
                                }
                            });
                            return listFiles;
                        }
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static void a(Context context, String str, int i) {
        if (str == null) {
            try {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        } else {
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (c) {
                File[] listFiles = file.listFiles();
                ULog.i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                if (listFiles == null || listFiles.length < i) {
                    ULog.i("AmapLBS", "[lbs-build] file size < max");
                } else {
                    ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i) {
                        Collections.sort(arrayList, new Comparator<File>() {
                            /* class com.umeng.commonsdk.stateless.d.AnonymousClass4 */

                            /* renamed from: a */
                            public int compare(File file, File file2) {
                                if (file == null || file2 == null || file.lastModified() >= file2.lastModified()) {
                                    return (file == null || file2 == null || file.lastModified() != file2.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                            }
                        }
                        for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                            if (arrayList.get(i3) != null) {
                                ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                try {
                                    ((File) arrayList.get(i3)).delete();
                                    arrayList.remove(i3);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        }
    }

    public static void a(Context context, String str, final String str2, int i) {
        if (str != null) {
            try {
                File file = new File(str);
                if (file.isDirectory()) {
                    synchronized (c) {
                        File[] listFiles = file.listFiles(new FilenameFilter() {
                            /* class com.umeng.commonsdk.stateless.d.AnonymousClass5 */

                            @Override // java.io.FilenameFilter
                            public boolean accept(File file, String str) {
                                return str.startsWith(str2);
                            }
                        });
                        if (listFiles == null || listFiles.length < i) {
                            ULog.i("AmapLBS", "[lbs-build] file size < max");
                        } else {
                            ULog.i("AmapLBS", "[lbs-build] file size >= max");
                            ArrayList arrayList = new ArrayList();
                            for (File file2 : listFiles) {
                                if (file2 != null) {
                                    arrayList.add(file2);
                                }
                            }
                            if (arrayList.size() >= i) {
                                Collections.sort(arrayList, new Comparator<File>() {
                                    /* class com.umeng.commonsdk.stateless.d.AnonymousClass6 */

                                    /* renamed from: a */
                                    public int compare(File file, File file2) {
                                        if (file == null || file2 == null || file.lastModified() >= file2.lastModified()) {
                                            return (file == null || file2 == null || file.lastModified() != file2.lastModified()) ? 1 : 0;
                                        }
                                        return -1;
                                    }
                                });
                                if (ULog.DEBUG) {
                                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                        ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                                    }
                                }
                                for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                                    if (arrayList.get(i3) != null) {
                                        ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                        try {
                                            ((File) arrayList.get(i3)).delete();
                                            arrayList.remove(i3);
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            }
                        }
                        ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    public static byte[] a(byte[] bArr) throws IOException {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        a = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    a += deflate;
                    byteArrayOutputStream2.write(bArr2, 0, deflate);
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(b));
        return instance.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(String str) {
        int lastIndexOf;
        int lastIndexOf2;
        if (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (lastIndexOf = str.lastIndexOf("_")) >= 0 && (lastIndexOf2 = str.lastIndexOf(".")) >= 0) {
            return str.substring(lastIndexOf + 1, lastIndexOf2);
        }
        return "";
    }
}
