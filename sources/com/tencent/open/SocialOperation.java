package com.tencent.open;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.j;

/* compiled from: ProGuard */
public class SocialOperation extends BaseApi {
    public static final String GAME_FRIEND_ADD_MESSAGE = "add_msg";
    public static final String GAME_FRIEND_LABEL = "friend_label";
    public static final String GAME_FRIEND_OPENID = "fopen_id";
    public static final String GAME_SIGNATURE = "signature";
    public static final String GAME_UNION_ID = "unionid";
    public static final String GAME_UNION_NAME = "union_name";
    public static final String GAME_ZONE_ID = "zoneid";

    public SocialOperation(QQToken qQToken) {
        super(qQToken);
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        f.c("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- start");
        if (bundle == null) {
            f.e("openSDK_LOG.GameAppOperation", "-->makeFriend params is null");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.MAKEAFRIEND.XX", "14", "18", "1");
            return;
        }
        String string = bundle.getString("fopen_id");
        if (TextUtils.isEmpty(string)) {
            f.e("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid is empty.");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.MAKEAFRIEND.XX", "14", "18", "1");
            return;
        }
        String string2 = bundle.getString("friend_label");
        String string3 = bundle.getString("add_msg");
        String a = j.a(activity);
        String openId = this.b.getOpenId();
        String appId = this.b.getAppId();
        f.a("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid: " + string + " | label: " + string2 + " | message: " + string3 + " | openid: " + openId + " | appid:" + appId);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://gamesdk/add_friend?src_type=app&version=1");
        StringBuilder sb = new StringBuilder();
        sb.append("&fopen_id=");
        sb.append(Base64.encodeToString(j.i(string), 2));
        stringBuffer.append(sb.toString());
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(j.i(openId), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&app_id=" + appId);
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&friend_label=" + Base64.encodeToString(j.i(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&add_msg=" + Base64.encodeToString(j.i(string3), 2));
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(j.i(a), 2));
        }
        f.a("openSDK_LOG.GameAppOperation", "-->make friend, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (!a(intent) || j.f(activity, "5.1.0")) {
            f.d("openSDK_LOG.GameAppOperation", "-->make friend, there is no activity.");
            a(activity);
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.MAKEAFRIEND.XX", "14", "18", "1");
        } else {
            f.c("openSDK_LOG.GameAppOperation", "-->makeFriend target activity found, qqver greater than 5.1.0");
            try {
                activity.startActivity(intent);
                d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.MAKEAFRIEND.XX", "14", "18", "0");
            } catch (Exception e) {
                f.b("openSDK_LOG.GameAppOperation", "-->make friend, start activity exception.", e);
                a(activity);
                d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.MAKEAFRIEND.XX", "14", "18", "1");
            }
        }
        f.c("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- end");
    }

    public void bindQQGroup(Activity activity, Bundle bundle) {
        f.c("openSDK_LOG.GameAppOperation", "-->bindQQGroup()  -- start");
        if (activity == null) {
            f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, activity is empty.");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
        } else if (bundle == null) {
            Toast.makeText(activity, "Bundle参数为空", 0).show();
            f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, params is empty.");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
        } else {
            String a = j.a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://gamesdk/bind_group?src_type=app&version=1");
            if (!TextUtils.isEmpty(a)) {
                stringBuffer.append("&app_name=" + Base64.encodeToString(j.i(a), 2));
            }
            String string = bundle.getString("unionid");
            if (TextUtils.isEmpty(string)) {
                Toast.makeText(activity, "游戏公会ID为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, game union id is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
                return;
            }
            stringBuffer.append("&unionid=" + Base64.encodeToString(j.i(string), 2));
            String string2 = bundle.getString("union_name");
            if (TextUtils.isEmpty(string2)) {
                Toast.makeText(activity, "游戏公会名称为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, game union name is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
                return;
            }
            stringBuffer.append("&union_name=" + Base64.encodeToString(j.i(string2), 2));
            String string3 = bundle.getString("zoneid");
            if (TextUtils.isEmpty(string3)) {
                Toast.makeText(activity, "游戏区域ID为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, game zone id  is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
                return;
            }
            stringBuffer.append("&zoneid=" + Base64.encodeToString(j.i(string3), 2));
            String string4 = bundle.getString("signature");
            if (TextUtils.isEmpty(string4)) {
                Toast.makeText(activity, "游戏签名为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, game signature is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
                return;
            }
            stringBuffer.append("&signature=" + Base64.encodeToString(j.i(string4), 2));
            String openId = this.b.getOpenId();
            if (!TextUtils.isEmpty(openId)) {
                stringBuffer.append("&openid=" + Base64.encodeToString(j.i(openId), 2));
                Bundle b = b();
                for (String str : b.keySet()) {
                    b.putString(str, Base64.encodeToString(j.i(b.getString(str)), 2));
                }
                stringBuffer.append("&" + HttpUtils.encodeUrl(b));
                f.a("openSDK_LOG.GameAppOperation", "-->bindQQGroup, url: " + stringBuffer.toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringBuffer.toString()));
                if (!a(intent) || j.f(activity, "5.1.0")) {
                    f.d("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
                    d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
                    a(activity);
                } else {
                    f.c("openSDK_LOG.GameAppOperation", "-->bingQQGroup target activity found, qqver > 5.1.0");
                    try {
                        activity.startActivity(intent);
                        d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "0");
                    } catch (Exception e) {
                        f.b("openSDK_LOG.GameAppOperation", "-->bind group, start activity exception.", e);
                        d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
                        a(activity);
                    }
                }
                f.c("openSDK_LOG.GameAppOperation", "-->bindQQGroup()  -- end");
                return;
            }
            Toast.makeText(activity, "Openid为空", 0).show();
            f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, openid is empty.");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDSDK.BINDGROUP.XX", "18", "18", "1");
        }
    }

    private void a(Activity activity) {
        a(activity, "");
    }

    private void a(Activity activity, String str) {
        new TDialog(activity, "", a(str), null, this.b).show();
    }
}
