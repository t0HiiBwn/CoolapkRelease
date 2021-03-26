package com.coolapk.market.view.webview;

import android.text.Html;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.SystemUtils;

public class UserAgentHandler {
    private String mDefaultUserAgent;

    public void onUrlLoading(WebSettings webSettings, String str) {
    }

    public UserAgentHandler(WebSettings webSettings) {
        String userAgentString = webSettings.getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            this.mDefaultUserAgent = DataManager.getInstance().getDataConfig().getUserAgent();
        } else {
            this.mDefaultUserAgent = Html.escapeHtml(SystemUtils.getUserAgent(userAgentString)) + " +CoolMarket/" + AppHolder.getAppMetadata().getAppVersionName() + "-" + AppHolder.getAppMetadata().getAppVersionCode() + "-" + AppHolder.getAppMetadata().getAppMode();
        }
        webSettings.setUserAgentString(this.mDefaultUserAgent);
    }
}
