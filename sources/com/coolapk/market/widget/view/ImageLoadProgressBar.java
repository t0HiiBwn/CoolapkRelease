package com.coolapk.market.widget.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.ImageLoadEvent;
import com.coolapk.market.util.ImageLoadProgressDispatcher;
import com.coolapk.market.widget.RingProgressBar;

public class ImageLoadProgressBar extends RingProgressBar {
    private String mMonitorUrl;

    public ImageLoadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextColor(AppHolder.getAppTheme().getColorAccent());
        setRingProgressColor(AppHolder.getAppTheme().getColorAccent());
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!TextUtils.isEmpty(this.mMonitorUrl)) {
            ImageLoadProgressDispatcher.INSTANCE.put(this.mMonitorUrl, this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!TextUtils.isEmpty(this.mMonitorUrl)) {
            ImageLoadProgressDispatcher.INSTANCE.remove(this.mMonitorUrl, this);
        }
        this.mMonitorUrl = null;
    }

    public void setMonitorUrl(String str) {
        setVisibility(8);
        if (!TextUtils.isEmpty(this.mMonitorUrl)) {
            ImageLoadProgressDispatcher.INSTANCE.remove(this.mMonitorUrl, this);
        }
        this.mMonitorUrl = str;
        if (!TextUtils.isEmpty(str) && isAttachedToWindow()) {
            ImageLoadProgressDispatcher.INSTANCE.put(this.mMonitorUrl, this);
        }
    }

    public void onProgress(ImageLoadEvent imageLoadEvent) {
        if (!imageLoadEvent.getUrl().equals(this.mMonitorUrl)) {
            return;
        }
        if (imageLoadEvent.isClosed()) {
            onClosed();
        } else {
            onProgress(imageLoadEvent.getBytesRead(), imageLoadEvent.getExpectedLength());
        }
    }

    private void onClosed() {
        setVisibility(8);
    }

    private void onProgress(long j, long j2) {
        if (j2 == Long.MAX_VALUE) {
            onConnecting();
        } else if (j == j2) {
            onDownloaded();
        } else {
            onDownloading(j, j2);
        }
    }

    public void onConnecting() {
        setProgress(0);
        setVisibility(0);
    }

    public void onDownloading(long j, long j2) {
        setProgress((int) ((j * 100) / j2));
        setVisibility(0);
    }

    public void onDownloaded() {
        setProgress(0);
        if (!TextUtils.isEmpty(this.mMonitorUrl)) {
            ImageLoadProgressDispatcher.INSTANCE.remove(this.mMonitorUrl, this);
        }
        this.mMonitorUrl = null;
        setVisibility(8);
    }
}
