package com.coolapk.market.view.webview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.AppUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.LoginInfo;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.encode.UUEncoder;
import com.coolapk.market.wxapi.WXEntryActivity;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00039:;B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\u001a\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0014\u0010*\u001a\u00020\u00112\n\u0010+\u001a\u00060,R\u00020-H\u0007J \u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\"\u00103\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0018\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u0002082\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/coolapk/market/view/webview/LoginFragment;", "Lcom/coolapk/market/view/webview/WebViewFragment;", "()V", "mAuthInfo", "Lcom/sina/weibo/sdk/auth/AuthInfo;", "mIsPosting", "", "mSsoHandler", "Lcom/sina/weibo/sdk/auth/sso/SsoHandler;", "mTencent", "Lcom/tencent/tauth/Tencent;", "mUiListener", "Lcom/tencent/tauth/IUiListener;", "checkThirdPart", "url", "", "loginThirdPartUrl", "", "tokenType", "tokenCode", "tokenUid", "tokenExpiredIn", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDestroy", "onLoginQQ", "onLoginWechat", "onLoginWeibo", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onWechatCode", "wechatCode", "Lcom/coolapk/market/wxapi/WXEntryActivity$WechatCode;", "Lcom/coolapk/market/wxapi/WXEntryActivity;", "postLoginRequest", "code", "forwardUrl", "message", "processAccessCode", "processLoginResult", "result", "Lcom/coolapk/market/model/LoginInfo;", "shouldOverrideUrlLoading", "webView", "Landroid/webkit/WebView;", "Companion", "LoginUiListener", "SelfWbAuthListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoginFragment.kt */
public final class LoginFragment extends WebViewFragment {
    public static final String CALLBACK_COOLAPK = "https://account.coolapk.com/auth/callback";
    public static final Companion Companion = new Companion(null);
    public static final String LOGIN_OUT = "https://account.coolapk.com/auth/logout";
    public static final String LOGIN_URL_BASE = "https://account.coolapk.com/auth/loginByOpenId";
    public static final String LOGIN_URL_COOLAPK = "https://account.coolapk.com/auth/login?type=coolapk";
    public static final String LOGIN_URL_MOBILE = "https://account.coolapk.com/auth/login?type=mobile";
    public static final String LOGIN_URL_QQ = "https://account.coolapk.com/auth/loginByOpenId?type=qq";
    public static final String LOGIN_URL_WECHAT = "https://account.coolapk.com/auth/loginByOpenId?type=weixin";
    public static final String LOGIN_URL_WEIBO = "https://account.coolapk.com/auth/loginByOpenId?type=weibo";
    public static final String REGISTER_URL_COOLAPK = "https://account.coolapk.com/auth/login?type=register";
    private AuthInfo mAuthInfo;
    private boolean mIsPosting;
    private SsoHandler mSsoHandler;
    private Tencent mTencent;
    private IUiListener mUiListener;

    @JvmStatic
    public static final LoginFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    @JvmStatic
    public static final LoginFragment newLoginInstance() {
        return Companion.newLoginInstance();
    }

