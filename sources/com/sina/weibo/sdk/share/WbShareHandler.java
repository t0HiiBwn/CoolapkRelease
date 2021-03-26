package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.utils.FileUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.ShareWebViewRequestParam;

public class WbShareHandler {
    public static final int WB_SHARE_REQUEST = 1;
    private Activity context;
    private boolean hasRegister = false;
    private int progressColor = -1;
    private int progressId = -1;

    public boolean supportMulti() {
        return false;
    }

    public WbShareHandler(Activity activity) {
        this.context = activity;
    }

    public boolean registerApp() {
        sendBroadcast(this.context, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER", WbSdk.getAuthInfo().getAppKey(), null, null);
        this.hasRegister = true;
        return true;
    }

    private void sendBroadcast(Context context2, String str, String str2, String str3, Bundle bundle) {
        Intent intent = new Intent(str);
        String packageName = context2.getPackageName();
        intent.putExtra("_weibo_sdkVersion", "0041005000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", str2);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(context2, packageName)));
        if (!TextUtils.isEmpty(str3)) {
            intent.setPackage(str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context2.sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
    }

    public void shareMessage(WeiboMultiMessage weiboMultiMessage, boolean z) {
        if (!this.hasRegister) {
            throw new RuntimeException("please call WbShareHandler.registerApp(),before use share function");
        } else if (!WbSdk.isWbInstall(this.context) && z) {
        } else {
            if (z) {
                startClientShare(weiboMultiMessage);
                return;
            }
            WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this.context).getWbAppInfo();
            if (!WbSdk.isWbInstall(this.context) || wbAppInfo == null || wbAppInfo.getSupportVersion() <= 10000) {
                startWebShare(weiboMultiMessage);
            } else {
                startClientShare(weiboMultiMessage);
            }
        }
    }

    public void shareToStory(StoryMessage storyMessage) {
        Uri imageUri = storyMessage.getImageUri();
        Uri videoUri = storyMessage.getVideoUri();
        if ((imageUri == null || !FileUtils.isImageFile(this.context, imageUri)) && (videoUri == null || !FileUtils.isVideoFile(this.context, videoUri))) {
            throw new IllegalStateException("File only can be Image or Video. ");
        }
        Intent intent = new Intent();
        intent.putExtra("_weibo_message_stroy", storyMessage);
        intent.putExtra("startActivity", this.context.getClass().getName());
        intent.putExtra("startPackage", WeiboAppManager.getInstance(this.context).getWbAppInfo().getPackageName());
        intent.putExtra("progressColor", this.progressColor);
        intent.putExtra("progressId", this.progressId);
        intent.putExtra("startFlag", 0);
        intent.setClass(this.context, WbShareToStoryActivity.class);
        this.context.startActivityForResult(intent, 1);
    }

    private void startClientShare(WeiboMultiMessage weiboMultiMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_command_type", 1);
        bundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        bundle.putLong("callbackId", 0);
        bundle.putAll(weiboMultiMessage.toBundle(bundle));
        Intent intent = new Intent();
        intent.setClass(this.context, WbShareTransActivity.class);
        intent.putExtra("startFlag", 0);
        intent.putExtra("startActivity", this.context.getClass().getName());
        intent.putExtra("progressColor", this.progressColor);
        intent.putExtra("progressId", this.progressId);
        intent.putExtras(bundle);
        try {
            this.context.startActivityForResult(intent, 1);
        } catch (Exception e) {
            LogUtil.v("weibo sdk error ", e.toString());
        }
    }

    private void startWebShare(WeiboMultiMessage weiboMultiMessage) {
        LogUtil.i("Share", "startWebShare");
        Intent intent = new Intent(this.context, WbShareTransActivity.class);
        String packageName = this.context.getPackageName();
        ShareWebViewRequestParam shareWebViewRequestParam = new ShareWebViewRequestParam(WbSdk.getAuthInfo(), WebRequestType.SHARE, "", 1, "微博分享", null, this.context);
        shareWebViewRequestParam.setContext(this.context);
        shareWebViewRequestParam.setHashKey("");
        shareWebViewRequestParam.setPackageName(packageName);
        Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.context);
        if (readAccessToken != null && !TextUtils.isEmpty(readAccessToken.getToken())) {
            shareWebViewRequestParam.setToken(readAccessToken.getToken());
        }
        shareWebViewRequestParam.setMultiMessage(weiboMultiMessage);
        Bundle bundle = new Bundle();
        shareWebViewRequestParam.fillBundle(bundle);
        intent.putExtras(bundle);
        intent.putExtra("startFlag", 0);
        intent.putExtra("startActivity", this.context.getClass().getName());
        intent.putExtra("startAction", "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
        intent.putExtra("gotoActivity", "com.sina.weibo.sdk.web.WeiboSdkWebActivity");
        this.context.startActivityForResult(intent, 1);
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        return WbSdk.isWbInstall(this.context);
    }

    public void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        if (wbShareCallback != null && intent != null && (extras = intent.getExtras()) != null) {
            int i = extras.getInt("_weibo_resp_errcode", -1);
            if (i == 0) {
                wbShareCallback.onWbShareSuccess();
            } else if (i == 1) {
                wbShareCallback.onWbShareCancel();
            } else if (i == 2) {
                wbShareCallback.onWbShareFail();
            }
        }
    }

    public void setProgressColor(int i) {
        this.progressColor = i;
    }

    public void setProgressId(int i) {
        this.progressId = i;
    }
}
