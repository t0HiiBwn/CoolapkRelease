package com.coolapk.market.view.goodsList;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.coolapk.market.event.GoodsAddedEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AddGoodsDialogFragment.kt */
final class AddGoodsDialogFragment$onCreateDialog$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ AddGoodsDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddGoodsDialogFragment$onCreateDialog$1(AddGoodsDialogFragment addGoodsDialogFragment) {
        super(1);
        this.this$0 = addGoodsDialogFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        ProgressBar progressBar = AddGoodsDialogFragment.access$getBinding$p(this.this$0).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(0);
        TextView textView = AddGoodsDialogFragment.access$getBinding$p(this.this$0).okButton;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.okButton");
        textView.setVisibility(4);
        if (this.this$0.isAddGoods) {
            EditText editText = AddGoodsDialogFragment.access$getBinding$p(this.this$0).editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            final String obj = editText.getText().toString();
            if (this.this$0.isEditNote) {
                AddGoodsDialogFragment.access$getMGoodsListItemViewModel$p(this.this$0).setItemNote(obj);
            }
            DataManager.getInstance().addGoodsOrNote(this.this$0.feedId, this.this$0.goodsId, obj, this.this$0.isEditNote).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                /* class com.coolapk.market.view.goodsList.AddGoodsDialogFragment$onCreateDialog$1.AnonymousClass1 */
                final /* synthetic */ AddGoodsDialogFragment$onCreateDialog$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(String str) {
                    ProgressBar progressBar = AddGoodsDialogFragment.access$getBinding$p(this.this$0.this$0).loadingView;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                    progressBar.setVisibility(4);
                    TextView textView = AddGoodsDialogFragment.access$getBinding$p(this.this$0.this$0).okButton;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.okButton");
                    textView.setVisibility(0);
                    if (AddGoodsDialogFragment.access$getMGoodsListItemViewModel$p(this.this$0.this$0).getGoodsListItem() != null) {
                        this.this$0.this$0.goodsListItem = AddGoodsDialogFragment.access$getMGoodsListItemViewModel$p(this.this$0.this$0).getGoodsListItem();
                    }
                    if (this.this$0.this$0.goodsListItem != null) {
                        this.this$0.this$0.goodsListItem = GoodsListItem.newBuilder(this.this$0.this$0.goodsListItem).id(str).note(obj).build();
                        EventBus.getDefault().post(new GoodsAddedEvent(this.this$0.this$0.goodsListItem));
                    }
                    this.this$0.this$0.dismiss();
                }
            }, new Action1<Throwable>(this) {
                /* class com.coolapk.market.view.goodsList.AddGoodsDialogFragment$onCreateDialog$1.AnonymousClass2 */
                final /* synthetic */ AddGoodsDialogFragment$onCreateDialog$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(Throwable th) {
                    ProgressBar progressBar = AddGoodsDialogFragment.access$getBinding$p(this.this$0.this$0).loadingView;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                    progressBar.setVisibility(4);
                    TextView textView = AddGoodsDialogFragment.access$getBinding$p(this.this$0.this$0).okButton;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.okButton");
                    textView.setVisibility(0);
                    Toast.error(this.this$0.this$0.getActivity(), th);
                    this.this$0.this$0.dismiss();
                }
            });
        }
    }
}
