package com.coolapk.market.view.feedv8;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$doOnNextPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class FeedEntranceV8Activity$onCreate$$inlined$doOnNextPreDraw$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View $this_doOnNextPreDraw;
    final /* synthetic */ FeedEntranceV8Activity this$0;

    public FeedEntranceV8Activity$onCreate$$inlined$doOnNextPreDraw$1(View view, FeedEntranceV8Activity feedEntranceV8Activity) {
        this.$this_doOnNextPreDraw = view;
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.$this_doOnNextPreDraw.getViewTreeObserver().removeOnPreDrawListener(this);
        this.this$0.playShowAnimation();
        this.this$0.playDraftAnimation();
        return false;
    }
}
