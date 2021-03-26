package com.coolapk.market.view.webview;

import android.content.Context;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.coolapk.market.manager.ActionManager;

class CoolDownloadListener implements DownloadListener {
    private Context mContext;

    CoolDownloadListener(Context context) {
        this.mContext = context;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        ActionManager.startView(this.mContext, Uri.parse(str), null);
    }
}
