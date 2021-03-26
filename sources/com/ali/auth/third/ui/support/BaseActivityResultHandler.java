package com.ali.auth.third.ui.support;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.ui.webview.BaseWebViewActivity;
import java.util.Map;

public abstract class BaseActivityResultHandler implements ActivityResultHandler {
    @Override // com.ali.auth.third.ui.support.ActivityResultHandler
    public void onActivityResult(int i, int i2, int i3, Intent intent, Activity activity, Map<Class<?>, Object> map, WebView webView) {
        String str;
        if (i == 1) {
            onCallbackContext(i2, i3, intent, activity, map, webView);
            return;
        }
        if (i != 2) {
            str = "Unrecognized source " + i;
        } else if (activity instanceof BaseWebViewActivity) {
            onTaeSDKActivity(i2, i3, intent, (BaseWebViewActivity) activity, map, webView);
            return;
        } else {
            str = "OnActivityResult is invoked from unsupported activity type " + activity.getClass().getName();
        }
        SDKLogger.e("system", str);
    }

    protected abstract void onCallbackContext(int i, int i2, Intent intent, Activity activity, Map<Class<?>, Object> map, WebView webView);

    protected abstract void onTaeSDKActivity(int i, int i2, Intent intent, BaseWebViewActivity baseWebViewActivity, Map<Class<?>, Object> map, WebView webView);
}
