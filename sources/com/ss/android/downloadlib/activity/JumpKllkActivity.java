package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.h.h;
import com.ss.android.socialbase.appdownloader.c;

public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void a() {
        if (getIntent() == null) {
            c.a((Activity) this);
        }
        String stringExtra = getIntent().getStringExtra("p");
        long longExtra = getIntent().getLongExtra("id", 0);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            c.a((Activity) this);
        }
        boolean z = false;
        int optInt = k.i().optInt("ab", 0);
        if (optInt == 1) {
            z = true;
        }
        h.a(this, stringExtra, longExtra, z);
        if (optInt != 1) {
            c.a((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        c.a((Activity) this);
    }
}
