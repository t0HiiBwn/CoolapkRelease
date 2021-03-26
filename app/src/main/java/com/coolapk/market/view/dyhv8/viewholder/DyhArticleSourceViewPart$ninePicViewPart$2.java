package com.coolapk.market.view.dyhv8.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.databinding.ItemDyhSourcePartBinding;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhArticleSourceViewPart.kt */
final class DyhArticleSourceViewPart$ninePicViewPart$2 extends Lambda implements Function0<NinePicViewPart> {
    final /* synthetic */ DyhArticleSourceViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DyhArticleSourceViewPart$ninePicViewPart$2(DyhArticleSourceViewPart dyhArticleSourceViewPart) {
        super(0);
        this.this$0 = dyhArticleSourceViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NinePicViewPart invoke() {
        NinePicViewPart ninePicViewPart = new NinePicViewPart(DyhArticleSourceViewPart.access$getComponent$p(this.this$0));
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        View view = this.this$0.getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ninePicViewPart.createView(from, (ViewGroup) view);
        ViewUtil.replaceView(((ItemDyhSourcePartBinding) this.this$0.getBinding()).spaceView, ninePicViewPart.getView());
        ViewGroup.LayoutParams layoutParams = ninePicViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = DisplayUtils.dp2px(this.this$0.getContext(), 4.0f);
            marginLayoutParams.topMargin = DisplayUtils.dp2px(this.this$0.getContext(), 4.0f);
        }
        return ninePicViewPart;
    }
}
