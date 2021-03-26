package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public class AvailableAdapter {
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static int d = 0;
    private final int a;
    private AvailableCallBack b;
    private SystemObserver e = new SystemObserver() {
        /* class com.huawei.hms.adapter.AvailableAdapter.AnonymousClass1 */

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent intent, String str) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i) {
            AvailableCallBack c = AvailableAdapter.this.c();
            if (c == null) {
                HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            c.onComplete(i);
            int unused = AvailableAdapter.d = i;
            HMSLog.i("AvailableAdapter", "user response " + AvailableAdapter.d);
            AvailableAdapter.c.set(false);
            return true;
        }
    };

    public interface AvailableCallBack {
        void onComplete(int i);
    }

    public boolean isUserResolvableError(int i) {
        return i == 1 || i == 2;
    }

    public AvailableAdapter(int i) {
        this.a = i;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        if (Build.VERSION.SDK_INT < 16) {
            HMSLog.i("AvailableAdapter", "HMS can not be supported under android 4.1");
            return 21;
        }
        HMSPackageManager instance = HMSPackageManager.getInstance(context);
        PackageManagerHelper.PackageStates hMSPackageStates = instance.getHMSPackageStates();
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStates)) {
            HMSLog.i("AvailableAdapter", "HMS is not installed");
            return 1;
        } else if (PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStates)) {
            HMSLog.i("AvailableAdapter", "HMS is disabled");
            return 3;
        } else if (!instance.isApkUpdateNecessary(this.a)) {
            return 0;
        } else {
            HMSLog.i("AvailableAdapter", "The current version does not meet the minimum version requirements");
            return 2;
        }
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        boolean z;
        int i = 0;
        if (HMSPackageManager.getInstance(activity).getHmsVersionCode() >= 40000000) {
            HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
            z = true;
        } else {
            z = false;
        }
        if (c.compareAndSet(false, true)) {
            HMSLog.i("AvailableAdapter", "Start to resolution for the 1st time.");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            HMSLog.i("AvailableAdapter", "main thread invokes resolution.");
        } else {
            HMSLog.i("AvailableAdapter", "Another thread start to resolution.");
            while (c.get()) {
                if (i >= 300) {
                    HMSLog.i("AvailableAdapter", "Previous popup is not handled by user or download has not finished within 1min.");
                    if (availableCallBack != null) {
                        availableCallBack.onComplete(27);
                        return;
                    }
                    return;
                }
                try {
                    HMSLog.d("AvailableAdapter", "Concurrent startResolution thread is waiting.");
                    Thread.sleep(200);
                    i++;
                } catch (InterruptedException unused) {
                    HMSLog.d("AvailableAdapter", "Concurrent startResolution thread waiting is interrupted.");
                }
            }
            HMSLog.i("AvailableAdapter", "Concurrent startResolution thread waiting finished.");
            if (availableCallBack != null) {
                availableCallBack.onComplete(d);
                return;
            }
            return;
        }
        HMSLog.i("AvailableAdapter", "startResolution");
        if (activity != null && availableCallBack != null) {
            this.b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.e);
            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
            intentStartBridgeActivity.putExtra("update_version", this.a);
            intentStartBridgeActivity.putExtra("new_update", z);
            activity.startActivity(intentStartBridgeActivity);
        }
    }

    /* access modifiers changed from: private */
    public AvailableCallBack c() {
        return this.b;
    }
}
