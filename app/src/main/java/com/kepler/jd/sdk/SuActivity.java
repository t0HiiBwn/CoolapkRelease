package com.kepler.jd.sdk;

import android.app.Activity;
import android.os.Bundle;

public class SuActivity extends Activity {
    protected Activity a;
    protected boolean b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (!this.b) {
            this.a = this;
            super.onCreate(bundle);
        }
    }
}
