package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.utils.LogUtil;

public class WbShareResultActivity extends BaseActivity {
    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.i("Share", "startShareResultActivity");
        try {
            Intent intent = getIntent();
            if (intent.getIntExtra("startFlag", -1) == 0) {
                finish();
                return;
            }
            if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY".equals(intent.getAction())) {
                intent.setClass(this, WbShareTransActivity.class);
            } else {
                intent.setClass(this, WbShareToStoryActivity.class);
            }
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
