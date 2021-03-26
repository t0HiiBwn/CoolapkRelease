package com.ali.auth.third.core.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.FailureCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.model.ResultCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class CommonUtils {
    private static String a;
    public static String mAppLabel;
    public static String mAppVersion;

    public static String getAndroidAppVersion() {
        return "android_" + getAppVersion();
    }

    public static String getAndroidId() {
        return Settings.Secure.getString(KernelContext.getApplicationContext().getContentResolver(), "android_id");
    }

    public static String getAppLabel() {
        if (mAppLabel == null) {
            try {
                PackageManager packageManager = KernelContext.getApplicationContext().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(KernelContext.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    mAppVersion = packageInfo.versionName;
                    mAppLabel = "" + ((Object) packageManager.getApplicationLabel(packageInfo.applicationInfo));
                }
            } catch (Exception unused) {
            }
        }
        return mAppLabel;
    }

    public static String getAppVersion() {
        if (mAppVersion == null) {
            try {
                PackageManager packageManager = KernelContext.getApplicationContext().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(KernelContext.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    mAppVersion = packageInfo.versionName;
                    mAppLabel = "" + ((Object) packageManager.getApplicationLabel(packageInfo.applicationInfo));
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return mAppVersion;
    }

    public static String getCurrentProcessName() {
        if (KernelContext.context == null) {
            return null;
        }
        String str = a;
        if (str != null) {
            return str;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) KernelContext.context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    a = runningAppProcessInfo.processName;
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static String getHashString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString(b & 15));
        }
        return sb.toString();
    }

    public static String getLocalIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            Log.e("Error", e.toString());
            return null;
        }
    }

    public static String getSDCardSize() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return "0";
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return Formatter.formatFileSize(KernelContext.getApplicationContext(), ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount()));
    }

    public static String getSystemSize() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return Formatter.formatFileSize(KernelContext.getApplicationContext(), ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount()));
    }

    public static String getTotalMemory() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            for (String str : split) {
                Log.i(readLine, str + "\t");
            }
            j = (long) Integer.valueOf(split[1]).intValue();
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return j + " KB";
    }

    public static boolean isNetworkAvailable() {
        if (KernelContext.context == null) {
            return true;
        }
        return isNetworkAvailable(KernelContext.context);
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING)) {
                return true;
            }
        }
        return false;
    }

    public static void onFailure(final FailureCallback failureCallback, final int i, final String str) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.core.util.CommonUtils.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                FailureCallback failureCallback = failureCallback;
                if (failureCallback != null) {
                    failureCallback.onFailure(i, str);
                }
            }
        });
    }

    public static void onFailure(final FailureCallback failureCallback, final Message message) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.core.util.CommonUtils.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                FailureCallback failureCallback = failureCallback;
                if (failureCallback != null) {
                    failureCallback.onFailure(message.code, message.message);
                }
            }
        });
    }

    public static void onFailure(final FailureCallback failureCallback, final ResultCode resultCode) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.core.util.CommonUtils.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                FailureCallback failureCallback = failureCallback;
                if (failureCallback != null) {
                    failureCallback.onFailure(resultCode.code, resultCode.message);
                }
            }
        });
    }

    public static void sendBroadcast(LoginAction loginAction) {
        Intent intent = new Intent();
        intent.setAction(loginAction.name());
        intent.setPackage(KernelContext.getApplicationContext().getPackageName());
        KernelContext.getApplicationContext().sendBroadcast(intent);
    }

    public static String toString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void toast(final String str) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.core.util.CommonUtils.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(KernelContext.getApplicationContext(), ResourceUtils.getString(str), 0).show();
            }
        });
    }

    public static void toastSystemException() {
        toast("com_taobao_tae_sdk_system_exception");
    }
}
