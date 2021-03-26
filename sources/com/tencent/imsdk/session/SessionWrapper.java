package com.tencent.imsdk.session;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.tencent.imsdk.log.QLog;
import java.util.List;

public class SessionWrapper {
    private static final String TAG = "SessionWrapper";

    public static boolean isMainProcess(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String packageName = context.getPackageName();
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            String str = TAG;
            QLog.i(str, "isMainProcess get getRunningAppProcesses null");
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null) {
                QLog.i(str, "isMainProcess get getRunningServices null");
                return false;
            }
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.pid == myPid && packageName.equals(runningServiceInfo.service.getPackageName())) {
                    return true;
                }
            }
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && packageName.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }
}
