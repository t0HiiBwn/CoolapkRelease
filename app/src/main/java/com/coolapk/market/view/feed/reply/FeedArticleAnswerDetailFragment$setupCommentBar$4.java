package com.coolapk.market.view.feed.reply;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "aFloat", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedArticleAnswerDetailFragment.kt */
final class FeedArticleAnswerDetailFragment$setupCommentBar$4 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ LinearLayout $answerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedArticleAnswerDetailFragment$setupCommentBar$4(LinearLayout linearLayout) {
        super(1);
        this.$answerView = linearLayout;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
        invoke(f.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        float f2 = (float) 1;
        if (f >= f2 && this.$answerView.getVisibility() == 4) {
            this.$answerView.setVisibility(0);
        } else if (f < f2 && this.$answerView.getVisibility() == 0) {
            this.$answerView.setVisibility(4);
        }
    }
}
