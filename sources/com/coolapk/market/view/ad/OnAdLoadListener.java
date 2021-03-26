package com.coolapk.market.view.ad;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H&¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/ad/OnAdLoadListener;", "", "onLoadError", "", "e", "", "onLoadSuccess", "data", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OnAdLoadListener.kt */
public interface OnAdLoadListener {
    void onLoadError(Throwable th);

    void onLoadSuccess(Object obj);
}
