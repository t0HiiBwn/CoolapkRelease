package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.sso.WeiboSsoManager;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.SecurityHelper;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.sina.weibo.sdk.web.param.AuthWebViewRequestParam;

public class BaseSsoHandler {
    public static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
    private static final String TAG = "BaseSsoHandler";
    protected final int SSO_TYPE_INVALID = 3;
    protected WbAuthListener authListener;
    protected Context mAuthActivity;
    protected int ssoRequestCode = -1;
    protected int ssoRequestType = 3;

    protected enum AuthType {
        ALL,
        SsoOnly,
        WebOnly
    }

    protected void fillExtraIntent(Intent intent, int i) {
    }

    public BaseSsoHandler(Activity activity) {
        this.mAuthActivity = activity;
        WeiboSsoManager.getInstance().init(activity, WbSdk.getAuthInfo().getAppKey());
    }

    public BaseSsoHandler(Context context) {
        this.mAuthActivity = context;
        WeiboSsoManager.getInstance().init(context, WbSdk.getAuthInfo().getAppKey());
    }

    public void authorize(WbAuthListener wbAuthListener) {
        authorize(32973, wbAuthListener, AuthType.ALL);
    }

    public void authorizeClientSso(WbAuthListener wbAuthListener) {
        authorize(32973, wbAuthListener, AuthType.SsoOnly);
    }

    public void authorizeWeb(WbAuthListener wbAuthListener) {
        authorize(32973, wbAuthListener, AuthType.WebOnly);
    }

    private void authorize(int i, WbAuthListener wbAuthListener, AuthType authType) {
        resetIntentFillData();
        if (wbAuthListener != null) {
            this.authListener = wbAuthListener;
            if (authType == AuthType.WebOnly) {
                startWebAuth();
                return;
            }
            boolean z = false;
            if (authType == AuthType.SsoOnly) {
                z = true;
            }
            WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this.mAuthActivity).getWbAppInfo();
            if (isWbAppInstalled() && wbAppInfo != null) {
                startClientAuth(i);
            } else if (z) {
                this.authListener.onFailure(new WbConnectErrorMessage());
            } else {
                startWebAuth();
            }
        } else {
            throw new RuntimeException("please set auth listener");
        }
    }

    protected void startClientAuth(int i) {
        try {
            WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this.mAuthActivity).getWbAppInfo();
            Intent intent = new Intent();
            intent.setClassName(wbAppInfo.getPackageName(), wbAppInfo.getAuthActivityName());
            intent.putExtras(WbSdk.getAuthInfo().getAuthBundle());
            intent.putExtra("_weibo_command_type", 3);
            intent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
            intent.putExtra("aid", Utility.getAid(this.mAuthActivity, WbSdk.getAuthInfo().getAppKey()));
            if (!SecurityHelper.validateAppSignatureForIntent(this.mAuthActivity, intent)) {
                this.authListener.onFailure(new WbConnectErrorMessage("your install weibo app is counterfeit", "8001"));
                return;
            }
            fillExtraIntent(intent, i);
            try {
                ((Activity) this.mAuthActivity).startActivityForResult(intent, this.ssoRequestCode);
            } catch (Exception unused) {
                WbAuthListener wbAuthListener = this.authListener;
                if (wbAuthListener != null) {
                    wbAuthListener.onFailure(new WbConnectErrorMessage());
                }
            }
        } catch (Exception unused2) {
        }
    }

    protected void resetIntentFillData() {
        this.ssoRequestCode = 32973;
    }

    protected void startWebAuth() {
        String str;
        AuthInfo authInfo = WbSdk.getAuthInfo();
        WeiboParameters weiboParameters = new WeiboParameters(authInfo.getAppKey());
        weiboParameters.put("client_id", authInfo.getAppKey());
        weiboParameters.put("redirect_uri", authInfo.getRedirectUrl());
        weiboParameters.put("scope", authInfo.getScope());
        weiboParameters.put("response_type", "code");
        weiboParameters.put("version", "0041005000");
        weiboParameters.put("luicode", "10000360");
        Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.mAuthActivity);
        if (readAccessToken != null && !TextUtils.isEmpty(readAccessToken.getToken())) {
            weiboParameters.put("trans_token", readAccessToken.getToken());
            weiboParameters.put("trans_access_token", readAccessToken.getToken());
        }
        weiboParameters.put("lfid", "OP_" + authInfo.getAppKey());
        String aid = Utility.getAid(this.mAuthActivity, authInfo.getAppKey());
        if (!TextUtils.isEmpty(aid)) {
            weiboParameters.put("aid", aid);
        }
        weiboParameters.put("packagename", authInfo.getPackageName());
        weiboParameters.put("key_hash", authInfo.getKeyHash());
        String str2 = "https://open.weibo.cn/oauth2/authorize?" + weiboParameters.encodeUrl();
        if (!NetworkHelper.hasInternetPermission(this.mAuthActivity)) {
            UIUtils.showAlert(this.mAuthActivity, "Error", "Application requires permission to access the Internet");
            return;
        }
        if (this.authListener != null) {
            WeiboCallbackManager instance = WeiboCallbackManager.getInstance();
            String genCallbackKey = instance.genCallbackKey();
            instance.setWeiboAuthListener(genCallbackKey, this.authListener);
            str = genCallbackKey;
        } else {
            str = null;
        }
        AuthWebViewRequestParam authWebViewRequestParam = new AuthWebViewRequestParam(authInfo, WebRequestType.AUTH, str, "微博登录", str2, this.mAuthActivity);
        Intent intent = new Intent(this.mAuthActivity, WeiboSdkWebActivity.class);
        Bundle bundle = new Bundle();
        authWebViewRequestParam.fillBundle(bundle);
        intent.putExtras(bundle);
        this.mAuthActivity.startActivity(intent);
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        if (32973 != i) {
            return;
        }
        if (i2 == -1) {
            Context context = this.mAuthActivity;
            if (!SecurityHelper.checkResponseAppLegal(context, WeiboAppManager.getInstance(context).getWbAppInfo(), intent)) {
                this.authListener.onFailure(new WbConnectErrorMessage("your install weibo app is counterfeit", "8001"));
                return;
            }
            String safeString = Utility.safeString(intent.getStringExtra("error"));
            String safeString2 = Utility.safeString(intent.getStringExtra("error_type"));
            String safeString3 = Utility.safeString(intent.getStringExtra("error_description"));
            LogUtil.d("BaseSsoHandler", "error: " + safeString + ", error_type: " + safeString2 + ", error_description: " + safeString3);
            if (TextUtils.isEmpty(safeString) && TextUtils.isEmpty(safeString2) && TextUtils.isEmpty(safeString3)) {
                Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                if (parseAccessToken != null && parseAccessToken.isSessionValid()) {
                    LogUtil.d("BaseSsoHandler", "Login Success! " + parseAccessToken.toString());
                    AccessTokenKeeper.writeAccessToken(this.mAuthActivity, parseAccessToken);
                    this.authListener.onSuccess(parseAccessToken);
                }
            } else if ("access_denied".equals(safeString) || "OAuthAccessDeniedException".equals(safeString)) {
                LogUtil.d("BaseSsoHandler", "Login canceled by user.");
                this.authListener.cancel();
            } else {
                LogUtil.d("BaseSsoHandler", "Login failed: " + safeString);
                this.authListener.onFailure(new WbConnectErrorMessage(safeString2, safeString3));
            }
        } else if (i2 == 0) {
            this.authListener.cancel();
        }
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        return WbSdk.isWbInstall(this.mAuthActivity);
    }
}
