package com.coolapk.market.view.message;

import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MessageCardDialogFragment.kt */
final class MessageCardDialogFragment$onClick$1<T> implements Action1<List<Entity>> {
    final /* synthetic */ MessageCardDialogFragment this$0;

    MessageCardDialogFragment$onClick$1(MessageCardDialogFragment messageCardDialogFragment) {
        this.this$0 = messageCardDialogFragment;
    }

    public final void call(List<Entity> list) {
        Intrinsics.checkNotNullExpressionValue(list, "it");
        if (!list.isEmpty()) {
            ProgressBar progressBar = MessageCardDialogFragment.access$getBinding$p(this.this$0).loadingView;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
            progressBar.setVisibility(8);
            TextView textView = MessageCardDialogFragment.access$getBinding$p(this.this$0).dialogConfirm;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.dialogConfirm");
            textView.setVisibility(0);
            this.this$0.dismiss();
            CompleteNavDialogFragment newInstance = CompleteNavDialogFragment.Companion.newInstance(this.this$0.uid, this.this$0.userName);
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
    }
}
