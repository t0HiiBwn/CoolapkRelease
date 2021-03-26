package com.coolapk.market.view.webview;

import android.graphics.Bitmap;
import com.coolapk.market.view.webview.CoolBrowserData;

public interface CoolBrowserCommunicator {
    void onPageLoadFinished(CoolBrowserData.PageData pageData);

    void onReceivedIcon(Bitmap bitmap, CoolBrowserData.PageData pageData);

    void onTitleReceived(String str, CoolBrowserData.PageData pageData);

    void onUrlLoad(String str, CoolBrowserData.PageData pageData);
}
