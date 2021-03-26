package com.coolapk.market.view.feedv8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: View.kt */
public final class FeedEntranceV8Activity$onCreate$$inlined$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ View $this_doOnPreDraw;
    final /* synthetic */ FeedEntranceV8Activity this$0;

    public FeedEntranceV8Activity$onCreate$$inlined$doOnPreDraw$1(View view, FeedEntranceV8Activity feedEntranceV8Activity) {
        this.$this_doOnPreDraw = view;
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View root = FeedEntranceV8Activity.access$getBinding$p(this.this$0).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        int measuredWidth = ((root.getMeasuredWidth() - (NumberExtendsKt.getDp((Number) 16) * 2)) - (NumberExtendsKt.getDp((Number) 54) * 4)) / 8;
        if (measuredWidth > 0) {
            Space space = FeedEntranceV8Activity.access$getBinding$p(this.this$0).leftSpaceView;
            Intrinsics.checkNotNullExpressionValue(space, "binding.leftSpaceView");
            Space space2 = space;
            ViewGroup.LayoutParams layoutParams = space2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = NumberExtendsKt.getDp((Number) 16) + measuredWidth;
                space2.setLayoutParams(layoutParams);
                Space space3 = FeedEntranceV8Activity.access$getBinding$p(this.this$0).rightSpaceView;
                Intrinsics.checkNotNullExpressionValue(space3, "binding.rightSpaceView");
                Space space4 = space3;
                ViewGroup.LayoutParams layoutParams2 = space4.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = NumberExtendsKt.getDp((Number) 16) + measuredWidth;
                    space4.setLayoutParams(layoutParams2);
                    Space space5 = FeedEntranceV8Activity.access$getBinding$p(this.this$0).spaceView;
                    Intrinsics.checkNotNullExpressionValue(space5, "binding.spaceView");
                    Space space6 = space5;
                    ViewGroup.LayoutParams layoutParams3 = space6.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.width = measuredWidth * 2;
                        space6.setLayoutParams(layoutParams3);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }
}
