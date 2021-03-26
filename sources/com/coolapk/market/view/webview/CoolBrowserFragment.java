package com.coolapk.market.view.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import com.coolapk.market.view.webview.CoolBrowserData;

public class CoolBrowserFragment extends WebViewFragment {
    private CoolBrowserCommunicator mCommunicator;
    private Bitmap mIcon;
    private CoolBrowserData.PageData mPageData;

    public static CoolBrowserFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        CoolBrowserFragment coolBrowserFragment = new CoolBrowserFragment();
        coolBrowserFragment.setArguments(bundle);
        return coolBrowserFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mCommunicator = (CoolBrowserCommunicator) getActivity();
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCommunicator = null;
    }

    public void setPageData(CoolBrowserData.PageData pageData) {
        this.mPageData = pageData;
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        CoolBrowserCommunicator coolBrowserCommunicator = this.mCommunicator;
        if (coolBrowserCommunicator != null) {
            coolBrowserCommunicator.onUrlLoad(str, this.mPageData);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        CoolBrowserCommunicator coolBrowserCommunicator = this.mCommunicator;
        if (coolBrowserCommunicator != null) {
            coolBrowserCommunicator.onTitleReceived(str, this.mPageData);
        }
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
        this.mIcon = bitmap;
        CoolBrowserCommunicator coolBrowserCommunicator = this.mCommunicator;
        if (coolBrowserCommunicator != null) {
            coolBrowserCommunicator.onReceivedIcon(bitmap, this.mPageData);
        }
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        CoolBrowserCommunicator coolBrowserCommunicator = this.mCommunicator;
        if (coolBrowserCommunicator != null) {
            coolBrowserCommunicator.onPageLoadFinished(this.mPageData);
        }
    }

    public Bitmap getIcon() {
        return this.mIcon;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            getWebView().pauseTimers();
        } else {
            getWebView().resumeTimers();
        }
    }
}
