package com.coolapk.market.view.center;

import com.coolapk.market.event.MyCardUpdateEvent;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MyCardManagerActivity.kt */
final class MyCardManagerActivity$submitCardConfig$1<T> implements Action1<Result<String>> {
    final /* synthetic */ ProgressDialogFragment $dialog;
    final /* synthetic */ MyCardManagerActivity this$0;

    MyCardManagerActivity$submitCardConfig$1(MyCardManagerActivity myCardManagerActivity, ProgressDialogFragment progressDialogFragment) {
        this.this$0 = myCardManagerActivity;
        this.$dialog = progressDialogFragment;
    }

    public final void call(Result<String> result) {
        Intrinsics.checkNotNullExpressionValue(result, "it");
        if (Intrinsics.areEqual(result.getData(), "1")) {
            EventBus.getDefault().post(new MyCardUpdateEvent(Intrinsics.areEqual(result.getData(), "1")));
            this.$dialog.dismiss();
            this.this$0.finish();
        }
    }
}
