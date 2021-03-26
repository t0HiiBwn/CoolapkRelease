package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class BaseApi {
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;
    protected c a;
    protected QQToken b;

    public void releaseResource() {
    }

    public BaseApi(c cVar, QQToken qQToken) {
        this.a = cVar;
        this.b = qQToken;
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    protected Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", "3.3.0.lite");
        bundle.putString("sdkp", "a");
        QQToken qQToken = this.b;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.b.getAccessToken());
            bundle.putString("oauth_consumer_key", this.b.getAppId());
            bundle.putString("openid", this.b.getOpenId());
            bundle.putString("appid_for_getting_config", this.b.getAppId());
        }
        SharedPreferences sharedPreferences = e.a().getSharedPreferences("pfStore", 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
        }
        return bundle;
    }

    protected String a(String str) {
        Bundle a2 = a();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            a2.putString("need_version", str);
        }
        sb.append("http://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.encodeUrl(a2));
        return sb.toString();
    }

    protected Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.b.getAppId());
        if (this.b.isSessionValid()) {
            bundle.putString("keystr", this.b.getAccessToken());
            bundle.putString("keytype", "0x80");
        }
        String openId = this.b.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = e.a().getSharedPreferences("pfStore", 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
            bundle.putString("pf", "openmobile_android");
        }
        bundle.putString("sdkv", "3.3.0.lite");
        bundle.putString("sdkp", "a");
        return bundle;
    }

    private Intent a(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        return intent2;
    }

    protected void a(Activity activity, int i, Intent intent, boolean z) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        activity.startActivityForResult(intent2, i);
    }

    protected void a(Activity activity, Intent intent, int i) {
        intent.putExtra("key_request_code", i);
        activity.startActivityForResult(a(activity, intent), i);
    }

    protected void a(Fragment fragment, Intent intent, int i) {
        intent.putExtra("key_request_code", i);
        fragment.startActivityForResult(a(fragment.getActivity(), intent), i);
    }

    protected boolean a(Intent intent) {
        if (intent != null) {
            return h.a(e.a(), intent);
        }
        return false;
    }

    protected Intent b(String str) {
        Intent intent = new Intent();
        if (j.d(e.a())) {
            intent.setClassName("com.tencent.minihd.qq", str);
            if (h.a(e.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (h.a(e.a(), intent)) {
            return intent;
        }
        intent.setClassName("com.tencent.tim", str);
        if (h.a(e.a(), intent)) {
            return intent;
        }
        return null;
    }

    protected void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new TDialog(activity, "", "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.b).show();
    }

    protected Intent c(String str) {
        Intent intent = new Intent();
        Intent b2 = b(str);
        if (b2 == null || b2.getComponent() == null) {
            return null;
        }
        intent.setClassName(b2.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    /* compiled from: ProGuard */
    public class TempRequestListener implements IRequestListener {
        private final IUiListener b;
        private final Handler c;

        public TempRequestListener(IUiListener iUiListener) {
            this.b = iUiListener;
            this.c = new Handler(e.a().getMainLooper(), BaseApi.this) {
                /* class com.tencent.connect.common.BaseApi.TempRequestListener.AnonymousClass1 */

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = connectTimeoutException.getMessage();
            obtainMessage.what = -7;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.c.sendMessage(obtainMessage);
        }
    }
}
