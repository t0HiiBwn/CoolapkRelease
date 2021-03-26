package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class QzonePublish extends BaseApi {
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void publishToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        f.c("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, "传入参数不可以为空", null));
            f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "传入参数不可以为空");
        } else if (!j.e(activity)) {
            iUiListener.onError(new UiError(-15, "手Q版本过低，请下载安装最新版手Q", null));
            f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new TDialog(activity, "", a(""), null, this.b).show();
        } else {
            String a = j.a(activity);
            int i = 0;
            if (a == null) {
                a = bundle.getString("appName");
            } else if (a.length() > 20) {
                a = a.substring(0, 20) + "...";
            }
            if (!TextUtils.isEmpty(a)) {
                bundle.putString("appName", a);
            }
            int i2 = bundle.getInt("req_type");
            if (i2 == 3) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    while (i < stringArrayList.size()) {
                        if (!j.h(stringArrayList.get(i))) {
                            stringArrayList.remove(i);
                            i--;
                        }
                        i++;
                    }
                    bundle.putStringArrayList("imageUrl", stringArrayList);
                }
                b(activity, bundle, iUiListener);
                f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            } else if (i2 == 4) {
                final String string = bundle.getString("videoPath");
                if (!j.h(string)) {
                    f.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                    iUiListener.onError(new UiError(-5, "请选择有效的视频文件", null));
                    return;
                }
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    /* class com.tencent.connect.share.QzonePublish.AnonymousClass1 */

                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        long length = new File(string).length();
                        int duration = mediaPlayer.getDuration();
                        bundle.putString("videoPath", string);
                        bundle.putInt("videoDuration", duration);
                        bundle.putLong("videoSize", length);
                        QzonePublish.this.b(activity, bundle, iUiListener);
                        f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                    }
                });
                mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    /* class com.tencent.connect.share.QzonePublish.AnonymousClass2 */

                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        f.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                        iUiListener.onError(new UiError(-5, "请选择有效的视频文件", null));
                        return false;
                    }
                });
                try {
                    mediaPlayer.setDataSource(string);
                    mediaPlayer.prepareAsync();
                } catch (Exception unused) {
                    f.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
                    iUiListener.onError(new UiError(-5, "请选择有效的视频文件", null));
                }
            } else {
                iUiListener.onError(new UiError(-5, "请选择支持的分享类型", null));
                f.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02d1  */
    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        String appId;
        String openId;
        Intent intent;
        int size;
        int i;
        Exception e;
        String str3 = "";
        f.c("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string = bundle.getString("summary");
        int i2 = bundle.getInt("req_type", 3);
        String string2 = bundle.getString("appName");
        String string3 = bundle.getString("videoPath");
        int i3 = bundle.getInt("videoDuration");
        long j = bundle.getLong("videoSize");
        try {
            Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                Set<String> keySet = bundle2.keySet();
                JSONObject jSONObject = new JSONObject();
                for (String str4 : keySet) {
                    if (!TextUtils.isEmpty(bundle2.getString(str4))) {
                        str = str3;
                        try {
                            jSONObject.put(str4, bundle2.getString(str4));
                        } catch (Exception e2) {
                            e = e2;
                            f.b("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                            str2 = str;
                            appId = this.b.getAppId();
                            openId = this.b.getOpenId();
                            f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
                            StringBuffer stringBuffer2 = new StringBuffer();
                            size = stringArrayList.size();
                            i = 0;
                            while (i < size) {
                            }
                            stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer2.toString()), 2));
                            str = "7";
                            if (4 == i2) {
                            }
                            if (!TextUtils.isEmpty(string)) {
                            }
                            if (!TextUtils.isEmpty(appId)) {
                            }
                            if (!TextUtils.isEmpty(string2)) {
                            }
                            if (!j.e(openId)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
                            f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                            a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
                            intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(stringBuffer.toString()));
                            intent.putExtra("pkg_name", activity.getPackageName());
                            if (!a(intent)) {
                            }
                            f.c("openSDK_LOG", "doPublishToQzone() --end");
                        }
                    } else {
                        str = str3;
                    }
                    str3 = str;
                }
                str = str3;
                if (jSONObject.length() > 0) {
                    str2 = jSONObject.toString();
                    appId = this.b.getAppId();
                    openId = this.b.getOpenId();
                    f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
                    if (3 == i2 && stringArrayList != null) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        size = stringArrayList.size();
                        i = 0;
                        while (i < size) {
                            stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i)));
                            if (i != size - 1) {
                                stringBuffer2.append(";");
                            }
                            i++;
                            stringArrayList = stringArrayList;
                        }
                        stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer2.toString()), 2));
                        str = "7";
                    }
                    if (4 == i2) {
                        stringBuffer.append("&videoPath=" + Base64.encodeToString(j.i(string3), 2));
                        stringBuffer.append("&videoDuration=" + Base64.encodeToString(j.i(String.valueOf(i3)), 2));
                        stringBuffer.append("&videoSize=" + Base64.encodeToString(j.i(String.valueOf(j)), 2));
                        str = "8";
                    }
                    if (!TextUtils.isEmpty(string)) {
                        stringBuffer.append("&description=" + Base64.encodeToString(j.i(string), 2));
                    }
                    if (!TextUtils.isEmpty(appId)) {
                        stringBuffer.append("&share_id=" + appId);
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        stringBuffer.append("&app_name=" + Base64.encodeToString(j.i(string2), 2));
                    }
                    if (!j.e(openId)) {
                        stringBuffer.append("&open_id=" + Base64.encodeToString(j.i(openId), 2));
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(j.i(str2), 2));
                    }
                    stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
                    f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                    a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(stringBuffer.toString()));
                    intent.putExtra("pkg_name", activity.getPackageName());
                    if (!a(intent)) {
                        a(activity, 10104, intent, false);
                        d.a().a(0, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                        d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "1", str, "0", "1", "0");
                    } else {
                        f.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
                        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                        d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "1", str, "0", "1", "0");
                    }
                    f.c("openSDK_LOG", "doPublishToQzone() --end");
                }
            } else {
                str = str3;
            }
        } catch (Exception e3) {
            e = e3;
            str = str3;
            f.b("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
            str2 = str;
            appId = this.b.getAppId();
            openId = this.b.getOpenId();
            f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
            StringBuffer stringBuffer2 = new StringBuffer();
            size = stringArrayList.size();
            i = 0;
            while (i < size) {
            }
            stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer2.toString()), 2));
            str = "7";
            if (4 == i2) {
            }
            if (!TextUtils.isEmpty(string)) {
            }
            if (!TextUtils.isEmpty(appId)) {
            }
            if (!TextUtils.isEmpty(string2)) {
            }
            if (!j.e(openId)) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
            f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
            a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra("pkg_name", activity.getPackageName());
            if (!a(intent)) {
            }
            f.c("openSDK_LOG", "doPublishToQzone() --end");
        }
        str2 = str;
        appId = this.b.getAppId();
        openId = this.b.getOpenId();
        f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
        StringBuffer stringBuffer2 = new StringBuffer();
        size = stringArrayList.size();
        i = 0;
        while (i < size) {
        }
        stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer2.toString()), 2));
        str = "7";
        if (4 == i2) {
        }
        if (!TextUtils.isEmpty(string)) {
        }
        if (!TextUtils.isEmpty(appId)) {
        }
        if (!TextUtils.isEmpty(string2)) {
        }
        if (!j.e(openId)) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
        f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
        a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (!a(intent)) {
        }
        f.c("openSDK_LOG", "doPublishToQzone() --end");
    }
}
