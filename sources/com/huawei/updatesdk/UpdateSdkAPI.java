package com.huawei.updatesdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.a.a.c.b.b;
import com.huawei.updatesdk.service.a.a;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import com.huawei.updatesdk.service.otaupdate.d;
import com.huawei.updatesdk.service.otaupdate.e;
import com.huawei.updatesdk.service.otaupdate.g;
import com.huawei.updatesdk.service.otaupdate.h;
import java.util.List;
import java.util.concurrent.Executors;

public final class UpdateSdkAPI {
    public static final String TAG = "UpdateSdk";

    public static void checkAppUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z, boolean z2) {
        if (context != null) {
            if (b.a(context)) {
                init(context);
                new e(context, new UpdateParams.Builder().setIsShowImmediate(z).setMustBtnOne(z2).build(), checkUpdateCallBack).executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
                return;
            }
            if (checkUpdateCallBack != null) {
                Intent intent = new Intent();
                intent.putExtra("status", 2);
                checkUpdateCallBack.onUpdateInfo(intent);
            }
            Toast.makeText(context, g.b(context, "upsdk_no_available_network_prompt_toast"), 0).show();
        }
    }

    public static void checkAppUpdate(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        if (context != null && updateParams != null && checkUpdateCallBack != null) {
            init(context);
            long currentTimeMillis = System.currentTimeMillis();
            long b = a.a().b();
            if (updateParams.getMinIntervalDay() != 0 && Math.abs(currentTimeMillis - b) < ((long) updateParams.getMinIntervalDay()) * 86400000) {
                return;
            }
            if (b.a(context)) {
                a.a().a(currentTimeMillis);
                new e(context, updateParams, checkUpdateCallBack).executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("status", 2);
            checkUpdateCallBack.onUpdateInfo(intent);
        }
    }

    public static void checkClientOTAUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z, int i, boolean z2) {
        if (context != null && b.a(context)) {
            init(context);
            long currentTimeMillis = System.currentTimeMillis();
            long b = a.a().b();
            if (i == 0 || Math.abs(currentTimeMillis - b) >= ((long) i) * 86400000) {
                a.a().a(currentTimeMillis);
                e eVar = new e(context, new UpdateParams.Builder().setIsShowImmediate(z).setMustBtnOne(z2).setMinIntervalDay(i).build(), checkUpdateCallBack);
                eVar.a(true);
                eVar.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
            }
        }
    }

    public static void checkTargetAppUpdate(Context context, String str, CheckUpdateCallBack checkUpdateCallBack) {
        if (context == null || TextUtils.isEmpty(str) || checkUpdateCallBack == null) {
            if (checkUpdateCallBack != null) {
                Intent intent = new Intent();
                intent.putExtra("status", 1);
                checkUpdateCallBack.onUpdateInfo(intent);
            }
        } else if (b.a(context)) {
            init(context);
            new e(context, new UpdateParams.Builder().setMustBtnOne(false).setTargetPkgName(str).build(), checkUpdateCallBack).executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra("status", 2);
            checkUpdateCallBack.onUpdateInfo(intent2);
        }
    }

    private static void init(Context context) {
        com.huawei.updatesdk.a.b.a.a.a(context);
        Log.i("updatesdk", "UpdateSDK version is: 2.0.6.302 ,flavor: envrelease ,pkgName: " + context.getPackageName());
    }

    public static void releaseCallBack() {
        d.a().a((CheckUpdateCallBack) null);
        List<AsyncTask> a = com.huawei.updatesdk.service.d.a.b.a();
        if (!(a == null || a.isEmpty())) {
            for (AsyncTask asyncTask : a) {
                if (asyncTask != null) {
                    asyncTask.cancel(true);
                }
                Log.d("UpdateSdk", "cancel task");
            }
            a.clear();
        }
    }

    public static void setAppStorePkgName(String str) {
        h.a().c(str);
    }

    public static void setServiceZone(String str) {
        h.a().a(str);
    }

    public static void showUpdateDialog(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z) {
        StringBuilder sb;
        String str;
        if (context != null && apkUpgradeInfo != null) {
            Intent intent = new Intent(context, AppUpdateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("app_update_parm", apkUpgradeInfo);
            bundle.putBoolean("app_must_btn", z);
            intent.putExtras(bundle);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                sb = new StringBuilder();
                sb.append("go AppUpdateActivity error: ");
                str = e.toString();
            } catch (SecurityException e2) {
                sb = new StringBuilder();
                sb.append("go AppUpdateActivity security error: ");
                str = e2.toString();
            }
        } else {
            return;
        }
        sb.append(str);
        Log.e("UpdateSdk", sb.toString());
    }
}
