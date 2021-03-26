package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HiappWizard */
public class i extends a {
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2005;
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        if (this.c != null) {
            this.f = 5;
            if (this.c.isNeedConfirm() && !TextUtils.isEmpty(this.h)) {
                a(j.class);
            } else if (d()) {
            } else {
                if (!a(false)) {
                    b(8, this.f);
                } else {
                    a(8, this.f);
                }
            }
        }
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        super.onBridgeActivityDestroy();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (this.e && this.b != null) {
            return this.b.onBridgeActivityResult(i, i2, intent);
        }
        if (this.f != 5 || i != getRequestCode()) {
            return false;
        }
        if (a(this.g, this.i)) {
            b(0, this.f);
            return true;
        }
        b(8, this.f);
        return true;
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        super.onBridgeConfigurationChanged();
    }

    @Override // com.huawei.hms.update.ui.a
    public void a(b bVar) {
        HMSLog.i("HiappWizard", "Enter onCancel.");
        if (bVar instanceof j) {
            a();
        }
    }

    @Override // com.huawei.hms.update.ui.a
    public void b(b bVar) {
        HMSLog.i("HiappWizard", "Enter onDoWork.");
        if (bVar instanceof j) {
            bVar.c();
            if (d()) {
                return;
            }
            if (!a(false)) {
                b(8, this.f);
            } else {
                a(8, this.f);
            }
        }
    }

    private boolean d() {
        Activity b = b();
        if (b == null || b.isFinishing() || TextUtils.isEmpty(this.g)) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.appmarket.intent.action.AppDetail");
            intent.putExtra("APP_PACKAGENAME", this.g);
            if (SystemUtils.isTVDevice()) {
                int packageVersionCode = new PackageManagerHelper(b).getPackageVersionCode("com.hisilicon.android.hiRMService");
                HMSLog.i("HiappWizard", "version " + packageVersionCode);
                if (packageVersionCode == 1) {
                    HMSLog.i("HiappWizard", "startActivity");
                    intent.addFlags(268435456);
                    a(intent);
                    b.startActivity(intent);
                    return true;
                }
            }
            HMSLog.i("HiappWizard", "startActivityForResult");
            a(intent);
            b.startActivityForResult(intent, getRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            HMSLog.e("HiappWizard", "can not open hiapp");
            return false;
        }
    }

    private void a(Intent intent) {
        List<ResolveInfo> queryIntentActivities = b().getPackageManager().queryIntentActivities(intent, 65536);
        if (!(queryIntentActivities == null || queryIntentActivities.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.huawei.appmarket.tv");
            arrayList.add("com.huawei.appmarket.car");
            arrayList.add("com.huawei.appmarket");
            if (queryIntentActivities.size() != 1) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
                        intent.setPackage(resolveInfo.activityInfo.packageName);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.huawei.hms.update.ui.a
    void a(Class<? extends b> cls) {
        c();
        try {
            b bVar = (b) cls.newInstance();
            if (!TextUtils.isEmpty(this.h) && (bVar instanceof j)) {
                this.h = ResourceLoaderUtil.getString("hms_update_title");
                ((j) bVar).a(this.h);
            }
            bVar.a(this);
            this.d = bVar;
        } catch (IllegalAccessException | IllegalStateException | InstantiationException e) {
            HMSLog.e("HiappWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        }
    }

    @Override // com.huawei.hms.update.ui.a
    void a() {
        b(13, this.f);
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        if (this.e && this.b != null) {
            this.b.onKeyUp(i, keyEvent);
        } else if (4 == i) {
            HMSLog.i("HiappWizard", "In onKeyUp, Call finish.");
            Activity b = b();
            if (b != null && !b.isFinishing()) {
                b.setResult(0, null);
                b.finish();
            }
        }
    }
}
