package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.a.a.d;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.update.ui.e;
import com.huawei.hms.update.ui.k;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.File;
import java.io.Serializable;

/* compiled from: UpdateWizard */
public class m extends a implements b {
    private a k;
    private c l;
    private int m = 0;

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2006;
    }

    private static Uri a(Context context, File file) {
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        String packageName = context.getPackageName();
        String str = packageName + ".hms.update.provider";
        boolean z = true;
        if (Build.VERSION.SDK_INT <= 23 || (context.getApplicationInfo().targetSdkVersion <= 23 && !packageManagerHelper.hasProvider(packageName, str))) {
            z = false;
        }
        if (z) {
            return UpdateProvider.getUriForFile(context, str, file);
        }
        return Uri.fromFile(file);
    }

    private static void a(final b bVar, final int i, final c cVar) {
        if (bVar != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.huawei.hms.update.ui.m.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    bVar.a(i, cVar);
                }
            });
        }
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        if (this.c != null) {
            this.f = 6;
            if (a(activity)) {
                if (!this.c.isNeedConfirm() || TextUtils.isEmpty(this.h)) {
                    a(d.class);
                    a(this);
                    return;
                }
                a(j.class);
            }
        }
    }

    private boolean a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).isApkUpdateNecessary(this.c.c())) {
            return true;
        }
        c();
        SystemManager.getInstance().notifyUpdateResult(0);
        return false;
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        g();
        super.onBridgeActivityDestroy();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (this.e && this.b != null) {
            return this.b.onBridgeActivityResult(i, i2, intent);
        }
        if (this.f != 6 || i != getRequestCode()) {
            return false;
        }
        if (a(this.g, this.i)) {
            b(0, this.f);
            return true;
        }
        e();
        return true;
    }

    @Override // com.huawei.hms.update.a.a.b
    public void a(int i, c cVar) {
        HMSLog.i("UpdateWizard", "Enter onCheckUpdate, status: " + d.a(i));
        if (i != 1000) {
            switch (i) {
                case 1201:
                case 1202:
                case 1203:
                    a(k.b.class);
                    return;
                default:
                    a(k.b.class);
                    return;
            }
        } else {
            this.l = cVar;
            d();
        }
    }

    private void d() {
        Activity b = b();
        String netType = b != null ? SystemUtils.getNetType(b.getBaseContext()) : "";
        HMSLog.i("UpdateWizard", "current network is " + netType);
        if ("WIFI".equals(netType)) {
            a(f.class);
            f();
            HMSLog.i("UpdateWizard", "current network is wifi");
            return;
        }
        a(e.b.class);
        HMSLog.i("UpdateWizard", "current network is not wifi");
    }

    @Override // com.huawei.hms.update.a.a.b
    public void a(int i, int i2, int i3, File file) {
        HMSLog.i("UpdateWizard", "Enter onDownloadPackage, status: " + d.a(i) + ", reveived: " + i2 + ", total: " + i3);
        if (i == 2000) {
            c();
            if (file == null) {
                e();
            } else if (FileUtil.verifyHash(this.l.e, file)) {
                a(file);
            } else {
                HMSLog.i("UpdateWizard", "Hash value mismatch for download file");
            }
        } else if (i != 2100) {
            switch (i) {
                case 2201:
                    a(k.c.class);
                    return;
                case 2202:
                    a(e.c.class);
                    return;
                case 2203:
                case 2204:
                    a(k.d.class);
                    return;
                default:
                    return;
            }
        } else if (this.d != null && (this.d instanceof f)) {
            int i4 = 0;
            if (i2 >= 0 && i3 > 0) {
                i4 = (int) ((((long) i2) * 100) / ((long) i3));
            }
            this.m = i4;
            ((f) this.d).b(i4);
        }
    }

    private void a(File file) {
        Activity b = b();
        if (b != null && !b.isFinishing()) {
            Uri a = a(b, file);
            if (a == null) {
                HMSLog.e("UpdateWizard", "In startInstaller, Failed to creates a Uri from a file.");
                e();
            } else if (a(b)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(a, "application/vnd.android.package-archive");
                intent.setFlags(3);
                intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                try {
                    b.startActivityForResult(intent, getRequestCode());
                } catch (ActivityNotFoundException e) {
                    HMSLog.e("UpdateWizard", "In startInstaller, Failed to start package installer." + e.getMessage());
                    e();
                }
            }
        }
    }

    @Override // com.huawei.hms.update.ui.a
    public void a(b bVar) {
        HMSLog.i("UpdateWizard", "Enter onCancel.");
        if (bVar instanceof j) {
            a();
        } else if (bVar instanceof d) {
            g();
            a();
        } else if (bVar instanceof f) {
            g();
            a(e.d.class);
        } else if (bVar instanceof e.d) {
            a(f.class);
            f();
        } else if (bVar instanceof e.c) {
            a();
        } else if (bVar instanceof e.b) {
            a();
        } else {
            e();
        }
    }

    @Override // com.huawei.hms.update.ui.a
    public void b(b bVar) {
        HMSLog.i("UpdateWizard", "Enter onDoWork.");
        if (bVar instanceof j) {
            bVar.c();
            a(d.class);
            a(this);
        } else if (bVar instanceof e.d) {
            bVar.c();
            a();
        } else if (bVar instanceof e.c) {
            a(f.class);
            f();
        } else if (bVar instanceof e.b) {
            a(f.class);
            f();
        } else if (bVar instanceof k.b) {
            e();
        } else if (bVar instanceof k.c) {
            e();
        } else if (bVar instanceof k.d) {
            e();
        }
    }

    private void e() {
        if (!a(false)) {
            b(8, this.f);
        } else {
            a(8, this.f);
        }
    }

    @Override // com.huawei.hms.update.ui.a
    void a(Class<? extends b> cls) {
        if (a(b())) {
            c();
            try {
                b bVar = (b) cls.newInstance();
                if (!TextUtils.isEmpty(this.h) && (bVar instanceof j)) {
                    this.h = ResourceLoaderUtil.getString("hms_update_title");
                    ((j) bVar).a(this.h);
                }
                int i = this.m;
                if (i > 0 && (bVar instanceof f)) {
                    ((f) bVar).a(i);
                }
                bVar.a(this);
                this.d = bVar;
            } catch (IllegalAccessException | IllegalStateException | InstantiationException e) {
                HMSLog.e("UpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
            }
        }
    }

    @Override // com.huawei.hms.update.ui.a
    void a() {
        b(13, this.f);
    }

    private void a(final b bVar) {
        if (bVar != null) {
            Activity b = b();
            if (b == null || b.isFinishing()) {
                a(bVar, 1201, (c) null);
            } else if (a(b)) {
                UpdateSdkAPI.checkTargetAppUpdate(b, this.c.b(), new CheckUpdateCallBack() {
                    /* class com.huawei.hms.update.ui.m.AnonymousClass2 */

                    @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
                    public void onMarketInstallInfo(Intent intent) {
                    }

                    @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
                    public void onUpdateInfo(Intent intent) {
                        if (intent != null) {
                            m.this.a(intent, bVar);
                        }
                    }

                    @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
                    public void onMarketStoreError(int i) {
                        HMSLog.e("UpdateWizard", "onMarketStoreError responseCode: " + i);
                    }

                    @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
                    public void onUpdateStoreError(int i) {
                        HMSLog.e("UpdateWizard", "onUpdateStoreError responseCode: " + i);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Intent intent, b bVar) {
        try {
            int intExtra = intent.getIntExtra("status", -99);
            HMSLog.i("UpdateWizard", "CheckUpdateCallBack status is " + intExtra);
            String stringExtra = intent.getStringExtra("failreason");
            if (!TextUtils.isEmpty(stringExtra)) {
                HMSLog.e("UpdateWizard", "checkTargetAppUpdate reason is " + stringExtra);
            }
            if (intExtra == 7) {
                Serializable serializableExtra = intent.getSerializableExtra("updatesdk_update_info");
                if (serializableExtra instanceof ApkUpgradeInfo) {
                    ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) serializableExtra;
                    String package_ = apkUpgradeInfo.getPackage_();
                    int versionCode_ = apkUpgradeInfo.getVersionCode_();
                    String downurl_ = apkUpgradeInfo.getDownurl_();
                    int size_ = apkUpgradeInfo.getSize_();
                    String sha256_ = apkUpgradeInfo.getSha256_();
                    if (TextUtils.isEmpty(package_) || !package_.equals(this.c.b())) {
                        a(bVar, 1201, (c) null);
                    } else if (versionCode_ < this.c.c()) {
                        HMSLog.e("UpdateWizard", "CheckUpdateCallBack versionCode is " + versionCode_ + "bean.getClientVersionCode() is " + this.c.c());
                        a(bVar, 1203, (c) null);
                    } else if (TextUtils.isEmpty(downurl_) || TextUtils.isEmpty(sha256_)) {
                        a(bVar, 1201, (c) null);
                    } else {
                        a(bVar, 1000, new c(package_, versionCode_, downurl_, size_, sha256_));
                    }
                }
            } else if (intExtra == 3) {
                a(bVar, 1202, (c) null);
            } else {
                a(bVar, 1201, (c) null);
            }
        } catch (Exception e) {
            HMSLog.e("UpdateWizard", "intent has some error" + e.getMessage());
            a(bVar, 1201, (c) null);
        }
    }

    private void f() {
        Activity b = b();
        if (b == null || b.isFinishing()) {
            a(k.c.class);
        } else if (a(b)) {
            g();
            com.huawei.hms.update.a.c cVar = new com.huawei.hms.update.a.c(new com.huawei.hms.update.a.d(b));
            this.k = cVar;
            cVar.a(this, this.l);
        }
    }

    private void g() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a();
            this.k = null;
        }
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        if (this.e && this.b != null) {
            this.b.onKeyUp(i, keyEvent);
        } else if (4 == i) {
            HMSLog.i("UpdateWizard", "In onKeyUp, Call finish.");
            Activity b = b();
            if (b != null && !b.isFinishing()) {
                b.setResult(0, null);
                b.finish();
            }
        }
    }
}
