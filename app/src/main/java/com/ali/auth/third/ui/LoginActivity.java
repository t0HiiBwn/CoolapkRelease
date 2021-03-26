package com.ali.auth.third.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.task.LoginBySsoTokenTask;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.context.CallbackContext;
import java.util.Map;
import org.json.JSONObject;

public class LoginActivity extends Activity {
    public static final String TAG = "login.LoginActivity";
    LinearLayout a;

    protected void auth() {
        int intExtra = getIntent().getIntExtra("login_type", 0);
        if (intExtra == 4) {
            String stringExtra = getIntent().getStringExtra("params");
            Map<String, Object> map = null;
            if (!TextUtils.isEmpty(stringExtra)) {
                map = JSONUtils.toMap(new JSONObject(stringExtra));
            }
            LoginComponent.INSTANCE.goQrCodeLogin(this, map);
        } else if (intExtra != 5) {
            LoginComponent.INSTANCE.showLogin(this);
        } else {
            try {
                new LoginBySsoTokenTask(this, (LoginCallback) CallbackContext.loginCallback).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[]{getIntent().getStringExtra("token")});
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        SDKLogger.d("login.LoginActivity", "onActivityResult requestCode = " + i + " resultCode=" + i2);
        if (!KernelContext.checkServiceValid()) {
            finish();
            return;
        }
        this.a.setClickable(true);
        this.a.setLongClickable(true);
        super.onActivityResult(i, i2, intent);
        if (CallbackContext.activity == null) {
            CallbackContext.setActivity(this);
        }
        CallbackContext.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        this.a = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.a);
        if (KernelContext.context == null) {
            KernelContext.context = getApplicationContext();
        }
        this.a.setOnClickListener(new View.OnClickListener() {
            /* class com.ali.auth.third.ui.LoginActivity.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SDKLogger.e("login.LoginActivity", "click to destroy");
                LoginActivity.this.finish();
                LoginStatus.resetLoginFlag();
            }
        });
        this.a.setClickable(false);
        this.a.setLongClickable(false);
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.d("login.LoginActivity", "static field null");
            LoginStatus.resetLoginFlag();
            finish();
            return;
        }
        CallbackContext.setActivity(this);
        SDKLogger.e("login.LoginActivity", "before mtop call showLogin");
        auth();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        LoginStatus.resetLoginFlag();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!KernelContext.checkServiceValid()) {
            finish();
        }
    }
}
