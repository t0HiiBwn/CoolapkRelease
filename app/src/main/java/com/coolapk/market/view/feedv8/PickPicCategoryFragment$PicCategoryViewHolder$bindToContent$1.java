package com.coolapk.market.view.feedv8;

import android.content.Intent;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.model.PicCategory;
import com.coolapk.market.view.feedv8.PickPicCategoryFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: PickPicCategoryFragment.kt */
final class PickPicCategoryFragment$PicCategoryViewHolder$bindToContent$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ PicCategory $data;
    final /* synthetic */ PickPicCategoryFragment.PicCategoryViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PickPicCategoryFragment$PicCategoryViewHolder$bindToContent$1(PickPicCategoryFragment.PicCategoryViewHolder picCategoryViewHolder, PicCategory picCategory) {
        super(1);
        this.this$0 = picCategoryViewHolder;
        this.$data = picCategory;
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
        DataBindingComponent component = this.this$0.getComponent();
        LifecycleOwner lifecycleOwner = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof PickPicCategoryFragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        PickPicCategoryFragment pickPicCategoryFragment = (PickPicCategoryFragment) lifecycleOwner;
        if (pickPicCategoryFragment != null) {
            PickPicCategoryFragment pickPicCategoryFragment2 = pickPicCategoryFragment;
            if (pickPicCategoryFragment2.isAdded()) {
                FragmentActivity requireActivity = pickPicCategoryFragment2.requireActivity();
                Intent intent = new Intent();
                intent.putExtra("RESULT", this.$data.getTitle());
                Unit unit = Unit.INSTANCE;
                requireActivity.setResult(-1, intent);
                pickPicCategoryFragment2.requireActivity().finish();
            }
        }
    }
}
