package com.qq.e.comm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.qq.e.comm.managers.GDTADManager;
import java.util.List;

public final class SystemUtil {
    public static String buildNewPathByProcessName(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        String processName = GDTADManager.getInstance().getProcessName();
        if (StringUtil.isEmpty(processName)) {
            return str;
        }
        String str2 = "_";
        boolean endsWith = processName.endsWith(str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (endsWith) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(Md5Util.encode(processName));
        return sb.toString();
    }

    public static String getProcessName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            try {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
