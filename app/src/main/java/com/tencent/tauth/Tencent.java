package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.Fragment;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.SocialOperation;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    private static Tencent b;
    private final c a;

    public void releaseResource() {
    }

    private Tencent(String str, Context context) {
        this.a = c.a(str, context);
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            e.a(context.getApplicationContext());
            f.c("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            Tencent tencent = b;
            if (tencent == null) {
                b = new Tencent(str, context);
            } else if (!str.equals(tencent.getAppId())) {
                b.logout(context);
                b = new Tencent(str, context);
            }
            if (!a(context, str)) {
                return null;
            }
            com.tencent.open.utils.f.a(context, str);
            f.c("openSDK_LOG.Tencent", "createInstance()  -- end");
            return b;
        }
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                f.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            f.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.a.a(activity, str, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.a.a(fragment, str, iUiListener, "");
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        c cVar = this.a;
        return cVar.a(activity, str + ",server_side", iUiListener);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        c cVar = this.a;
        return cVar.a(fragment, str + ",server_side", iUiListener, "");
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        f.c("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        return this.a.a(activity, str, iUiListener, str2, str3, str4);
    }

    public void logout(Context context) {
        f.c("openSDK_LOG.Tencent", "logout()");
        this.a.b().setAccessToken(null, "0");
        this.a.b().setOpenId(null);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        return this.a.b(activity, str, iUiListener);
    }

    public void reportDAU() {
        this.a.a();
    }

    public void checkLogin(IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "checkLogin()");
        this.a.a(iUiListener);
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "invite()");
        new SocialApi(this.a.b()).invite(activity, bundle, iUiListener);
        return 0;
    }

    public int story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "story()");
        new SocialApi(this.a.b()).story(activity, bundle, iUiListener);
        return 0;
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "gift()");
        new SocialApi(this.a.b()).gift(activity, bundle, iUiListener);
        return 0;
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "ask()");
        new SocialApi(this.a.b()).ask(activity, bundle, iUiListener);
        return 0;
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener, Object obj) {
        f.c("openSDK_LOG.Tencent", "requestAsync()");
        HttpUtils.requestAsync(this.a.b(), e.a(), str, bundle, str2, iRequestListener);
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        f.c("openSDK_LOG.Tencent", "request()");
        return HttpUtils.request(this.a.b(), e.a(), str, bundle, str2);
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQQ()");
        new QQShare(activity, this.a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQzone()");
        new QzoneShare(activity, this.a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "publishToQzone()");
        new QzonePublish(activity, this.a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        f.c("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public static boolean onActivityResultData(int i, int i2, Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i);
        sb.append(", resultcode = ");
        sb.append(i2);
        sb.append(", data = null ? ");
        boolean z = true;
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        if (iUiListener != null) {
            z = false;
        }
        sb.append(z);
        f.c("openSDK_LOG.Tencent", sb.toString());
        return UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
    }

    public boolean isSessionValid() {
        return this.a.c();
    }

    public String getAppId() {
        return this.a.b().getAppId();
    }

    public String getAccessToken() {
        return this.a.b().getAccessToken();
    }

    public long getExpiresIn() {
        return this.a.b().getExpireTimeInSecond();
    }

    public String getOpenId() {
        return this.a.b().getOpenId();
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        boolean z = true;
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        if (iUiListener != null) {
            z = false;
        }
        sb.append(z);
        f.c("openSDK_LOG.Tencent", sb.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        boolean z = true;
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        if (iUiListener != null) {
            z = false;
        }
        sb.append(z);
        f.c("openSDK_LOG.Tencent", sb.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void setAccessToken(String str, String str2) {
        f.a("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        this.a.a(str, str2);
    }

    public void setOpenId(String str) {
        f.a("openSDK_LOG.Tencent", "setOpenId() --start");
        this.a.a(e.a(), str);
        f.a("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public boolean isReady() {
        return isSessionValid() && getOpenId() != null;
    }

    public QQToken getQQToken() {
        return this.a.b();
    }

    public boolean isSupportSSOLogin(Activity activity) {
        if ((!j.d(activity) || h.a(activity, "com.tencent.minihd.qq") == null) && h.c(activity, "4.1") < 0 && h.d(activity, "1.1") < 0) {
            return false;
        }
        return true;
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        new SocialOperation(getQQToken()).makeFriend(activity, bundle);
    }

    public void bindQQGroup(Activity activity, Bundle bundle) {
        new SocialOperation(getQQToken()).bindQQGroup(activity, bundle);
    }

    public boolean joinQQGroup(Activity activity, String str) {
        f.c("openSDK_LOG.Tencent", "joinQQGroup()");
        Intent intent = new Intent();
        String openId = this.a.b().getOpenId();
        String appId = this.a.b().getAppId();
        StringBuffer stringBuffer = new StringBuffer("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str);
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&openid=" + Base64.encodeToString(j.i(openId), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&appid=" + appId);
        }
        intent.setData(Uri.parse(stringBuffer.toString()));
        try {
            activity.startActivity(intent);
            d.a().a(this.a.b().getOpenId(), this.a.b().getAppId(), "ANDROIDQQ.JOININGROUP.XX", "13", "18", "0");
            return true;
        } catch (Exception unused) {
            d.a().a(this.a.b().getOpenId(), this.a.b().getAppId(), "ANDROIDQQ.JOININGROUP.XX", "13", "18", "1");
            return false;
        }
    }

    public boolean isQQInstalled(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void saveSession(JSONObject jSONObject) {
        this.a.b().saveSession(jSONObject);
    }

    public boolean checkSessionValid(String str) {
        JSONObject loadSession = this.a.b().loadSession(str);
        if (!(loadSession == null || loadSession.length() == 0)) {
            try {
                String string = loadSession.getString("access_token");
                String string2 = loadSession.getString("expires_in");
                String string3 = loadSession.getString("openid");
                String string4 = loadSession.getString("expires_time");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    if (System.currentTimeMillis() < Long.parseLong(string4)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                f.c("QQToken", "checkSessionValid " + e.toString());
            }
        }
        return false;
    }

    public JSONObject loadSession(String str) {
        return this.a.b().loadSession(str);
    }

    public void initSessionCache(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
        } catch (Exception e) {
            f.c("QQToken", "initSessionCache " + e.toString());
        }
    }
}
