package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: ProGuard */
public class TBaseLogger {
    protected static volatile ExecutorService a = Executors.newSingleThreadExecutor(new MinPriorityThreadFactory());
    private static boolean b = false;
    private static boolean c = false;
    private static String d = ("tencent" + File.separator + "TPush");
    private static int e = 2;
    private static List<String> f = Collections.synchronizedList(new ArrayList());
    private static boolean g = false;
    private static boolean h = false;
    private static String i = null;
    private static String j = null;
    private static Context k;
    private static DeviceInfo l;
    private static boolean m = false;
    private static LoggerInterface n = new DefaultLogger();

    /* compiled from: ProGuard */
    public interface WriteFileCallback {
        void onFinished();
    }

    public static void setLogger(LoggerInterface loggerInterface) {
        n = loggerInterface;
        m = true;
        loggerInterface.i("TBase - TPush", "set third logger delegate");
    }

    public static void enableDebug(Context context, boolean z) {
        b = z;
        c = z;
        init(context);
    }

    public static void setDebugLevel(int i2) {
        if (i2 >= 2 && i2 <= 6) {
            e = i2;
        }
    }

    public static void init(Context context) {
        if (context != null) {
            if (k == null) {
                k = context.getApplicationContext();
            }
            g = LogUtil.isSDCardMounted(k);
        }
    }

    public static Context getAppContent() {
        return k;
    }

    public static void addThirdLog(int i2, String str, String str2, Throwable th) {
        if (i2 == 2) {
            vv(str, str2, th);
        } else if (i2 == 3) {
            dd(str, str2, th);
        } else if (i2 == 4) {
            ii(str, str2, th);
        } else if (i2 == 5) {
            ww(str, str2, th);
        } else if (i2 != 6) {
            ee(str, "illegal log level: " + str2, th);
        } else {
            ee(str, str2, th);
        }
    }

    public static void v(String str, String str2) {
        if (b && a(2)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.v("TPush", "[" + str + "] " + str2);
            if (c) {
                a("TRACE", str, str2, null);
            }
        }
    }

