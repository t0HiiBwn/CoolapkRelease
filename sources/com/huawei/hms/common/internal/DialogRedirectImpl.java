package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

public class DialogRedirectImpl extends DialogRedirect {
    private final Activity a;
    private final int b;
    private final Intent c;

    DialogRedirectImpl(Intent intent, Activity activity, int i) {
        this.c = intent;
        this.a = activity;
        this.b = i;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Intent intent = this.c;
        if (intent != null) {
            this.a.startActivityForResult(intent, this.b);
        }
    }
}
