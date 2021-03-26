package com.ut.mini;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.ut.mini.plugin.UTPluginMgr;
import com.ut.mini.sdkevents.UTMI1010_2001Event;
import java.util.HashMap;
import java.util.Map;

public class UTAnalytics {
    private static UTAnalytics a;
    private boolean M;
    private boolean N;

    /* renamed from: a  reason: collision with other field name */
    private UTTracker f95a;
    private Map<String, UTTracker> w = new HashMap();
    private Map<String, UTTracker> x = new HashMap();

    private UTAnalytics() {
        if (Build.VERSION.SDK_INT < 14) {
            UTMI1010_2001Event uTMI1010_2001Event = new UTMI1010_2001Event();
            UTPluginMgr.getInstance().registerPlugin(uTMI1010_2001Event, false);
            UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event);
            return;
        }
        UTMI1010_2001Event uTMI1010_2001Event2 = new UTMI1010_2001Event();
        UTMCAppStatusRegHelper.registerAppStatusCallbacks(uTMI1010_2001Event2);
        UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event2);
    }

    @Deprecated
    public void setContext(Context context) {
        b.a().setContext(context);
        if (context != null) {
            UTTeamWork.getInstance().initialized();
        }
    }

    @Deprecated
    public void setAppApplicationInstance(Application application) {
        b.a().setAppApplicationInstance(application);
        AppMonitor.init(application);
    }

    public void setAppApplicationInstance(Application application, IUTApplication iUTApplication) {
        try {
            if (!this.M) {
                if (application == null || iUTApplication == null || application.getApplicationContext() == null) {
                    throw new IllegalArgumentException("application and callback must not be null");
                }
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (iUTApplication.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(iUTApplication.getUTChannel());
                getInstance().setAppVersion(iUTApplication.getUTAppVersion());
                getInstance().setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
                this.N = true;
                this.M = true;
            }
        } catch (Throwable unused) {
        }
    }

    public void setAppApplicationInstance4sdk(Application application, IUTApplication iUTApplication) {
        try {
            if (!this.N) {
                if (application == null || iUTApplication == null || application.getApplicationContext() == null) {
                    throw new IllegalArgumentException("application and callback must not be null");
                }
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (iUTApplication.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(iUTApplication.getUTChannel());
                getInstance().setAppVersion(iUTApplication.getUTAppVersion());
                getInstance().setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
                this.N = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized UTAnalytics getInstance() {
        UTAnalytics uTAnalytics;
        synchronized (UTAnalytics.class) {
            if (a == null) {
                a = new UTAnalytics();
            }
            uTAnalytics = a;
        }
        return uTAnalytics;
    }

    public synchronized UTTracker getDefaultTracker() {
        if (this.f95a == null) {
            this.f95a = new UTTracker();
        }
        if (this.f95a == null) {
            i.a("getDefaultTracker error", "Fatal Error,must call setRequestAuthentication method first.");
        }
        return this.f95a;
    }

    @Deprecated
    public void setRequestAuthentication(IUTRequestAuthentication iUTRequestAuthentication) {
        if (iUTRequestAuthentication == null) {
            i.a("setRequestAuthentication", "Fatal Error,pRequestAuth must not be null.");
        }
        if (iUTRequestAuthentication instanceof UTBaseRequestAuthentication) {
            String appkey = iUTRequestAuthentication.getAppkey();
            UTBaseRequestAuthentication uTBaseRequestAuthentication = (UTBaseRequestAuthentication) iUTRequestAuthentication;
            AppMonitor.setRequestAuthInfo(false, appkey, uTBaseRequestAuthentication.getAppSecret(), uTBaseRequestAuthentication.isEncode() ? "1" : "0");
            return;
        }
        AppMonitor.setRequestAuthInfo(true, iUTRequestAuthentication.getAppkey(), null, ((UTSecuritySDKRequestAuthentication) iUTRequestAuthentication).getAuthCode());
    }

    @Deprecated
    public void setAppVersion(String str) {
        b.a().setAppVersion(str);
    }

    public synchronized UTTracker getTracker(String str) {
        if (TextUtils.isEmpty(str)) {
            i.a("getTracker", "TrackId is null.");
            return null;
        } else if (this.w.containsKey(str)) {
            return this.w.get(str);
        } else {
            UTTracker uTTracker = new UTTracker();
            uTTracker.p(str);
            this.w.put(str, uTTracker);
            return uTTracker;
        }
    }

    public synchronized UTTracker getTrackerByAppkey(String str) {
        if (TextUtils.isEmpty(str)) {
            i.a("getTracker", "TrackId is null.");
            return null;
        } else if (this.x.containsKey(str)) {
            return this.x.get(str);
        } else {
            UTTracker uTTracker = new UTTracker();
            uTTracker.q(str);
            this.x.put(str, uTTracker);
            return uTTracker;
        }
    }

    @Deprecated
    public void setChannel(String str) {
        AppMonitor.setChannel(str);
    }

    @Deprecated
    public void turnOnDebug() {
        b.a().turnOnDebug();
    }

    public void updateUserAccount(String str, String str2) {
        b.a().updateUserAccount(str, str2);
    }

    public void userRegister(String str) {
        if (!TextUtils.isEmpty(str)) {
            UTTracker defaultTracker = getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(new UTOriginalCustomHitBuilder("UT", 1006, str, null, null, null).build());
            } else {
                i.a("Record userRegister event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
        } else {
            i.a("userRegister", "Fatal Error,usernick can not be null or empty!");
        }
    }

    public void updateSessionProperties(Map<String, String> map) {
        Map<String, String> a2 = c.a().m23a();
        HashMap hashMap = new HashMap();
        if (a2 != null) {
            hashMap.putAll(a2);
        }
        hashMap.putAll(map);
        c.a().c(hashMap);
    }

    public void turnOffAutoPageTrack() {
        UTPageHitHelper.getInstance().turnOffAutoPageTrack();
    }
}
