package com.coolapk.market.view.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.WebViewBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.BearStoryHelper;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.JavascriptInterfaceUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.appmanager.DownloadHandlerActivity;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.widget.CoolWebView;
import com.coolapk.market.widget.NavigationClipViewHelper;
import com.coolapk.market.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;
import okhttp3.Cookie;
import org.apache.commons.io.FilenameUtils;
import org.greenrobot.eventbus.EventBus;

public class WebViewFragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, BaseActivity.OnBackPressListener, CoolWebViewCallback {
    public static final String EXTRA_ACTION_TYPE = "extra_action_type";
    public static final String EXTRA_WEB_URL = "external_url";
    private static final String HOME_PAGE = "http://www.coolapk.com/";
    private static final int REQUEST_CODE_FILE = 134;
    private boolean addCookie;
    private WebViewBinding mBinding;
    private int mOriginOrientation;
    private UserAgentHandler mUserAgentHandler;
    private ValueCallback<Uri[]> mValueCallback;
    private View mVideoView;
    private FrameLayout mVideoViewContainer;
    private WebChromeClient.CustomViewCallback mViewCallback;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return null;
    }

    public static WebViewFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        WebViewFragment webViewFragment = new WebViewFragment();
        webViewFragment.setArguments(bundle);
        return webViewFragment;
    }

    public static WebViewFragment newInstance(String str, DyhArticle dyhArticle) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        bundle.putParcelable("extra_action_type", dyhArticle);
        WebViewFragment webViewFragment = new WebViewFragment();
        webViewFragment.setArguments(bundle);
        return webViewFragment;
    }

    public SwipeRefreshLayout getSwipeRefreshView() {
        return this.mBinding.swipeRefreshView;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinding = (WebViewBinding) DataBindingUtil.inflate(layoutInflater, 2131559302, viewGroup, false);
        AppTheme appTheme = AppHolder.getAppTheme();
        this.mBinding.progressBar.getProgressDrawable().setColorFilter(appTheme.getColorPrimaryDark(), PorterDuff.Mode.SRC_IN);
        this.mBinding.swipeRefreshView.setColorSchemeColors(appTheme.getColorPrimary());
        this.mBinding.swipeRefreshView.setScrollUpChild(this.mBinding.webView);
        this.mBinding.swipeRefreshView.setOnRefreshListener(this);
        this.mBinding.swipeRefreshView.setEnabled(false);
        setHasOptionsMenu(true);
        if (getActivity() instanceof TranslucentActivity) {
            new NavigationClipViewHelper(this.mBinding.webView).adapterToNavigationBar();
        }
        setupWebView();
        return this.mBinding.getRoot();
    }

    public WebViewBinding getBinding() {
        return this.mBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.setOnBackPressListener(this);
        }
    }

    private void setupWebView() {
        WebView webView = getWebView();
        webView.setDrawingCacheBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);
        webView.setScrollbarFadingEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setNetworkAvailable(true);
        webView.setWebChromeClient(new CoolChromeClient(this));
        webView.setDownloadListener(this);
        webView.setWebViewClient(new CoolWebViewClient(this));
        webView.setOnTouchListener(new CoolWebViewGestureListener(webView, this));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCachePath(DataManager.getInstance().getDataConfig().getCacheDir());
        settings.setAppCacheEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setMediaPlaybackRequiresUserGesture(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setMixedContentMode(2);
        webView.addJavascriptInterface(new JavascriptInterfaceUtils(getActivity()), "webHook");
        if (AppHolder.getAppSetting().getBooleanPref("webview_disable_image_load")) {
            settings.setBlockNetworkImage(true);
        }
        webView.setOnKeyListener(new View.OnKeyListener() {
            /* class com.coolapk.market.view.webview.WebViewFragment.AnonymousClass1 */

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 1) {
                    return WebViewFragment.this.onBackEvent();
                }
                return false;
            }
        });
        this.mUserAgentHandler = new UserAgentHandler(settings);
    }

    protected boolean onBackEvent() {
        if (!getWebView().canGoBack()) {
            return false;
        }
        getWebView().goBack();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String string = getArguments() != null ? getArguments().getString("external_url") : null;
        if (TextUtils.isEmpty(string)) {
            string = "http://www.coolapk.com/";
        }
        addCoolMarketCookie();
        getWebView().loadUrl(string);
        this.mUserAgentHandler.onUrlLoading(getWebView().getSettings(), string);
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (getActivity() instanceof WebViewActivity) {
            ((WebViewActivity) getActivity()).setCloseButtonVisible(webView.canGoBack());
        }
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public void onPageFinished(WebView webView, String str) {
        if (getActivity() instanceof WebViewActivity) {
            ((WebViewActivity) getActivity()).setCloseButtonVisible(webView.canGoBack());
        }
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public void onLongClickUrl(WebView webView, String str) {
        LogUtils.d("LONG CLICK %s", str);
        WebView.HitTestResult hitTestResult = webView.getHitTestResult();
        if (str != null || (hitTestResult != null && hitTestResult.getExtra() != null)) {
            WebViewDialog newInstance = WebViewDialog.newInstance();
            if (hitTestResult != null) {
                newInstance.setUrl(hitTestResult.getExtra());
                if (hitTestResult.getType() == 8 || hitTestResult.getType() == 5) {
                    newInstance.setSaveImage(true);
                } else {
                    newInstance.setSaveImage(false);
                }
            } else {
                newInstance.setUrl(str);
            }
            newInstance.show(getChildFragmentManager(), (String) null);
        }
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (valueCallback == null) {
            return false;
        }
        this.mValueCallback = valueCallback;
        startActivityForResult(fileChooserParams.createIntent(), 134);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 134 && this.mValueCallback != null) {
            this.mValueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i2, intent));
            this.mValueCallback = null;
        }
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String actionTypeFromUrl;
        LogUtils.d("Loading url: " + str, new Object[0]);
        this.mUserAgentHandler.onUrlLoading(webView.getSettings(), str);
        if (str.startsWith("mailto:")) {
            startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
            return true;
        }
        final Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if ((host == null || host.endsWith(".coolapk.com") || host.equals("coolapk.com")) && UriUtils.isCoolApkHost(webView.getUrl()) && (actionTypeFromUrl = UriUtils.getActionTypeFromUrl(str)) != null && !actionTypeFromUrl.equals("web")) {
            ActionManagerCompat.startActivityByUrl(getActivity(), str, getActivity().getTitle().toString(), "");
            return true;
        } else if (str.startsWith("http")) {
            if (str.startsWith("https://account.coolapk.com/auth/logout")) {
                logout();
            }
            return false;
        } else if (BearStoryHelper.checkBearStoryAutoJump(getActivity(), getArguments().getString("external_url", webView.getOriginalUrl()), parse)) {
            return true;
        } else {
            Snackbar.make(getWebView(), 2131887162, 0).setAction(2131887161, new View.OnClickListener() {
                /* class com.coolapk.market.view.webview.WebViewFragment.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActionManager.startView(WebViewFragment.this.getActivity(), parse, null);
                }
            }).show();
            return true;
        }
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public void onReceivedTitle(WebView webView, String str) {
        if (getActivity() != null && !str.startsWith("http")) {
            getActivity().setTitle(str);
        }
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public void onCloseWindow(WebView webView) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar = this.mBinding.progressBar;
        progressBar.setProgress(i);
        if (i == 0 || i == 100) {
            if (progressBar.getVisibility() == 0) {
                progressBar.setVisibility(8);
            }
        } else if (progressBar.getVisibility() == 8) {
            progressBar.setVisibility(0);
        }
        if (i == 100 && getSwipeRefreshView().isRefreshing()) {
            getSwipeRefreshView().setRefreshing(false);
        }
    }

    protected final void addCoolMarketCookie() {
        if (!this.addCookie) {
            this.addCookie = true;
        }
        if (DataManager.getInstance().getLoginSession().isLogin()) {
            CookieManager instance = CookieManager.getInstance();
            String cookie = instance.getCookie(".coolapk.com");
            if (cookie == null || !cookie.contains(DataManager.getInstance().getLoginSession().getToken())) {
                List<Cookie> coolApkCookie = KotlinExtendKt.getCoolApkCookie(DataManager.getInstance().getDataConfig());
                instance.setAcceptCookie(true);
                for (Cookie cookie2 : coolApkCookie) {
                    instance.setCookie(".coolapk.com", cookie2.name() + "=" + cookie2.value());
                }
                instance.flush();
            }
        }
    }

    public WebView getWebView() {
        WebViewBinding webViewBinding = this.mBinding;
        if (webViewBinding == null) {
            return null;
        }
        return webViewBinding.webView;
    }

    private void logout() {
        LoginSession loginSession = DataManager.getInstance().getLoginSession();
        loginSession.reset();
        EventBus.getDefault().post(loginSession);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(2131623976, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        CoolWebView coolWebView = this.mBinding.webView;
        switch (menuItem.getItemId()) {
            case 2131361883:
                coolWebView.clearCache(true);
                Toast.show(getWebView(), 2131887156);
                break;
            case 2131361889:
                if (coolWebView.getUrl() != null) {
                    StringUtils.copyText(getActivity(), coolWebView.getUrl());
                    Toast.show(getWebView(), 2131887190);
                    break;
                }
                break;
            case 2131361956:
                coolWebView.reload();
                break;
            case 2131361968:
                if (coolWebView.getUrl() != null) {
                    String title = coolWebView.getTitle();
                    String reconvert = LinkTextUtils.reconvert(coolWebView.getTitle());
                    if (reconvert.length() > 240) {
                        reconvert = reconvert.substring(0, 240) + "…";
                    }
                    ActionManager.shareText(getActivity(), title, String.format("%s  %s %s", reconvert, getString(2131886685), coolWebView.getUrl()));
                    break;
                }
                break;
            case 2131361985:
                if (coolWebView.getUrl() != null) {
                    ActionManager.startView(getActivity(), Uri.parse(coolWebView.getUrl()), null);
                    break;
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getSwipeRefreshView().setRefreshing(false);
        ((BaseActivity) getActivity()).setOnBackPressListener(null);
        if (getWebView() != null) {
            getWebView().destroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getWebView().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        getWebView().onResume();
        super.onResume();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        if (getWebView() != null) {
            this.mUserAgentHandler.onUrlLoading(getWebView().getSettings(), getWebView().getUrl());
            getWebView().reload();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity.OnBackPressListener
    public boolean onBackKeyPressed() {
        return onBackEvent();
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(final String str, String str2, String str3, String str4, long j) {
        final Uri parse = Uri.parse(str);
        String name = FilenameUtils.getName(parse.getPath());
        if (TextUtils.isEmpty(name)) {
            name = str.substring(str.lastIndexOf("/") + 1);
        }
        Snackbar.make(getWebView(), getString(2131887158, name), -2).setAction(2131886128, new View.OnClickListener() {
            /* class com.coolapk.market.view.webview.WebViewFragment.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("apk".equals(MimeTypeMap.getFileExtensionFromUrl(str))) {
                    String name = FilenameUtils.getName(parse.getPath());
                    if (TextUtils.isEmpty(name)) {
                        String str = str;
                        name = str.substring(str.lastIndexOf("/") + 1);
                    }
                    Intent intent = new Intent(WebViewFragment.this.getActivity(), DownloadHandlerActivity.class);
                    intent.putExtra("TITLE", name);
                    intent.setData(Uri.parse(str));
                    WebViewFragment.this.getActivity().startActivity(intent);
                    return;
                }
                ActionManager.startView(WebViewFragment.this.getActivity(), parse, null);
            }
        }).show();
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, getActivity().getRequestedOrientation(), customViewCallback);
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public synchronized void onHideCustomView() {
        if (this.mVideoView != null) {
            getActivity().setRequestedOrientation(this.mOriginOrientation);
            this.mVideoView.setKeepScreenOn(false);
            this.mVideoViewContainer.removeAllViews();
            ((ViewGroup) this.mVideoViewContainer.getParent()).removeView(this.mVideoViewContainer);
            WebChromeClient.CustomViewCallback customViewCallback = this.mViewCallback;
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
            }
            this.mVideoViewContainer = null;
            this.mVideoView = null;
            this.mViewCallback = null;
        }
    }

    @Override // com.coolapk.market.view.webview.CoolWebViewCallback
    public synchronized void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.mVideoView == null) {
            this.mVideoView = view;
            this.mViewCallback = customViewCallback;
            this.mOriginOrientation = getActivity().getRequestedOrientation();
            getActivity().setRequestedOrientation(i);
            if (this.mVideoViewContainer == null) {
                FrameLayout contentView = UiUtils.getContentView(getActivity());
                FrameLayout frameLayout = new FrameLayout(getActivity());
                this.mVideoViewContainer = frameLayout;
                frameLayout.setBackgroundColor(-16777216);
                contentView.addView(this.mVideoViewContainer, new FrameLayout.LayoutParams(-1, -1));
            }
            this.mVideoViewContainer.addView(this.mVideoView, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
