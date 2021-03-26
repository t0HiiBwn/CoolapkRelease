package com.coolapk.market.view.node.app;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.AppNodeHeaderBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.viewpart.TripleAvatarViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeViewPart.kt */
final class AppNodeViewPart$tripleViewPart$2 extends Lambda implements Function0<TripleAvatarViewPart> {
    final /* synthetic */ AppNodeViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeViewPart$tripleViewPart$2(AppNodeViewPart appNodeViewPart) {
        super(0);
        this.this$0 = appNodeViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final TripleAvatarViewPart invoke() {
        TripleAvatarViewPart tripleAvatarViewPart = new TripleAvatarViewPart(new ContextBindingComponent(this.this$0.activity));
        Space space = ((AppNodeHeaderBinding) this.this$0.getBinding()).tripleAvatarSpaceHolder;
        Intrinsics.checkNotNullExpressionValue(space, "binding.tripleAvatarSpaceHolder");
        LayoutInflater from = LayoutInflater.from(this.this$0.activity);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
        tripleAvatarViewPart.createView(from, null);
        ViewUtil.replaceView(space, tripleAvatarViewPart.getView());
        View view = tripleAvatarViewPart.getView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = NumberExtendsKt.getDp((Number) 8);
        Unit unit = Unit.INSTANCE;
        view.setLayoutParams(layoutParams);
        return tripleAvatarViewPart;
    }
}
