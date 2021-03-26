package com.coolapk.market.local;

import android.text.TextUtils;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class AppStore extends Store {
    public static final int ACTION_APP_ADD = 2;
    public static final int ACTION_APP_CHANGED = 1;
    public static final int ACTION_APP_DELETE = 3;
    public static final int ACTION_APP_UPDATE = 4;
    private static final int THRESHOLD = 500;
    private final Object appLock = new Object();
    private final Map<String, MobileApp> appMapping = new HashMap();
    private final DbHelper database;
    private boolean isInit;
    private TimerTask lastTimerTask;
    private final Timer timer = new Timer(true);

    public AppStore(DbHelper dbHelper) {
        this.database = dbHelper;
    }

    private void ensureInit() {
        if (!this.isInit) {
            this.isInit = true;
            synchronized (this.appLock) {
                for (MobileApp mobileApp : this.database.getMobileAppList(1)) {
                    this.appMapping.put(mobileApp.getPackageName(), mobileApp);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r3 != 4) goto L_0x0022;
     */
    @Override // com.coolapk.market.local.Store
    public void handleAction(int i, Object obj) {
        ensureInit();
        synchronized (this.appLock) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        doActionAppDelete((String) obj);
                    }
                }
                doActionAppUpdate((MobileApp) obj);
            } else {
                doActionAppChanged();
            }
        }
    }

    private void doActionAppDelete(String str) {
        this.appMapping.remove(str);
        postChangeEvent(new AppEvent(str));
    }

    private void doActionAppUpdate(MobileApp mobileApp) {
        this.appMapping.put(mobileApp.getPackageName(), mobileApp);
        postChangeEvent(new AppEvent(mobileApp.getPackageName()));
    }

    private void doActionAppChanged() {
        List<MobileApp> mobileAppExistList = DataManager.getInstance().getMobileAppExistList();
        this.appMapping.clear();
        for (MobileApp mobileApp : mobileAppExistList) {
            this.appMapping.put(mobileApp.getPackageName(), mobileApp);
        }
        LogUtils.v("I want to do action app changed", new Object[0]);
        TimerTask timerTask = this.lastTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.timer.purge();
        }
        AnonymousClass1 r0 = new TimerTask() {
            /* class com.coolapk.market.local.AppStore.AnonymousClass1 */

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LogUtils.v("Really to do action app changed", new Object[0]);
                AppStore.this.postChangeEvent(new AppEvent(null));
            }
        };
        this.lastTimerTask = r0;
        this.timer.schedule(r0, 500);
    }

    public MobileApp getMobileApp(String str) {
        ensureInit();
        return this.appMapping.get(str);
    }

    public List<MobileApp> getMobileAppList() {
        ensureInit();
        return getMobileAppList(true);
    }

    public List<MobileApp> getMobileAppList(boolean z) {
        ArrayList arrayList;
        ensureInit();
        synchronized (this.appLock) {
            arrayList = new ArrayList();
            for (MobileApp mobileApp : this.appMapping.values()) {
                if (!mobileApp.isSystemApp() || z) {
                    arrayList.add(mobileApp);
                }
            }
        }
        return arrayList;
    }

    public List<MobileApp> getMobileAppUpgradeList(boolean z) {
        ArrayList arrayList;
        ensureInit();
        synchronized (this.appLock) {
            arrayList = new ArrayList();
            for (MobileApp mobileApp : this.appMapping.values()) {
                if (mobileApp.getUpgradeInfo() != null && !TextUtils.isEmpty(mobileApp.getUpgradeInfo().getApkId()) && mobileApp.getUpgradeInfo().getVersionCode() > mobileApp.getVersionCode()) {
                    if (z) {
                        arrayList.add(mobileApp);
                    } else if (mobileApp.getIgnoreInfo() == null || !mobileApp.getIgnoreInfo().isIgnore()) {
                        arrayList.add(mobileApp);
                    }
                }
            }
        }
        return arrayList;
    }

    public MobileApp getMobileAppUpgrade(String str, boolean z) {
        ensureInit();
        synchronized (this.appLock) {
            MobileApp mobileApp = getMobileApp(str);
            if (mobileApp != null && mobileApp.getUpgradeInfo() != null && !TextUtils.isEmpty(mobileApp.getUpgradeInfo().getApkId()) && mobileApp.getUpgradeInfo().getVersionCode() > mobileApp.getVersionCode()) {
                if (z) {
                    return mobileApp;
                }
                if (mobileApp.getIgnoreInfo() == null || !mobileApp.getIgnoreInfo().isIgnore()) {
                    return mobileApp;
                }
            }
            return null;
        }
    }
}
