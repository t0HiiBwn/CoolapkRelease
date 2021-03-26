package com.coolapk.market.view.webview;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

class CoolWebViewGestureListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    private CoolWebViewCallback mCallback;
    private GestureDetector mDetector;
    private WebViewHandler mHandler;
    private boolean mTriggerLongPress = true;
    private WebView mWebView;

    CoolWebViewGestureListener(WebView webView, CoolWebViewCallback coolWebViewCallback) {
        this.mCallback = coolWebViewCallback;
        this.mWebView = webView;
        this.mDetector = new GestureDetector(webView.getContext(), this);
        this.mHandler = new WebViewHandler();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.mDetector.onTouchEvent(motionEvent);
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.mTriggerLongPress) {
            this.mWebView.requestFocusNodeHref(this.mHandler.obtainMessage());
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        this.mTriggerLongPress = false;
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        this.mTriggerLongPress = true;
    }

    class WebViewHandler extends Handler {
        WebViewHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            CoolWebViewGestureListener.this.mCallback.onLongClickUrl(CoolWebViewGestureListener.this.mWebView, message.getData().getString("url"));
        }
    }
}
