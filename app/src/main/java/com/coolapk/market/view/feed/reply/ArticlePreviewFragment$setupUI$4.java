package com.coolapk.market.view.feed.reply;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.feedv8.ArticleNative;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "aFloat", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticlePreviewFragment.kt */
final class ArticlePreviewFragment$setupUI$4 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ ArticleNative $topModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticlePreviewFragment$setupUI$4(FragmentActivity fragmentActivity, ArticleNative articleNative) {
        super(1);
        this.$activity = fragmentActivity;
        this.$topModel = articleNative;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
        invoke(f.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        ((AlphableToolbar) this.$activity).setToolbarTitle(f >= ((float) 1) ? this.$topModel.getText() : "");
    }
}
