package com.coolapk.market.view.video;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import com.coolapk.market.extend.ExtraExtendsKt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$doOnNextPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ VideoReplyDetailHeaderFragment $fragment$inlined;
    final /* synthetic */ View $this_doOnNextPreDraw;

    public VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1(View view, VideoReplyDetailHeaderFragment videoReplyDetailHeaderFragment) {
        this.$this_doOnNextPreDraw = view;
        this.$fragment$inlined = videoReplyDetailHeaderFragment;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.$this_doOnNextPreDraw.getViewTreeObserver().removeOnPreDrawListener(this);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1$lambda$1(this));
        ExtraExtendsKt.addListeners$default(valueAnimator, null, new VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1$lambda$2(this), 1, null);
        valueAnimator.start();
        return false;
    }
}
