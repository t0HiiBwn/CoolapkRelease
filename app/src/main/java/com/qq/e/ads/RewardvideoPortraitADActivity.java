package com.qq.e.ads;

import android.os.Bundle;

public class RewardvideoPortraitADActivity extends ADActivity {
    @Override // com.qq.e.ads.ADActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
    }
}
