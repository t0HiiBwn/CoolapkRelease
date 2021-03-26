package com.huawei.hms.activity.internal;

import android.content.Intent;

public class BusResponseResult {
    private Intent a;
    private int b;

    public Intent getIntent() {
        return this.a;
    }

    public void setIntent(Intent intent) {
        this.a = intent;
    }

    public int getCode() {
        return this.b;
    }

    public void setCode(int i) {
        this.b = i;
    }
}
