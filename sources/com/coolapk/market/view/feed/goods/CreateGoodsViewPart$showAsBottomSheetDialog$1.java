package com.coolapk.market.view.feed.goods;

import android.app.Activity;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: CreateGoodsViewPart.kt */
final class CreateGoodsViewPart$showAsBottomSheetDialog$1 implements View.OnClickListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ Function0 $dismissAction;
    final /* synthetic */ CreateGoodsViewPart this$0;

    CreateGoodsViewPart$showAsBottomSheetDialog$1(CreateGoodsViewPart createGoodsViewPart, Activity activity, Function1 function1, Function0 function0) {
        this.this$0 = createGoodsViewPart;
        this.$activity = activity;
        this.$callback = function1;
        this.$dismissAction = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.handleDone(this.$activity, this.$callback, this.$dismissAction);
    }
}
