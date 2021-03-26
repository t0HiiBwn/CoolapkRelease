package com.coolapk.market.view.ad;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/ad/OnAdEventListener;", "", "()V", "onAdClick", "", "view", "Landroid/view/View;", "data", "onAdClose", "onAdShow", "shouldGoMainActivity", "message", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OnAdEventListener.kt */
public abstract class OnAdEventListener {
    public void onAdClick(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void onAdClose(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void onAdShow(Object obj) {
    }

    public void shouldGoMainActivity(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
