package com.coolapk.market.view.feedv8;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.sencondhand.EditSecondHandDialogFragment;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitSecondHandExtraViewPart.kt */
final class SubmitSecondHandExtraViewPart$showSecondHandDialog$1<T> implements Action1<String> {
    final /* synthetic */ EditSecondHandDialogFragment $dialog;
    final /* synthetic */ int $id;
    final /* synthetic */ SubmitSecondHandExtraViewPart this$0;

    SubmitSecondHandExtraViewPart$showSecondHandDialog$1(SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart, int i, EditSecondHandDialogFragment editSecondHandDialogFragment) {
        this.this$0 = submitSecondHandExtraViewPart;
        this.$id = i;
        this.$dialog = editSecondHandDialogFragment;
    }

    public final void call(String str) {
        if (this.$id == 2131363446) {
            DataManager.getInstance().checkUrl(str).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                /* class com.coolapk.market.view.feedv8.SubmitSecondHandExtraViewPart$showSecondHandDialog$1.AnonymousClass1 */
                final /* synthetic */ SubmitSecondHandExtraViewPart$showSecondHandDialog$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(String str) {
                    SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart = this.this$0.this$0;
                    Intrinsics.checkNotNullExpressionValue(str, "it");
                    submitSecondHandExtraViewPart.onPickSHOutLink(str, this.this$0.$id);
                    this.this$0.$dialog.dismiss();
                }
            }, new Action1<Throwable>(this) {
                /* class com.coolapk.market.view.feedv8.SubmitSecondHandExtraViewPart$showSecondHandDialog$1.AnonymousClass2 */
                final /* synthetic */ SubmitSecondHandExtraViewPart$showSecondHandDialog$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(Throwable th) {
                    Toast.error(SubmitSecondHandExtraViewPart.access$getActivity$p(this.this$0.this$0), th);
                    this.this$0.$dialog.dismiss();
                }
            });
            return;
        }
        SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart = this.this$0;
        Intrinsics.checkNotNullExpressionValue(str, "it");
        submitSecondHandExtraViewPart.onPickSHOutLink(str, this.$id);
        this.$dialog.dismiss();
    }
}
