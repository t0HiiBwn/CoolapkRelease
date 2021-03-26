package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;

public class CoolWebView extends WebView {
    private int dx;
    private int dy;
    private boolean mDonotTrack;
    private OnWebViewScrollCallback mOnScrollChangedCallback;

    public interface OnWebViewScrollCallback {
        void onScroll(int i, int i2, boolean z);
    }

    public CoolWebView(Context context) {
        super(context);
    }

    public CoolWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        HashMap hashMap = new HashMap();
        if (this.mDonotTrack) {
            hashMap.put("dnt", "1");
        }
        loadUrl(str, hashMap);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str, map);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        boolean z;
        super.onScrollChanged(i, i2, i3, i4);
        OnWebViewScrollCallback onWebViewScrollCallback = this.mOnScrollChangedCallback;
        if (onWebViewScrollCallback != null) {
            if (i4 > i2) {
                this.dx -= i - i3;
                this.dy -= i4 - i2;
                z = false;
            } else {
                this.dx += i - i3;
                this.dy += i2 - i4;
                z = true;
            }
            onWebViewScrollCallback.onScroll(this.dx, this.dy, z);
        }
    }

    public OnWebViewScrollCallback getOnWebViewScrollCallback() {
        return this.mOnScrollChangedCallback;
    }

    public void setOnWebViewScrollCallback(OnWebViewScrollCallback onWebViewScrollCallback) {
        this.mOnScrollChangedCallback = onWebViewScrollCallback;
    }
}
