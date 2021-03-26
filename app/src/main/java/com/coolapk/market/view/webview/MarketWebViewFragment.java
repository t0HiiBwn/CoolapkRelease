package com.coolapk.market.view.webview;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.coolapk.market.view.appmanager.DownloadHandlerActivity;
import org.apache.commons.io.FilenameUtils;

public class MarketWebViewFragment extends WebViewFragment {
    private static final String APP_CHINA_SCRIPT = "javascript:void(function(){if ($(\"#b-gs\")[0].style[\"display\"] != \"none\") { b_down()}  $(\"#yyh-bottom\")[0].style[\"display\"] = \"none\"; $(\"#check-bw\")[0].style[\"display\"] = \"none\";})()";
    private static final String WANDOUJIA_SCRIPT = "javascript:void(function(){$(\"body > div.container > div > div.detail-top.clearfix > div.app-info > div > a.install-btn.i-source\")[0].style[\"display\"] = \"none\";$(\"body > a.comeon-uc.i-source\")[0].style[\"display\"] = \"none\";})()";
    private static final String YYB_SCRIPT = "javascript:void(function(){\n$(\"#appbao-download-banner\")[0].style[\"display\"] = \"none\";$(\"#btn-fast-download\")[0].style[\"display\"] = \"none\";$(\"#normalOpenDialogFastDownBtn\")[0].style[\"display\"] = \"none\";})()";

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (str.contains("http://m.appchina.com/app/")) {
            getWebView().loadUrl("javascript:void(function(){if ($(\"#b-gs\")[0].style[\"display\"] != \"none\") { b_down()}  $(\"#yyh-bottom\")[0].style[\"display\"] = \"none\"; $(\"#check-bw\")[0].style[\"display\"] = \"none\";})()");
        } else if (str.contains("http://www.wandoujia.com/apps/")) {
            getWebView().loadUrl("javascript:void(function(){$(\"body > div.container > div > div.detail-top.clearfix > div.app-info > div > a.install-btn.i-source\")[0].style[\"display\"] = \"none\";$(\"body > a.comeon-uc.i-source\")[0].style[\"display\"] = \"none\";})()");
        } else if (str.contains("http://a.app.qq.com/")) {
            getWebView().loadUrl("javascript:void(function(){\n$(\"#appbao-download-banner\")[0].style[\"display\"] = \"none\";$(\"#btn-fast-download\")[0].style[\"display\"] = \"none\";$(\"#normalOpenDialogFastDownBtn\")[0].style[\"display\"] = \"none\";})()");
        }
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("http")) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String name = FilenameUtils.getName(Uri.parse(str).getPath());
        if (TextUtils.isEmpty(name)) {
            name = str.substring(str.lastIndexOf("/") + 1);
        }
        Intent intent = new Intent(getActivity(), DownloadHandlerActivity.class);
        intent.putExtra("TITLE", name);
        intent.setData(Uri.parse(str));
        getActivity().startActivity(intent);
    }
}
