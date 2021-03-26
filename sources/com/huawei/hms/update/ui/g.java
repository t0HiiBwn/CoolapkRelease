package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: GooglePlayWizard */
public class g extends a {
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2002;
    }

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        if (this.c != null) {
            this.f = 2;
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

    @Override // com.huawei.hms.update.ui.a, com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        super.onBridgeConfigurationChanged();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (this.e && this.b != null) {
            return this.b.onBridgeActivityResult(i, i2, intent);
        }
        if (this.f != 2 || i != getRequestCode()) {
            return false;
        }
        if (a(this.g, this.i)) {
            b(0, this.f);
            return true;
        }
        b(8, this.f);
        return true;
    }

    @Override // com.huawei.hms.update.ui.a
    public void a(b bVar) {
        HMSLog.i("GooglePlayWizard", "Enter onCancel.");
        if (bVar instanceof j) {
            a();
        }
    }

    @Override // com.huawei.hms.update.ui.a
    public void b(b bVar) {
        HMSLog.i("GooglePlayWizard", "Enter onDoWork.");
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
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.g));
            intent.setPackage("com.android.vending");
            b.startActivityForResult(intent, getRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            HMSLog.e("GooglePlayWizard", "can not open google play");
            return false;
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
            HMSLog.i("GooglePlayWizard", "In onKeyUp, Call finish.");
            Activity b = b();
            if (b != null && !b.isFinishing()) {
                b.setResult(0, null);
                b.finish();
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
            HMSLog.e("GooglePlayWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        }
    }
}
