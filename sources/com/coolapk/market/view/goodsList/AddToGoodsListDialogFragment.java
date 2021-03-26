package com.coolapk.market.view.goodsList;

import android.app.Dialog;
import android.os.Bundle;
import com.coolapk.market.databinding.AddGoodsItemDialogBinding;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/goodsList/AddToGoodsListDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/AddGoodsItemDialogBinding;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddToGoodsListDialogFragment.kt */
public final class AddToGoodsListDialogFragment extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private AddGoodsItemDialogBinding binding;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/AddToGoodsListDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/goodsList/AddToGoodsListDialogFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AddToGoodsListDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AddToGoodsListDialogFragment newInstance() {
            Bundle bundle = new Bundle();
            AddToGoodsListDialogFragment addToGoodsListDialogFragment = new AddToGoodsListDialogFragment();
            addToGoodsListDialogFragment.setArguments(bundle);
            return addToGoodsListDialogFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }
}
