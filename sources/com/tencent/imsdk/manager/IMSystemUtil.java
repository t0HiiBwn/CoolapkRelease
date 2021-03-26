package com.tencent.imsdk.manager;

import android.os.AsyncTask;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;

public class IMSystemUtil {
    private static final String TAG = "TIMSystemUtil";
    private static long lastMemCheckTimeStamps = 0;
    private static int lastMemUsage = 0;
    private static boolean mFirstTimeRun = true;
    private static CpuUsageMeasurer sCpuUsageMeasurer;
    private static boolean sRunningMemCheck;

    public static class ExperimentalAPI {
        private static boolean sIsSoLoaded;

        public static boolean loadLibrary(String str) {
            try {
                if (sIsSoLoaded) {
                    Log.i("TIMSystemUtil", "library loaded");
                    return true;
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        System.load(str);
                        sIsSoLoaded = true;
                        Log.i("TIMSystemUtil", "system load so library succ: " + str);
                        return true;
                    } catch (UnsatisfiedLinkError e) {
                        sIsSoLoaded = false;
                        Log.e("TIMSystemUtil", "load custom library failed: " + str, e);
                    } catch (Exception e2) {
                        sIsSoLoaded = false;
                        Log.e("TIMSystemUtil", "load custom library failed: " + str, e2);
                    }
                }
                if (!TextUtils.isEmpty(str) && sIsSoLoaded) {
                    return false;
                }
                System.loadLibrary("ImSDK");
                sIsSoLoaded = true;
                Log.i("TIMSystemUtil", "system load so library succ, libImSDK.so");
                return true;
            } catch (UnsatisfiedLinkError e3) {
                sIsSoLoaded = false;
                Log.e("TIMSystemUtil", "system load so library failed, libImSDK.so", e3);
                return false;
            }
        }
    }

    static float getAppCpuUsage() {
        return ((float) (getProcessCPURate()[0] / 10)) / 100.0f;
    }

    static float getSysCpuUsage() {
        return ((float) (getProcessCPURate()[1] / 10)) / 100.0f;
    }

    static int[] getProcessCPURate() {
        if (sCpuUsageMeasurer == null) {
            sCpuUsageMeasurer = new CpuUsageMeasurer();
        }
        if (!mFirstTimeRun) {
            return sCpuUsageMeasurer.getCpuUsage();
        }
        mFirstTimeRun = false;
        sCpuUsageMeasurer.getCpuUsage();
        return new int[]{0, 0};
    }

    static float getAppMemory() {
        int i;
        if (sRunningMemCheck || (lastMemCheckTimeStamps != 0 && NativeManager.nativeGetTimeTick() - lastMemCheckTimeStamps < 15000)) {
            i = lastMemUsage;
        } else {
            sRunningMemCheck = true;
            AsyncTask.execute(new Runnable() {
                /* class com.tencent.imsdk.manager.IMSystemUtil.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    boolean unused = IMSystemUtil.sRunningMemCheck = false;
                    try {
                        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                        Debug.getMemoryInfo(memoryInfo);
                        int totalPss = memoryInfo.getTotalPss();
                        long unused2 = IMSystemUtil.lastMemCheckTimeStamps = NativeManager.nativeGetTimeTick();
                        int unused3 = IMSystemUtil.lastMemUsage = totalPss / 1024;
                    } catch (Exception unused4) {
                    }
                }
            });
            i = lastMemUsage;
        }
        return (float) i;
    }
}
