package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static String mDefaultEnvelopeDir = "envelope";
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static Object mEnvelopeFileLock = new Object();
    private static String sCurrentProcessName = "";

    public static String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it2.next();
                        if (next.pid == myPid) {
                            sCurrentProcessName = next.processName;
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context.getApplicationContext(), th);
            }
        }
        return sCurrentProcessName;
    }

    public static String getSubProcessName(Context context) {
        String str = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(":");
            if (indexOf >= 0) {
                str = currentProcessName.substring(indexOf + 1);
            }
            if (indexOf < 0) {
                String packageName = context.getPackageName();
                if (currentProcessName.length() > packageName.length()) {
                    return currentProcessName.substring(packageName.length() + 1, currentProcessName.length());
                }
                return currentProcessName;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
        }
        return str;
    }

    private static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(applicationContext, th);
                return false;
            }
        } else {
            try {
                if (applicationContext.getPackageManager().checkPermission(str, applicationContext.getPackageName()) != 0) {
                    return false;
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(applicationContext, th2);
                return false;
            }
        }
        return true;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return false;
        }
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    if (file.isDirectory() && (list = file.list()) != null) {
                        return list.length;
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return 0;
    }

    private static long getDistanceDays(long j, long j2) {
        return (j < j2 ? j2 - j : j - j2) / 86400000;
    }

    public static void removeRedundantEnvelopeFiles(Context context, int i) {
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                if (listFiles.length > i) {
                    Arrays.sort(listFiles, new Comparator<File>() {
                        /* class com.umeng.commonsdk.framework.UMFrUtils.AnonymousClass1 */

                        /* renamed from: a */
                        public int compare(File file, File file2) {
                            int i = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
                            if (i > 0) {
                                return 1;
                            }
                            return i == 0 ? 0 : -1;
                        }
                    });
                    if (listFiles.length > i) {
                        for (int i2 = 0; i2 < listFiles.length - i; i2++) {
                            try {
                                if (!listFiles[i2].delete()) {
                                    ULog.d("--->>> remove [" + i2 + "] file fail.");
                                }
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                        }
                    }
                }
            }
        }
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                if (listFiles.length != 0) {
                    Arrays.sort(listFiles, new Comparator<File>() {
                        /* class com.umeng.commonsdk.framework.UMFrUtils.AnonymousClass2 */

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

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        if (context != null) {
            try {
                String legacyEnvelopeDir = getLegacyEnvelopeDir(context);
                if (!TextUtils.isEmpty(legacyEnvelopeDir) && !legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            try {
                                if (file.isDirectory()) {
                                    file.delete();
                                }
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                        } else {
                            try {
                                String envelopeDirPath = getEnvelopeDirPath(context);
                                for (int i = 0; i < listFiles.length; i++) {
                                    File file2 = listFiles[i];
                                    file2.renameTo(new File(envelopeDirPath + File.separator + listFiles[i].getName()));
                                }
                                if (file.isDirectory()) {
                                    file.delete();
                                }
                            } catch (Throwable th2) {
                                UMCrashManager.reportCrash(context, th2);
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                UMCrashManager.reportCrash(context, th3);
            }
        }
    }

    public static String getLegacyEnvelopeDir(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                ULog.d("--->>> getEnvelopeDir: can't get process name, use default envelope directory.");
                return mDefaultEnvelopeDir;
            } else if (runningAppProcesses.size() == 0) {
                return mDefaultEnvelopeDir;
            } else {
                try {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == Process.myPid()) {
                            String replace = runningAppProcessInfo.processName.replace(':', '_');
                            ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                            return replace;
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
        return mDefaultEnvelopeDir;
    }

    public static String getEnvelopeDirPath(Context context) {
        String str;
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + "." + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.d("--->>> Create Envelope Directory failed!!!");
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
            str = mDefaultEnvelopeDirPath;
        }
        return str;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong("last_successful_build_time", 0);
        }
        return j;
    }

    public static long getLastInstantBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong("last_instant_build_time", 0);
        }
        return j;
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong("last_successful_build_time", System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong("last_instant_build_time", System.currentTimeMillis()).commit();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c A[SYNTHETIC, Splitter:B:28:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068 A[SYNTHETIC, Splitter:B:35:0x0068] */
    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        Throwable th;
        IOException e;
        if (bArr == null) {
            return 101;
        }
        File file = new File(getEnvelopeDirPath(context) + File.separator + str);
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.close();
                    boolean a = a.a(context).a(str);
                    boolean b = a.a(context).b(str);
                    if (a) {
                        updateLastSuccessfulBuildTime(context);
                    }
                    if (b) {
                        updateLastInstantBuildTime(context);
                    }
                    return 0;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        UMCrashManager.reportCrash(context, e);
                        if (fileOutputStream != null) {
                        }
                        return 101;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                UMCrashManager.reportCrash(context, th3);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                UMCrashManager.reportCrash(context, e);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th5) {
                        UMCrashManager.reportCrash(context, th5);
                    }
                }
                return 101;
            }
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        return file.delete();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(appContext, th);
                }
            }
            return true;
        }
    }

    public static byte[] toByteArray(String str) throws IOException {
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            FileChannel fileChannel = null;
            try {
                FileChannel channel = new RandomAccessFile(str, "r").getChannel();
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size()).load();
                bArr = new byte[((int) channel.size())];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    channel.close();
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(appContext, th);
                }
            } catch (IOException e) {
                UMCrashManager.reportCrash(appContext, e);
                throw e;
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(appContext, th2);
            }
        }
        return bArr;
        throw th;
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        String str = "a";
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL) {
            str = "i";
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = "z";
        }
        String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath == null) {
            return false;
        }
        File file = new File(envelopeDirPath);
        synchronized (mEnvelopeFileLock) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length != 0) {
                        for (File file2 : listFiles) {
                            if (file2.getName().startsWith(str)) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return false;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    }
}
