package com.coolapk.market.app;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface OnImageLoadListener {
    void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th);
}
