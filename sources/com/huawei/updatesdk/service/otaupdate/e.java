package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.a.b.d.a.d;
import com.huawei.updatesdk.a.b.d.b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.a;
import com.huawei.updatesdk.service.e.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class e extends AsyncTask<Void, Void, d> {
    private Context a;
    private CheckUpdateCallBack b;
    private UpdateParams c;
    private Toast d;
    private boolean e = false;
    private List<String> f = new ArrayList();
    private b g;

    public e(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        this.c = updateParams;
        this.a = context;
        this.b = checkUpdateCallBack;
        h.a().a(updateParams.getServiceZone());
        if (TextUtils.isEmpty(h.a().b())) {
            h.a().c(updateParams.getAppStorePkgName());
        }
    }

    private PackageInfo a(Context context, String str) {
        PackageInfo a2 = c.a(str, context);
        if (a2 != null) {
            return a2;
        }
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = str;
        packageInfo.versionName = "1.0";
        packageInfo.versionCode = 1;
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.targetSdkVersion = 19;
        packageInfo.applicationInfo = applicationInfo;
        return packageInfo;
    }

    private d a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(a(context, str));
        }
        a a2 = a.a(arrayList);
        a2.a(0);
        if (isCancelled()) {
            Log.w("CheckOtaAndUpdataTask", "UpdateSDK task is canceled and return empty upgradeInfo");
            return null;
        }
        b bVar = new b(a2, null);
        this.g = bVar;
        return bVar.a();
    }

    private void a(Context context, ApkUpgradeInfo apkUpgradeInfo) {
        if (context != null) {
            Intent intent = new Intent(context, AppUpdateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("app_update_parm", apkUpgradeInfo);
            bundle.putBoolean("app_must_btn", this.c.isMustBtnOne());
            intent.putExtras(bundle);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                com.huawei.updatesdk.a.a.b.a.a.a.d("CheckOtaAndUpdataTask", "go AppUpdateActivity error: " + e2.toString());
            }
        }
    }

    private void a(List<ApkUpgradeInfo> list) {
        if (!i.a(list)) {
            for (ApkUpgradeInfo apkUpgradeInfo : list) {
                if (apkUpgradeInfo != null && !TextUtils.isEmpty(apkUpgradeInfo.getFullDownUrl_())) {
                    apkUpgradeInfo.setDownurl_(apkUpgradeInfo.getFullDownUrl_());
                }
            }
        }
    }

    private boolean a() {
        return !this.e && TextUtils.isEmpty(this.c.getTargetPkgName()) && i.a(this.c.getPackageList());
    }

    private void b() {
        Toast toast = this.d;
        if (toast != null) {
            toast.cancel();
        }
    }

    private void b(d dVar) {
        if (this.b != null) {
            Intent intent = new Intent();
            intent.putExtra("status", 6);
            if (dVar.d() != null) {
                intent.putExtra("failcause", dVar.d().ordinal());
            }
            intent.putExtra("failreason", dVar.e());
            intent.putExtra("responsecode", dVar.b());
            this.b.onUpdateInfo(intent);
            this.b.onUpdateStoreError(dVar.a());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public d doInBackground(Void... voidArr) {
        com.huawei.updatesdk.a.a.b.a.a.a.a("CheckOtaAndUpdataTask", "CheckOtaAndUpdataTask doInBackground");
        com.huawei.updatesdk.service.d.a.b.a(this);
        if (Build.VERSION.SDK_INT >= 24 || com.huawei.updatesdk.a.a.c.a.b.d() == 0 || c.a(com.huawei.updatesdk.a.b.a.a.a().b()) != c.a.NOT_INSTALLED || c.c()) {
            h.a().a(this.a);
            com.huawei.updatesdk.a.b.d.a.c.a(com.huawei.updatesdk.a.a.c.a.b.a(this.a, g.c(this.a, "upsdk_store_url")));
            String targetPkgName = this.c.getTargetPkgName();
            if (TextUtils.isEmpty(targetPkgName)) {
                targetPkgName = this.a.getPackageName();
            }
            if (!i.a(this.c.getPackageList())) {
                this.f.addAll(this.c.getPackageList());
            } else if (!TextUtils.isEmpty(targetPkgName)) {
                this.f.add(targetPkgName);
            }
            com.huawei.updatesdk.service.a.a.a().a(h.a().c());
            return a(this.a, this.f);
        }
        com.huawei.updatesdk.a.a.b.a.a.a.a("CheckOtaAndUpdataTask", "api <24,HiApp not installed and no permission");
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(d dVar) {
        com.huawei.updatesdk.service.d.a.b.a().remove(this);
        b();
        if (dVar != null) {
            int b2 = dVar.b();
            ArrayList<ApkUpgradeInfo> arrayList = null;
            if (dVar.a() == 0 && dVar.c() == 0) {
                com.huawei.updatesdk.service.appmgr.bean.b bVar = (com.huawei.updatesdk.service.appmgr.bean.b) dVar;
                arrayList = bVar.list_;
                if (!i.a(bVar.notRcmList_)) {
                    ApkUpgradeInfo apkUpgradeInfo = bVar.notRcmList_.get(0);
                    Log.w("CheckOtaAndUpdataTask", "UpdateSDK get update info is not recommend,reason: " + apkUpgradeInfo.getNotRcmReason_() + ",is same signature: " + apkUpgradeInfo.getSameS_());
                }
                a(arrayList);
                if (i.a(arrayList) && this.b != null) {
                    Intent intent = new Intent();
                    intent.putExtra("status", 3);
                    intent.putExtra("responsecode", b2);
                    this.b.onUpdateInfo(intent);
                }
            } else {
                b(dVar);
                com.huawei.updatesdk.a.a.b.a.a.a.d("CheckOtaAndUpdataTask", "get app update msg failed,responseCode is " + dVar.a());
            }
            if (!i.a(arrayList)) {
                ApkUpgradeInfo apkUpgradeInfo2 = arrayList.get(0);
                if (this.b != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("updatesdk_update_info", (Serializable) apkUpgradeInfo2);
                    intent2.putParcelableArrayListExtra("updatesdk_update_info_list", arrayList);
                    intent2.putExtra("status", 7);
                    intent2.putExtra("responsecode", b2);
                    this.b.onUpdateInfo(intent2);
                }
                if (apkUpgradeInfo2 != null) {
                    Log.i("CheckOtaAndUpdataTask", "ApkUpgradeInfo,version = " + apkUpgradeInfo2.getVersion_() + ",versionCode = " + apkUpgradeInfo2.getVersionCode_() + ",detailId = " + apkUpgradeInfo2.getDetailId_() + ",devType = " + apkUpgradeInfo2.getDevType_() + ",oldVersionCode = " + apkUpgradeInfo2.getOldVersionCode_());
                } else {
                    Log.e("CheckOtaAndUpdataTask", "info == null");
                }
                if (this.c.isShowImmediate()) {
                    a(this.a, apkUpgradeInfo2);
                }
            } else if (a()) {
                Context context = this.a;
                Toast.makeText(context, g.b(context, "upsdk_update_check_no_new_version"), 0).show();
            }
        } else if (this.b != null) {
            Intent intent3 = new Intent();
            intent3.putExtra("status", 3);
            this.b.onUpdateInfo(intent3);
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        b bVar = this.g;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        d.a().a(this.b);
        if (a()) {
            Context context = this.a;
            Toast makeText = Toast.makeText(context, g.b(context, "upsdk_checking_update_prompt"), 1);
            this.d = makeText;
            makeText.show();
        }
    }
}
