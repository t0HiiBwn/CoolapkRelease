package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.network.IRequestService;
import com.sina.weibo.sdk.network.impl.RequestParam;
import com.sina.weibo.sdk.network.impl.RequestService;
import com.sina.weibo.sdk.network.target.SimpleTarget;
import com.sina.weibo.sdk.utils.Base64;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ShareWebViewRequestParam extends BaseWebViewRequestParam {
    public static final String SHARE_URL = "https://service.weibo.com/share/mobilesdk.php";
    private static final String UPLOAD_PIC_URL = "https://service.weibo.com/share/mobilesdk_uppic.php";
    private String hashKey;
    private byte[] mBase64ImgData;
    private String mShareContent;
    private WeiboMultiMessage multiMessage;
    private String packageName;
    private String picId;
    private String token;

    public ShareWebViewRequestParam() {
    }

    public ShareWebViewRequestParam(Context context) {
        this.context = context;
    }

    public ShareWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        this(authInfo, webRequestType, str, 0, str2, str3, context);
    }

    public ShareWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, int i, String str2, String str3, Context context) {
        super(authInfo, webRequestType, str, i, str2, str3, context);
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public boolean hasExtraTask() {
        byte[] bArr = this.mBase64ImgData;
        if (bArr == null || bArr.length <= 0) {
            return super.hasExtraTask();
        }
        return true;
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void doExtraTask(final BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback) {
        super.doExtraTask(extraTaskCallback);
        LogUtil.i("Share", "ShareWebViewRequestParam.doExtraTask()");
        new WeiboParameters(getBaseData().getAuthInfo().getAppKey());
        String str = new String(this.mBase64ImgData);
        IRequestService instance = RequestService.getInstance();
        RequestParam.Builder builder = new RequestParam.Builder(this.context);
        builder.setShortUrl("https://service.weibo.com/share/mobilesdk_uppic.php");
        builder.addPostParam("img", str);
        builder.addPostParam("appKey", getBaseData().getAuthInfo().getAppKey());
        instance.asyncRequest(builder.build(), new SimpleTarget() {
            /* class com.sina.weibo.sdk.web.param.ShareWebViewRequestParam.AnonymousClass1 */

            @Override // com.sina.weibo.sdk.network.target.SimpleTarget
            public void onSuccess(String str) {
                LogUtil.i("Share", "ShareWebViewRequestParam.doExtraTask().onSuccess(),response = " + str);
                WebPicUploadResult parse = WebPicUploadResult.parse(str);
                if (parse == null || parse.getCode() != 1 || TextUtils.isEmpty(parse.getPicId())) {
                    BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback = extraTaskCallback;
                    if (extraTaskCallback != null) {
                        extraTaskCallback.onException("upload pic fail");
                        return;
                    }
                    return;
                }
                ShareWebViewRequestParam.this.picId = parse.getPicId();
                BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback2 = extraTaskCallback;
                if (extraTaskCallback2 != null) {
                    extraTaskCallback2.onComplete(ShareWebViewRequestParam.this.picId);
                }
            }

            @Override // com.sina.weibo.sdk.network.target.Target
            public void onFailure(Exception exc) {
                LogUtil.i("Share", "ShareWebViewRequestParam.doExtraTask().onFailure(),e =" + exc.getMessage());
                BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback = extraTaskCallback;
                if (extraTaskCallback != null) {
                    extraTaskCallback.onException("upload pic fail");
                }
            }
        });
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    protected void childFillBundle(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.multiMessage;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.toBundle(bundle);
        }
        bundle.putString("token", this.token);
        bundle.putString("packageName", this.packageName);
        bundle.putString("hashKey", this.hashKey);
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    protected void transformChildBundle(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        this.multiMessage = weiboMultiMessage;
        weiboMultiMessage.toObject(bundle);
        this.token = bundle.getString("token");
        this.packageName = bundle.getString("packageName");
        this.hashKey = bundle.getString("hashKey");
        getBaseUrl();
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public String getRequestUrl() {
        String appKey = getBaseData().getAuthInfo().getAppKey();
        Uri.Builder buildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.mShareContent);
        buildUpon.appendQueryParameter("version", "0041005000");
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.token)) {
            buildUpon.appendQueryParameter("access_token", this.token);
        }
        if (this.context != null) {
            String aid = Utility.getAid(this.context, appKey);
            if (!TextUtils.isEmpty(aid)) {
                buildUpon.appendQueryParameter("aid", aid);
            }
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            buildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.hashKey)) {
            buildUpon.appendQueryParameter("key_hash", this.hashKey);
        }
        if (!TextUtils.isEmpty(this.picId)) {
            buildUpon.appendQueryParameter("picinfo", this.picId);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_" + appKey);
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void updateRequestUrl(String str) {
        this.picId = str;
    }

    public void setMultiMessage(WeiboMultiMessage weiboMultiMessage) {
        this.multiMessage = weiboMultiMessage;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setHashKey(String str) {
        this.hashKey = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    private void getBaseUrl() {
        StringBuilder sb = new StringBuilder();
        if (this.multiMessage.textObject instanceof TextObject) {
            TextObject textObject = this.multiMessage.textObject;
            sb.append(textObject.text + " ");
        }
        if (this.multiMessage.mediaObject != null && (this.multiMessage.mediaObject instanceof WebpageObject) && !TextUtils.isEmpty(this.multiMessage.mediaObject.actionUrl)) {
            sb.append(this.multiMessage.mediaObject.actionUrl);
        }
        if (this.multiMessage.imageObject instanceof ImageObject) {
            ImageObject imageObject = this.multiMessage.imageObject;
            handleMblogPic(imageObject.imagePath, imageObject.imageData);
        }
        this.mShareContent = sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[SYNTHETIC, Splitter:B:22:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A[SYNTHETIC, Splitter:B:28:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    private void handleMblogPic(String str, byte[] bArr) {
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.canRead() && file.length() > 0) {
                byte[] bArr2 = new byte[((int) file.length())];
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileInputStream2.read(bArr2);
                        this.mBase64ImgData = Base64.encodebyte(bArr2);
                        try {
                            fileInputStream2.close();
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    } catch (IOException unused2) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (bArr == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (SecurityException unused4) {
                        }
                    }
                    if (bArr == null) {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            }
        }
        if (bArr == null && bArr.length > 0) {
            this.mBase64ImgData = Base64.encodebyte(bArr);
        }
    }
}
