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
import com.tencent.open.utils.b;
import com.tencent.open.utils.c;
import com.tencent.open.utils.e;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class QQShare extends BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_ARK_INFO = "share_to_qq_ark_info";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_APP = 6;
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public String mViaShareQQType = "";

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    public QQShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        f.c("openSDK_LOG.QQShare", "shareToQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("imageLocalUrl");
        int i = bundle.getInt("req_type", 1);
        f.c("openSDK_LOG.QQShare", "shareToQQ -- type: " + i);
        if (i == 1) {
            this.mViaShareQQType = "1";
        } else if (i == 2) {
            this.mViaShareQQType = "3";
        } else if (i == 5) {
            this.mViaShareQQType = "2";
        } else if (i == 6) {
            this.mViaShareQQType = "4";
        }
        if (i == 6) {
            if (j.f(activity, "5.0.0")) {
                iUiListener.onError(new UiError(-15, "手Q版本过低，应用分享只支持手Q5.0及其以上版本", null));
                f.e("openSDK_LOG.QQShare", "shareToQQ, app share is not support below qq5.0.");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, app share is not support below qq5.0.");
                return;
            }
            string4 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", this.b.getAppId(), "mqq");
            bundle.putString("targetUrl", string4);
        }
        if (j.b() || !j.f(activity, "4.5.0")) {
            if (i == 5) {
                if (j.f(activity, "4.3.0")) {
                    iUiListener.onError(new UiError(-6, "低版本手Q不支持该项功能!", null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                    return;
                } else if (!j.h(string5)) {
                    iUiListener.onError(new UiError(-6, "非法的图片地址!", null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "非法的图片地址!");
                    return;
                }
            }
            if (i != 5) {
                if (TextUtils.isEmpty(string4) || (!string4.startsWith("http://") && !string4.startsWith("https://"))) {
                    iUiListener.onError(new UiError(-6, "传入参数有误!", null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                    return;
                } else if (TextUtils.isEmpty(string2)) {
                    iUiListener.onError(new UiError(-6, "title不能为空!", null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                    return;
                }
            }
            if (TextUtils.isEmpty(string) || string.startsWith("http://") || string.startsWith("https://") || new File(string).exists()) {
                if (TextUtils.isEmpty(string2) || string2.length() <= 128) {
                    str = null;
                } else {
                    str = null;
                    bundle.putString("title", j.a(string2, 128, (String) null, (String) null));
                }
                if (!TextUtils.isEmpty(string3) && string3.length() > 512) {
                    bundle.putString("summary", j.a(string3, 512, str, str));
                }
                if (j.a(activity, bundle.getInt("cflag", 0) == 1)) {
                    f.c("openSDK_LOG.QQShare", "shareToQQ, support share");
                    b(activity, bundle, iUiListener);
                } else {
                    try {
                        f.d("openSDK_LOG.QQShare", "shareToQQ, don't support share, will show download dialog");
                        new TDialog(activity, "", a(""), null, this.b).show();
                    } catch (RuntimeException e) {
                        f.b("openSDK_LOG.QQShare", " shareToQQ, TDialog.show not in main thread", e);
                        e.printStackTrace();
                        iUiListener.onError(new UiError(-6, "没有在主线程调用！", null));
                    }
                }
                f.c("openSDK_LOG.QQShare", "shareToQQ() -- end.");
                return;
            }
            iUiListener.onError(new UiError(-6, "非法的图片地址!", null));
            f.e("openSDK_LOG.QQShare", "shareToQQ, image url is emprty or illegal.");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
            return;
        }
        iUiListener.onError(new UiError(-6, "分享图片失败，检测不到SD卡!", null));
        f.e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
    }

    private void b(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        final String string2 = bundle.getString("title");
        final String string3 = bundle.getString("summary");
        f.a("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (TextUtils.isEmpty(string)) {
            c(activity, bundle, iUiListener);
        } else if (!j.g(string)) {
            bundle.putString("imageUrl", null);
            if (j.f(activity, "4.3.0")) {
                f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                c(activity, bundle, iUiListener);
            } else {
                f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0 ");
                a.a(activity, string, new c() {
                    /* class com.tencent.connect.share.QQShare.AnonymousClass2 */

                    @Override // com.tencent.open.utils.c
                    public void a(int i, ArrayList<String> arrayList) {
                    }

                    @Override // com.tencent.open.utils.c
                    public void a(int i, String str) {
                        if (i == 0) {
                            bundle.putString("imageLocalUrl", str);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            IUiListener iUiListener = iUiListener;
                            if (iUiListener != null) {
                                iUiListener.onError(new UiError(-6, "获取分享图片失败!", null));
                                f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            d.a().a(1, "SHARE_CHECK_SDK", "1000", QQShare.this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
                            return;
                        }
                        QQShare.this.c(activity, bundle, iUiListener);
                    }
                });
            }
        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            if (iUiListener != null) {
                iUiListener.onError(new UiError(-6, "分享图片失败，检测不到SD卡!", null));
                f.e("openSDK_LOG.QQShare", "分享图片失败，检测不到SD卡!");
            }
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享图片失败，检测不到SD卡!");
            return;
        } else if (!j.f(activity, "4.3.0")) {
            c(activity, bundle, iUiListener);
        } else {
            new b(activity).a(string, new c() {
                /* class com.tencent.connect.share.QQShare.AnonymousClass1 */

                @Override // com.tencent.open.utils.c
                public void a(int i, ArrayList<String> arrayList) {
                }

                @Override // com.tencent.open.utils.c
                public void a(int i, String str) {
                    if (i == 0) {
                        bundle.putString("imageLocalUrl", str);
                    } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                        IUiListener iUiListener = iUiListener;
                        if (iUiListener != null) {
                            iUiListener.onError(new UiError(-6, "获取分享图片失败!", null));
                            f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                        }
                        d.a().a(1, "SHARE_CHECK_SDK", "1000", QQShare.this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
                        return;
                    }
                    QQShare.this.c(activity, bundle, iUiListener);
                }
            });
        }
        f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    /* access modifiers changed from: private */
    public void c(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i;
        int i2;
        f.c("openSDK_LOG.QQShare", "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("audio_url");
        int i3 = bundle.getInt("req_type", 1);
        String string6 = bundle.getString("share_to_qq_ark_info");
        int i4 = bundle.getInt("cflag", 0);
        String string7 = bundle.getString("share_qq_ext_str");
        String a = j.a(activity);
        if (a == null) {
            a = bundle.getString("appName");
        }
        String str = a;
        String string8 = bundle.getString("imageLocalUrl");
        String appId = this.b.getAppId();
        String openId = this.b.getOpenId();
        f.a("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + openId);
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(string), 2));
        }
        if (!TextUtils.isEmpty(string8)) {
            stringBuffer.append("&file_data=" + Base64.encodeToString(j.i(string8), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&title=" + Base64.encodeToString(j.i(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&description=" + Base64.encodeToString(j.i(string3), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuffer.append("&url=" + Base64.encodeToString(j.i(string4), 2));
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 20) {
                str = str.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(j.i(str), 2));
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(j.i(openId), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(j.i(string5), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i3)), 2));
        if (!TextUtils.isEmpty(string6)) {
            stringBuffer.append("&share_to_qq_ark_info=" + Base64.encodeToString(j.i(string6), 2));
        }
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(j.i(string7), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(j.i(String.valueOf(i4)), 2));
        f.a("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
        a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (j.f(activity, "4.6.0")) {
            f.c("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            if (a(intent)) {
                UIListenerManager.getInstance().setListenerWithRequestcode(11103, iUiListener);
                a(activity, intent, 11103);
            }
            i2 = i4;
            i = 1;
        } else {
            f.c("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQQ", iUiListener) != null) {
                f.c("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            if (a(intent)) {
                i = 1;
                a(activity, 10103, intent, true);
            } else {
                i = 1;
            }
            i2 = i4;
        }
        String str2 = i2 == i ? "11" : "10";
        if (a(intent)) {
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.SHARETOQQ.XX", str2, "3", "0", this.mViaShareQQType, "0", "1", "0");
            d.a().a(0, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.SHARETOQQ.XX", str2, "3", "1", this.mViaShareQQType, "0", "1", "0");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        f.c("openSDK_LOG.QQShare", "doShareToQQ() --end");
    }
}
