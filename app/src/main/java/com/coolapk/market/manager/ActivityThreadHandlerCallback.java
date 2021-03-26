package com.coolapk.market.manager;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ReflectUtils;

public class ActivityThreadHandlerCallback implements Handler.Callback {
    private static final int DESTROY_ACTIVITY = 109;
    private static final int SCHEDULE_CRASH = 134;
    private static final int STOP_ACTIVITY_HIDE = 104;
    private static final int STOP_ACTIVITY_SHOW = 103;
    private ArrayMap mActivities;

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        boolean z = false;
        if (i == 103 || i == 104) {
            try {
                if (this.mActivities == null) {
                    this.mActivities = (ArrayMap) ReflectUtils.wrap(AppHolder.getApplication()).getChildField("mLoadedApk").getChildField("mActivityThread").getChildField("mActivities").get();
                }
                if (this.mActivities.get((IBinder) ReflectUtils.wrap(message.obj).getChildField("arg1").get()) != null) {
                    z = true;
                }
                return !z;
            } catch (Throwable unused) {
            }
        } else {
            if (i == 134) {
                String obj = message.obj == null ? "" : message.obj.toString();
                if (obj.contains("Bad notification")) {
                    return true;
                }
                if (obj.contains("Context.startForegroundService")) {
                    AppHolder.getThirdPartUtils().markException(new RemoteException(obj));
                    return true;
                }
            }
            return false;
        }
    }
}
