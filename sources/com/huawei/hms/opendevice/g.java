package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* compiled from: AutoInitRunnable */
public class g implements Runnable {
    private Context a;

    public g(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String token = HmsInstanceId.getInstance(this.a).getToken(Util.getAppId(this.a), "HCM");
            if (!TextUtils.isEmpty(token)) {
                HMSLog.i("AutoInit", "Push init succeed");
                try {
                    ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
                    if (applicationInfo.metaData == null || applicationInfo.metaData.getString("com.huawei.hms.client.service.name:push") == null) {
                        HMSLog.i("AutoInit", "push kit sdk not exists");
                        return;
                    }
                    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.a.getPackageName());
                    Bundle bundle = new Bundle();
                    bundle.putString("message_type", "new_token");
                    bundle.putString("device_token", token);
                    if (!new h().a(this.a, bundle, intent)) {
                        HMSLog.e("AutoInit", "start service failed");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    HMSLog.i("AutoInit", "push kit sdk not exists");
                }
            }
        } catch (Exception e) {
            HMSLog.e("AutoInit", "Push init failed", e);
        }
    }
}
