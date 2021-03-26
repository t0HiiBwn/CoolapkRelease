package com.coolapk.market.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.WifiEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.SystemUtils;
import org.greenrobot.eventbus.EventBus;

public class ConnectivityReceiver extends BroadcastReceiver {
    public static final String ACTION_CHECK_FOR_NETWORK_STATE = "com.coolapk.market.CHECK_FOR_NETWORK_STATE";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        if (intent != null) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.net.conn.CONNECTIVITY_CHANGE") || action.equals("com.coolapk.market.CHECK_FOR_NETWORK_STATE")) {
                LogUtils.v("Start check for network state", new Object[0]);
                Boolean isWifiAvailableNullable = AppHolder.getAppSetting().isWifiAvailableNullable();
                boolean isWifiAvailable = SystemUtils.isWifiAvailable(context);
                AppHolder.getAppSetting().setWifiAvailable(isWifiAvailable);
                boolean z2 = isWifiAvailableNullable == null;
                EventBus eventBus = EventBus.getDefault();
                if (z2) {
                    z = false;
                } else {
                    z = isWifiAvailableNullable.booleanValue();
                }
                eventBus.post(new WifiEvent(z2, z, isWifiAvailable));
                if (z2) {
                    saveLog(context, z2, isWifiAvailableNullable, isWifiAvailable);
                } else if (!isWifiAvailableNullable.booleanValue() && isWifiAvailable) {
                    LogUtils.v("Change to wifi, start download which we stop before", new Object[0]);
                    saveLog(context, z2, isWifiAvailableNullable, isWifiAvailable);
                    for (DownloadState downloadState : DataManager.getInstance().getDownloadStateList()) {
                        if (downloadState.getExtra() != null && downloadState.getExtra().getBoolean("IS_WIFI_RESTART")) {
                            ActionManager.startDownload(context, downloadState.getUrl(), downloadState.getExtra(), 0);
                        }
                    }
                } else if (isWifiAvailableNullable.booleanValue() && !isWifiAvailable) {
                    LogUtils.v("Change to mobile network, stop all download", new Object[0]);
                    saveLog(context, z2, isWifiAvailableNullable, isWifiAvailable);
                    for (DownloadState downloadState2 : DataManager.getInstance().getDownloadStateList()) {
                        if (downloadState2.isRunning()) {
                            ActionManager.stopDownload(context, downloadState2.getUrl(), 4);
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0040: APUT  (r2v1 java.lang.Object[]), (4 ??[int, float, short, byte, char]), (r8v1 java.lang.Object) */
    private void saveLog(Context context, boolean z, Boolean bool, boolean z2) {
        NetworkInfo networkInfo;
        Exception exc;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            exc = null;
        } catch (Exception e) {
            exc = e;
            networkInfo = null;
        }
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = networkType(bool);
        objArr[2] = networkType(Boolean.valueOf(z2));
        objArr[3] = networkInfo;
        Object obj = "unknown";
        objArr[4] = networkInfo != null ? Boolean.valueOf(networkInfo.isConnectedOrConnecting()) : obj;
        if (networkInfo != null) {
            obj = Integer.valueOf(networkInfo.getType());
        }
        objArr[5] = obj;
        String format = String.format("First init: %s, prev: %s, current: %s\nnetworkInfo: %s\nisConnectedOrConnecting: %s, type: %s", objArr);
        DataManager instance = DataManager.getInstance();
        if (exc != null) {
            str = exc.getMessage();
        }
        instance.saveLog("network_state", format, str);
    }

    private String networkType(Boolean bool) {
        if (bool == null) {
            return "null";
        }
        return bool.booleanValue() ? "wifi" : "mobile";
    }

    public void register(Context context) {
        DataManager.getInstance().saveLog("network_state", "Register connectivity", null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.coolapk.market.CHECK_FOR_NETWORK_STATE");
        LocalBroadcastManager.getInstance(context).registerReceiver(this, intentFilter2);
    }

    public void unregister(Context context) {
        DataManager.getInstance().saveLog("network_state", "Unregister connectivity", null);
        context.unregisterReceiver(this);
        LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
    }
}
