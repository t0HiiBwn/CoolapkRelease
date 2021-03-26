package com.coolapk.market.view.feedv8;

import android.graphics.Rect;
import android.view.View;
import com.coolapk.market.databinding.SubmitFeedBottomSetVisibilityBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitExtraViewPart.kt */
final class SubmitExtraViewPart$onRequestVisibility$2 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ SubmitFeedBottomSetVisibilityBinding $binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitExtraViewPart$onRequestVisibility$2(SubmitFeedBottomSetVisibilityBinding submitFeedBottomSetVisibilityBinding) {
        super(1);
        this.$binding = submitFeedBottomSetVisibilityBinding;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
        invoke(rect);
        return Unit.INSTANCE;
    }

    public final void invoke(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "it");
        SubmitFeedBottomSetVisibilityBinding submitFeedBottomSetVisibilityBinding = this.$binding;
        Intrinsics.checkNotNullExpressionValue(submitFeedBottomSetVisibilityBinding, "binding");
        View root = submitFeedBottomSetVisibilityBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setPadding(root.getPaddingLeft(), root.getPaddingTop(), root.getPaddingRight(), rect.bottom);
    }
}
