package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AssistActivity extends Activity {
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
    protected boolean a = false;
    protected Handler b = new Handler() {
        /* class com.tencent.connect.common.AssistActivity.AnonymousClass1 */

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && !AssistActivity.this.isFinishing()) {
                f.d("openSDK_LOG.AssistActivity", "-->finish by timeout");
                AssistActivity.this.finish();
            }
        }
    };
    private boolean c = false;
    private String d;

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, AssistActivity.class);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        String str;
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(3);
        f.b("openSDK_LOG.AssistActivity", "--onCreate--");
        if (getIntent() == null) {
            f.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra("openSDK_LOG.AssistActivity.ExtraIntent");
        if (intent == null) {
            i = 0;
        } else {
            i = intent.getIntExtra("key_request_code", 0);
        }
        if (intent == null) {
            str = "";
        } else {
            str = intent.getStringExtra("appid");
        }
        this.d = str;
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.c = bundle.getBoolean("RESTART_FLAG");
            this.a = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (this.c) {
            f.b("openSDK_LOG.AssistActivity", "is restart");
        } else if (bundleExtra != null) {
            f.d("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
        } else if (intent != null) {
            f.c("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + i);
            startActivityForResult(intent, i);
        } else {
            f.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        f.b("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        f.b("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("is_login", false)) {
            if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.c && !isFinishing()) {
                finish();
            }
            if (this.a) {
                this.b.sendMessage(this.b.obtainMessage(0));
                return;
            }
            this.a = true;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        f.b("openSDK_LOG.AssistActivity", "-->onPause");
        this.b.removeMessages(0);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onStop() {
        f.b("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        f.b("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        f.c("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        intent.putExtra("key_action", "action_share");
        setResult(-1, intent);
        if (!isFinishing()) {
            f.c("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        f.b("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.a);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("--onActivityResult--requestCode: ");
        sb.append(i);
        sb.append(" | resultCode: ");
        sb.append(i2);
        sb.append("data = null ? ");
        sb.append(intent == null);
        f.c("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (intent != null) {
                intent.putExtra("key_action", "action_login");
            }
            setResultData(i, intent);
            finish();
        }
    }

    public void setResultData(int i, Intent intent) {
        if (intent == null) {
            f.d("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i == 11101) {
                d.a().a("", this.d, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("key_response");
            f.b("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("openid");
                String optString2 = jSONObject.optString("access_token");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    f.d("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    d.a().a("", this.d, "2", "1", "7", "1");
                    return;
                }
                f.c("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
                d.a().a(optString, this.d, "2", "1", "7", "0");
                return;
            }
            f.d("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
            setResult(-1, intent);
        } catch (Exception e) {
            f.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
    private void a(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String string = bundle.getString("viaShareType");
        String string2 = bundle.getString("callbackAction");
        String string3 = bundle.getString("url");
        String string4 = bundle.getString("openId");
        String string5 = bundle.getString("appId");
        String str4 = "";
        if ("shareToQQ".equals(string2)) {
            str2 = "ANDROIDQQ.SHARETOQQ.XX";
            str3 = "10";
        } else if ("shareToQzone".equals(string2)) {
            str2 = "ANDROIDQQ.SHARETOQZ.XX";
            str3 = "11";
        } else {
            str = str4;
            if (j.a(this, string3)) {
                IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string2);
                if (listnerWithAction != null) {
                    listnerWithAction.onError(new UiError(-6, "打开浏览器失败!", null));
                }
                d.a().a(string4, string5, str4, str, "3", "1", string, "0", "2", "0");
                finish();
            } else {
                d.a().a(string4, string5, str4, str, "3", "0", string, "0", "2", "0");
            }
            getIntent().removeExtra("shareH5");
        }
        str = str3;
        str4 = str2;
        if (j.a(this, string3)) {
        }
        getIntent().removeExtra("shareH5");
    }
}
