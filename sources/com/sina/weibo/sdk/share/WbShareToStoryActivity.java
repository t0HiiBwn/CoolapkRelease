package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;

public class WbShareToStoryActivity extends BaseActivity {
    private String callbackActivity;
    private View progressBar;
    private int progressColor = -1;
    private int progressId = -1;
    private FrameLayout rootLayout;
    private SaveFileTask saveFileTask;

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            if (bundle != null) {
                try {
                    this.callbackActivity = bundle.getString("startActivity");
                } catch (Exception unused) {
                }
            } else {
                this.callbackActivity = intent.getStringExtra("startActivity");
            }
            if (intent.getIntExtra("startFlag", -1) != 0) {
                finish();
            } else if (TextUtils.isEmpty(this.callbackActivity)) {
                finish();
            } else {
                StoryMessage storyMessage = null;
                try {
                    storyMessage = (StoryMessage) getIntent().getParcelableExtra("_weibo_message_stroy");
                } catch (Exception unused2) {
                }
                if (storyMessage == null) {
                    setCallbackActivity(2);
                } else if (checkInfo(storyMessage)) {
                    initView();
                    gotoSave(storyMessage);
                } else {
                    setCallbackActivity(2);
                }
            }
        }
    }

    private void initView() {
        try {
            this.progressColor = getIntent().getIntExtra("progressColor", -1);
            this.progressId = getIntent().getIntExtra("progressId", -1);
        } catch (Exception unused) {
        }
        this.rootLayout = new FrameLayout(this);
        if (this.progressId != -1) {
            try {
                this.progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(this.progressId, (ViewGroup) null);
            } catch (Exception unused2) {
                this.progressBar = new WbSdkProgressBar(this);
            }
        } else {
            WbSdkProgressBar wbSdkProgressBar = new WbSdkProgressBar(this);
            this.progressBar = wbSdkProgressBar;
            int i = this.progressColor;
            if (i != -1) {
                wbSdkProgressBar.setProgressColor(i);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.rootLayout.addView(this.progressBar, layoutParams);
        this.rootLayout.setBackgroundColor(855638016);
        setContentView(this.rootLayout);
    }

    private boolean checkInfo(StoryMessage storyMessage) {
        return storyMessage.checkSource() && WbSdk.supportMultiImage(this);
    }

    private void gotoSave(StoryMessage storyMessage) {
        SaveFileTask saveFileTask2 = this.saveFileTask;
        if (saveFileTask2 != null) {
            saveFileTask2.cancel(true);
        }
        SaveFileTask saveFileTask3 = new SaveFileTask(this, new TransResourceCallback() {
            /* class com.sina.weibo.sdk.share.WbShareToStoryActivity.AnonymousClass1 */

            @Override // com.sina.weibo.sdk.share.TransResourceCallback
            public void onTransFinish(TransResourceResult transResourceResult) {
            }

            @Override // com.sina.weibo.sdk.share.TransResourceCallback
            public void onTransFinish(StoryObject storyObject) {
                if (storyObject != null) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
                        intent.setPackage(intent.getStringExtra("startPackage"));
                        intent.putExtra("storyData", storyObject);
                        WbShareToStoryActivity.this.startActivity(intent);
                    } catch (Exception unused) {
                        WbShareToStoryActivity.this.setCallbackActivity(2);
                    }
                } else {
                    WbShareToStoryActivity.this.setCallbackActivity(2);
                }
            }
        });
        this.saveFileTask = saveFileTask3;
        saveFileTask3.execute(storyMessage);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        int i;
        super.onNewIntent(intent);
        try {
            i = intent.getIntExtra("backType", 0);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            setCallbackActivity(1);
        } else {
            setCallbackActivity(0);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("startActivity", this.callbackActivity);
    }

    /* access modifiers changed from: private */
    public void setCallbackActivity(int i) {
        FrameLayout frameLayout = this.rootLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("_weibo_resp_errcode", i);
            setResult(-1, intent);
        } catch (Exception e) {
            LogUtil.v("weibo sdk", e.toString());
        }
        finish();
    }
}
