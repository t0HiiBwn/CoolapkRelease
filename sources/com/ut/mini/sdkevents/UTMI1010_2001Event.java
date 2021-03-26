package com.ut.mini.sdkevents;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTInterfaceCallDelegate;
import com.ut.mini.UTTracker;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.plugin.UTPlugin;
import java.util.List;
import java.util.Map;

public class UTMI1010_2001Event extends UTPlugin implements UTMCAppStatusCallbacks {
    private long C = 0;
    private long D = 0;
    private long E = 0;

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.ut.mini.plugin.UTPlugin
    public int[] returnRequiredMsgIds() {
        return new int[]{3};
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // com.ut.mini.plugin.UTPlugin
    public void onPluginMsgArrivedFromSDK(int i, Object obj) {
        long j;
        if (i == 3) {
            Map map = (Map) obj;
            if (map.containsKey(LogField.EVENTID.toString()) && "2001".equals((String) map.get(LogField.EVENTID.toString()))) {
                if (map.containsKey(LogField.ARG3.toString())) {
                    try {
                        j = Long.parseLong((String) map.get(LogField.ARG3.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.C += j;
                    if (!m()) {
                        a(this.C);
                        this.C = 0;
                        return;
                    }
                    return;
                }
                j = 0;
                this.C += j;
                if (!m()) {
                }
            }
        }
    }

    private static boolean m() {
        String packageName;
        ActivityManager activityManager;
        ComponentName componentName;
        try {
            Context context = b.a().getContext();
            if (!(context == null || (packageName = context.getPackageName()) == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null)) {
                try {
                    List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                    if (runningTasks != null && runningTasks.size() > 0 && (componentName = runningTasks.get(0).topActivity) != null && packageName.contains(componentName.getPackageName())) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void a(long j) {
        if (!c.a().d()) {
            long j2 = 0;
            if (j > 0) {
                if (0 != this.E) {
                    j2 = SystemClock.elapsedRealtime() - this.E;
                }
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("UT", 1010, "" + j, "" + j2, null, null);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTOriginalCustomHitBuilder.build());
                } else {
                    i.a("Record app display event error", "Fatal Error,must call setRequestAuthentication method first.");
                }
            }
        }
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        a(SystemClock.elapsedRealtime() - this.D);
        this.E = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        this.D = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
        UTInterfaceCallDelegate.pageDisAppearByAuto(activity);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
        UTInterfaceCallDelegate.pageAppearByAuto(activity);
    }
}
