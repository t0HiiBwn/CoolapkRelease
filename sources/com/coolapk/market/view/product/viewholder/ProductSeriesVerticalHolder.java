package com.coolapk.market.view.product.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemProductSeriesVerticalBinding;
import com.coolapk.market.event.ProductEventRequester;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.view.FollowStyleTextView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSeriesVerticalHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemProductSeriesVerticalBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "onClick", "view", "setFollowText", "isFollow", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductSeriesVerticalHolder.kt */
public final class ProductSeriesVerticalHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558885;
    private final ItemProductSeriesVerticalBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductSeriesVerticalHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemProductSeriesVerticalBinding itemProductSeriesVerticalBinding = (ItemProductSeriesVerticalBinding) getBinding();
        this.binding = itemProductSeriesVerticalBinding;
        Intrinsics.checkNotNullExpressionValue(itemProductSeriesVerticalBinding, "binding");
        itemProductSeriesVerticalBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSeriesVerticalHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductSeriesVerticalHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.product.viewholder.ProductLocalData");
        Product product = ((ProductLocalData) obj).getProduct();
        if (product != null) {
            ItemProductSeriesVerticalBinding itemProductSeriesVerticalBinding = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemProductSeriesVerticalBinding, "binding");
            itemProductSeriesVerticalBinding.setModel(product);
            TextView textView = this.binding.subtitleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.subtitleView");
            textView.setText(KotlinExtendKt.toDisplayString(product.getHotNum()) + "热度");
            UserAction userAction = product.getUserAction();
            Intrinsics.checkNotNullExpressionValue(userAction, "product.userAction");
            boolean z = true;
            if (userAction.getFollow() != 1) {
                z = false;
            }
            setFollowText(z);
            this.binding.executePendingBindings();
        }
    }

    /* access modifiers changed from: private */
    public final void setFollowText(boolean z) {
        FollowStyleTextView followStyleTextView = this.binding.actionButton;
        Intrinsics.checkNotNullExpressionValue(followStyleTextView, "binding.actionButton");
        followStyleTextView.setSelected(z);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemProductSeriesVerticalBinding itemProductSeriesVerticalBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemProductSeriesVerticalBinding, "binding");
        Product model = itemProductSeriesVerticalBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            int id = view.getId();
            if (id == 2131361877) {
                UserAction userAction = model.getUserAction();
                Intrinsics.checkNotNullExpressionValue(userAction, "product.userAction");
                boolean z = userAction.getFollow() == 1;
                ProductEventRequester productEventRequester = ProductEventRequester.INSTANCE;
                String id2 = model.getId();
                if (id2 == null) {
                    id2 = "";
                }
                if (ProductEventRequester.requestFollow$default(productEventRequester, id2, !z, new ProductSeriesVerticalHolder$onClick$accepted$1(this, model), null, 8, null)) {
                    setFollowText(!z);
                }
            } else if (id != 2131362779) {
                super.onClick(view);
            } else {
                ActionManager.startProductActivity(getContext(), model.getId());
            }
        }
    }
}
