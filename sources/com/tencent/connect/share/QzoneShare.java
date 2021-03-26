package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.c;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_APP = 6;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    private boolean c = true;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    public String mViaShareQzoneType = "";

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03a5  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02f1 A[ADDED_TO_REGION] */
    public void shareToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        f.c("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, "传入参数不可以为空", null));
            f.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "传入参数不可以为空");
            return;
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String a = j.a(activity);
        if (a == null) {
            a = bundle.getString("appName");
            str2 = string3;
        } else {
            str2 = string3;
            if (a.length() > 20) {
                StringBuilder sb = new StringBuilder();
                str = "imageUrl";
                sb.append(a.substring(0, 20));
                sb.append("...");
                a = sb.toString();
                i = bundle.getInt("req_type");
                if (i != 1) {
                    this.mViaShareQzoneType = "1";
                } else if (i == 5) {
                    this.mViaShareQzoneType = "2";
                } else if (i != 6) {
                    this.mViaShareQzoneType = "1";
                } else {
                    this.mViaShareQzoneType = "4";
                }
                if (i != 1) {
                    this.c = true;
                    this.d = false;
                    this.e = true;
                    this.f = false;
                } else if (i == 5) {
                    iUiListener.onError(new UiError(-5, "请选择支持的分享类型", null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                    return;
                } else if (i != 6) {
                    if (!j.e(string) || !j.e(string2)) {
                        this.c = true;
                    } else if (stringArrayList == null || stringArrayList.size() == 0) {
                        string = "来自" + a + "的分享";
                        this.c = true;
                    } else {
                        this.c = false;
                    }
                    this.d = false;
                    this.e = true;
                    this.f = false;
                } else if (j.g(activity, "5.0.0")) {
                    iUiListener.onError(new UiError(-15, "手Q版本过低，应用分享只支持手Q5.0及其以上版本", null));
                    f.e("openSDK_LOG.QzoneShare", "-->shareToQzone, app share is not support below qq5.0.");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone, app share is not support below qq5.0.");
                    return;
                } else {
                    str3 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", this.b.getAppId(), "mqq");
                    bundle.putString("targetUrl", str3);
                    if (!j.b() || !j.g(activity, "4.5.0")) {
                        if (this.c) {
                            if (TextUtils.isEmpty(str3)) {
                                iUiListener.onError(new UiError(-5, "targetUrl为必填项，请补充后分享", null));
                                f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "targetUrl为必填项，请补充后分享");
                                return;
                            } else if (!j.g(str3)) {
                                iUiListener.onError(new UiError(-5, "targetUrl有误", null));
                                f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "targetUrl有误");
                                return;
                            }
                        }
                        if (this.d) {
                            bundle.putString("title", "");
                            bundle.putString("summary", "");
                        } else if (!this.e || !j.e(string)) {
                            if (j.e(string) || string.length() <= 200) {
                                str4 = null;
                            } else {
                                str4 = null;
                                bundle.putString("title", j.a(string, 200, (String) null, (String) null));
                            }
                            if (!j.e(string2) && string2.length() > 600) {
                                bundle.putString("summary", j.a(string2, 600, str4, str4));
                            }
                        } else {
                            iUiListener.onError(new UiError(-6, "title不能为空!", null));
                            f.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                            return;
                        }
                        if (!TextUtils.isEmpty(a)) {
                            bundle.putString("appName", a);
                        }
                        if (stringArrayList == null && (stringArrayList == null || stringArrayList.size() != 0)) {
                            int i2 = 0;
                            while (i2 < stringArrayList.size()) {
                                String str5 = stringArrayList.get(i2);
                                if (!j.g(str5) && !j.h(str5)) {
                                    stringArrayList.remove(i2);
                                    i2--;
                                }
                                i2++;
                            }
                            if (stringArrayList.size() == 0) {
                                iUiListener.onError(new UiError(-6, "非法的图片地址!", null));
                                f.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                                return;
                            }
                            bundle.putStringArrayList(str, stringArrayList);
                        } else if (this.f) {
                            iUiListener.onError(new UiError(-6, "纯图分享，imageUrl 不能为空", null));
                            f.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                            return;
                        }
                        if (!j.g(activity, "4.6.0")) {
                            f.c("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                            a.a(activity, stringArrayList, new c() {
                                /* class com.tencent.connect.share.QzoneShare.AnonymousClass1 */

                                @Override // com.tencent.open.utils.c
                                public void a(int i, String str) {
                                    iUiListener.onError(new UiError(-6, "非法的图片地址!", null));
                                }

                                @Override // com.tencent.open.utils.c
                                public void a(int i, ArrayList<String> arrayList) {
                                    if (i == 0) {
                                        bundle.putStringArrayList("imageUrl", arrayList);
                                    }
                                    QzoneShare.this.b(activity, bundle, iUiListener);
                                }
                            });
                        } else if (h.c(activity, "4.2.0") < 0 || h.c(activity, "4.6.0") >= 0) {
                            f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                            new TDialog(activity, "", a(""), null, this.b).show();
                        } else {
                            f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                            QQShare qQShare = new QQShare(activity, this.b);
                            if (stringArrayList != null && stringArrayList.size() > 0) {
                                String str6 = stringArrayList.get(0);
                                if (i != 5 || j.h(str6)) {
                                    bundle.putString("imageLocalUrl", str6);
                                } else {
                                    iUiListener.onError(new UiError(-6, "手Q版本过低，纯图分享不支持网路图片", null));
                                    f.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                    return;
                                }
                            }
                            if (!j.g(activity, "4.5.0")) {
                                bundle.putInt("cflag", 1);
                            }
                            qQShare.shareToQQ(activity, bundle, iUiListener);
                        }
                        f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
                    }
                    iUiListener.onError(new UiError(-6, "分享图片失败，检测不到SD卡!", null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享图片失败，检测不到SD卡!");
                    return;
                }
                str3 = str2;
                if (!j.b()) {
                }
                if (this.c) {
                }
                if (this.d) {
                }
                if (!TextUtils.isEmpty(a)) {
                }
                if (stringArrayList == null) {
                }
                if (this.f) {
                }
                if (!j.g(activity, "4.6.0")) {
                }
                f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
            }
        }
        str = "imageUrl";
        i = bundle.getInt("req_type");
        if (i != 1) {
        }
        if (i != 1) {
        }
        str3 = str2;
        if (!j.b()) {
        }
        if (this.c) {
        }
        if (this.d) {
        }
        if (!TextUtils.isEmpty(a)) {
        }
        if (stringArrayList == null) {
        }
        if (this.f) {
        }
        if (!j.g(activity, "4.6.0")) {
        }
        f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x035f  */
    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i;
        String appId;
        String openId;
        Intent intent;
        Exception e2;
        f.c("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        String string4 = bundle.getString("audio_url");
        int i2 = bundle.getInt("req_type", 1);
        String string5 = bundle.getString("appName");
        int i3 = bundle.getInt("cflag", 0);
        String string6 = bundle.getString("share_qq_ext_str");
        String str = "";
        try {
            Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                Set<String> keySet = bundle2.keySet();
                JSONObject jSONObject = new JSONObject();
                for (String str2 : keySet) {
                    i = i3;
                    try {
                        jSONObject.put(str2, bundle2.get(str2));
                        i3 = i;
                    } catch (Exception e3) {
                        e2 = e3;
                        f.b("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e2);
                        appId = this.b.getAppId();
                        openId = this.b.getOpenId();
                        f.a("openSDK_LOG.QzoneShare", "openId:" + openId);
                        if (stringArrayList != null) {
                        }
                        if (!TextUtils.isEmpty(string)) {
                        }
                        if (!TextUtils.isEmpty(string2)) {
                        }
                        if (!TextUtils.isEmpty(appId)) {
                        }
                        if (!TextUtils.isEmpty(string3)) {
                        }
                        if (!TextUtils.isEmpty(string5)) {
                        }
                        if (!j.e(openId)) {
                        }
                        if (!j.e(string4)) {
                        }
                        stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
                        if (!j.e(string6)) {
                        }
                        if (!TextUtils.isEmpty(str)) {
                        }
                        stringBuffer.append("&cflag=" + Base64.encodeToString(j.i(String.valueOf(i)), 2));
                        f.a("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                        a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
                        intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(stringBuffer.toString()));
                        intent.putExtra("pkg_name", activity.getPackageName());
                        if (j.g(activity, "4.6.0")) {
                        }
                        if (a(intent)) {
                        }
                        f.c("openSDK_LOG", "doShareToQzone() --end");
                    }
                }
                i = i3;
                if (keySet.size() > 0) {
                    str = jSONObject.toString();
                }
            } else {
                i = i3;
            }
        } catch (Exception e4) {
            e2 = e4;
            i = i3;
            f.b("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e2);
            appId = this.b.getAppId();
            openId = this.b.getOpenId();
            f.a("openSDK_LOG.QzoneShare", "openId:" + openId);
            if (stringArrayList != null) {
            }
            if (!TextUtils.isEmpty(string)) {
            }
            if (!TextUtils.isEmpty(string2)) {
            }
            if (!TextUtils.isEmpty(appId)) {
            }
            if (!TextUtils.isEmpty(string3)) {
            }
            if (!TextUtils.isEmpty(string5)) {
            }
            if (!j.e(openId)) {
            }
            if (!j.e(string4)) {
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
            if (!j.e(string6)) {
            }
            if (!TextUtils.isEmpty(str)) {
            }
            stringBuffer.append("&cflag=" + Base64.encodeToString(j.i(String.valueOf(i)), 2));
            f.a("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
            a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra("pkg_name", activity.getPackageName());
            if (j.g(activity, "4.6.0")) {
            }
            if (a(intent)) {
            }
            f.c("openSDK_LOG", "doShareToQzone() --end");
        }
        appId = this.b.getAppId();
        openId = this.b.getOpenId();
        f.a("openSDK_LOG.QzoneShare", "openId:" + openId);
        if (stringArrayList != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i4 = 9;
            if (stringArrayList.size() <= 9) {
                i4 = stringArrayList.size();
            }
            int i5 = 0;
            while (i5 < i4) {
                stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i5)));
                if (i5 != i4 - 1) {
                    stringBuffer2.append(";");
                }
                i5++;
                stringArrayList = stringArrayList;
            }
            stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer2.toString()), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + Base64.encodeToString(j.i(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + Base64.encodeToString(j.i(string2), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + Base64.encodeToString(j.i(string3), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(j.i(string5), 2));
        }
        if (!j.e(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(j.i(openId), 2));
        }
        if (!j.e(string4)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(j.i(string4), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
        if (!j.e(string6)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(j.i(string6), 2));
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(j.i(str), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(j.i(String.valueOf(i)), 2));
        f.a("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
        a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (j.g(activity, "4.6.0")) {
            if (a(intent)) {
                UIListenerManager.getInstance().setListenerWithRequestcode(11104, iUiListener);
                a(activity, intent, 11104);
            }
            f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
            }
            if (a(intent)) {
                a(activity, 10104, intent, false);
            }
        }
        if (a(intent)) {
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
            d.a().a(0, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        f.c("openSDK_LOG", "doShareToQzone() --end");
    }
}
