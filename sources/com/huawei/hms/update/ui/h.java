package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: HiappWebWizard */
public class h extends a {
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2004;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        if (this.c != null) {
            this.f = 4;
            if (this.c.isNeedConfirm() && !TextUtils.isEmpty(this.h)) {
                a(j.class);
            } else if (!d()) {
                b(8, this.f);
            }
        }
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        super.onBridgeActivityDestroy();
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        super.onBridgeConfigurationChanged();
    }

    @Override // com.huawei.hms.update.ui.a
    public void a(b bVar) {
        HMSLog.d("HiappWebWizard", "Enter onCancel.");
        if (bVar instanceof j) {
            a();
        }
    }

    @Override // com.huawei.hms.update.ui.a
    public void b(b bVar) {
        HMSLog.d("HiappWebWizard", "Enter onDoWork.");
        if (bVar instanceof j) {
            bVar.c();
            if (!d()) {
                b(8, this.f);
            }
        }
    }

    private boolean d() {
        Activity b = b();
        if (b == null || b.isFinishing() || this.c == null || TextUtils.isEmpty(this.j)) {
            return false;
        }
        try {
            ResourceLoaderUtil.setmContext(b);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ResourceLoaderUtil.getString("hms_base_vmall") + this.j));
            intent.setFlags(268435456);
            b.startActivityForResult(intent, getRequestCode());
            a(0, this.f);
            return true;
        } catch (ActivityNotFoundException unused) {
            HMSLog.e("HiappWebWizard", "can not find web to hold update hms apk");
            return false;
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
            HMSLog.e("HiappWebWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        }
    }

    @Override // com.huawei.hms.update.ui.a
    void a() {
        b(13, this.f);
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        if (4 == i) {
            HMSLog.i("HiappWebWizard", "In onKeyUp, Call finish.");
            Activity b = b();
            if (b != null && !b.isFinishing()) {
                b.setResult(0, null);
                b.finish();
            }
        }
    }
}
