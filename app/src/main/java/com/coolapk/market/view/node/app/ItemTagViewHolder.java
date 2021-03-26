package com.coolapk.market.view.node.app;

import android.view.View;
import com.coolapk.market.databinding.ItemAppNodeTagBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/node/app/ItemTagViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "binding", "Lcom/coolapk/market/databinding/ItemAppNodeTagBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "item", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemTagViewHolder.kt */
public final class ItemTagViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558595;
    private final ItemAppNodeTagBinding binding;
    private final AppNodeViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/app/ItemTagViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemTagViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemTagViewHolder(View view, AppNodeViewModel appNodeViewModel) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        this.viewModel = appNodeViewModel;
        ItemAppNodeTagBinding itemAppNodeTagBinding = (ItemAppNodeTagBinding) getBinding();
        this.binding = itemAppNodeTagBinding;
        Intrinsics.checkNotNullExpressionValue(itemAppNodeTagBinding, "binding");
        itemAppNodeTagBinding.getRoot().setOnClickListener(this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        ItemAppNodeTagBinding itemAppNodeTagBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemAppNodeTagBinding, "binding");
        itemAppNodeTagBinding.setName((String) obj);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        AppCategory appCategory = this.viewModel.getAppCategoryList().get(Math.max(getAdapterPosition() - 1, 0));
        Intrinsics.checkNotNullExpressionValue(appCategory, "viewModel.appCategoryList[index]");
        ActionManager.startAppCategoryActivity(getContext(), appCategory, getAdapterPosition());
    }
}
