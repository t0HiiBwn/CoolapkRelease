package mtopsdk.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Character;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.TBSdkLog;
import org.json.JSONObject;

public final class MtopUtils {
    public static final int MTOP_BIZID = 4099;
    private static AtomicInteger a = new AtomicInteger();
    public static final List<String> apiWhiteList = Collections.singletonList("mtop.common.gettimestamp$*");
    private static volatile Context b;
    private static volatile String c;
    private static final char[] d = {'E', 'T', 'A', 'O', 'I', 'N', 'S', 'R', 'H', 'L', 'D', 'C', 'U', 'M', 'F', 'P', 'G', 'W', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z'};
    private static final char[] e = {'e', 't', 'a', 'o', 'i', 'n', 's', 'r', 'h', 'l', 'd', 'c', 'u', 'm', 'f', 'p', 'g', 'w', 'y', 'b', 'v', 'k', 'x', 'j', 'q', 'z'};
    private static final char[] f = {'8', '6', '1', '5', '9', '2', '3', '0', '4', '7'};

    public static long convertTimeFormatGMT2Long(String str) {
        if (StringUtils.isBlank(str)) {
            return -1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception unused) {
            TBSdkLog.e("mtopsdk.MtopUtils", "[convertTimeFormatGMT2Long]parse gmt timeformat error");
        }
        if (date != null) {
            return date.getTime() / 1000;
        }
        return -1;
    }

    public static int createIntSeqNo() {
        return a.incrementAndGet() & Integer.MAX_VALUE;
    }

    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean isApkDebug(Context context) {
        if (context == null) {
            context = getContext();
        }
        if (context == null) {
            TBSdkLog.e("mtopsdk.MtopUtils", "[isApkDebug] context is null!");
            return false;
        }
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    public static String urlDecode(String str, String str2) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (Exception e2) {
            TBSdkLog.e("mtopsdk.MtopUtils", "[urlDecode] URLDecoder decode error. input=" + str + ", charset= " + str2, e2);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (r2 == null) goto L_0x0049;
     */
    public static Serializable readObject(File file, String str) {
        Serializable serializable;
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        ObjectInputStream objectInputStream;
        try {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file2);
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                serializable = (Serializable) objectInputStream.readObject();
            } catch (Throwable th3) {
                th2 = th3;
                serializable = null;
                th = th2;
                try {
                    TBSdkLog.w("mtopsdk.MtopUtils", String.format("readObject error.fileDir={%s},fileName={%s}", file, str), th);
                } catch (Throwable th4) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th4;
                }
            }
            try {
                objectInputStream.close();
            } catch (Throwable th5) {
                th = th5;
                TBSdkLog.w("mtopsdk.MtopUtils", String.format("readObject error.fileDir={%s},fileName={%s}", file, str), th);
            }
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return serializable;
        } catch (Throwable th6) {
            th2 = th6;
            fileInputStream = null;
            serializable = null;
            th = th2;
            TBSdkLog.w("mtopsdk.MtopUtils", String.format("readObject error.fileDir={%s},fileName={%s}", file, str), th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a A[SYNTHETIC, Splitter:B:22:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public static boolean writeObject(Serializable serializable, File file, String str) {
        File file2;
        Throwable th;
        FileOutputStream fileOutputStream;
        boolean z = true;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            file2 = new File(file, str + new Random().nextInt(10));
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                try {
                    TBSdkLog.w("mtopsdk.MtopUtils", String.format("writeObject error.fileDir={%s},fileName={%s},object={%s}", file, str, serializable), th);
                    z = false;
                    if (!z) {
                    }
                } finally {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                }
            }
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
                objectOutputStream.writeObject(serializable);
                objectOutputStream.flush();
                objectOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                TBSdkLog.w("mtopsdk.MtopUtils", String.format("writeObject error.fileDir={%s},fileName={%s},object={%s}", file, str, serializable), th);
                z = false;
                if (!z) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            file2 = null;
            TBSdkLog.w("mtopsdk.MtopUtils", String.format("writeObject error.fileDir={%s},fileName={%s},object={%s}", file, str, serializable), th);
            z = false;
            if (!z) {
            }
        }
        return !z ? file2.renameTo(new File(file, str)) : z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        if (r5 == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0065, code lost:
        if (r5 == null) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0047 A[SYNTHETIC, Splitter:B:28:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0060 A[SYNTHETIC, Splitter:B:37:0x0060] */
    public static byte[] readFile(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        byte[] bArr = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException unused) {
                byteArrayOutputStream = null;
                TBSdkLog.w("mtopsdk.MtopUtils", String.format("readFile error.filePath={%s} is not found.", str));
                if (byteArrayOutputStream != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                try {
                    TBSdkLog.w("mtopsdk.MtopUtils", String.format("readFile error.filePath={%s}", str), th);
                    if (byteArrayOutputStream != null) {
                    }
                } catch (Throwable th3) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
            } catch (FileNotFoundException unused5) {
                TBSdkLog.w("mtopsdk.MtopUtils", String.format("readFile error.filePath={%s} is not found.", str));
                if (byteArrayOutputStream != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                TBSdkLog.w("mtopsdk.MtopUtils", String.format("readFile error.filePath={%s}", str), th);
                if (byteArrayOutputStream != null) {
                }
            }
        } catch (FileNotFoundException unused6) {
            byteArrayOutputStream = null;
            fileInputStream = null;
            TBSdkLog.w("mtopsdk.MtopUtils", String.format("readFile error.filePath={%s} is not found.", str));
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused7) {
                }
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            fileInputStream = null;
            TBSdkLog.w("mtopsdk.MtopUtils", String.format("readFile error.filePath={%s}", str), th);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused8) {
                }
            }
        }
        try {
            fileInputStream.close();
        } catch (IOException unused9) {
        }
        return bArr;
    }

    public static String convertUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("//")) {
                str = "http:" + str;
            }
            try {
                int indexOf = str.indexOf("?");
                if (indexOf != -1) {
                    return str.substring(0, indexOf);
                }
                int indexOf2 = str.indexOf("#");
                return indexOf2 != -1 ? str.substring(0, indexOf2) : str;
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static Context getContext() {
        if (b == null) {
            synchronized (MtopUtils.class) {
                if (b == null) {
                    try {
                        Class<?> cls = Class.forName("android.app.ActivityThread");
                        Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                        b = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        TBSdkLog.e("mtopsdk.MtopUtils", "getContext through reflection error.");
                    }
                }
            }
        }
        return b;
    }

    public static String getCurrentProcessName(Context context) {
        if (context == null) {
            return c;
        }
        if (c == null) {
            synchronized (MtopUtils.class) {
                if (c == null) {
                    try {
                        int myPid = Process.myPid();
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it2.next();
                                if (next.pid == myPid) {
                                    c = next.processName;
                                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                        TBSdkLog.i("mtopsdk.MtopUtils", "get current processName succeed,processName=" + c);
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        TBSdkLog.e("mtopsdk.MtopUtils", "get current processName failed.", e2);
                    }
                }
            }
        }
        return c;
    }

    public static boolean isAppOpenMock(Context context) {
        if (context == null) {
            context = getContext();
        }
        if (context == null) {
            TBSdkLog.e("mtopsdk.MtopUtils", "[isAppOpenMock] context is null!");
            return false;
        }
        try {
            byte[] readFile = readFile(context.getFilesDir().getCanonicalPath() + "/mock/openMock.json");
            if (readFile != null) {
                try {
                    return new JSONObject(new String(readFile)).getBoolean("openMock");
                } catch (Exception e2) {
                    TBSdkLog.e("mtopsdk.MtopUtils", "[isAppOpenMock]parse openMock flag error in isOpenMock.json .", e2);
                }
            }
            return false;
        } catch (IOException e3) {
            TBSdkLog.e("mtopsdk.MtopUtils", "[isAppOpenMock] parse ExternalFilesDir/mock/openMock.json filePath error.", e3);
            return false;
        }
    }

    public static String caesarEncrypt(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                charAt = d[charAt - 'A'];
            } else if (charAt >= 'a' && charAt <= 'z') {
                charAt = e[charAt - 'a'];
            } else if (charAt >= '0' && charAt <= '9') {
                charAt = f[charAt - '0'];
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static final boolean isContainChineseCharacter(String str) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            try {
                Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
                if (of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                    return true;
                }
            } catch (Throwable unused) {
                if (c2 >= 19968 && c2 <= 40959) {
                    return true;
                }
            }
        }
        return false;
    }
}
