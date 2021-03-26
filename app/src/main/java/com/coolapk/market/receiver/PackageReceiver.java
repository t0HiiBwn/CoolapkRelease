package com.coolapk.market.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.coolapk.market.util.LogUtils;

public abstract class PackageReceiver extends BroadcastReceiver {
    public abstract void onPackageAdded(Context context, Intent intent, String str);

    public abstract void onPackageRemoved(Context context, Intent intent, String str);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        String schemeSpecificPart;
        if (intent != null && (action = intent.getAction()) != null) {
            Uri data = intent.getData();
            action.hashCode();
            char c = 65535;
            switch (action.hashCode()) {
                case -810471698:
                    if (action.equals("android.intent.action.PACKAGE_REPLACED")) {
                        c = 0;
                        break;
                    }
                    break;
                case 525384130:
                    if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1544582882:
                    if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (data != null && TextUtils.equals("package", data.getScheme())) {
                        LogUtils.v("应用(%s)已更新成功", data.getSchemeSpecificPart());
                        return;
                    }
                    return;
                case 1:
                    if (data != null && TextUtils.equals("package", data.getScheme()) && (schemeSpecificPart = data.getSchemeSpecificPart()) != null) {
                        PackageInfo packageInfo = null;
                        try {
                            packageInfo = context.getPackageManager().getPackageInfo(schemeSpecificPart, 8192);
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if (packageInfo == null) {
                            LogUtils.v("应用(%s)已删除成功", schemeSpecificPart);
                            onPackageRemoved(context, intent, schemeSpecificPart);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (data != null && TextUtils.equals("package", data.getScheme())) {
                        String schemeSpecificPart2 = data.getSchemeSpecificPart();
                        LogUtils.v("应用(%s)已安装成功", schemeSpecificPart2);
                        onPackageAdded(context, intent, schemeSpecificPart2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void register(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(this, intentFilter);
    }

    public void unregister(Context context) {
        context.unregisterReceiver(this);
    }
}
