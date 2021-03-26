package com.coolapk.market.imageloader;

import android.content.Context;
import com.bumptech.glide.RequestManager;
import java.lang.ref.WeakReference;

public class GlideRequestComponent {
    private final WeakReference<Context> contextRef;
    private final RequestManager requestManager;

    public GlideRequestComponent(Context context, RequestManager requestManager2) {
        this.contextRef = new WeakReference<>(context);
        this.requestManager = requestManager2;
    }

    public Context getContext() {
        return this.contextRef.get();
    }

    public RequestManager getRequestManager() {
        return this.requestManager;
    }
}
