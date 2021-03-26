package com.kepler.jd.sdk;

import android.os.Bundle;

public class KeplerBackActivity extends SuActivity {
    @Override // com.kepler.jd.sdk.SuActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
