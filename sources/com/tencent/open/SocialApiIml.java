package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.c.b;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class SocialApiIml extends BaseApi {
    private Activity c;

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public SocialApiIml(c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, "action_gift", bundle, iUiListener);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, "action_ask", bundle, iUiListener);
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c2 = c("com.tencent.open.agent.SocialFriendChooser");
        if (c2 == null) {
            f.c("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            c2 = c("com.tencent.open.agent.RequestFreegiftActivity");
        }
        bundle.putAll(b());
        if ("action_ask".equals(str)) {
            bundle.putString("type", "request");
        } else if ("action_gift".equals(str)) {
            bundle.putString("type", "freegift");
        }
        a(activity, c2, str, bundle, g.a().a(e.a(), "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c2 = c("com.tencent.open.agent.SocialFriendChooser");
        if (c2 == null) {
            f.c("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            c2 = c("com.tencent.open.agent.AppInvitationActivity");
        }
        bundle.putAll(b());
        a(activity, c2, "action_invite", bundle, g.a().a(e.a(), "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c2 = c("com.tencent.open.agent.SendStoryActivity");
        bundle.putAll(b());
        a(activity, c2, "action_story", bundle, g.a().a(e.a(), "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        boolean z2 = true;
        sb.append(intent == null);
        f.c("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        com.tencent.open.utils.f a2 = com.tencent.open.utils.f.a(e.a(), this.b.getAppId());
        if (!z && !a2.b("C_LoginH5")) {
            z2 = false;
        }
        if (z2) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra("key_action", str);
        intent.putExtra("key_params", bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(11105, iUiListener);
        a(activity, intent, 11105);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent b = b("com.tencent.open.agent.AgentActivity");
        a aVar = new a(activity, iUiListener, str, str2, bundle);
        Intent b2 = b("com.tencent.open.agent.EncryTokenActivity");
        if (b2 == null || b == null || b.getComponent() == null || b2.getComponent() == null || !b.getComponent().getPackageName().equals(b2.getComponent().getPackageName())) {
            f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
            String f = j.f("tencent&sdk&qazxc***14969%%" + this.b.getAccessToken() + this.b.getAppId() + this.b.getOpenId() + "qzone3.4");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("encry_token", f);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aVar.onComplete(jSONObject);
            return;
        }
        b2.putExtra("oauth_consumer_key", this.b.getAppId());
        b2.putExtra("openid", this.b.getOpenId());
        b2.putExtra("access_token", this.b.getAccessToken());
        b2.putExtra("key_action", "action_check_token");
        if (a(b2)) {
            f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
            UIListenerManager.getInstance().setListenerWithRequestcode(11106, aVar);
            a(activity, b2, 11106);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        f.a("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.b.getAppId());
        if (this.b.isSessionValid()) {
            bundle.putString("access_token", this.b.getAccessToken());
        }
        String openId = this.b.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString("pf", e.a().getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
        } catch (Exception e) {
            e.printStackTrace();
            bundle.putString("pf", "openmobile_android");
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if ("action_challenge".equals(str) || "action_brag".equals(str)) {
            f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new c(this.c, str, str3, iUiListener, this.b).show();
            return;
        }
        new TDialog(this.c, str, str3, iUiListener, this.b).show();
    }

    /* compiled from: ProGuard */
    private class a implements IUiListener {
        private IUiListener b;
        private String c;
        private String d;
        private Bundle e;
        private Activity f;

        a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.b = iUiListener;
            this.c = str;
            this.d = str2;
            this.e = bundle;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString("encry_token");
            } catch (JSONException e2) {
                e2.printStackTrace();
                f.b("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e2);
                str = null;
            }
            this.e.putString("encrytoken", str);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a((Context) socialApiIml.c, this.c, this.e, this.d, this.b);
            if (TextUtils.isEmpty(str)) {
                f.b("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            f.b("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.b.onError(uiError);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            this.b.onCancel();
        }
    }

    public void writeEncryToken(Context context) {
        String str;
        String accessToken = this.b.getAccessToken();
        String appId = this.b.getAppId();
        String openId = this.b.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            str = j.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        b bVar = new b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        String a2 = g.a().a(context, "http://qzs.qq.com");
        bVar.loadDataWithBaseURL(a2, "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.b.getOpenId() + "_" + this.b.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>", "text/html", "utf-8", a2);
    }

    @Override // com.tencent.connect.common.BaseApi
    protected Intent b(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.qzone", str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        Intent intent3 = new Intent();
        intent3.setClassName("com.tencent.minihd.qq", str);
        if (j.d(e.a()) && h.a(e.a(), intent3)) {
            return intent3;
        }
        if (h.a(e.a(), intent2) && h.c(e.a(), "4.7") >= 0) {
            return intent2;
        }
        if (!h.a(e.a(), intent) || h.a(h.a(e.a(), "com.qzone"), "4.2") < 0) {
            return null;
        }
        if (h.a(e.a(), intent.getComponent().getPackageName(), "ec96e9ac1149251acbb1b0c5777cae95")) {
            return intent;
        }
        return null;
    }
}
