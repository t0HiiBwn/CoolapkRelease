package com.coolapk.market.view.feed.reply;

import android.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailFragmentV8.kt */
final class FeedDetailFragmentV8$setupFeedToolbar$2 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ FrameLayout $container;
    final /* synthetic */ AppCompatTextView $titleView;
    final /* synthetic */ View $userToolbarView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDetailFragmentV8$setupFeedToolbar$2(View view, AppCompatTextView appCompatTextView, FrameLayout frameLayout) {
        super(1);
        this.$userToolbarView = view;
        this.$titleView = appCompatTextView;
        this.$container = frameLayout;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
        invoke(f.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        boolean z = true;
        int i = 0;
        float f2 = (float) 1;
        int i2 = (f > f2 ? 1 : (f == f2 ? 0 : -1));
        if ((this.$userToolbarView.getVisibility() == 0) == (i2 >= 0)) {
            if ((this.$titleView.getVisibility() == 0) == (f < f2)) {
                return;
            }
        }
        TransitionManager.beginDelayedTransition(this.$container);
        this.$userToolbarView.setVisibility(i2 >= 0 ? 0 : 8);
        AppCompatTextView appCompatTextView = this.$titleView;
        if (f >= f2) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        appCompatTextView.setVisibility(i);
    }
}
