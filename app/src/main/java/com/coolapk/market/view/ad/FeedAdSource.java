package com.coolapk.market.view.ad;

import android.view.ViewGroup;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/ad/FeedAdSource;", "", "detachListeners", "", "firstData", "isSucceedLoaded", "", "load", "listener", "Lcom/coolapk/market/view/ad/OnAdLoadListener;", "onResume", "release", "render", "container", "Landroid/view/ViewGroup;", "data", "setOnAdEventListener", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedAdSource.kt */
public interface FeedAdSource {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: FeedAdSource.kt */
    public static final class DefaultImpls {
        public static void onResume(FeedAdSource feedAdSource) {
        }
    }

    void detachListeners();

    Object firstData();

    boolean isSucceedLoaded();

    void load(OnAdLoadListener onAdLoadListener);

    void onResume();

    void release();

    void render(ViewGroup viewGroup, Object obj);

    void setOnAdEventListener(OnAdEventListener onAdEventListener);
}
