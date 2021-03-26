package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

public class d {
    private static final Object a = new Object();
    private static d b;
    private CheckUpdateCallBack c;

    public static d a() {
        d dVar;
        synchronized (a) {
            if (b == null) {
                b = new d();
            }
            dVar = b;
        }
        return dVar;
    }

    public void a(int i) {
        CheckUpdateCallBack checkUpdateCallBack = this.c;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onMarketStoreError(i);
        }
    }

    public void a(Intent intent) {
        CheckUpdateCallBack checkUpdateCallBack = this.c;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onMarketInstallInfo(intent);
        }
    }

    public void a(CheckUpdateCallBack checkUpdateCallBack) {
        this.c = checkUpdateCallBack;
    }

    public void b(Intent intent) {
        CheckUpdateCallBack checkUpdateCallBack = this.c;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onUpdateInfo(intent);
        }
    }
}