    public static void vv(String str, String str2) {
        if (a(2)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.v("TPush", "[" + str + "] " + str2);
            a("TRACE", str, str2, null);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (b && a(2)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.v("TPush", "[" + str + "] " + str2, th);
            if (c) {
                a("TRACE", str, str2, th);
            }
        }
    }

    public static void vv(String str, String str2, Throwable th) {
        if (a(2)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.v("TPush", "[" + str + "] " + str2, th);
            a("TRACE", str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (b && a(3)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.d("TPush", "[" + str + "] " + str2);
            if (c) {
                a("DEBUG", str, str2, null);
            }
        }
    }

    public static void dd(String str, String str2) {
        if (a(3)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.d("TPush", "[" + str + "] " + str2);
            a("DEBUG", str, str2, null);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (b && a(3)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.d("TPush", "[" + str + "] " + str2, th);
            if (c) {
                a("DEBUG", str, str2, th);
            }
        }
    }

    public static void dd(String str, String str2, Throwable th) {
        if (a(3)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.d("TPush", "[" + str + "] " + str2, th);
            a("DEBUG", str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (b && a(4)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.i("TPush", "[" + str + "] " + str2);
            if (c) {
                a("INFO", str, str2, null);
            }
        }
    }

    public static void ii(String str, String str2) {
        if (a(4)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.i("TPush", "[" + str + "] " + str2);
            a("INFO", str, str2, null);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (b && a(4)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.i("TPush", "[" + str + "] " + str2, th);
            if (c) {
                a("INFO", str, str2, th);
            }
        }
    }

    public static void ii(String str, String str2, Throwable th) {
        if (a(4)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.i("TPush", "[" + str + "] " + str2, th);
            a("INFO", str, str2, th);
        }
    }

    public static void w(String str, String str2) {
        if (b && a(5)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.w("TPush", "[" + str + "] " + str2);
        }
        a("WARN", str, str2, null);
    }

    public static void ww(String str, String str2) {
        if (a(5)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.w("TPush", "[" + str + "] " + str2);
        }
        a("WARN", str, str2, null);
    }

    public static void w(String str, String str2, Throwable th) {
        if (b && a(5)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.w("TPush", "[" + str + "] " + str2, th);
        }
        a("WARN", str, str2, th);
    }

    public static void ww(String str, String str2, Throwable th) {
        if (a(5)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.w("TPush", "[" + str + "] " + str2, th);
        }
        a("WARN", str, str2, th);
    }

    public static void e(String str, String str2) {
        if (b && a(6)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.e("TPush", "[" + str + "] " + str2);
        }
        a("ERROR", str, str2, null);
    }

    public static void ee(String str, String str2) {
        if (a(6)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.e("TPush", "[" + str + "] " + str2);
        }
        a("ERROR", str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (b && a(6)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.e("TPush", "[" + str + "] " + str2, th);
        }
        a("ERROR", str, str2, th);
    }

    public static void ee(String str, String str2, Throwable th) {
        if (a(6)) {
            LoggerInterface loggerInterface = n;
            loggerInterface.e("TPush", "[" + str + "] " + str2, th);
        }
        a("ERROR", str, str2, th);
    }

    public static String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static boolean isFileEnabled() {
        return c;
    }

    private static boolean a(int i2) {
        return i2 >= e;
    }

    public static synchronized void uploadLogFile(final Context context, final HttpRequestCallback httpRequestCallback) {
        synchronized (TBaseLogger.class) {
            init(context);
            final String f2 = f();
            flush(new WriteFileCallback() {
                /* class com.tencent.tpns.baseapi.base.logger.TBaseLogger.AnonymousClass1 */

                @Override // com.tencent.tpns.baseapi.base.logger.TBaseLogger.WriteFileCallback
                public void onFinished() {
                    LogUploadUtil.uploadFile(context, f2, "Logs", "tmp", httpRequestCallback);
                }
            });
        }
    }

    public static void flush() {
        flush(null);
    }

    public static void flush(WriteFileCallback writeFileCallback) {
        h = true;
        List<String> list = f;
        f = Collections.synchronizedList(new ArrayList());
        if (g) {
            a(list, writeFileCallback);
        }
        h = false;
    }

    public static void removeOldDebugLogFiles(int i2) {
        int i3 = 7;
        try {
            String f2 = f();
            if (!TextUtils.isEmpty(f2)) {
                String str = f2 + File.separator + "Logs";
                File file = new File(str);
                if (file.exists()) {
                    int length = str.length() + 5;
                    int length2 = LogUtil.PATTERN_DATETIME_FILENAME.length() + length;
                    if (file.listFiles() != null && file.listFiles().length > 0) {
                        File[] listFiles = file.listFiles();
                        for (File file2 : listFiles) {
                            try {
                                if (file2.isFile()) {
                                    String absolutePath = file2.getAbsolutePath();
                                    Date parseDateInFilename = LogUtil.parseDateInFilename(absolutePath.substring(length, length2));
                                    if (i2 > 0) {
                                        i3 -= i2;
                                    }
                                    if (LogUtil.isDaysAgo(parseDateInFilename, i3)) {
                                        d("TBase - TPush", "delete logs file " + absolutePath);
                                        file2.delete();
                                    }
                                }
                            } catch (Throwable th) {
                                e("TBase - TPush", "removeOldDebugLogFiles" + th);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            e("TBase - TPush", "removeOldDebugLogFiles", th2);
        }
    }

    private static void a(String str, String str2, String str3, Throwable th) {
        if (!m) {
            if (str2 == null || str2.trim().equals("")) {
                str2 = "TBase - TPush";
            }
            String formatDate = LogUtil.formatDate(new Date(), "MM.dd_HH:mm:ss_SSS");
            if (str3 == null) {
                str3 = "";
            }
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str3), 256);
            String str4 = "[" + str2 + "]";
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    b(((Object) formatDate) + " " + e() + " " + str + " " + str4 + " " + readLine);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                b(((Object) formatDate) + " " + e() + " " + str + stringWriter.toString());
            }
        }
    }

    private static String e() {
        try {
            return Process.myPid() + " " + Thread.currentThread().getId();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b(String str) {
        if (!h) {
            f.add(str);
            if (f.size() == 100) {
                List<String> list = f;
                f = Collections.synchronizedList(new ArrayList());
                boolean isSDCardMounted = LogUtil.isSDCardMounted(k);
                g = isSDCardMounted;
                if (isSDCardMounted) {
                    v("TBase - TPush", "have writable external storage, write log file!");
                    a(list, null);
                    return;
                }
                v("TBase - TPush", "no writable external storage");
            }
        }
    }

    /* access modifiers changed from: private */
    public static String f() {
        String str = i;
        if (str != null) {
            return str;
        }
        try {
            Context context = k;
            if (context != null) {
                i = context.getExternalFilesDir(d).getAbsolutePath();
            }
            return i;
        } catch (Throwable th) {
            w("TBase - TPush", "TLogger ->getFileNamePre:" + th.getMessage());
            return null;
        }
    }

    private static void a(final List<String> list, final WriteFileCallback writeFileCallback) {
        try {
            a.execute(new Runnable() {
                /* class com.tencent.tpns.baseapi.base.logger.TBaseLogger.AnonymousClass2 */

                /* JADX WARNING: Removed duplicated region for block: B:47:0x016c  */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x0178  */
                /* JADX WARNING: Removed duplicated region for block: B:53:0x017c  */
                @Override // java.lang.Runnable
                public void run() {
                    WriteFileCallback writeFileCallback;
                    Throwable th;
                    BufferedWriter bufferedWriter = null;
                    try {
                        String f = TBaseLogger.f();
                        if (TextUtils.isEmpty(f)) {
                            WriteFileCallback writeFileCallback2 = writeFileCallback;
                            if (writeFileCallback2 != null) {
                                writeFileCallback2.onFinished();
                            }
                            try {
                                list.clear();
                                return;
                            } catch (Throwable th2) {
                                TBaseLogger.e("TBase - TPush", "close file stream error", th2);
                                return;
                            }
                        } else {
                            String str = f + File.separator + "Logs" + File.separator + "log";
                            String str2 = TBaseLogger.j;
                            if (TextUtils.isEmpty(str2)) {
                                str2 = str + "-" + LogUtil.getTodayDateTimeForFilename() + ".txt";
                            }
                            File file = new File(str2);
                            file.getParentFile().mkdirs();
                            if (file.exists() && file.length() > 1048576) {
                                TBaseLogger.v("TBase - TPush", "length:" + file.length() + ", max size:1048576");
                                str2 = str + "-" + LogUtil.getTodayDateTimeForFilename() + ".txt";
                                file = new File(str2);
                            }
                            TBaseLogger.v("TBase - TPush", "Write log file: " + str2);
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str2, true));
                            try {
                                if (file.length() == 0) {
                                    if (TBaseLogger.l == null && TBaseLogger.k != null) {
                                        DeviceInfo unused = TBaseLogger.l = new DeviceInfo(TBaseLogger.k);
                                    }
                                    if (TBaseLogger.l != null) {
                                        bufferedWriter2.write(TBaseLogger.l.toString() + "\n");
                                    }
                                }
                                Iterator it2 = list.iterator();
                                while (it2.hasNext()) {
                                    bufferedWriter2.write(((String) it2.next()) + "\n");
                                }
                                String unused2 = TBaseLogger.j = str2;
                                try {
                                    list.clear();
                                    bufferedWriter2.close();
                                } catch (Throwable th3) {
                                    TBaseLogger.e("TBase - TPush", "close file stream error", th3);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedWriter = bufferedWriter2;
                                try {
                                    TBaseLogger.i("TBase - TPush", "write logs to file error", th);
                                    list.clear();
                                    if (bufferedWriter != null) {
                                        bufferedWriter.close();
                                    }
                                    writeFileCallback = writeFileCallback;
                                    if (writeFileCallback != null) {
                                    }
                                } catch (Throwable th5) {
                                    TBaseLogger.e("TBase - TPush", "close file stream error", th5);
                                }
                            }
                            writeFileCallback = writeFileCallback;
                            if (writeFileCallback != null) {
                                writeFileCallback.onFinished();
                                return;
                            } else {
                                TBaseLogger.removeOldDebugLogFiles(0);
                                return;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        TBaseLogger.i("TBase - TPush", "write logs to file error", th);
                        list.clear();
                        if (bufferedWriter != null) {
                        }
                        writeFileCallback = writeFileCallback;
                        if (writeFileCallback != null) {
                        }
                    }
                    throw th;
                }
            });
        } catch (Throwable th) {
            e("TBase - TPush", "savelog error", th);
        }
    }

    /* compiled from: ProGuard */
    private static class MinPriorityThreadFactory implements ThreadFactory {
        private MinPriorityThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(10);
            return thread;
        }
    }
}