    @JvmStatic
    public static final LoginFragment newRegisterInstance() {
        return Companion.newRegisterInstance();
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        CookieManager.getInstance().removeAllCookie();
        WebView webView = getWebView();
        Intrinsics.checkNotNull(webView);
        webView.clearCache(true);
        WebView webView2 = getWebView();
        Intrinsics.checkNotNull(webView2);
        webView2.clearHistory();
        WebView webView3 = getWebView();
        Intrinsics.checkNotNull(webView3);
        WebSettings settings = webView3.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView!!.settings");
        settings.setBuiltInZoomControls(false);
        SwipeRefreshLayout swipeRefreshView = getSwipeRefreshView();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshView, "swipeRefreshView");
        swipeRefreshView.setRefreshing(false);
        SwipeRefreshLayout swipeRefreshView2 = getSwipeRefreshView();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshView2, "swipeRefreshView");
        swipeRefreshView2.setEnabled(false);
        super.onViewCreated(view, bundle);
        WebView webView4 = getWebView();
        Intrinsics.checkNotNull(webView4);
        if (checkThirdPart(webView4.getUrl()) && (!Intrinsics.areEqual("https://account.coolapk.com/auth/login?type=mobile", webView4.getUrl()))) {
            webView4.loadUrl("https://account.coolapk.com/auth/login?type=mobile");
        }
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(str, "url");
        if (checkThirdPart(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    private final boolean checkThirdPart(String str) {
        if (str == null) {
            return false;
        }
        if (StringsKt.startsWith$default(str, "https://account.coolapk.com/auth/callback", false, 2, (Object) null)) {
            return processAccessCode(str);
        }
        if (StringsKt.startsWith$default(str, "https://account.coolapk.com/auth/loginByOpenId?type=qq", false, 2, (Object) null)) {
            return onLoginQQ();
        }
        if (StringsKt.startsWith$default(str, "https://account.coolapk.com/auth/loginByOpenId?type=weibo", false, 2, (Object) null)) {
            return onLoginWeibo();
        }
        if (StringsKt.startsWith$default(str, "https://account.coolapk.com/auth/loginByOpenId?type=weixin", false, 2, (Object) null)) {
            return onLoginWechat();
        }
        return false;
    }

    private final boolean onLoginWeibo() {
        if (!WbSdk.isWbInstall(getActivity())) {
            return false;
        }
        if (this.mAuthInfo == null) {
            this.mAuthInfo = new AuthInfo(getActivity(), "123216742", "https://account.coolapk.com/auth/loginByOpenId?type=weibo", "follow_app_official_microblog,");
            WbSdk.install(getActivity(), this.mAuthInfo);
            this.mSsoHandler = new SsoHandler(getActivity());
        }
        SsoHandler ssoHandler = this.mSsoHandler;
        Intrinsics.checkNotNull(ssoHandler);
        ssoHandler.authorize(new SelfWbAuthListener());
        return true;
    }

    private final boolean onLoginQQ() {
        if (this.mTencent == null) {
            this.mTencent = Tencent.createInstance("100336226", AppHolder.getApplication());
            this.mUiListener = new LoginUiListener();
            Tencent tencent = this.mTencent;
            Intrinsics.checkNotNull(tencent);
            if (tencent.isSessionValid()) {
                Tencent tencent2 = this.mTencent;
                Intrinsics.checkNotNull(tencent2);
                tencent2.logout(getActivity());
            }
        }
        if (PackageUtils.isInstalled(getActivity(), "com.tencent.mobileqq") || PackageUtils.isInstalled(getActivity(), "com.tencent.tim")) {
            Tencent tencent3 = this.mTencent;
            Intrinsics.checkNotNull(tencent3);
            tencent3.login(getActivity(), "get_user_info", this.mUiListener);
            return true;
        }
        Toast.show$default(getActivity(), "未安装QQ", 0, false, 12, null);
        return false;
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mTencent != null) {
            Tencent.onActivityResultData(i, i2, intent, this.mUiListener);
        }
        SsoHandler ssoHandler = this.mSsoHandler;
        if (ssoHandler != null) {
            Intrinsics.checkNotNull(ssoHandler);
            ssoHandler.authorizeCallBack(i, i2, intent);
        }
    }

    private final boolean onLoginWechat() {
        IWXAPI wxApi = AppHolder.getWxApi();
        Intrinsics.checkNotNullExpressionValue(wxApi, "iwxapi");
        if (wxApi.isWXAppInstalled()) {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = String.valueOf(System.currentTimeMillis());
            wxApi.sendReq(req);
            return true;
        }
        Toast.show$default(getActivity(), "未安装微信", 0, false, 12, null);
        return false;
    }

    @Subscribe
    public final void onWechatCode(WXEntryActivity.WechatCode wechatCode) {
        Intrinsics.checkNotNullParameter(wechatCode, "wechatCode");
        String uri = Uri.parse("https://account.coolapk.com/auth/loginByOpenId?type=weixin").buildUpon().appendQueryParameter("code", wechatCode.getCode()).appendQueryParameter("state", "com.coolapk.market").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(LOGIN_URL_WECH…      .build().toString()");
        if (isAdded()) {
            WebView webView = getWebView();
            Intrinsics.checkNotNull(webView);
            webView.loadUrl(uri);
        }
    }

    private final boolean processAccessCode(String str) {
        String queryParameter;
        Uri parse = Uri.parse(str);
        if (Intrinsics.areEqual("access_token", parse.getQueryParameter("ac")) && (queryParameter = parse.getQueryParameter("code")) != null) {
            if (!(queryParameter.length() == 0)) {
                String queryParameter2 = parse.getQueryParameter("forward");
                String str2 = "";
                if (queryParameter2 == null) {
                    queryParameter2 = str2;
                }
                String queryParameter3 = parse.getQueryParameter("message");
                if (queryParameter3 != null) {
                    str2 = queryParameter3;
                }
                postLoginRequest(queryParameter, queryParameter2, str2);
                return true;
            }
        }
        return false;
    }

    private final void postLoginRequest(String str, String str2, String str3) {
        if (!this.mIsPosting) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setProgressStyle(0);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
            progressDialog.setMessage(getString(2131886871));
            progressDialog.show();
            this.mIsPosting = true;
            DataManager.getInstance().getAccessToken(str).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new LoginFragment$postLoginRequest$1(this, progressDialog)).subscribe((Subscriber<? super R>) new LoginFragment$postLoginRequest$2(this, str2, str3));
        }
    }

    /* access modifiers changed from: private */
    public final void processLoginResult(LoginInfo loginInfo, String str, String str2) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        if (loginInfo != null) {
            loginSession.update(loginInfo);
        }
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isLogin()) {
            boolean z = true;
            if (str.length() > 0) {
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                instance2.getPreferencesEditor().putString("login_forward_url", str).apply();
            }
            if (str2.length() <= 0) {
                z = false;
            }
            if (z) {
                AppHolder.getMainThreadHandler().postDelayed(new LoginFragment$processLoginResult$1(str2), 400);
            }
            EventBus.getDefault().post(loginSession);
            requireActivity().setResult(-1);
            requireActivity().finish();
            return;
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Toast.show(requireActivity, 2131886870);
        WebView webView = getWebView();
        Intrinsics.checkNotNull(webView);
        webView.loadUrl("https://account.coolapk.com/auth/login?type=coolapk");
    }

    /* access modifiers changed from: private */
    public final void loginThirdPartUrl(String str, String str2, String str3, int i) {
        try {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            String packageName = requireActivity.getPackageName();
            List<String> appSignaturesSHA1 = AppUtils.getAppSignaturesSHA1();
            Intrinsics.checkNotNullExpressionValue(appSignaturesSHA1, "AppUtils.getAppSignaturesSHA1()");
            String str4 = (String) CollectionsKt.firstOrNull((List<? extends Object>) appSignaturesSHA1);
            if (str4 == null) {
                str4 = "";
            }
            int currentTimeMillis = (int) ((System.currentTimeMillis() / ((long) 1000)) + ((long) 86400));
            String escapeHtml = Html.escapeHtml(Build.BRAND + "; " + Build.MODEL + "; " + Build.DISPLAY + "; " + Build.VERSION.RELEASE);
            StringBuilder sb = new StringBuilder();
            sb.append(packageName);
            sb.append(str4);
            sb.append(str);
            sb.append(str2);
            sb.append(currentTimeMillis);
            sb.append(escapeHtml);
            String md5 = StringUtils.toMd5(sb.toString());
            Intrinsics.checkNotNullExpressionValue(md5, "StringUtils.toMd5(packag…en + expiredTime + agent)");
            if (md5 != null) {
                String upperCase = md5.toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                UUEncoder uUEncoder = new UUEncoder();
                String str5 = str3 + upperCase + str2 + currentTimeMillis;
                if (str5 != null) {
                    String obj = StringsKt.reversed((CharSequence) str5).toString();
                    Charset charset = Charsets.UTF_8;
                    if (obj != null) {
                        byte[] bytes = obj.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        String encode = uUEncoder.encode(bytes);
                        StringBuilder sb2 = new StringBuilder();
                        if (upperCase != null) {
                            String substring = upperCase.substring(8, 23);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            sb2.append(substring);
                            Intrinsics.checkNotNullExpressionValue(encode, "accessCode");
                            Charset charset2 = Charsets.UTF_8;
                            if (encode != null) {
                                byte[] bytes2 = encode.getBytes(charset2);
                                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                                byte[] encode2 = Base64.encode(bytes2, 0);
                                Intrinsics.checkNotNullExpressionValue(encode2, "Base64.encode(accessCode.toByteArray(), 0)");
                                sb2.append(new String(encode2, Charsets.UTF_8));
                                String uri = Uri.parse("https://account.coolapk.com/auth/loginByOpenId").buildUpon().appendQueryParameter("type", str).appendQueryParameter("code", sb2.toString()).appendQueryParameter("expires_in", String.valueOf(i)).appendQueryParameter("expires_time", String.valueOf(currentTimeMillis)).appendQueryParameter("state", "com.coolapk.market").build().toString();
                                Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(LOGIN_URL_BASE…      .build().toString()");
                                WebView webView = getWebView();
                                if (webView != null) {
                                    webView.loadUrl(uri);
                                    return;
                                }
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e) {
            Toast.error(getActivity(), e);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/webview/LoginFragment$LoginUiListener;", "Lcom/tencent/tauth/IUiListener;", "(Lcom/coolapk/market/view/webview/LoginFragment;)V", "onCancel", "", "onComplete", "o", "", "onError", "uiError", "Lcom/tencent/tauth/UiError;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LoginFragment.kt */
    private final class LoginUiListener implements IUiListener {
        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public LoginUiListener() {
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "o");
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("access_token");
                if (!TextUtils.isEmpty(optString)) {
                    LoginFragment loginFragment = LoginFragment.this;
                    String optString2 = jSONObject.optString("expires_in", "0");
                    Intrinsics.checkNotNullExpressionValue(optString2, "o.optString(Constants.PARAM_EXPIRES_IN, \"0\")");
                    loginFragment.loginThirdPartUrl("qq", optString, "", Integer.parseInt(optString2));
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Intrinsics.checkNotNullParameter(uiError, "uiError");
            FragmentActivity activity = LoginFragment.this.getActivity();
            Toast.show$default(activity, uiError.errorMessage + " \nerrorCode: " + uiError.errorCode, 0, false, 12, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/webview/LoginFragment$SelfWbAuthListener;", "Lcom/sina/weibo/sdk/auth/WbAuthListener;", "(Lcom/coolapk/market/view/webview/LoginFragment;)V", "cancel", "", "onFailure", "errorMessage", "Lcom/sina/weibo/sdk/auth/WbConnectErrorMessage;", "onSuccess", "token", "Lcom/sina/weibo/sdk/auth/Oauth2AccessToken;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LoginFragment.kt */
    private final class SelfWbAuthListener implements WbAuthListener {
        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void cancel() {
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public SelfWbAuthListener() {
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
            Intrinsics.checkNotNullParameter(oauth2AccessToken, "token");
            if (oauth2AccessToken.isSessionValid() && LoginFragment.this.isAdded() && !TextUtils.isEmpty(oauth2AccessToken.getToken())) {
                LoginFragment loginFragment = LoginFragment.this;
                String token = oauth2AccessToken.getToken();
                String uid = oauth2AccessToken.getUid();
                String string = oauth2AccessToken.getBundle().getString("expires_in", "0");
                Intrinsics.checkNotNullExpressionValue(string, "token.bundle.getString(\"expires_in\", \"0\")");
                loginFragment.loginThirdPartUrl("weibo", token, uid, Integer.parseInt(string));
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            Intrinsics.checkNotNullParameter(wbConnectErrorMessage, "errorMessage");
            FragmentActivity activity = LoginFragment.this.getActivity();
            Toast.show$default(activity, wbConnectErrorMessage.getErrorMessage() + " \nerrorCode: " + wbConnectErrorMessage.getErrorCode(), 0, false, 12, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/webview/LoginFragment$Companion;", "", "()V", "CALLBACK_COOLAPK", "", "LOGIN_OUT", "LOGIN_URL_BASE", "LOGIN_URL_COOLAPK", "LOGIN_URL_MOBILE", "LOGIN_URL_QQ", "LOGIN_URL_WECHAT", "LOGIN_URL_WEIBO", "REGISTER_URL_COOLAPK", "newInstance", "Lcom/coolapk/market/view/webview/LoginFragment;", "url", "newLoginInstance", "newRegisterInstance", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LoginFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LoginFragment newLoginInstance() {
            LoginFragment loginFragment = new LoginFragment();
            Bundle bundle = new Bundle();
            bundle.putString("external_url", "https://account.coolapk.com/auth/login?type=coolapk");
            loginFragment.setArguments(bundle);
            return loginFragment;
        }

        @JvmStatic
        public final LoginFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            LoginFragment loginFragment = new LoginFragment();
            Bundle bundle = new Bundle();
            bundle.putString("external_url", str);
            loginFragment.setArguments(bundle);
            return loginFragment;
        }

        @JvmStatic
        public final LoginFragment newRegisterInstance() {
            LoginFragment loginFragment = new LoginFragment();
            Bundle bundle = new Bundle();
            bundle.putString("external_url", "https://account.coolapk.com/auth/login?type=register");
            loginFragment.setArguments(bundle);
            return loginFragment;
        }
    }
}
