package com.coolapk.market.view.feedv8.util;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.databinding.SubmitFeedNewGoodsBinding;
import com.coolapk.market.manager.StatisticHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showGoodsDialog$4 implements View.OnClickListener {
    final /* synthetic */ SubmitFeedNewGoodsBinding $binding;
    final /* synthetic */ Ref.ObjectRef $cancelCallback;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ Function2 $onClick;
    final /* synthetic */ FeedGoodsHelper$showGoodsDialog$1 $toLoadingUI$1;

    FeedGoodsHelper$showGoodsDialog$4(SubmitFeedNewGoodsBinding submitFeedNewGoodsBinding, Ref.ObjectRef objectRef, Function2 function2, AlertDialog alertDialog, FeedGoodsHelper$showGoodsDialog$1 feedGoodsHelper$showGoodsDialog$1) {
        this.$binding = submitFeedNewGoodsBinding;
        this.$cancelCallback = objectRef;
        this.$onClick = function2;
        this.$dialog = alertDialog;
        this.$toLoadingUI$1 = feedGoodsHelper$showGoodsDialog$1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText = this.$binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        this.$cancelCallback.element = (T) ((Function0) this.$onClick.invoke(obj, this.$dialog));
        this.$toLoadingUI$1.invoke();
        StatisticHelper.Companion.getInstance().recordGoodsRelatedAction("确定添加好物");
    }
}
