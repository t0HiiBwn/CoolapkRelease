package com.coolapk.market.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManagerCopy;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemProgressHintBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.HolderItem;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/ProgressHintViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemProgressHintBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProgressBarViewHolder.kt */
public final class ProgressHintViewHolder extends GenericBindHolder<ItemProgressHintBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558883;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressHintViewHolder(View view, FragmentBindingComponent fragmentBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, fragmentBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
        Intrinsics.checkNotNullParameter(itemActionHandler, "onItemClick");
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "holderItem");
        ((ItemProgressHintBinding) getBinding()).executePendingBindings();
        String title = holderItem.getTitle();
        int i = 0;
        boolean z = !(title == null || title.length() == 0);
        TextView textView = ((ItemProgressHintBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(holderItem.getTitle());
        TextView textView2 = ((ItemProgressHintBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        textView2.setVisibility(z ? 0 : 8);
        ProgressBar progressBar = ((ItemProgressHintBinding) getBinding()).progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        if (z) {
            i = 8;
        }
        progressBar.setVisibility(i);
        FrameLayout frameLayout = ((ItemProgressHintBinding) getBinding()).emptyView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.emptyView");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Integer intValue = holderItem.getIntValue();
        Intrinsics.checkNotNullExpressionValue(intValue, "holderItem.intValue");
        layoutParams.height = intValue.intValue();
        FrameLayout frameLayout2 = ((ItemProgressHintBinding) getBinding()).emptyView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.emptyView");
        frameLayout2.setMinimumHeight(NumberExtendsKt.getDp((Number) 160));
        ((ItemProgressHintBinding) getBinding()).emptyView.requestLayout();
        ((ItemProgressHintBinding) getBinding()).emptyView.setOnClickListener(this);
        if (holderItem.getIntValue().intValue() <= NumberExtendsKt.getDp((Number) 64)) {
            ProgressBar progressBar2 = ((ItemProgressHintBinding) getBinding()).progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.progressBar");
            ProgressBar progressBar3 = progressBar2;
            ViewGroup.LayoutParams layoutParams2 = progressBar3.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = NumberExtendsKt.getDp((Number) 32);
                layoutParams2.height = NumberExtendsKt.getDp((Number) 32);
                progressBar3.setLayoutParams(layoutParams2);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        ItemProgressHintBinding itemProgressHintBinding = (ItemProgressHintBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProgressHintBinding, "binding");
        View root = itemProgressHintBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewGroup.LayoutParams layoutParams3 = root.getLayoutParams();
        if (layoutParams3 instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams3).setFullSpan(true);
        } else if (layoutParams3 instanceof StaggeredGridLayoutManagerCopy.LayoutParams) {
            ((StaggeredGridLayoutManagerCopy.LayoutParams) layoutParams3).setFullSpan(true);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ProgressHintViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProgressBarViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
